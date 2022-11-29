import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class ch14_4 extends JFrame{
    public ch14_4(){
        setTitle("숫자가 아니면 경고창 띄우기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        
        
        Container c = getContentPane();
        
        JToolBar tb = new JToolBar();

        JLabel jl = new JLabel("학번 : ");
        tb.add(jl);

        JTextField tf = new JTextField();
        tb.add(tf);
        
        tf.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                super.keyTyped(e);
                if(e.getKeyChar() < '0' || e.getKeyChar() > '9'){
                    e.consume();
                    JOptionPane.showMessageDialog(null, e.getKeyChar()+ "는 숫자가 아닙니다.\n숫자를 입력하세요.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        c.add(tb, BorderLayout.SOUTH);

        setVisible(true);
    }
    public static void main(String[] args){
        new ch14_4();
    }
}