import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class test10_2 extends JFrame{
    public test10_2(){
        setTitle("dd");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        
        c.setBackground(Color.GREEN);

        c.addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent e){
                c.setBackground(Color.GREEN);
            }
        });

        c.addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent e){
                c.setBackground(Color.YELLOW);
            }
        });
        setVisible(true);
    }
    public static void main(String[] args){
new test10_2();
    }
    
}
