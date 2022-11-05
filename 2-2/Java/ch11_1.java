import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;


public class ch11_1  extends JFrame{
    public ch11_1(){
        setTitle("11_1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JCheckBox b1,b2;
        b1 = new JCheckBox("버튼 비활성화");
        b2 = new JCheckBox("버튼 감추기");
        JButton btn1 = new JButton("test button");
        b1.addItemListener(new ItemListener(){ 
            public void itemStateChanged(ItemEvent e){
                if(e.getStateChange() == ItemEvent.SELECTED){
                    btn1.setEnabled(false);
                }
                else{
                    btn1.setEnabled(true);
                }

            }
        });

        b2.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                if(e.getStateChange() == ItemEvent.SELECTED){
                    btn1.setVisible(false);
                }
                else{
                    btn1.setVisible(true);
                }
            }
        });

        c.add(b1);
        c.add(b2);
        c.add(btn1);

        setSize(300,300);
        setVisible(true);
    }
    
    public static void main(String[] args){
        new ch11_1();
    }
}
