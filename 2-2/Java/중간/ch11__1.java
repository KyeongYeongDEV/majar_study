import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ch11__1 extends JFrame{
    public ch11__1(){
        setTitle("공부");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JCheckBox cb1 = new JCheckBox("클릭 불가");
        JCheckBox cb2 = new JCheckBox("버튼 안 보이기");
        JButton btn = new JButton("test button");
        

        cb1.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                if(e.getStateChange() == ItemEvent.SELECTED){
                    btn.setEnabled(false);
                }
                else{
                    btn.setEnabled(true);
                }
            }
        });
        c.add(cb1);

        cb2.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                if(e.getStateChange()== ItemEvent.SELECTED){
                    btn.setVisible(false);
                }
                else{
                    btn.setVisible(true);
                }
            }
        });
        c.add(cb2);
        c.add(btn);

        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args){
         new ch11__1();
    }
}
