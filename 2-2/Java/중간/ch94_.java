import java.awt.*;
import javax.swing.*;

public class ch94_ extends JFrame{
    public ch94_(){
        setTitle("dkssud");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container c = getContentPane();
        c.setLayout(new GridLayout(1,10));
        Color[] color = {
            Color.RED, Color.ORANGE,Color.YELLOW, Color.GREEN,Color.CYAN,
            Color.BLUE, Color.MAGENTA, Color.GRAY,Color.PINK, Color.LIGHT_GRAY
        };

        for(int i=0; i <10; i++){
            JButton jb = new JButton(Integer.toString(i));
            jb.setBackground(color[i]);
            jb.setOpaque(true);
            c.add(jb);
        }
        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] arg){
        new ch94_();
    }
    
}
