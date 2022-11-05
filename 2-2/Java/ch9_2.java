import java.awt.*;
import javax.swing.*;

class Border extends JFrame{
	public Border() {
		setTitle("BorderLayout practice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		setLayout( new BorderLayout(5,7));
		
		c.add(new JButton("North"), BorderLayout.NORTH);
		c.add(new JButton("West"), BorderLayout.WEST);
		c.add(new JButton("Center"), BorderLayout.CENTER);
		c.add(new JButton("East"), BorderLayout.EAST);
		c.add(new JButton("South"), BorderLayout.SOUTH);
		
		setSize(400,200);
		setVisible(true);
	}
}

public class ch9_2 {
	public static void main(String[] args) {
		new Border();
	}
}
