import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ch11_4 extends JFrame{
    JButton cal;
	JTextField input;
	JLabel money[]=new JLabel[8];
	String moneytag[]= {"오만원","만원","천원","500원","100원","50원","10원","1원"};
	int moneys[]= {50000,10000,1000,500,100,50,10,1};
	JTextField result[]=new JTextField[8];
	JCheckBox check[]=new JCheckBox[7];

	public ch11_4() {
		setTitle("Money Changer with CheckBox");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=getContentPane();
		c.setLayout(new BorderLayout());
		c.setBackground(Color.pink);
		
		JPanel North=new JPanel();
		
		North.setLayout(new FlowLayout());
		North.add(new JLabel("금액"));
		input=new JTextField(10);
		cal=new JButton("계산");
		
	    cal.addActionListener(new ActionListener() { //버튼이 눌린다면
			public void actionPerformed(ActionEvent e) {
				int total=Integer.parseInt(input.getText());

				for(int i=0;i<7;i++) {
					if(check[i].isSelected()) { //선택되어 있다면 계산
						result[i].setText(Integer.toString(total/moneys[i])); //체크되어 있는 액수에 해당하는 번째를 moneylag를 이용해 장수를 구한 뒤 저장해 준다.
						total%=moneys[i];// 처음 입력받은 total을 체크되어있는 값으로 나누고 남은 나머지로 바꿔준다.
					}
					else {
						result[i].setText("0"); //체크되어 있지 않으면 나누지 않으므로 0을 띄워준다.
					}
				}

				result[7].setText(Integer.toString(total)); // 남은 값은 1의 자리수밖에 없으므로 1의 자리칸에 저장해준다.
			}
		});

		North.add(input);
		North.add(cal);
		North.setBackground(Color.pink);
		c.add(North,BorderLayout.NORTH);
		
		
		JPanel center=new JPanel();
		center.setLayout(new GridLayout(8,3));
		center.setBackground(Color.pink);

		for(int i=0;i<8;i++) { //위에서 계산된 값을 이용해 액수에 따른 장수를 화면에 띄어준다.
			money[i]=new JLabel(moneytag[i]);
			result[i]=new JTextField();
			center.add(money[i]);
			center.add(result[i]);
			if(i<7) {
				check[i]=new JCheckBox();
				check[i].setBackground(Color.pink);
				center.add(check[i]);
			}
		}
		c.add(center,BorderLayout.CENTER);
		
		
		JPanel west=new JPanel();
		west.setBackground(Color.pink);
		c.add(west,BorderLayout.WEST);
		
		JPanel east=new JPanel();
		east.setBackground(Color.pink);
		c.add(west,BorderLayout.EAST);
		
		JPanel south=new JPanel();
		south.setBackground(Color.pink);
		c.add(west,BorderLayout.SOUTH);
		
		setSize(300,300);
		setVisible(true);
    }

    public static void main(String[] args){
        new ch11_4();
    }
}
