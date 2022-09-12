import javax.swing.*;

	
class MyFrame extends JFrame{
	public MyFrame(){
		
		setTitle("300 * 300 스윙 프레임 만들기");
		//super("타이틀 문자열"); //super로도 가능 
		
		setSize(300,300);//frame 크리 300*300
		setVisible(true);//프레임 출력
	}
}

public class ex9_1{
	public static void main(String[] args) {
		MyFrame mf = new MyFrame();
	}
}