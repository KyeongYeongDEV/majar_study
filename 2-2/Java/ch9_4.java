import javax.swing.*;
import java.awt.*;

class ColorGrid extends JFrame{
	public ColorGrid(){
		setTitle("Ten Color Button Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		GridLayout grid = new GridLayout(1,10);
		
		c.setLayout(grid);
		
		Color[] color = {
				Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN,
				Color.BLUE,Color.MAGENTA, Color.GRAY, Color.PINK, Color.LIGHT_GRAY
		};
		
		for(int i =0;i <=9; i++) {
			JLabel BT  = new JLabel("    "+i);
			BT.setBackground(color[i]);
			BT.setOpaque(true);
			c.add(BT);
		}
		
		setSize(400, 200);
		setVisible(true);
	}
}

public class ch9_4 {
	public static void main(String[] args) {
		new ColorGrid();
	}
}
