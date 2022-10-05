import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ch104 extends JFrame{
    public ch104(){
        setTitle("연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.setFocusable(true);
        c.requestFocus();

        JLabel jl = new JLabel("Love Java");
        c.add(jl);

        c.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    String text = jl.getText();
                    jl.setText(text.substring(1,text.length()) + text.charAt(0));
                    c.add(jl);
                } 
            }
        });

        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args){
        new ch104();
    }
}
