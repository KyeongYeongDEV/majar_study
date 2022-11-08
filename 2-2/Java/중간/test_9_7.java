import javax.swing.*;
import java.awt.*;

public class test_9_7 extends JFrame{
    public test_9_7(){
        setTitle("dd");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        JPanel jn = new JPanel();
        JPanel jc = new JPanel(new GridLayout(4,4));
        JPanel js = new JPanel();

        jn.add(new JLabel("수식입력"));
        jn.add(new JTextField(10));
        jn.setBackground(Color.LIGHT_GRAY);
        jn.setOpaque(true);
        c.add(jn, BorderLayout.NORTH);

        String[] str = {
            "0","1","2","3",
            "4","5","6","7",
            "8","9","CE","계산",
            "+","-","*","/"
        };

        for(int i=0; i< 16; i++){
            JButton jb = new JButton(str[i]);
            if(i>11){
                jb.setBackground(Color.GREEN);
                jb.setOpaque(true);
            }
            jc.add(jb);
        }
        c.add(jc, BorderLayout.CENTER);

        js.add(new JLabel("계산 결과"));
        js.add(new JTextField(10));
        js.setBackground(Color.YELLOW);

        c.add(js, BorderLayout.SOUTH);

        setVisible(true);


    }
    public static void main(String[] args){
        new test_9_7();
    }
}