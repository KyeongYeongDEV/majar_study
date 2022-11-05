import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ch101번 extends JFrame{
    public ch101번(){
        setTitle("dddd");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JLabel j = new JLabel("Love Java");
        j.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
              //  JLabel jb = (JLabel)e.getSource();
                j.setText("사랑해");
                
            }
            public void mouseExited(MouseEvent e){
              //  JLabel jb = (JLabel)e.getSource();
                j.setText("Love Java");
                
            }
        });
        c.add(j);

        setVisible(true);
    }

    public static void main(String[] args){
        new ch101번();
    }
}
