package Group;

import main.MemberBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static main.CalendarSwing.*;

public class Group_Make {
    public String group_make() throws SQLException { //그룹 생성
        int sw=0;
        int gap=0;
        String SelectSql = "SELECT * FROM member";

        ResultSet resultSet = null;
        try {
            resultSet = stmt.executeQuery(SelectSql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ArrayList<MemberBean> list = new ArrayList<MemberBean>();
        while (sw==0) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            MemberBean memberBean = new MemberBean();
            memberBean.setGroup(resultSet.getString("member_group"));
            memberBean.setGroup_code(resultSet.getInt("member_group_code"));
            memberBean.setGroup_check(resultSet.getString("member_group_check"));
            gap =Integer.parseInt(create_code.getText());
            System.out.println(memberBean.getGroup_code());
            if(memberBean.getGroup_code()==gap || memberBean.getGroup_check().equals(create_name.getText())) {
                return "실패!";
            }
        }

        String sql2 = "INSERT INTO member(`member_group_code`, `member_group_check` , `member_group`, `member_name`, `member_pw`, `member_id`)";
        sql2 += " VALUES (" + gap + ",'" + create_name.getText() + "', '"+"-"+"', '" + "-" +"', '"+"-"
                + "', '"+"-" +"')";
        stmt.executeUpdate(sql2);

        return "성공!";
    }
}
