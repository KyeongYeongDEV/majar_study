import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ch114 extends JFrame{
    public ch114(){
        setTitle("ddd");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        
        JPanel north = new JPanel();
        JPanel center = new JPanel(new GridLayout(8,3));
       

        JLabel label  = new JLabel("검색");
        JButton button = new JButton("계산");
        north.add(label);
        north.add(new JTextField(10));
        north.add(button);

        north.setBackground(Color.PINK);
        center.setBackground(Color.PINK);
      
     

        String[] str = {"오만원" , "만원", "천원" , "500원", "100원" , "50원", "10원", "1원"};
        int[] arr={50000,10000,1000,500,100,50,10,1};
        JLabel[] jl = new JLabel[8];
        JTextField[] jt = new JTextField[8];
        JCheckBox[] jc = new JCheckBox[7];

        
        
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int money =Integer.parseInt(label.getText());

                for(int i=0; i<7; i++){
                    if(jc[i].isSelected()){
                        jt[i].setText((money/arr[i])+"");
                        money %= arr[i];
                    }else{
                        jt[i].setText("0");
                    }
                }
                jt[7].setText(money +"");
            }
        });
        for(int i=0; i < 8; i++){ //기본 세팅
            jl[i] = new JLabel(str[i]);
            jt[i] = new JTextField(10); 
            center.add(jl[i]);
            center.add(jt[i]);
            if(i != 7){jc[i] = new JCheckBox(); center.add(jc[i]);}
        }

        JPanel south = new JPanel();
        JPanel east = new JPanel();
        JPanel west = new JPanel();

        south.setBackground(Color.PINK);
        east.setBackground(Color.PINK);
        west.setBackground(Color.PINK);

        c.add(north, BorderLayout.NORTH);
        c.add(center, BorderLayout.CENTER);
        c.add(south, BorderLayout.SOUTH);
        c.add(east, BorderLayout.EAST);
        c.add(west, BorderLayout.WEST);
        setVisible(true);
    }
    public static void main(String[] args){
        new ch114();
    }
}
