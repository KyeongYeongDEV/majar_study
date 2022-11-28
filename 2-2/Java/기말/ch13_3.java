import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

class TimeThread extends Thread {
	private JLabel la;

	public TimeThread(JLabel la) {
		this.la = la;
	}

	@Override
	public void run() {
		while (true) {
			Calendar c = Calendar.getInstance();
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int min = c.get(Calendar.MINUTE);
			int second = c.get(Calendar.SECOND);

			String clock = Integer.toString(hour);
			clock = clock.concat(":");
			clock = clock.concat(Integer.toString(min));
			clock = clock.concat(":");
			clock = clock.concat(Integer.toString(second));
			la.setText(clock);

		}
	}
}

public class ch13_3 extends JFrame {
	JLabel la = new JLabel();

	public ch13_3() {
		super("디지털 시계 만들기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(la,BorderLayout.CENTER);
		
		la.setVerticalAlignment(SwingConstants.CENTER);
		la.setHorizontalAlignment(SwingConstants.CENTER);

		la.setFont(new Font("Gothic", Font.ITALIC, 80));
		c.add(la);

		TimeThread th = new TimeThread(la);
		setSize(500, 500);

		setVisible(true);
		th.start();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ch13_3();
	}

}