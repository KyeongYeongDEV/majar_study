import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class test124 extends JFrame{
    private MyPanel panel  = new MyPanel();

    public test124(){
        setTitle("ds");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        setSize(500,500);
        setVisible(true);
    }
    

    class MyPanel extends JPanel{
        Image img = new ImageIcon("1mini.png").getImage();
        int x = 0, y=0;

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img,x,y,getWidth()/4, getHeight()/4,this);

            addMouseMotionListener(new MouseMotionAdapter(){
                public void mouseDragged(MouseEvent e){
                    x= e.getX();
                    y = e.getY();
                    repaint();
                }
            });
        }
    }
    public static void main(String[] args){
        new test124();
    }
    
}
