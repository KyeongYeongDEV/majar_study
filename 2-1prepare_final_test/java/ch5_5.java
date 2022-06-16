package choi;
import java.util.*;

class Point{
	private int x,y;
	public Point(int x, int y) {
		this.x =x;
		this.y = y;
	}
	public int getx() {return x;}
	public int gety() {return y;}
	protected void move(int x, int y) {this.x = x; this.y =y;}
}
	
//class ColorPoint extends Point{
//	private String color;
//	ColorPoint(int x, int y, String color){
//		super(x,y);
//		this.color = color;		
//	}
//	
//	public void setxy(int x, int y) {
//		super.move(x, y);
//	}
//	public void setcolor(String color) {
//		this.color = color;
//	}
//	public String toString() {
//		return color + "색의 (" +super.getx() + "," + super.gety() + ")의 점 " ;
//	}
//}

class ColorPoint extends Point{
	private String color;
	ColorPoint(){
		super(0,0);
		this.color  = "BLACK";
	}
	ColorPoint(int x, int y){
		super(x,y);
		this.color  = "BLACK";
	}
	public void setXY(int x, int y) {
		super.move(x, y);
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String toString() {
		return color + "색의 ( "+ super.getx() + ", " + super.gety() + ")의 점 입니다. ";
	}
}


public class ch5_5 {
	public static void main(String[] args) {
		//무제 5번 
//		ColorPoint cp = new ColorPoint(5,5,"Yellow");
//		cp.setxy(10,20);
//		cp.setcolor("red");
//		String str = cp.toString();
//		System.out.println(str + "입니다.");
		
		//문제 6번 
		ColorPoint zeropoint = new ColorPoint();//(0,0)위치의 black색 점 
		System.out.println(zeropoint.toString() + "입니다. ");
		
		ColorPoint cp = new ColorPoint(10,10);//(10,10)위치의 black색 점 
		cp.setXY(5,5);
		cp.setColor("RED");
		System.out.println(cp.toString() + "입니다.");	
		
	}
}
