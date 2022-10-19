import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ch11__4 extends JFrame{
    public ch11__4(){
        setTitle("ddd");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setSize(300,300);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        JPanel north = new JPanel();
        JPanel center = new JPanel(new GridLayout(8,3));
        JPanel south = new JPanel();
        JPanel east = new JPanel();
        JPanel west = new JPanel();

        north.setBackground(Color.PINK);
        south.setBackground(Color.PINK);
        center.setBackground(Color.PINK);
        west.setBackground(Color.PINK);
        east.setBackground(Color.PINK);

        JTextField text = new JTextField(10);
        JButton jb = new JButton("계산");
        north.add(new JLabel("금액"));
        north.add(text);
        north.add(jb);

        String[] str ={"오만원","만원","천원","500원","100원","50원","10원","1원"};
        int arr[] = {50000,10000,1000,500,100,50,10,1};
        JLabel[] jl = new JLabel[8];
        JTextField[] jt = new JTextField[8];
        JCheckBox[] jc = new JCheckBox[7];

        for(int i =0; i<8; i++){
            if(i < 7){
                jl[i] = new JLabel(str[i]);
                jt[i] = new JTextField(10);
                jc[i] = new JCheckBox();
                center.add(jl[i]);
                center.add(jt[i]);
                center.add(jc[i]);
            }
            else{
                jl[i] = new JLabel(str[i]);
                jt[i] = new JTextField();
                center.add(jl[i]);
                center.add(jt[i]);
            }
        }

        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int money = Integer.parseInt(text.getText());

                for(int i=0; i< 8; i++){
                    if(i <7){
                        if(jc[i].isSelected()){
                            jt[i].setText(""+ money/arr[i]);
                            money %= arr[i];
                        }
                        else{
                            jt[i].setText("0");
                        }
                    }
                    else{
                        jt[i].setText(""+money);
                    }
                }                
            }
        });
        

        c.add(north, BorderLayout.NORTH);
        c.add(south, BorderLayout.SOUTH);
        c.add(center, BorderLayout.CENTER);
        c.add(west, BorderLayout.WEST);
        c.add(east, BorderLayout.EAST);
        setVisible(true);
        
    }
    public static void main(String [] args){
        new ch11__4();
    }
} 
