package prac1;
import java.io.IOException;
import java.io.InputStreamReader;

public class ch6_challenge {
	static int alphabet[] = null;
	final static int alphabetNum=26;
	
	ch6_challenge(){
		alphabet = new int [alphabetNum];
		for(int i =0; i < alphabetNum; i++) {
			alphabet[i] = 0; //개수 초기화 
		}
	}
	
	public static void main(String[] args) {
		new ch6_challenge();
		InputStreamReader rd = new InputStreamReader(System.in);
		int index;
		try {
			System.out.println("영문 텍스트를 입력하고 세미콜론을 입력하세요.");
			while(true) {
				int c = rd.read(); //문자을 받는다 
				if(c == ';') break; //';'가 입력이 되면 종료 
				if(Character.isAlphabetic(c)) { //알파벳인지 확인 
					if(c >= 'a' && c <= 'z') { //대문자로 변경 
						c -= 32;
					}
					index = c -'A';
					alphabet[index]+=1; //알파벳에 해당하는 배열의 값을 1 증가한다.
				}
			}
			
			System.out.println("히스토그램을 그립니다.");
			
			for(int i=0; i < alphabetNum; i++) {
				System.out.print((char)(i+'A'));
				for(int j =0; j <alphabet[i]; j++) { //위에서 체크한 개수만큼 출력한다.
					System.out.print("-");
				}
				System.out.println();
			}
			
		}
		catch(IOException e) {
			System.out.println("입력 오류 발");
		}
	}
}