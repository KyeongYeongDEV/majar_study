package choi;
import java.util.*;

interface Stack1{
	int length(); //현재 스택에 저장된 개수 리턴 
	int capacity(); //스택의 전체 저장 가능한 개수 리턴 
	String pop(); // 스택의 톱(top)에 저장 
	boolean push(String val); // 스택의 top에 저장된 실수 리턴 
}

class stack implements Stack1{
	private int top,capacity;
	private String[] str_arr;
	
	stack(){
		top =0;capacity =0;
	}
	public void get_strsize(int num) {
		capacity = num;
		str_arr = new String[num];
	}
	
	@Override
	public int length() {
		return top;
	}
	@Override
	public int capacity() {
		return str_arr.length;
	}
	@Override
	public String pop() {
		top--;
		return str_arr[top];
	}
	@Override
	public boolean push(String val) {
		if(top == capacity) {return false;}
		else {str_arr[top++] = val; return true;}
	}
	
	void run() {
		Scanner scan = new Scanner(System.in);
		System.out.print("총 스택 저장 공간의 크기 입력>>" );
		int num = scan.nextInt();
		get_strsize(num);
		
		while(true) {
			System.out.print("문자열 입력 >>");
			String Stmp = scan.next();
			if(Stmp.equals("그만")) {
				System.out.print("스택에 저장된 모든 문자열 팝");
				for(int i=0; i< str_arr.length; i++) {
					System.out.print(" "+pop());
				}
				break;
			}
			if(!push(Stmp)) {
				System.out.println("스택이 꽉 차서 푸시 불가!");
			}
		}
	}
	
}

public class ch5_9 {
	public static void main(String[] args) {
		stack s = new stack();
		s.run();
	}
}
