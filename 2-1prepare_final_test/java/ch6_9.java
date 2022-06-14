package choi;
import java.util.*;

interface aaa{
	abstract void set_user(int num);
	abstract void set_cum();
}

class bbb implements aaa{
	private int user,cum;
	
	bbb(){
		this.user = 0;
		this.cum = 0;
	}
	
	@Override 
	public void set_user(int num) {
		this.user = num;
	}
	
	@Override
	public void set_cum() {
		this.cum = (int)Math.random()*3;
	}
	
	public void run() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("철수[가위(1), 바위(2), 보(3), 끝내기(4)]>>");
			int num = scan.nextInt();
			this.cum = (int)(Math.random()*3);
			
			switch(num) {
			case 1: //가위 
				this.set_user(num);
				System.out.print("철수 (가위) : ");
				switch(cum) {
				case 0:
					System.out.println("컴푸터 (가위)");
					System.out.println("비겼습니다. ");
					break;
				case 1:
					System.out.println("컴푸터 (바위)");
					System.out.println("컴퓨터가 이겼습니다.");
					break;
				case 2:
					System.out.println("컴푸터 (보)");
					System.out.println("철수가 이겼습니다.");
					break;
				}
				break;
			case 2://바위 
				this.set_user(num);
				System.out.print("철수 (바위) : ");
				switch(cum) {
				case 0:
					System.out.println("컴푸터 (가위)");
					System.out.println("철수가 이겼습니다.");
					break;
				case 1:
					System.out.println("컴푸터 (바위)");		
					System.out.println("비겼습니다. ");
					break;
				case 2:
					System.out.println("컴푸터 (보)");
					System.out.println("컴퓨터가 이겼습니다.");
					break;
				}
				break;
			case 3://보 
				this.set_user(num);
				System.out.print("철수 (보) : ");
				switch(cum) {
				case 0:
					System.out.println("컴푸터 (가위)");		
					System.out.println("컴퓨터가 이겼습니다.");
					break;
				case 1:
					System.out.println("컴푸터 (바위)");
					System.out.println("철수가 이겼습니다.");
					break;
				case 2:
					System.out.println("컴푸터 (보)");
					System.out.println("비겼습니다. ");
					break;
				}
				break;
			case 4://끝내기 
				System.out.print("종료하겠습니다");
				return;
			default:
				System.out.println("1~4에서 입력해주시기 바랍니다.");
			}
		}
	}
}
public class ch6_9 {
	public static void main(String[] args) {
		bbb b = new bbb();
		b.run();
	}
}
