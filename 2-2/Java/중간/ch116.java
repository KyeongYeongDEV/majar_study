import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class ch116 extends JFrame{
    public ch116(){
        setTitle("rrr");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        
        Container c = getContentPane();
        c.setLayout(new GridLayout(3,1));

        JSlider js = new JSlider(0,100,0);
        JTextArea jt = new JTextArea();

        js.setMajorTickSpacing(20);
        js.setMinorTickSpacing(5);
        js.setPaintLabels(true);

        c.add(jt);
        c.add(js);

        js.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e){
                String str = jt.getText();
                if(str.length() <= js.getValue()){
                    js.setValue(str.length());
                }
                else{
                    jt.setText(str.substring(0,js.getValue()));
                }
            }
        });

        jt.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                String text = jt.getText();
                if(text.length() <=100){
                    js.setValue(text.length());
                }
                else{
                    jt.setText(text.substring(0,99));
                }
            }
        });
        setVisible(true);
    }

    public static void main(String[] args){
        new ch116();
    }   
}
