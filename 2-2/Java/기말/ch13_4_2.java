import java.awt.*;
import javax.swing.*;
import java.util.*;

class myth extends Thread{
    private JLabel l;
    int x = 100;

    public myth(JLabel l){
        this.l = l;
    }

    public void run(){
        while(true){
            try{
                if(x == 100) x+=20;
                else  x-= 20;
                l.setLocation(x,x);
                sleep(10);
            }catch(InterruptedException e){
                return;
            }
        }
    }
}

public class ch13_4_2 extends JFrame{
    private JLabel l = new JLabel("진동 레이블");
    public ch13_4_2(){
        setTitle("진동하는 레이블 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        l.setBounds(100,100,200,300);
        add(l);
        
        myth th= new myth(l);
        th.start();
        setVisible(true);
        setSize(500,500);
    }
    public static void main(String[] args){
        new ch13_4_2();
    }    
}
