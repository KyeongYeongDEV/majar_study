import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ch102 extends JFrame{
    public ch102(){
        setTitle("드래깅 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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

        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args){
        new ch102();
    }
}
