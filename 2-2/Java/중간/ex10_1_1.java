import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//독립 클래스로 Action 이벤트와 리스너 작성

public class ex10_1_1 extends JFrame{
	public ex10_1_1() {
		setTitle("Action 이벤트 리스터 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JButton btn = new JButton("Action");
		btn.addActionListener(new MyActionListener());
		c.add(btn);
		
		setSize(350,150);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ex10_1_1();
	}
}

class MyActionListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource(); //이번트 소스 버튼 알아내기
		if(b.getText().equals("Action")) {
			b.setText("액션");
		}
		else {
			b.setText("Action");
		}
	}
}