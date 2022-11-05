import javax.swing.*;
import java.awt.*;

class cl7 extends JFrame{
	public cl7() {
		setTitle("9장 7번 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		
		Container c = getContentPane();
		
		JPanel jn = new JPanel();
		JPanel jc= new JPanel();
		JPanel js = new JPanel();
		
		jn.setBackground(Color.gray);
		jc.setLayout(new GridLayout(4,4));
		js.setBackground(Color.yellow);
		
		c.add(jn, BorderLayout.NORTH);
		c.add(jc,BorderLayout.CENTER);
		c.add(js, BorderLayout.SOUTH);
		
		JLabel label1 = new JLabel("수식 입력 ");
		JTextField txf1 = new JTextField(10);
		jn.add(label1);
		jn.add(txf1);
		
		String[] str = {
				"0","1","2","3",
				"4","5","6","7",
				"8","9","CE","계산",
				"+","-","*","/"
		};
		
		for(int i = 0; i < 16; i++) {
			if(i >=12) {
				JButton jb = new JButton(str[i]);
				jb.setBackground(Color.cyan);
				jb.setOpaque(true);
				jc.add(jb);
			}else {
				JButton jb = new JButton(str[i]);
				jc.add(jb);
			}
		}
		
		JLabel label2 = new JLabel("계산 결과");
		JTextField txf2 = new JTextField(10);
		js.add(label2);
		js.add(txf2);
		
		setVisible(true);
	}
}

public class ch9_7 {
	public static void main(String[] args) {
		new cl7();
	}
}
