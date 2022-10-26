import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ch12_2 extends JFrame{
	private MyPanel panel = new MyPanel();
	public ch12_2(){//레이아웃과 사이즈 등 기본 설정을 한다.
		setTitle("이미지 위에 원 드래깅 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setLayout(new FlowLayout());
		setSize(300, 300);
		setVisible(true);
	}
	
	// paintComponent를 이용하여 이미지 그림
	class MyPanel extends JPanel{
		private ImageIcon image = new ImageIcon("/Users/kyeongyeong/Library/Mobile Documents/com~apple~CloudDocs/가족사진/2013-10-2918.06.3965199.770.jpg");	//사진 위치 경로
		private Image img = image.getImage();//이미지 저장
		int x = 100, y = 100;//기본 좌표 설정
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);		// 화면에 꽉 차게 사진을 채워 넣는다
			g.setColor(Color.green); //포인터 색 설정
			g.fillOval(x, y, 20, 20);								// 초기 위치는 (100, 100)으로 설정
			
			addMouseMotionListener(new MouseMotionAdapter() {
				public void mouseDragged(MouseEvent e) { //마우스 드래그 이벤트 발생 시
					// x와 y의 좌표를 드래그 된 위치로 바꾸고 repaint()
					x = e.getX(); //현재 마우수의, (x,y)좌표로 초기화
					y = e.getY();
					repaint();
				}
			});
		}
	}
	
	public static void main(String[] args) {
		new ch12_2();
	}
}