import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ch10_1 extends JFrame{
    public ch10_1(){
        setTitle("10장 1번");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        
        JLabel j = new JLabel("Love Java");
        j.addMouseListener(new MouseAdapter(){
            public void mouseExited(MouseEvent e){
                j.setText("사랑해");
            }
            public void mouseEntered(MouseEvent e){
                j.setText("Love Java");
            }
        });
        c.add(j);

        setSize(300,300);
        setVisible(true);
}

    public static void main(String[] arg){
        new ch10_1();
    }
}
