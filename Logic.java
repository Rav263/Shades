import java.util.*;
import java.io.*;
import java.lang.*;
public class Logic{
  static int Ots,FHeigth,FWigth,MapStX,MapStY;
  public static List<Block> Blocks=new ArrayList<>();
  static Block nowBlock;
  public Logic(){
    nowBlock=new Block();
    DonData();
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
  }
}