import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;

public class ch12_7 extends JFrame{
    private MyPanel panel = new MyPanel();

    public ch12_7(){
        setTitle("마우스로 폐다각형 그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        setSize(400,400);
        setVisible(true);
    }

    public class MyPanel extends JPanel{
        Vector<Integer> vx = new Vector<Integer>();
        Vector<Integer> vy = new Vector<Integer>();
        public MyPanel(){
            addMouseListener( new MouseAdapter(){
                public void mousePressed(MouseEvent e){
                    vx.add(e.getX());
                    vy.add(e.getY());
                    repaint();
                }
            });
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            int[] x = new int[vx.size()];
            int[] y = new int[vy.size()];
            for(int i=0; i <vx.size(); i++){
                x[i] = vx.get(i);
                y[i] = vy.get(i);
            }
            g.drawPolygon(x,y,vx.size());
        }
    }   
    public static void main(String[] args){
        new ch12_7();
    }
    
}
