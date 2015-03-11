import java.util.*;
import java.io.*;
import java.lang.*;
public class Logic{
  static int Ots,FHeigth,FWigth,MapStX,MapStY;
  public static List<Block> Blocks=new ArrayList<>();
  public static Block nowBlock;
  static DopFunctions DF=new DopFunctions();
  public Logic(){
    nowBlock=new Block();
    Add();
    DonData();
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
      Blocks.add(nowBlock);
      return false;
    }
    for(int i=0;i<Blocks.size();i++){
      Block bk=Blocks.get(i);
      if(bk.x!=nowBlock.x)continue;
      if(bk.y==nowBlock.y+MapStY){
        if(OneToTwo(nowBlock,i,0))return false;
        Blocks.add(nowBlock);
        return false;
      }
    }
    return true;
  }
  static boolean OneToTwo(Block now,int index,int Deph){
    Block bk=Blocks.get(index);
    if(now.type==6)return false;
    if(now.type!=bk.type)return false;
    Blocks.set(index,DF.block(bk.x,bk.y,bk.type+1));
    int nexIndex=Find(bk.y,bk.x);
    if(nexIndex==-1)return true;
    if(OneToTwo(Blocks.get(index),nexIndex,0))Blocks.remove(index);
    
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
    if(key=='d' ||key=='D'||key=='В' ||key=='в')MoveRigth();
    if(key=='a' ||key=='A'||key=='Ф' ||key=='ф')MoveLeft();
    // if(key=='s' ||key=='S'||key=='Ы' ||key=='ы')MoveDown();
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