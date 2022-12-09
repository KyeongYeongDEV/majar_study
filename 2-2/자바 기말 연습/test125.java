import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class test125 extends JFrame{
    private MyPanel panel = new MyPanel();
    public test125(){
        setTitle("dd");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        setSize(500,500);
        setVisible(true);
    }


    class MyPanel extends JPanel{
        Image img = new ImageIcon("1mini.png").getImage();
        int width, height;

        public MyPanel(){
            width = img.getWidth(this);
            height = img.getHeight(this);

            addKeyListener(new KeyAdapter(){
                public void keyPressed(KeyEvent e){
                    if(e.getKeyChar() == '+'){
                        width *= 1.1;
                        height *= 1.1;
                    }
                    else if(e.getKeyChar() == '-'){
                        width *= 0.9;
                        height *= 0.9;
                    }
                }
            });

            setFocusable(true);
            requestFocus();
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img,0,0,width,height,this);
            repaint();
        }
    }

    public static void main(String[] args){
        new test125();
    }
}
