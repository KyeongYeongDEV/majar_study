import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ch11__2 extends JFrame{
    public ch11__2(){
        setTitle("연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        JComboBox<String> cb = new JComboBox<String>(); //콤버박스에 요소를 추가한 상태로 생성ㅇ해보기
        JTextField tf = new JTextField(10);

        c.setLayout(new FlowLayout());

        tf.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JTextField j = (JTextField)e.getSource();
                String text = j.getText();
                j.setText(" ");
                cb.addItem(text);
            }
        });
        c.add (tf);
        c.add(cb);

        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args){
        new ch11__2();
    }
}
