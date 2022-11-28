import javax.swing.*;

class FrameThread extends Thread {
	private JFrame j;
	int x = 400;

	public FrameThread(JFrame j) {
		this.j = j;
	}

	@Override
	public void run() {
		while (true) {
            try{
                if (x == 400)x += 10;
			    else x -= 10;
			j.setLocation(x, x);
            sleep(10);
            }catch(InterruptedException e){
                return;
            }
			
		}
	}
}

public class ch13_4_1 extends JFrame {
	public ch13_4_1() {
		super("진동하는 프레임 만들기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		FrameThread th = new FrameThread(this);
		setSize(400, 400);
		setVisible(true);
		th.start();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ch13_4_1();
	}

}