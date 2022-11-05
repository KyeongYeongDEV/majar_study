import java.awt.*;
import javax.swing.*;

public class ch95_ extends JFrame{
    public ch95_(){
        setTitle("dkdk");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container c = getContentPane();
        c.setLayout(new GridLayout(4,4));
        Color[] color = {
            Color.RED, Color.ORANGE,Color.YELLOW, Color.GREEN,
            Color.CYAN,Color.BLUE, Color.MAGENTA, Color.GRAY,
            Color.PINK, Color.LIGHT_GRAY, Color.RED, Color.WHITE,
            Color.BLACK,Color.ORANGE,Color.BLUE,Color.CYAN
        };

        for(int i=0 ; i < 16; i++){
            JLabel jb = new JLabel(Integer.toString(i));
            jb.setBackground(color[i]);
            jb.setOpaque(true);
            c.add(jb);
        }

        setSize(300,300);
        setVisible(true);
    }
    public static void main(String[] args){
        new ch95_();
    }
}
