import javax.swing.*;

class FrameThread extends Thread{
    private JFrame l;
    int x = 300;

    public FrameThread(JFrame l){
        this.l = l;
    }

    @Override
    public void run(){
        while(true){
            try{
                if(x == 300) x -=10;
                else x+=10;
                l.setLocation(x,x);
                sleep(10);
            }catch(InterruptedException e){
                return;
            }
        }
    }
}

public class c13에4 extends JFrame{
    public c13에4(){
        setTitle("진동하는 프레임 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FrameThread th = new FrameThread(this);
        setSize(400,400);
        setVisible(true);
        th.start();
    }

    public static void main(String[] args){
        new c13에4();
    }
}

