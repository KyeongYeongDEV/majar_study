import javax.swing.*;
import java.awt.*;


import java.awt.event.*;

public class test_10_1 extends JFrame{
    public test_10_1(){
        setTitle("ddd");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);

        Container c= getContentPane();
        c.setLayout(new FlowLayout());

        JLabel jl = new JLabel("Love Java");

        jl.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                jl.setText("사랑해");
            }
            public void mouseExited(MouseEvent e){
                jl.setText("Love Java");
            }
        });
        c.add(jl);

        setVisible(true);
    }

    public static void main(String[] args){
        new test_10_1();
    }
    
}
