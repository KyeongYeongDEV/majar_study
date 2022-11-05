import javax.swing.*;
import java.awt.*;

class x9_5 extends JFrame{
	public x9_5() {
		setTitle("4*4 Coor Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane(); 
	
		c.setLayout(new GridLayout(4,4));
		
		Color[] Clist = {
			Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
			Color.CYAN, Color.BLUE, Color.MAGENTA, Color.GRAY,
			Color.PINK, Color.LIGHT_GRAY, Color.WHITE, Color.DARK_GRAY,
			Color.BLACK, Color.ORANGE, Color.BLUE,Color.MAGENTA
		} ;
		
		for(int i=0; i < 16; i++) {
			JLabel Jl = new JLabel(Integer.toString(i));
			Jl.setBackground(Clist[i]);
			Jl.setOpaque(true);
			
			c.add(Jl);
		}
		
		setSize(400,200);
		setVisible(true);
		
	}
}

public class ch9_5 {
	public static void main(String[] args) {
		new x9_5();
	}
}
