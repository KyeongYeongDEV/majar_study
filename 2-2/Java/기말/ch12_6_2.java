import java.awt.*;
import javax.swing.*;

public class ch12_6_2 extends JFrame{
    private MyPanel  panel = new MyPanel();

    public ch12_6_2(){
        setTitle("격자 그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        setSize(300,300);
        setVisible(true);
    }

    class MyPanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            int count = 10;
            for(int i=0; i< 10; i++){
                int halfWidth = this.getWidth() / 2;
                int halfHeight = this.getHeight() /2;
                int fullWidth = this.getWidth();
                int fullHeight = this.getHeight();
                int calc = count *i;

                g.drawLine(calc, halfHeight, halfWidth, calc);
                g.drawLine(halfWidth, calc, fullWidth - calc, halfHeight);
                g.drawLine(fullWidth - calc, halfHeight, halfWidth, fullHeight - calc);
                g.drawLine(halfWidth, fullHeight-calc, calc, halfHeight );
            }
    }
} 
    public static void main(String [] args){
        new ch12_6_2();
    }

}
