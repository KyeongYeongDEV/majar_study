import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class test121 extends JFrame{
    private JButton btn = new JButton("hide/show");
    private MyPanel panel = new MyPanel();

    private ImageIcon image = new ImageIcon("0back.png");
    private Image img = image.getImage();

    boolean check = true;

    public test121(){
        setTitle("숨겨지는 이미지");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(300,300);
        
        setContentPane(panel);
        add(btn);

        btn.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if(check == false){
                    img = image.getImage();
                    check = true;
                    repaint();
                }else{
                    img = null;
                    check  = false;
                    repaint();
                }
            }
        });
        
        setVisible(true);
    }

    class MyPanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img,0,0,getWidth(),getHeight(),this);
        }
    }

    public static void main(String[] args){
        new test121();
    }
}