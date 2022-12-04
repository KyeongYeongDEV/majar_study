package sign;

import main.MemberBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static main.CalendarSwing.*;
import static main.CalendarSwing.sign_name;

public class Sign_Id {
    public void id() throws SQLException {  //회원 가입 입니다 !
        if (sign_ok.getText().equals("") || sign_pw.getPassword().equals("") ||
                sign_name.getText().equals("") || sign_pwcheck.getPassword().equals("")) {
            sign_error.setText("공백 불가");
        } else {
            int sw=0;
            String SelectSql = "SELECT * FROM member\n";

            ResultSet resultSet = null;
            try {
                resultSet = stmt.executeQuery(SelectSql);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            ArrayList<MemberBean> list = new ArrayList<MemberBean>();
            while (true) {
                if(resultSet==null)
                    break;
                if(!resultSet.next())
                    break;
                MemberBean memberBean = new MemberBean();
                memberBean.setId(resultSet.getString("member_id"));
                memberBean.setName(resultSet.getString("member_name"));
                memberBean.setPassword(resultSet.getString("member_pw"));
                System.out.println(sign_id.getText());

                if (memberBean.getId().equals("") || sign_id.getText().equals(""))
                    break;
                //System.out.println(sign_error.getText());
                if (memberBean.getId().equals(sign_id.getText())) {
                    sw = 1;
                    sign_error.setText("아이디 중복 에러");
                }
                if (memberBean.getName().equals(sign_name.getText())) {
                    sw = 1;
                    sign_error.setText("이름 중복 에러");
                } else if (!(String.valueOf(sign_pw.getPassword()).equals(String.valueOf(sign_pwcheck.getPassword())))) {
                    sw = 1;
                    sign_error.setText("다시확인 비밀번호 에러");
                }
            }
            if (sw == 0) {
                System.out.println("@#@#");
                System.out.println("@#@#");

                String sql = "INSERT INTO member(`member_group_code`, `member_pw`, `member_name`, `member_id`, `member_group_check`, `member_group`)\n";
                sql += " VALUES (1, '" + String.valueOf(sign_pw.getPassword()) + "', '" + sign_name.getText() + "', '" + sign_id.getText() +
                        "', '" + "-" + "', '" + "-" + "')";

                stmt.executeUpdate(sql);
                sign_error.setText(sign_name.getText() + "님 회원가입 되셨습니다");
                sign_id.setText("");
                sign_pw.setText("");
                sign_pwcheck.setText("");
                sign_name.setText("");
            }
        }
    }
}
