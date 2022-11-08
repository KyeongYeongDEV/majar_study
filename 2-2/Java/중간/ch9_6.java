import javax.swing.*;
import java.awt.*;


class C_ch9_6 extends JFrame{
	public C_ch9_6() {
		super("Random Labels");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		
		for(int i=0; i < 10; i++) {
			JLabel label = new JLabel(Integer.toString(i));
			int x = (int)(Math.random() *200)+50;
			int y = (int)(Math.random() *200) +50;
			
			label.setBackground(Color.BLUE);
			label.setLocation(x,y);
			label.setSize(10,10);
			label.setOpaque(true);
			
			c.add(label);
		}
		setSize(300,300);
		setVisible(true);
	}
}

public class ch9_6 {
	public static void main(String[] args) {
		new C_ch9_6();
	}
}
