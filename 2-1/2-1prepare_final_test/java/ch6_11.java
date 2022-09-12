package choi;
import java.util.*;

public class ch6_11 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);		
		System.out.print(">>");
		String str = scan.nextLine();
		
		while(true) {
			System.out.print("명령: ");
			String s  = scan.nextLine();
			String[] tmp = s.split("!");
			
			if(s.equals("그만")) {
				System.out.print("종료합니다. ");
			}
			
			if(tmp[0].equals("")) {
				System.out.println("잘못된 명령입니다. ");
			}
			else if(!str.contains(tmp[0])) {
				System.out.println("찾을 수 없습니다. ");
			}
			else {
				StringBuffer SB = new StringBuffer(str);
				int sb_num  = SB.indexOf(tmp[0]);
				SB=SB.replace(sb_num, sb_num + tmp[0].length(), tmp[1]);
				s  = SB.toString();
				System.out.println(s);
			}
		}
	}
}