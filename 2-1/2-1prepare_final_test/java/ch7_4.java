package choi;
import java.util.*;

public class ch7_4 {
	public static void main(String[] args) {
		Vector<Integer> vec = new Vector<Integer>();
		Scanner scan  = new Scanner(System.in);
		int avg = 0;
		
		
		while(true) {
			System.out.print("강수량 입력(0입력시 종료 )>>");
			int tmp= scan.nextInt();
			if(tmp ==0) {
				System.out.print("종료합니다.");
				break;
			}
			avg+=tmp;
			vec.add(tmp);
			for(int i=0; i < vec.size(); i++) {
				System.out.print(vec.get(i) + " ");
			}
			System.out.println();
			System.out.println("현재 평균 "+avg/vec.size());
		}
	}
}
