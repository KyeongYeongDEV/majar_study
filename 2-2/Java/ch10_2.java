import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ch10_2 extends JFrame {
	JPanel contentPane = new JPanel(); //컨텐트팬에 사용할 패널 
	
	public ch10_2() {
		setTitle("드래깅동안 YELLO");//타이틀 이름 
		setLayout(new FlowLayout());//레이아웃 설정 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//닫기 버튼 누르면 꺼
		
		setContentPane(contentPane);
		contentPane.setBackground(Color.GREEN);
		
		contentPane.addMouseMotionListener(new MyMouseMotionListener());//패널에 마우스 모션 리스너 추가 
		contentPane.addMouseListener(new MyAdapter());//패널에 마우스리스너 추가 
		
		setSize(400,200);
		setVisible(true);
	}
	
	//아래는 상속받는 클래스들 
	class MyMouseMotionListener extends MouseMotionAdapter{
		@Override
		public void mouseDragged(MouseEvent e) {
			//마우스가 드래그 되는 동안 
			contentPane.setBackground(Color.YELLOW);
			}
	}
	
	class MyAdapter implements MouseListener{
		public void mouseReleased(MouseEvent e) {
			//눌러진 마우스가 떼어질 때 
			contentPane.setBackground(Color.GREEN);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}
	}

	public static void main(String[] args) {
		new ch10_2(); //실행 
	}
}
