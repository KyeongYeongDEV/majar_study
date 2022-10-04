import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ch11_5 extends JFrame{
    public ch11_5(){
        setTitle("11장 5번");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JSlider js = new JSlider(100,200,120);
        JLabel jl = new JLabel("120");
        js.setMajorTickSpacing(20);
        js.setPaintLabels(true);
        // js.addChangeListener(new ChangeListener() {
		// 	public void stateChanged(ChangeEvent e) {
		// 		JSlider temp=(JSlider)e.getSource();
		// 		jl.setText(Integer.toString(temp.getValue()));
		// 	}
		// });

        c.add(js);

        jl.setBackground(Color.green);
        jl.setOpaque(true);
        c.add(jl);

        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args){
        new ch11_5();
    }
}
