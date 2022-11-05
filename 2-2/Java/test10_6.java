import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class test10_6 extends JFrame{
    public test10_6(){
        setTitle("dd");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JLabel jl = new JLabel("C");
        jl.setLocation(100,100);
        jl.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                int x = (int)(Math.random()*190)+10;
                int y = (int)(Math.random()*190)+10;

                jl.setLocation(x,y);
            }
        });
        c.add(jl);

        setVisible(true);
    }

    public static void main(String[] args){
        new test10_6();
    }
}



