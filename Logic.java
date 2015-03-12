 

import java.util.*;
import java.io.*;
import java.lang.*;
public class Logic{
  static int Ots,FHeigth,FWigth,MapStX,MapStY;
  public static List<Block> Blocks=new ArrayList<>();
  public static Block nowBlock;
  public static Block[][] Field =new Block[4][12];
  static DopFunctions DF=new DopFunctions();
  public Logic(){
    nowBlock=new Block();
    Fulling();
    Add();
    DonData();
  }
  static void Fulling(){
    for(int y=0;y<12;y++){
      for(int x=0;x<4;x++){
        Field[x][y]=DF.block(0,0,0);
      }
    }
  }
  static void Add(){
    nowBlock=DF.block(DF.Random(4)-1,Ots,DF.Random(5));
  }
  public static void Move(){
    if(!Correct()){
      Add();
    }
    nowBlock.y+=5;
  }
  static boolean Correct(){
    if(nowBlock.y>=FHeigth+Ots-MapStY){
      Field[nowBlock.x][(nowBlock.y-Ots)/MapStY]=nowBlock;
      return false;
    }
    for(int y=0;y<12;y++){
      for(int x=0;x<4;x++){
        Block bk=Field[x][y];
        if(bk.x!=nowBlock.x)continue;
        if(bk.y==nowBlock.y+MapStY){
          if(OneToTwo(nowBlock,x,y,0))return false;
          Field[nowBlock.x][(nowBlock.y-Ots)/MapStY]=nowBlock;
          return false;
        }
      }
    }
    return true;
  }
  static boolean OneToTwo(Block now,int x,int y,int Deph){
    Block bk=Field[x][y];
    if(now.type==6)return false;
    if(now.type!=bk.type)return false;
    Field[x][y]=DF.block(x,y*MapStY+Ots,bk.type+1);
    int nexIndex=(y+1);
    if(nexIndex==12)return true;
    if(OneToTwo(bk,x,nexIndex,0)){
      Field[x][y]=DF.block(0,0,0);
    }
    return true;
  }
  static int Find(int nowY,int nowX){
    for(int i=0;i<Blocks.size();i++){
      if(Blocks.get(i).x!=nowX)continue;
      if(Blocks.get(i).y==nowY+55)return i;
    }
    return -1;
  }
  public static void key(int key){
    if(key=='d' ||key=='D'||key=='Â' ||key=='â')MoveRigth();
    if(key=='a' ||key=='A'||key=='Ô' ||key=='ô')MoveLeft();
    // if(key=='s' ||key=='S'||key=='Ð«' ||key=='Ñ‹')MoveDown();
  }
  public static void MoveDown(){
    if(!Correct()){
      Add();
      return;
    }
    nowBlock.y+=MapStY;
  }
  public static void MoveLeft(){
    if(nowBlock.x==0)return;
    nowBlock.x-=1;
  }
  public static void MoveRigth(){
    if(nowBlock.x==3)return;
    nowBlock.x+=1;
  }
  static void DonData(){
    Scanner sc=new Scanner(System.in);
    try{
      sc=new Scanner(new FileReader("Propertis.data"));
    }catch(Exception e){
      System.err.println("WTF");      
    }
    List<Integer> Don=new ArrayList<>();
    for(;sc.hasNextInt();){
      Don.add(sc.nextInt());
    }
    FHeigth=Don.get(2);
    FWigth=Don.get(3);
    MapStX=Don.get(4);
    MapStY=Don.get(5);
    Ots=20;
  }
}