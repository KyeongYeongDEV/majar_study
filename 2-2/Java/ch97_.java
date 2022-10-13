import java.awt.*;
import javax.swing.*;

public class ch97_ extends JFrame{
    public ch97_(){
        setTitle("ddd");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        JPanel pn = new JPanel();
        JPanel pc = new JPanel();
        JPanel ps = new JPanel();

        pn.add(new JLabel("입력"));
        pn.add(new JTextField(10));
        pn.setBackground(Color.LIGHT_GRAY);
        c.add(pn,BorderLayout.NORTH);

        String []str = {
            "0","1","2","3",
            "4","5","6","7",
            "8","9","CE","계산",
            "+","-","x","%"
        };
        pc.setLayout(new GridLayout(4,4));
        for(int i=0; i< 16; i++){
            JButton jb = new JButton(str[i]);
            pc.add(jb);
        }
        c.add(pc,BorderLayout.CENTER);

        ps.add(new JLabel("계산 결과"));
        ps.add(new JTextField(10));
        ps.setBackground(Color.YELLOW);
        c.add(ps, BorderLayout.SOUTH);

        setVisible(true);
    }   
    public static void main(String[] args){
        new ch97_();
    }
}
