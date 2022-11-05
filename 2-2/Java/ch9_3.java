import javax.swing.*;
import java.awt.*;

class Grid extends JFrame{
	public Grid() {
		setTitle("Ten Color Button Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridLayout grid = new GridLayout(1,10);
		
		Container c = getContentPane();
		c.setLayout(grid);
		
		for(int i=0; i <=9; i++) {
			c.add(new JButton(Integer.toString(i)));
		}
		
		setSize(400,200);
		setVisible(true);
	}
}

public class ch9_3 {
	public static void main(String[] args) {
		new Grid();
	}
}
