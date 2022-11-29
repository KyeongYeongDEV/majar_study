import java.awt.*;
import javax.swing.*;

public class ch14_1 extends JFrame{
    public ch14_1(){
        JMenuBar mb = new JMenuBar();
        JMenu[] menu = new JMenu[4];
        JMenuItem mi1 = new JMenuItem("화면 확대");
        JMenuItem mi2 = new JMenuItem("쪽윤곽");

        menu[0] =new JMenu("파일");
        menu[1] = new JMenu("편집");
        menu[2] = new JMenu("보기");
        menu[3] = new JMenu("입력");
        
        for(int i=0; i<menu.length; i++){
            mb.add(menu[i]);
        }
        menu[2].add(mi1);
        menu[2].add(mi2);

        Container c = getContentPane();
        setJMenuBar(mb);

        setTitle("메뉴 연습");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
    }

    public static void main(String[] args){
        new ch14_1();
    }
    
}
