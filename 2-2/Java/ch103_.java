import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ch103_ extends JFrame{
    public ch103_(){
        setTitle("'dd");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        JLabel j = new JLabel("Love Java");
        c.setLayout(new FlowLayout());
        c.add(j);
        c.setFocusable(true);
        c.requestFocus();

        c.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    String text = j.getText();
                    if(text.equals("Love Java")){
                        j.setText("avaJ evoL");
                    }
                    else if(text.equals("avaJ evoL")){
                        j.setText("Love Java");
                    }
                }
            }
        });

        setSize(300,300);
        setVisible(true);
    }
    public static void main(String[] args){
        new ch103_();
    }
    
}
