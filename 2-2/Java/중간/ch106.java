import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ch106 extends JFrame{
    public ch106(){
        setTitle("연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JLabel jl = new JLabel("C");
        jl.setLocation(100,100);

        jl.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                int x = (int)(Math.random()*300);
                int y = (int)(Math.random()*300);   
                jl.setLocation(x,y);
            }
        });
        c.add(jl);

        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args){
        new ch106();
    }
}
