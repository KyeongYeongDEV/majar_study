package 기말;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;



public class test121 extends JFrame{
    private MyPanel panel = new MyPanel();
    private JButton btn  = new JButton("Hide/Show");

    private ImageIcon image = new ImageIcon("0back.png");
    private Image img = image.getImage();

    boolean check =1;


    public test121(){

    }

    class MyPanel extends JPanel{
        public void paintCoponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img,0,0,getWidth(), getHeight(), this);
        }
    }
    
    public static void main(String[] args){
        new test121();
    }
}
