import javax.swing.*;
import java.awt.*;

public class test_9_8 extends JFrame{
    public test_9_8(){
        setTitle("dd");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        JPanel js = new JPanel();
        JPanel jc = new JPanel();
        JPanel jn = new JPanel();
        c.add(js,BorderLayout.NORTH);
        c.add(jc, BorderLayout.CENTER);
        c.add(jn, BorderLayout.SOUTH);

        js.add(new JButton("열기"));
        js.add(new JButton("닫기"));
        js.add(new JButton("나가기"));
        js.setBackground(Color.GRAY);

        for(int i =0; i <10; i++){
            JLabel star = new JLabel("*");
            
            int x =(int)(Math.random()*200)+20;
            int y =(int)(Math.random()*200)+20;

            star.setLocation(x,y);
            star.setForeground(Color.RED);
            star.setSize(10,10);
            star.setOpaque(true);
            
            c.add(star);
        }
       
        jn.add(new JButton("Word Input"));
        jn.add(new JTextField(10));
        jn.setBackground(Color.YELLOW);

        setVisible(true);
    }

    public static void main(String[] args){
        new test_9_8();
    }
}
