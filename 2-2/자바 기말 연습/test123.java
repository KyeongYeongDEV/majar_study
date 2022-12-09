import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class test123 extends JFrame{
    public test123(){
        setTitle("prac");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);
        
        ImageIcon icon = new ImageIcon("0back.png");
        JLabel label = new JLabel();
        label.setIcon(icon);
        label.setSize(icon.getIconWidth(),icon.getIconHeight());
        
        c.add(label);
        c.addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent e){
                label.setLocation(e.getX(),e.getY());
            }
        });
        setSize(500,500);
        setVisible(true);
    }
    public static void main(String[] args){
        new test123();
    }
}
