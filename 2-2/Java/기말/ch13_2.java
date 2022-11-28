import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel extends JPanel {
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.MAGENTA);
		int x = (int) (Math.random() * 300);
		int y = (int) (Math.random() * 300);
		g.drawOval(x, y, 50, 50);
	}
}

class CircleThread extends Thread {
	private MyPanel pa;

	public CircleThread(MyPanel pa) {
		this.pa = pa;
	}

	@Override
	public void run() {
		while (true) {
			try {
				sleep(500);
				pa.repaint();
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}

public class ch13_2 extends JFrame {
	MyPanel pa = new MyPanel();

	public ch13_2() {
		super("원을 0.5초 간격으로...");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(pa);
		setContentPane(pa);
		pa.setLayout(null);
		pa.setOpaque(true);
		setSize(400, 400);
		setVisible(true);
		
		CircleThread th = new CircleThread(pa);

		pa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				th.start();
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ch13_2();
	}

}