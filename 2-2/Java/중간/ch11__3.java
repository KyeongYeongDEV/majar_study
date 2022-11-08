import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class ch11__3 extends JFrame{ //다시 해보자
    public ch11__3(){
        setTitle("practice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.setBackground(Color.PINK);

        JPanel north = new JPanel();
        JPanel center = new JPanel();

        north.add(new JLabel("금액"));
        TextField text = new TextField(10);

        north.add(new TextField(10));
        JButton jb = new JButton("계산");
        String list[] = {
            "오만원", "만원", "천원", "500원", "100원", "50원", "10원", "1원"
        };
        int money[]={
            50000,10000,10000,500,100,50,10,1
        };

        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int price = Integer.parseInt( text.getText());

                for(int i=0; i < list.length;i++){
                    center.add(new JLabel(list[i]));
                    center.add(new TextField(Integer.toString(price/(money[i]))));
                    price %= money[i];
                }
            }
        });
        north.add(jb);

        c.add(north, BorderLayout.NORTH);
        c.add(center, BorderLayout.CENTER);

        setSize(300,300);
        setVisible(true);
    }


    public static void main(String[] args){
        new ch11__3();
    }
}
