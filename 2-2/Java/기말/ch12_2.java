import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ch12_2 extends JFrame{
    MyPanel panel = new MyPanel();
    public ch12_2(){
        setTitle("이미지 위에 원 드래깅 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        setLayout(new FlowLayout());
        setSize(300,300);
        setVisible(true);
    }

    class MyPanel extends JPanel{
        private ImageIcon image = new ImageIcon("back.png");
        private Image img = image.getImage();
        int x = 100, y =100;

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img,0,0,getWidth(),getHeight(),this);
            g.setColor(Color.green);
            g.fillOval(x,y,20,20);//좌표 및 사이즈

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
        new ch12_2();
    }
}
