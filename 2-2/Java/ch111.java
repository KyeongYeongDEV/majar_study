import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ch111 extends JFrame{
    public ch111(){
        setTitle("dd");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JCheckBox cb1 = new JCheckBox("버튼 활성화");
        JCheckBox cb2 = new JCheckBox("버튼 감추기");
        JButton jb = new JButton("test button");

        cb1.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                if(e.getStateChange() == ItemEvent.SELECTED){
                    jb.setEnabled(false);
                }
                else{
                    jb.setEnabled(true);
                }
            }
        });

        cb2.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                if(e.getStateChange() == ItemEvent.SELECTED){
                    jb.setVisible(false);
                }
                else{
                    jb.setVisible(true);
                }
            }
        });

        c.add(cb1);
        c.add(cb2);
        c.add(jb);

        setVisible(true);
        
    }

    public static void main(String[] args){
        new ch111();
    }
}
