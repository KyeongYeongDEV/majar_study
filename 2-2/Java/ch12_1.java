import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ch12_1 extends JFrame{
    private MyPanel panel = new MyPanel();
    private JButton btn = new JButton("Hide/Show");

    private ImageIcon image = new ImageIcon("back.png");
    private Image img = image.getImage();

    boolean check = true; //버튼이 눌린지 확인
    
    public ch12_1(){
        setTitle("이미지 그리기 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        add(btn);

        //btn이 눌러질 때마다 그림의 hide/show 설정 (익명 클래스 사용함)
        btn.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                    if(check == false){//이미지가 없다면
                        img = image.getImage();
                        check = true;
                        repaint();
                        
                    }else{//이미지가 존재한다면
                        img = null;
                        check = false;
                        repaint();
                    }
            }
        });

        setLayout(new FlowLayout());
        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args){
        new ch12_1();
    }
    class MyPanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img,0,0,getWidth(), getHeight(),this); //화면에 꽉 차게 설정
        }
    }
}