import javax.swing.*;

class Study_Swing extends JFrame{
	public Study_Swing() {
		setTitle("Let's study Java");
		setSize(400,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
	}
}

public class ch9_1 {
	public static void main(String[] arg) {
		new Study_Swing();
	}
}
