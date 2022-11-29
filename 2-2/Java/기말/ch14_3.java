import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ch14_3 extends JFrame{ 
    public ch14_3(){
        setTitle("종료누르면 모달창");
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton exit = new JButton("종료");

        JToolBar tb = new JToolBar();
        tb.add(exit);
        exit.addActionListener((ActionListener) new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int result = JOptionPane.showConfirmDialog(null, "종료하시겠습니까", "YES", JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION){
                    System.exit(0);
                }

            }
        });
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(tb, BorderLayout.NORTH);

        setVisible(true);
    }
    public static void main(String[] args){
        new ch14_3();
    }
    
}
