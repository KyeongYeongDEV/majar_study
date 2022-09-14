import javax.swing.*;
import java.awt.*;

class FlowLayoutEx extends JFrame{
	public FlowLayoutEx() {
		super("FlowLayout Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		//컨텐트팬에 FlowLayout 배치 관리자 설정
		c.setLayout(new FlowLayout(FlowLayout.LEFT,30,40));
		c.add(new JButton("add"));
		c.add(new JButton("sub"));
		c.add(new JButton("mul"));
		c.add(new JButton("div"));
		c.add(new JButton("calculate"));
		
		setSize(300,200); 
		setVisible(true);
	}
}

public class ex9_3 {
	public static void main(String[] args) {
		new FlowLayoutEx();
	}
}
