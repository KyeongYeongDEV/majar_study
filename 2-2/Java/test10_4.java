import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class test10_4 extends JFrame{
    public test10_4(){
        setTitle("ddd");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);

        Container c= getContentPane();
        c.setLayout(new FlowLayout());

        JLabel jl = new JLabel("Love Java");


        jl.setFocusable(true);
        jl.requestFocus();
        jl.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                String str = jl.getText();

                jl.setText(str.substring(1,str.length()) + str.charAt(0));
            }
        });
        c.add(jl);        
        setVisible(true);

    }

    public static void main(String[] args){
        new test10_4();
    }
    
}
