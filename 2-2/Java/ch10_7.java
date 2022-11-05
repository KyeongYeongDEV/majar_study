import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ch10_7 extends JFrame {
    public ch10_7(){
        setTitle("10장 7번");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container c = getContentPane();
        JLabel j = new JLabel("Love Java");

        c.setLayout(new FlowLayout());
        c.add(j);

        j.addMouseWheelListener(new MouseWheelListener(){
            public void mouseWheelMoved(MouseWheelEvent e){
                int n = e.getWheelRotation();
                Font f = j.getFont();
                int size = f.getSize();
                if(n <0){
                    if(size -5 >0){
                        j.setFont(new Font("Arial",Font.PLAIN, size-5));
                    }
                }
                else{
                    j.setFont(new Font("Arial",Font.PLAIN, size+5));
                }

            }
        });
        
        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args){
        new ch10_7();
    }
}
