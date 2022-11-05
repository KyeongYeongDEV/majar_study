import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ch105 extends JFrame{
    public ch105(){
        setTitle("연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JLabel jl = new JLabel("Love Jave");
        jl.setFont(new Font("Arial",Font.PLAIN,10));
        jl.setSize(200,200);
        jl.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                Font f = jl.getFont();
                int size = f.getSize();
                
                if(e.getKeyCode() == KeyEvent.VK_PLUS){
                    jl.setFont(new Font("Arial", Font.PLAIN, size+5));
                }
                else if(e.getKeyCode() == KeyEvent.VK_MINUS){
                    jl.setFont(new Font("Arial", Font.PLAIN, size -5));
                }
            }
        });
        c.add(jl);

        setSize(300,300);
        setVisible(true);
    }

    public static void mian(String[] args){
        new ch105();
    }
}
