import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ch10_2 extends JFrame{
    public ch10_2(){
        setTitle("10장 2번");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.setBackground(Color.GREEN);
        
        c.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseReleased(MouseEvent e){
                c.setBackground(Color.GREEN);
            }
        });
        c.addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseDragged(MouseEvent e){
                c.setBackground(Color.YELLOW);
            }
        });
        
        setSize(300,300);
        setVisible(true);        
    }


    public static void main(String[] args){
        new ch10_2();
    }
}
