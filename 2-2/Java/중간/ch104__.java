import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ch104__ extends JFrame{
    public ch104__(){
        setTitle("dd");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JLabel jb = new JLabel("Love Java");
        
        jb.setFocusable(true);
        jb.requestFocus();
        jb.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                String str = jb.getText();
                jb.setText(str.substring(1)+ str.charAt(0));
            }
        });
        c.add(jb);

        setVisible(true);
    }
    public static void main(String[] args){
        new ch104__();
    }
}
