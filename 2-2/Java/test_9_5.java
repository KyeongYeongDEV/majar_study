import javax.swing.*;
import java.awt.*;

public class test_9_5 extends JFrame{
    public test_9_5(){
        setTitle("ddd");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,300);

        Container c = getContentPane();
        c.setLayout(new GridLayout(4,4));

        Color [] color = {
            Color.RED,Color.BLACK,Color.BLUE,Color.CYAN,
            Color.RED,Color.BLACK,Color.BLUE,Color.CYAN,
            Color.RED,Color.BLACK,Color.BLUE,Color.CYAN,
            Color.RED,Color.BLACK,Color.BLUE,Color.CYAN
        };

        for(int i=0;i < 16; i++){
            JLabel btn = new JLabel(Integer.toString(i));
            btn.setBackground(color[i]);
            btn.setOpaque(true);
            c.add(btn);

        }

        setVisible(true);
    }

    public static void main(String[] args){
        new test_9_5();
    }
    
}
