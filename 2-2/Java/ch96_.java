import java.awt.*;
import javax.swing.*;

public class ch96_ extends JFrame{
    public ch96_(){
        setTitle("ddd");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(null);

        for(int i=0; i < 20; i++){
            JLabel j = new JLabel(Integer.toString((int)(Math.random()*100)));
            int x = (int)(Math.random()*200)+50;
            int y = (int)(Math.random()*200)+50;

            j.setBackground(Color.RED);
            j.setLocation(x,y);
            j.setSize(20,20);        
            j.setOpaque(true);

            c.add(j);
        }

        setSize(300,300);
        setVisible(true);
    }
    public static void main(String[] args){
        new ch96_();
    }
}
