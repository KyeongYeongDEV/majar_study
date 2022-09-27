import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ex10_7 extends JFrame{
	private JLabel la  = new JLabel();

	
	public ex10_7(){
		setTitle("key code 예제 : F1키 초록색, %키 노랜색");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.addKeyListener(new MyKeyListener());
		c.add(la);
		setSize(300,150);
		setVisible(true);
	}
	

	class MyKeyListener extends KeyAdapter{
		public void keypressed(KeyEvent e){
			Container contentPane = (Container)e.getSource();

			la.setText(KeyEvent.getKeyText(e.getKeyCode()) + "키가 입력되었음");

			if(e.getKeyChar() == '%'){
				contentPane.setBackground(Color.YELLOW);
			}
			else if(e.getKeyCode() == KeyEvent.VK_F1){
				contentPane.setBackground(Color.GREEN);
			}
		}
	}
	
	public static void main(String[] args) {
		new ex10_7();
	}

}
