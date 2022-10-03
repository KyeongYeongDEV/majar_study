import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ch10_4 extends JFrame{
    public ch10_4(){
        setTitle("10장 3번");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JLabel j = new JLabel("Love Java");
        c.add(j);
        c.setFocusable(true);
        c.requestFocus();
        c.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    String str = j.getText();
                    j.setText(str.substring(1)+ str.charAt(0));
                }
            }
        });

        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args){
        new ch10_4();
    }
}
