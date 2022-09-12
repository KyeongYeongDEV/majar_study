package choi;
import java.util.*;

abstract class cal1{
	protected int x,y;
	
	cal1(){
		x=0;y=0;
	}
	
	public void setValue(int x, int y) {
		this.x = x;
		this.y =y;
	}
	public abstract int calculate();
}

class add extends cal1{
	add(){
		super();
	}
	@Override
	public int calculate() {
		return x+y;
	}
}
class sub extends cal1{
	sub(){
		super();
	}
	@Override
	public int calculate() {
		return x-y;
	}
}
class mul  extends cal1{
	mul(){
		super();
	}
	@Override
	public int calculate() {
		return x*y;
	}
}
class div extends cal1{
	div(){
		super();
	}
	@Override
	public int calculate() {
		return x/y;
	}
}


public class ch5_11 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("두 정수와 연산자를 입력하시오 >>");
		
		int x = scan.nextInt();
		int y = scan.nextInt();
		String ch = scan.next();
		
		switch(ch) {
		case "+":
			add a = new add();
			a.setValue(x,y);
			System.out.print( a.calculate());
			break;
		case "-":
			sub s = new sub();
			s.setValue(x,y);
			System.out.print( s.calculate());
			break;
		case "*":
			mul m = new mul();
			m.setValue(x,y);
			System.out.print( m.calculate());
			break;
		case "/":
			div  d = new div();
			d.setValue(x,y);
			System.out.print( d.calculate());
			break;
		}
	}
}
