import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ch11__5 extends JFrame{
    public ch11__5(){
        setTitle("연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JSlider js = new JSlider(100,200,120);
        JLabel jl = new JLabel("120");

        jl.setBackground(Color.GREEN);
        jl.setOpaque(true);

        js.setMajorTickSpacing(20);
        js.setPaintLabels(true);       
        js.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider temp=(JSlider)e.getSource();
				jl.setText(Integer.toString(temp.getValue()));
			}
		});
        c.add(js);
        c.add(jl);

        setSize(300,300);
        setVisible(true);
    }
    public static void main(String[] args){
        new ch11__5();
    }
}
