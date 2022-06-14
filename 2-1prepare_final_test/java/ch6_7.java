package choi;
import java.util.*;

public class ch6_7 {
	public static void main(String[] args) {
		//StringTokenizer 이용 
//		Scanner scan = new Scanner(System.in);
//		 while(true) {
//			 System.out.print(">>");
//			 String str = scan.nextLine();
//			 StringTokenizer st = new StringTokenizer(str," ");
//			 
//			 int cnt = st.countTokens();
//			 
//			 if(st.nextToken().equals("그만")) {
//				System.out.print("종료합니다." );
//				break;
//			 }
//			 
//			 System.out.println("어절 개수 " +cnt);
//		 }
		
		//String split() 이용 
		Scanner scan = new Scanner(System.in);
		while(true) {
			 System.out.print(">>");
			 String str = scan.nextLine();
			 String s[] = str.split(" ");
			 
			 if(s[0].equals("그만")) {
				 System.out.print("종료합니다." );
					break;
			 }
			 System.out.println("어절 개수 " + s.length);
		}
	}
}  