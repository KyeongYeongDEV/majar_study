import javax.swing.*;
import java.awt.*;

class BorderLayoutEx extends JFrame{
	public BorderLayoutEx() {
		setTitle("BorderLayout Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		//컨텐트팬에 BorderLayout 배치관리자 설정 
		c.add(new JButton("Calulate"), BorderLayout.CENTER);
		c.add(new JButton("add"), BorderLayout.NORTH);
		c.add(new JButton("sub"), BorderLayout.SOUTH);
		c.add(new JButton("mul"), BorderLayout.EAST);
		c.add(new JButton("div"), BorderLayout.WEST);
		
		setSize(300,200);
		setVisible(true);
	}
}
public class ex9_4 {
	public static void main(String[] args) {
		new BorderLayoutEx();
	}
}
