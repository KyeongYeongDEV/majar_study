import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class test122 extends{
    
    class Mypanel extends JPanel{
        Image img = new ImageIcon("0back.png").getImage();
        int x = 100, y =100;

        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img,0,0,getWidth(),getHeight(),this);
            g.setColor(Color.green);
            g.fillOval(x,y,)
        }
    }

    public static void main(String args){
        new test122();
    }
}
