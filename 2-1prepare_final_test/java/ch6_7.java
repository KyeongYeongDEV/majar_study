package choi;
import java.util.*;

public class ch6_7 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.print(">>");
			String str = scan.nextLine();
			
			StringTokenizer st = new StringTokenizer(str," ");
			
			int cnt = st.countTokens();
			String tmp_str = st.nextToken();
			if(tmp_str.equals("그만")) {
				System.out.print("종료합니다..");
				break;
			}			
			System.out.println("어절의 수는 "+ cnt);
			System.out.println(tmp_str);
			while(st.hasMoreTokens()) {
				System.out.println(st.nextToken());
			}
		}
	}
}  


