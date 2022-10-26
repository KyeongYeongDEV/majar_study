import javax.swing.*;
import java.awt.*;

public class test11_1 extends JFrame{
    public test11_1(){
        setTitle("dd");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JCheckBox cb1 = new JCheckBox("버튼 비활성화");
        JCheckBox cb2 = new JCheckBox("버튼 숨기기");
        JButton bt = new JButton("버튼");
        c.add(cb1);
        c.add(cb2);
        c.add(bt);

        cb1.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                if(e.getStateChange() == ItemEvent.SELECTED){
                    bt.setEnabled(false);
                }
                else{
                    bt.setEnabled(true);
                }
            }
        });

        setVisible(true);

        

        
    }
    public static void main(String[] args){
new test11_1();
    }
    
}
