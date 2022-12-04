package login;

import javax.swing.*;
import java.awt.*;

import static main.CalendarSwing.*;

public class Login_Fail {
    public static void login_fail(){
        login_pane.removeAll();

        //로그인 팬
        JLabel idlbl = new JLabel("로그인");
        JLabel pwlbl=new JLabel("불가.");

        login_pane.add(BorderLayout.NORTH,idlbl); //아이디 비번텍스트필드 프레임
        login_pane.add(BorderLayout.CENTER,pwlbl);


        login_pane.add(BorderLayout.SOUTH,logout);
        login_pane.setBackground(new Color(0XF5F5F5));
        login_pane.setBorder(BorderFactory.createEmptyBorder(30 , 90, 30 , 75));
        main_topPane.add(BorderLayout.WEST,login_pane);
        main_topPane.repaint();
    }
}
