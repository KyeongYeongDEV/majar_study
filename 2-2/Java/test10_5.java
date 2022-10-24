import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class test10_5 extends JFrame{
    public test10_5(){
        setTitle("dd");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JLabel jl = new JLabel("Love Java");
        jl.setFont(new Font("Arial",Font.PLAIN, 10));

        jl.setFocusable(true);
        jl.requestFocus();
        jl.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                Font f = jl.getFont();
                int size = f.getSize();
                if(e.getKeyCode() == KeyEvent.VK_PLUS | e.getKeyCode() == KeyEvent.VK_EQUALS){
                    jl.setFont(new Font("Arial", Font.PLAIN, size+5));
                }
                else if(e.getKeyCode() == KeyEvent.VK_MINUS){
                    if(size >5){
                        jl.setFont(new Font("Arial",Font.PLAIN, size-5));
                    }
                }
                
            }
        });

        c.add(jl);
        setVisible(true);
    }

    public static void main(String[] args){
        new test10_5();
    }
}