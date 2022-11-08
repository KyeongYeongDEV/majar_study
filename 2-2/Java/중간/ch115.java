import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class ch115 extends JFrame{
    public ch115(){
        setTitle("dd");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
    
        JSlider js = new JSlider(100,200,120);
        JLabel jl = new JLabel("120");

        js.setMajorTickSpacing(20);
        js.setPaintLabels(true);

        jl.setBackground(Color.GREEN);
        jl.setOpaque(true);
        c.add(js);
        c.add(jl);
       

        js.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e){
                jl.setText(""+ js.getValue());
            }
        });

        setVisible(true);
    }
    public static void main(String[] args){
        new ch115();
    }
}
