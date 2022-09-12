package choi;
import java.util.*;


abstract class Shape10{ //추상클래스 
	Shape10(){}
	abstract void draw();
}

class Line10 extends Shape10{
	Line10(){}
	@Override
	public void draw() {
		System.out.println("Line"); //line을 그리도록 오버라이딩 
	}
}

class Rect10 extends Shape10{
	Rect10(){}
	@Override
	public void draw() {
		System.out.println("Rect"); //rect를 그리도록 오버라이딩 
	}
}
class Circle10 extends Shape10{
	Circle10(){}
	@Override
	public void draw() {
		System.out.println("Circle");//circle을 그리도록 오버라이딩 
	}
}

public class ch710 {
	public static void main(String[] args) {
		Vector <Shape10>vec = new Vector<Shape10> (); //vector의 요소 하나의 크기를 Shape 클래스로 받는다. 
		System.out.println("그래픽 에디터 beauty를 실행합니다.");
		while(true){
			Scanner scan = new Scanner(System.in);
			System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4) >>");
			int num = scan.nextInt();
			
			switch(num) {
			case 1: //삽
				System.out.print("Line(1), Rect(2), Circle(3) >>");
				int tmp = scan.nextInt();
				switch(tmp) {
				case 1:
					vec.add(new Line10()); // Vector에 원하는  객체 추가 이하 동문 
					break;
				case 2:
					vec.add(new Rect10());
					break;
				case 3:
					vec.add(new Circle10());
					break;
				}
				break;
			case 2://삭
				System.out.print("삭제할 도형의 위치>> ");
				int tm = scan.nextInt();
				if(vec.size() >= tm) { //size를 받아 삭제를 원하는 위치에 요소가 있는지 검사 
					vec.remove(tm-1);// 원하는 위치에 Vector 삭제 
					System.out.println("삭제하였습니다.");
				}else {
					System.out.println("삭제할 수 없습니다.");
				}
				break;
			case 3: //모두보기 
				for(int i = 0 ; i < vec.size(); i++) {
					vec.get(i).draw();//벡터 안의 원하는 것을 얻는다 즉, 원하는 도형 draw 
				}
				break;
			case 4://종료 
				System.out.print("beauty를 종료합니다.");
				return;
			}
		}	
		
	}
}
