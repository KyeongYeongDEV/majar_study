package sign;

import main.MemberBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static main.CalendarSwing.*;
import static main.CalendarSwing.password;

public class Sign_Search {
    public static String k;
    public String search() throws SQLException {
        int sw=0;
        String SelectSql = "SELECT * FROM member";
        /*WHERE member_id = " +"'"+id.getText()+"'"*/

        ResultSet resultSet = null;
        try {
            resultSet = stmt.executeQuery(SelectSql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ArrayList<MemberBean> list = new ArrayList<MemberBean>();

        while (true) {
            if(!resultSet.next())
                break;
            MemberBean memberBean = new MemberBean();
            memberBean.setId(resultSet.getString("member_id"));
            try {
                memberBean.setName(resultSet.getString("member_name"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                memberBean.setPassword(resultSet.getString("member_pw"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            String w = memberBean.getId();
            String p = memberBean.getPassword();
            String pa= String.valueOf(password.getPassword());
            System.out.println(id.getText());
            System.out.println(memberBean.getId());

            System.out.println(password.getPassword());
            System.out.println(memberBean.getPassword());
            System.out.println();
            if(w.equals(id.getText()) && p.equals(pa)){
                System.out.println(password.getPassword());
                k = memberBean.getName();
                System.out.println(k+"!!!!");
                return "로그인 성공!";
            }


        }
        return "로그인 불가";
    }
}
