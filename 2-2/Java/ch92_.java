import java.awt.*;
import javax.swing.*;

public class ch92_ extends JFrame{
    public ch92_(){
        setTitle("dustmq");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new BorderLayout(5,7));
        c.add(new Button("NORTH"), BorderLayout.NORTH);
        c.add(new Button("CENTER"), BorderLayout.CENTER);
        c.add(new Button("SOUTH"), BorderLayout.SOUTH);
        c.add(new Button("EAST"), BorderLayout.EAST);
        c.add(new Button("WEST"), BorderLayout.WEST);        

        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args){
        new ch92_();
    }
}
