import java.util.*;
public class DopFunctions{
  static Random ran=new Random();
  DopFunctions(){
  }
  public static int[] color(int type){
    int[] color=new int[3];
    if(type==1){color[0]=255;color[1]=255;color[2]=255;}
    if(type==2){color[0]=255;color[1]=0;color[2]=0;}
    if(type==3){color[0]=60;color[1]=0;color[2]=0;}
    if(type==4){color[0]=0;color[1]=0;color[2]=255;}
    if(type==5){color[0]=0;color[1]=0;color[2]=60;}
    if(type==6){color[0]=0;color[1]=0;color[2]=0;}
    return color;
  }
  public static Block block(int x,int y,int type){
    Block bl=new Block();
    bl.x=x;bl.y=y;
    bl.type=type;
    return bl;
  }
  public static int Random(int d){
    int now=(ran.nextInt(d*1000))+1000;
    int WTH=now/1000;
    return WTH;
  }
}