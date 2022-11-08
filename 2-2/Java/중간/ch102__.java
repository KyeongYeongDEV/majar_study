import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ch102__ extends JFrame{
    public ch102__(){
        setTitle("ddd");
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
            c.setBackground(Color.RED);
           }
       });

        setVisible(true);
    }
    public static void main(String[] args){
        new ch102__();
    }
}
