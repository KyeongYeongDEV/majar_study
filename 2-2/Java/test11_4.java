import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class test11_4 extends JFrame{
    public test11_4(){
        setTitle("dd");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        JPanel jn = new JPanel();
        JPanel jc = new JPanel(new GridLayout(8,3));
        JPanel js = new JPanel();
        JPanel jw = new JPanel();
        JPanel je = new JPanel();

        jn.setBackground(Color.PINK);
        jc.setBackground(Color.PINK);
        js.setBackground(Color.PINK);
        jw.setBackground(Color.PINK);
        je.setBackground(Color.PINK);

        c.add(jn, BorderLayout.NORTH);
        c.add(jc, BorderLayout.CENTER);
        c.add(js, BorderLayout.SOUTH);
        c.add(jw, BorderLayout.WEST);
        c.add(je, BorderLayout.EAST);

        jn.add(new JLabel("금액"));
        JTextField jt = new JTextField(10);
        JButton jb = new JButton();
        jn.add(jt);
        jn.add(jb);

        //jb.add(comp)

        String[] str ={"오만","만원","천원","오백","백","오십","십","일"};
        int[] arr = {50000,10000,1000,500,100,50,10,1};
        JTextField[] jtf = new JTextField[8];
        JCheckBox[] jcb = new JCheckBox[7];

        for(int i =0; i <8; i++){
            int money
            jc.add(new JLabel(str[i]));

            jtf[i] = new JTextField()
        }
        
    }
    public static void main(String[] args){
new test11_4();
    }
    
}
