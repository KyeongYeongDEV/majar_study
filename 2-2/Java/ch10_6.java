import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ch10_6 extends JFrame {
    public ch10_6(){
        setTitle("10장 6번문제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JLabel j = new JLabel("c");
        c.add(j);
        j.setLocation(100,100);
        j.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int x = (int)(Math.random()* c.getWidth());
                int y = (int)(Math.random() * c.getHeight());
                j.setLocation(x,y);
            }
        });
        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args){
        new ch10_6();
    }
}
