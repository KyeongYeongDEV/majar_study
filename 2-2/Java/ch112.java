import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ch112 extends JFrame{
    public ch112(){
        setTitle("ddd");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JComboBox<String> cb = new JComboBox<String>();
        JTextField tf = new JTextField(10);

        tf.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                cb.addItem(tf.getText());
                tf.setText("");
            }
        });
        c.add(tf);
        c.add(cb);

        setVisible(true);
    }

    public static void main(String[] args){
        new ch112();
    }
}
