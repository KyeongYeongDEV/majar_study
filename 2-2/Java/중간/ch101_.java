import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ch101_ extends JFrame{ 
    public ch101_(){
        setTitle("dkdk");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        JLabel jl = new JLabel("Love Java");
        c.add(jl);
        c.setLayout(new FlowLayout());

        jl.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                String text = jl.getText();
                if(text.equals("Love Java")){
                    jl.setText("사랑해");
                    setTitle("사랑해");
                }
                else if(text.equals("사랑해")){
                    jl.setText("Love Java");
                    setTitle("Love Java");
                }
            }
        });

        setSize(300,300);
        setVisible(true);
    }
    public static void main(String[] args){
        new ch101_();
    }
}
