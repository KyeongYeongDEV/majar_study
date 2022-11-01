import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class ch13_2 extends JFrame {
	MyPanel p = new MyPanel();

	public ch13_2() { //타이틀, 종료, 컨테이너, 사이즈, 비저블 설정
		setTitle("원을 0.5초 간격으로 랜덤 이동");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(p);
		setSize(300, 300);
		setVisible(true);
	}

	class MyPanel extends JPanel implements Runnable {
		int x, y;

		public void paintComponent(Graphics g) { //원의 크기, 색, 위치 설정
			super.paintComponent(g);
			g.setColor(Color.red);
			g.drawOval(x, y, 50, 50);
		}

		public MyPanel() {
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) { //마우스가 클릭을 하면 시작
					Thread th;
					th = new Thread(p); //스레드 생성 
					th.start();//스레드 실행
				}
			});
		}

		public void run() {
			while (true) {
				try {
					Thread.sleep(500);//0.5초
				} catch (InterruptedException e) {
					return;
				}
                //랜덤값 x,y
				x = (int) (Math.random() * getWidth()); //최대범위가  setSize범위 까지입니다
				y = (int) (Math.random() * getHeight());
				repaint(); //컴포넌트를 다시 그립니다.
			}
		}
	}

	public static void main(String[] args) {
		new ch13_2(); 
	}
}


