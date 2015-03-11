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
  static Logic log;
  public static void main(String[] args){
    PApplet.main("MainApplet");
  }
  public void setup(){
    DonData();
    size(Wigth,Heigth);
  }
  public void draw(){
    background(0);
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