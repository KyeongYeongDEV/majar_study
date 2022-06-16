package choi;

class Point1{
	private int x,y;
	
	Point1(){
		x=0;y=0;
	}
	Point1(int x, int y){
		if( x <0 || y <0) {
			this.x = 0;
			this.y = 0;
		}else {
			this.x = x;
			this.y = y;
		}
	}
	
	protected void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	protected int getX() {
		return x;
	}
	protected int getY() {
		return y;
	}
}

class PositivePoint extends Point1{
	PositivePoint(){
		super();
	}
	PositivePoint(int x, int y){
		super(x,y);		
	}
	public void move(int x, int y) {
		if (x <0 || y <0) {
			return;
		}
		else {super.setXY(x, y);}		
	}
	public String toString() {
		return "(" + super.getX() + "," + super.getY() + ")의 점입니다.";
	}
}

public class ch5_8 {
	public static void main(String[] args) {
		PositivePoint p = new PositivePoint();
		p.move(10,10);
		System.out.println(p.toString() + "입니다. ");
		
		p.move(-5,5);
		System.out.println(p.toString() + "입니다. ");
		
		PositivePoint p2 = new PositivePoint(-10,-10);
		System.out.println(p2.toString() + "입니다. ");
		
	}
}