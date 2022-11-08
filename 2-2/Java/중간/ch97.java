import java.awt.*;
import javax.swing.*;

public class ch97 extends JFrame{
    public ch97(){
        setTitle("계산기 프레임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        JPanel pn = new JPanel();
        JPanel pc = new JPanel(new GridLayout(4,4));
        JPanel ps = new JPanel();


        pn.add(new JLabel("수식 입력"));
        pn.add(new JTextField(10));
        pn.setBackground(Color.gray);
        c.add(pn, BorderLayout.NORTH);

        String[] jl ={
            "0","1","2","3",
            "4","5","6","7",
            "8","9","CE","계산",
            "+","-","x","/"
        };

        for(int i=0 ; i< 16; i++){
            JButton jb = new JButton(jl[i]);
            if(i >=12){
                jb.setBackground(Color.GREEN);
                jb.setOpaque(true);
            }
            pc.add(jb);
        }
        c.add(pc, BorderLayout.CENTER);

        ps.add(new JLabel("계산 결과"));
        ps.add(new JTextField(10));
        ps.setBackground(Color.YELLOW);
        c.add(ps, BorderLayout.SOUTH);

        
        setSize(200,200);
        setVisible(true);
    }

    public static void main(String[] arg){
        new ch97();
    }
}
