import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ch102_ extends JFrame{
    public ch102_(){
        setTitle("dddkdk");
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
        new ch102_();
    }
}
