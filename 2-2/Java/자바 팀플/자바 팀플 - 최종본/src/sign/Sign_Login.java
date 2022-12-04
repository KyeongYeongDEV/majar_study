package sign;

import main.MemberBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static main.CalendarSwing.*;
import static main.CalendarSwing.password;

public class Sign_Login {
    public String login() throws SQLException {
        System.out.println(password.getPassword());
        System.out.println("!_!_!_!_!_!_");
        int sw=0;
        String SelectSql = "SELECT * FROM member\n";
        ResultSet resultSet = null;
        try {
            resultSet = stmt.executeQuery(SelectSql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        new ArrayList();

        while (!resultSet.next()) {

            MemberBean memberBean = new MemberBean();
            try {
                memberBean.setId(resultSet.getString("member_id"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                memberBean.setPassword(resultSet.getString("member_pw"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if (memberBean.getId().equals(id.getText()) && memberBean.getPassword().equals(password.getPassword())) {
                System.out.println(password.getPassword());
                System.out.println("!_!_!_!_!_!_");
                return "로그인 성공";
            }
        }
        return "로그인 불가";
    }
}
