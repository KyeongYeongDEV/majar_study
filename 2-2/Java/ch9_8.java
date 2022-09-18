import javax.swing.*;
import java.awt.*;

class C_ch9_8 extends JFrame{
	public C_ch9_8() {
		setTitle("9장 8번 ");
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		JPanel NP = new JPanel();
		JPanel CP = new JPanel();
		JPanel SP = new JPanel();
		
		c.add(CP, BorderLayout.CENTER);
		c.add(NP, BorderLayout.NORTH);
		c.add(SP, BorderLayout.SOUTH);
		
		NP.setBackground(Color.LIGHT_GRAY); 
		NP.add(new JButton("열기"));
		NP.add(new JButton("닫기"));
		NP.add(new JButton("나가기"));
		
		for(int i=0; i < 10; i++) {
			JLabel label = new JLabel("*");
			
			int x = (int)(Math.random() *200) +10;
			int  y = (int)(Math.random() * 200)+10;
			
			label.setForeground(Color.RED);
			label.setLocation(x,y);
			label.setSize(10,10);
			label.setOpaque(true);
			c.add(label);
		}
		
		SP.setBackground(Color.yellow);
		SP.add(new JButton("Word input"));
		SP.add(new TextField(15));
		
		setVisible(true);
		
	}
}

public class ch9_8 {
	public static void main(String[] args) {
		new C_ch9_8();
	}
}
