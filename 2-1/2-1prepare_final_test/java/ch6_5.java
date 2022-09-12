package choi;
import java.util.*;

public class ch6_5 {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		
		System.out.println("현재 시간은 " + hour + "시 "+minute + "분 입니다.");
	
		if(hour >= 4 && hour < 12) {
			System.out.print("Good Morning");
		}else if(hour <18) {
			System.out.print("Good Afternoon");
		}else if(hour < 22) {
			System.out.print("Good Evening");
		}else {
			System.out.print("Good Night");
		}
	}	
}
