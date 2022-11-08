import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ch11_2 extends JFrame{
    JTextField jt = new JTextField(10);
    JComboBox<String> jc = new JComboBox<String>();
    public ch11_2(){
        setTitle("11_2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c= getContentPane();
        c.setLayout(new FlowLayout());

        jt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JTextField j = (JTextField)e.getSource();
                String tmp = j.getText();
                j.setText(" ");
                jc.addItem(tmp);
            }
        });

        c.add(jt);
        c.add(jc);

        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args){
        new ch11_2();
    }
}
