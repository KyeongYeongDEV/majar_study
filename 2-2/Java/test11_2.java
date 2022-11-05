import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class test11_2 extends JFrame{
    public test11_2(){
        setTitle("dd");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JTextField jt = new JTextField(10);
        JComboBox<String> jc = new JComboBox<String>();
        
        c.add(jt);
        c.add(jc);

        jt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String str = jt.getText();
                jc.addItem(str);
                jt.setText("");
            }
        });

        

        setVisible(true);

        

        
    }
    public static void main(String[] args){
new test11_2();
    }
    
}
