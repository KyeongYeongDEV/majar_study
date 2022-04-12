package prac;
import java.util.Scanner;
//4장 8번
class phone{
	private String name;
	private String tel;
	
	public phone(String name, String tel) { //생성자를 통해 초기화
		this.name = name;// this는 객체 안의 변수를 뜻함
		this.tel = tel;
	}
	
	public String get_name() {//이름을 리턴해준다.
		return this.name;
	}
	
	public String get_tel() {//번호를 리턴해준다.
		return this.tel;
	}
}

class phonebook{
	Scanner scan = new Scanner(System.in);
	private phone pho[]; //객체 배열 선언
	private int get_num;//인원수를 받아줄 변수
	
	public phonebook() {// 생성자에서 인원수를 받고 
		System.out.print("인원수 >>");
		get_num = scan.nextInt();
		
		pho = new phone[get_num];//그 인원수의 공간만큼 객체배열을 만들어준다.
	}
	
	public void get() {
		for(int i =0; i < get_num; i++) {//값 받기
			System.out.print("이름과 전화번호(이름과 전화번호는 빈칸 없이 입력>>");
			String name = scan.next();
			String tel = scan.next();
			pho[i] = new phone(name,tel);// 입력 받은 값을 phone클래스의 생성자로 초기화해준다.
		}
		System.out.print("저장되었습니다...");		
			
	}
	
	public void run() {//실행해주는 메소드
		while(true) {//무한반복
			boolean check = false; //이름이 있는지 확인을 위해 생성	
			int check_num =0;
			
			System.out.print("검색할 이름 >>");
			String get_name = scan.next();
			
			if(get_name.equals("그만")) {//그만이 입력되면 종료
				break;
			}
			
			for(int i=0; i < get_num; i++) { // for문을 통해 이름 검색
				if(get_name.equals(pho[i].get_name())) {
					check = true; //있다면  true
					check_num = i; //이름이 있는 배열의 위치를 저장
					break;//이름을 찾았다면 더이상의 반복은 시간 낭비니 종료
				}
			}
			if(check) {//찾는 이름이 있다면 
				System.out.println(get_name + "의 번호는 " + pho[check_num].get_tel() + "입니다.");
				check = false;
			}
			else {//찾는 이름이 없다면
				System.out.println(get_name + "이 없습니다.");
			}
		}
	}
}


public class prac {
	public static void main(String args[]) {
		phonebook P = new phonebook(); //phonebook 객체 생성
		P.get();
		P.run();
	}
}
