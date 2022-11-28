import javax.swing.*;

class LabelThread extends Thread{
    private JLabel l;
    int x = 100;

    public LabelThread(JLabel l){
        this.l = l;
    }

    @Override
    public void run(){
        while(true){
            try{
                if(x == 100) x-=10;
                else x+=10;
                l.setLocation(x,x);
                sleep(10);
            }catch(InterruptedException e){
                return;
            }
        }
    }
}


public class c13에4_2 extends JFrame{
    private JLabel l = new JLabel("흔들리는 레이블");

    public c13에4_2(){
        setTitle("진동하는 레이블 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        l.setBounds(100,100,100,100);
        add(l);

        LabelThread th = new LabelThread(l);
        th.start();
        setSize(500,500);
        setVisible(true);
    }
    public static void main(String[] args){
        new c13에4_2();
    }    
}