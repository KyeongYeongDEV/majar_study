import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class ch12_5 extends JFrame{
    MyPanel panel  = new MyPanel();

    public ch12_5(){
        setTitle("dustmq");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        setSize(400,450);
        setVisible(true);
    }

    class MyPanel extends JPanel{
        ImageIcon icon  = new ImageIcon("1mini.png");
        Image img = icon.getImage();

        int width, height;

        public MyPanel(){
            width = img.getWidth(this);
            height = img.getHeight(this);

            addKeyListener(new KeyAdapter(){
                public void keyPressed(KeyEvent e){
                    if(e.getKeyChar() == '+'){
                        width *= 1.1;
                        height *= 1.1;
                        repaint();
                    }
                    else if(e.getKeyChar() == '-'){
                        width *= 0.9;
                        height *= 0.9;
                        repaint();
                    }
                }
            });

            setFocusable(true);
            requestFocus();
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img, 10, 10, width, height, this);
        }
    }
    public static void main(String[] args){
        new ch12_5();
    }
}
