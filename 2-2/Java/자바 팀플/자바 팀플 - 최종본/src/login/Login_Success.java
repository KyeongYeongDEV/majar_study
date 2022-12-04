package login;

import todo.Todo_Set;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

import static main.CalendarSwing.*;
import static sign.Sign_Search.k;

public class Login_Success {
    Todo_Set todoSet = new Todo_Set();
    public void login_success() throws SQLException {
        login_pane.removeAll();

        //로그인 팬

        JLabel idlbl = new JLabel(k+"님");
        JLabel pwlbl=new JLabel("환영합니다.");

        login_pane.add(BorderLayout.NORTH,idlbl); //아이디 비번텍스트필드 프레임
        login_pane.add(BorderLayout.CENTER,pwlbl);


        login_pane.add(BorderLayout.SOUTH,logout);
        login_pane.setBackground(new Color(0XF5F5F5));
        login_pane.setBorder(BorderFactory.createEmptyBorder(30 , 90, 30 , 75));
        main_topPane.add(BorderLayout.WEST,login_pane);

        todoSet.setTodo();
        main_topPane.repaint();
    }
}
