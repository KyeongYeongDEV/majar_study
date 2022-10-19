import javax.swing.*;
import java.awt.*;

public class test_9_5 extends JFrame{
    public test_9_5(){
        setTitle("ddd");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,300);

        Container c = getContentPane();
        c.setLayout(new GridLayout(1,10));

        for(int i=0;i < 10; i++){
            JButton btn = new JButton(Integer.toString(i));
            btn.setBackground(Color.RED);
            btn.setOpaque(true);
            c.add(btn);

        }

        setVisible(true);
    }

    public static void main(String[] args){
        new test_9_5();
    }
    
}
