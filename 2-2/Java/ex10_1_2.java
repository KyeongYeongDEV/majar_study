import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//내구 클래스로 Action 이벤트 이스터 만들기

public class ex10_1_2 extends JFrame{
		public ex10_1_2() {
			setTitle("Action 이벤트 리슨 예제 ");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container c = getContentPane();
			
			c.setLayout(new FlowLayout());
			JButton btn = new JButton("Action");
			btn.addActionListener(new MyActionListener());
			c.add(btn);
			
			setSize(350,150);
			setVisible(true);
		}
		
		//내부 클래스로 Action리스너를 만든다 
		private class MyActionListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource()
				if(b.getText().equals("Action")) {
					b.setText("액션");
				}
				else {
					b.setText("Action");
				}
				
				//Title도 같이 바꿔준다. 
				ex10_1_2.this.setTitle(b.getText()); // 프레임의 타이틀에 버튼 문자열을 출력한다. 
			}
		}
		
		public static void main(String[] args) {
			new ex10_1_2();
		}
}
