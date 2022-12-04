package Group;

import main.MemberBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import static main.CalendarSwing.*;
import static main.CalendarSwing.stmt;
import static sign.Sign_Search.k;

public class Group_Login {
    public String group_login() throws SQLException {
        int sw=0;
        String SelectSql = "SELECT * FROM member";

        ResultSet resultSet = null;
        try {
            resultSet = stmt.executeQuery(SelectSql);
        } catch (SQLException e) {
            System.out.println("뭔데");
        }
        ArrayList<MemberBean> list = new ArrayList<MemberBean>();
        while (sw==0) {
            try {
                if(resultSet==null) {
                    sw=2;
                    break;
                }
                if (!resultSet.next()) {
                    sw=1;
                    break;
                }
            } catch (SQLException e) {

                throw new RuntimeException(e);
            }
            MemberBean memberBean = new MemberBean();
            memberBean.setGroup(resultSet.getString("member_group"));
            memberBean.setName(resultSet.getString("member_name"));
            memberBean.setGroup_code(resultSet.getInt("member_group_code"));
            memberBean.setGroup_check(resultSet.getString("member_group_check"));
            int gap=Integer.parseInt(join_code.getText());
            if(join_name.getText().equals(memberBean.getGroup_check())){
                String sql = "SELECT * FROM member WHERE member_name = "+"'"+k+"'";
                ResultSet resultSet2 = null;
                try {
                    resultSet2 = stmt.executeQuery(sql);
                } catch (SQLException e) {
                    System.out.println("뭔데");
                }
                ArrayList<MemberBean> list2 = new ArrayList<MemberBean>();

                while (true) {
                    if(resultSet2==null)
                        break;
                    if(!resultSet2.next())
                        break;
                    try {
                        MemberBean memberBean2 = new MemberBean();
                        memberBean2.setGroup(resultSet2.getString("member_group"));
                        memberBean2.setGroup_check(resultSet2.getString("member_group_check"));
                        if(memberBean2.getGroup().equals(join_name.getText())){
                            return "중복된 그룹입니다!";
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                String sql2 = "INSERT INTO member(`member_group_code`, `member_group_check` , `member_group`, `member_name`, `member_pw`, `member_id`)";
                sql2 += " VALUES (" + join_code.getText() + ",'" + "-"+ "', '"+join_name.getText()+"', '" + k +"', '"+"-"
                        + "', '"+"-" +"')";
                stmt.executeUpdate(sql2);
                return "그룹 가입 완료!";
            }
        }
        return"그룹이 존재하지 않습니다!";

    }
}
