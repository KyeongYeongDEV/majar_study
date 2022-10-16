import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ch113 extends JFrame{
    public ch113(){
        setTitle("dd");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        

        JPanel pn = new JPanel();
        JPanel pc = new JPanel(new GridLayout(8,2));
        JPanel ps = new JPanel();
        JPanel pe = new JPanel();
        JPanel pw = new JPanel();
        ps.setBackground(Color.PINK);
        pe.setBackground(Color.PINK);
        pw.setBackground(Color.PINK);
        pc.setBackground(Color.PINK);
        c.add(ps, BorderLayout.SOUTH);
        c.add(pe, BorderLayout.EAST);
        c.add(pw, BorderLayout.WEST);

        

        JLabel b = new JLabel("금액");
        pn.add(b);

        JTextField tf = new JTextField(10);
        pn.add(tf);
        pn.setBackground(Color.PINK);

        String[] str={
            "오만원", "만원" ,"천원", "500원", "100원", "50원", "10원", "1원"
        } ;
        int[] money = {50000,10000,1000,500,100,50,10,1};
        JLabel[] jl = new JLabel[8];
        JTextField[] t = new JTextField[8];
        for(int i=0; i< 8; i++){
            jl[i] = new JLabel(str[i]);
            t[i] = new JTextField(10);
            pc.add(jl[i]);
            pc.add(t[i]);
        }

        JButton jb = new JButton("계산");
        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int price = Integer.parseInt(tf.getText());

                for(int i=0; i< 8; i++){
                    t[i].setText((price/money[i])+ "");
                    pc.add(new JTextField((price/money[i]) + ""));
                    price = price%money[i];
                }
            }
        });


        pn.add(jb);
        pn.setBackground(Color.PINK);
        c.add(pn, BorderLayout.NORTH);
        c.add(pc, BorderLayout.CENTER);



        setVisible(true);
    }

    public static void main(String [] args){
        new ch113();
    }
}
