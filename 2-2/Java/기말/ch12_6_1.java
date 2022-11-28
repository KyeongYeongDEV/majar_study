import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ch12_6_1 extends JFrame{
    private MyPanel panel = new MyPanel();
    public ch12_6_1(){
        setTitle("격자 그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel); //밑에서 만든 패너을 추가해주기만 하면 된다.
        setSize(300,300);
        setVisible(true);
    }


    class MyPanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            int x = this.getWidth() / 10;
            int y = this.getHeight() / 10;

            System.out.println(x + " " + this.getWidth());
            for(int i =1; i<10; i++){
                g.drawLine(0, y*i, this.getWidth(), y *i);
            }
            for(int i =1; i< 10; i++){
                g.drawLine(x*i, 0, x*i, this.getHeight());
            }
        }
    }
    public static void main(String[] args){
        new ch12_6_1();
    }
    
}
