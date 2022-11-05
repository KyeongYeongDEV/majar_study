import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ch10_5 extends JFrame{
    public ch10_5(){
        setTitle("10장 5번");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JLabel j = new JLabel("Love Java");
        j.setFont(new Font("Arial",Font.PLAIN,10));
        c.add(j);
        c.setFocusable(true);
        c.requestFocus();
        c.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                Font f = j.getFont();
                int size = f.getSize();

                if(e.getKeyCode() == KeyEvent.VK_ADD ||e.getKeyCode() == KeyEvent.VK_EQUALS){ //두 번재에 오는 조건도 붙여줘야 실행됨
                    j.setFont(new Font ("Arial",Font.PLAIN,size+5));
                }
                if(e.getKeyCode() == KeyEvent.VK_MINUS || e.getKeyCode() == KeyEvent.VK_SUBTRACT){
                    j.setFont(new Font("Arial",Font.PLAIN,size-5));
                }
            }

        });

        setSize(300,300);
        setVisible(true);
    }
    public static void main(String[] args){
        new ch10_5();
    }
    
}
