import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ch12_4 extends JFrame{
    MyPanel panel  = new MyPanel();
    public ch12_4(){
        setTitle("이미지 레이블 드래깅 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        setVisible(true);
        setSize(500,500);
    }

    class MyPanel extends JPanel{
        private ImageIcon image = new ImageIcon("1mini.png");
        private Image img = image.getImage();
        int x=0, y=0;

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img,x,y,getWidth()/4, getHeight()/4, this);
            addMouseMotionListener(new MouseMotionAdapter(){
                public void mouseDragged(MouseEvent e){
                    x = e.getX();
                    y = e.getY();
                    repaint();
                }
            });
        }
    }
    public static void main(String[] args){
        new ch12_4();
    }
}
