import java.util.*;
import java.io.*;
import java.lang.*;
import processing.core.PApplet;
import processing.core.PImage;

public class MainApplet extends PApplet{
  static int Heigth;
  static int Wigth;
  static int FHeigth;
  static int FWigth;
  static int MapStX,MapStY;
  static int Ots;
  static int counter=0;
  static Logic log;
  public static void main(String[] args){
    PApplet.main("MainApplet");
  }

  public void setup(){
    DonData();
    log=new Logic();
    size(Wigth,Heigth);
  }

  public void draw(){
    background(210);
    fill(100);
    counter++;
    if(counter%3==0){
      log.Move();
      counter=1;
    } 
    for(int y=0;y<FHeigth/MapStY;y++){
      for(int x=0;x<FWigth/MapStX;x++){
        rect(x*MapStX+Ots,y*MapStY+Ots,MapStX,MapStY);
      }
    }
    DrowNowBlock();
    for(int i=0;i<log.Blocks.size();i++){

      Block nw=log.Blocks.get(i);
      //System.out.println(i+"  "+nw.x+"  "+nw.y);
      int[] cl=DopFunctions.color(nw.type);
      fill(cl[0],cl[1],cl[2]);
      rect(nw.x*MapStX+Ots,nw.y,MapStX,MapStY);
    }
  }

  void DrowNowBlock(){
    Block now=log.nowBlock;
    int[] cl=DopFunctions.color(now.type);
    fill(cl[0],cl[1],cl[2]);
    //if(now.type==1)fill(100,0,0);
    rect(now.x*MapStX+Ots,now.y,MapStX,MapStY);
  }

  public void keyPressed(){
    //log.
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
    Heigth=Don.get(0);
    Wigth=Don.get(1);
    FHeigth=Don.get(2);
    FWigth=Don.get(3);
    MapStX=Don.get(4);
    MapStY=Don.get(5);
    Ots=(Heigth-FHeigth)/2;
  }
}