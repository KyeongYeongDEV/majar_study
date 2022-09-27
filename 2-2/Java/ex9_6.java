import javax.swing.*;
import java.awt.*;

class NullContainerEx extends JFrame{
	public NullContainerEx() {
		setTitle("Null Container Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null); //컨텐트팬의 배치관리자 제거 
		
		//JLabel 컴포넌트 생성하고 위치와 크기를 직접 지정한다.
		JLabel la = new JLabel("Hello, press Buttons!");
		la.setLocation(130,50); //la를 (130,50) 위치를 지정 
		la.setSize(200, 20); //la를 200*20 크기를 지정 
		c.add(la);// la	를 컨텐트팬에 부착 
		
		for(int i =1; i <=9; i++) {
			JButton b = new JButton(Integer.toString(i));
			b.setLocation(i*15,i*15);
			b.setSize(50,20);
			c.add(b);
		}
		
		setSize(300,200);
		setVisible(true);
		
	}
}

public class ex9_6 {
	public static void main(String[] args) {
		new NullContainerEx();
	}
}
