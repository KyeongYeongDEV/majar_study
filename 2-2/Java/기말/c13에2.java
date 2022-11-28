import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyPanel extends JPanel{
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.MAGENTA);
        int x = (int)Math.random() *300;
        int y = (int)Math.random() *300;
        g.drawOval(x,y, 50,50);
    }
}

class Draw extends Thread{
    private  MyPanel pa;

    public Draw(MyPanel pa){
        this.pa = pa;
    }

    @Override
    public void run(){
        while(true){
            try{
                sleep(400);
                pa.repaint();

            }catch(InterruptedException e){
                return;
            }
        }
    }
}

public class c13에2 extends JFrame{
    MyPanel pa = new MyPanel();

    public c13에2(){
        setTitle("원을 0.4초 간격으로");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(pa);
        setContentPane(pa);
        pa.setLayout(null);
        pa.setOpaque(true);
        setSize(400,400);
        setVisible(true);
        
        Draw th = new Draw(pa);

        pa.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                th.start();
            }
        });
    }
    public static void main(String[] args){
        new c13에2();
    }
    
}
