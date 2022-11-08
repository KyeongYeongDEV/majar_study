import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ch12_3 extends JFrame{
    JLabel label = new JLabel();
    ImageIcon icon = new ImageIcon("1mini.png");
    public ch12_3(){
        setTitle("이미지 레이블 드래깅 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        label.setIcon(icon);
        label.setSize(icon.getIconWidth(), icon.getIconHeight());
        c.add(label);

        c.addMouseMotionListener(new MouseMotionAdapter(){ 
            public void mouseDragged(MouseEvent e){
                c.setLocation(e.getX(),e.getY());
            }
        });

        setVisible(true);
        setSize(800,800);
    }
    
    public static void main(String[] args){
        new ch12_3();
    }
}
