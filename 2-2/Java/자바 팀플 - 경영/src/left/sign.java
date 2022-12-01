package left;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import main.CalendarSwing;

import static main.CalendarSwing.*;


public class sign {
    //회원가입
    static int cnt=0;
    public static String k;
    public static void setSign(){
        CalendarSwing.west_pane.removeAll();
        //회원가입 레이아웃 기본 설정

        JLabel west_l = new JLabel();
        CalendarSwing.west_pane.add(west_l);
        west_l.setBorder(BorderFactory.createEmptyBorder(0 , 30, 15 , 211));

        //회원가입 타이틀, 프레임공간 설정
        JLabel sign_label = new JLabel("회원가입");
        sign_label.setHorizontalAlignment(SwingConstants.CENTER);
        sign_label.setFont(new Font("Dialog",Font.BOLD,25));
        sign_label.setBorder(BorderFactory.createEmptyBorder(0 , 0, 50 , 0));
        CalendarSwing.west_pane.add(sign_label);

        //입력할 회원정보 쭉 나열
        JPanel sign_f1 = new JPanel(new FlowLayout());
        JLabel l1 = new JLabel("    아이디:");
        sign_f1.setBackground(Color.cyan);
        l1.setFont(new Font("Dialog",Font.BOLD,15));
        CalendarSwing.sign_id.setFont(new Font("Dialog",Font.BOLD,15));
        sign_f1.add(l1);
        sign_f1.add(CalendarSwing.sign_id); //회원가입 id 텍스트필드
        CalendarSwing.west_pane.add(sign_f1);

        JPanel sign_f2 = new JPanel(new FlowLayout());
        JLabel l2 = new JLabel("비밀번호:");
        sign_f2.setBackground(Color.cyan);
        sign_pw.setFont(new Font("Dialog",Font.BOLD,15));
        l2.setFont(new Font("Dialog",Font.BOLD,15));
        sign_f2.add(l2);
        sign_f2.add(sign_pw); //회원가입 비밀번호 텍스트필드
        CalendarSwing.west_pane.add(sign_f2);

        JPanel sign_f3 = new JPanel(new FlowLayout());
        JLabel l3 = new JLabel("다시확인:");
        sign_f3.setBackground(Color.cyan);
        sign_pwcheck.setFont(new Font("Dialog",Font.BOLD,15));
        l3.setFont(new Font("Dialog",Font.BOLD,15));
        sign_f3.add(l3);
        sign_f3.add(sign_pwcheck);//회원가입 비밀번호 체크
        CalendarSwing.west_pane.add(sign_f3);

        JPanel sign_f4 = new JPanel(new FlowLayout());
        JLabel l4 = new JLabel("    닉네임:");
        sign_f4.setBackground(Color.cyan);
        CalendarSwing.sign_name.setFont(new Font("Dialog",Font.BOLD,15));
        l4.setFont(new Font("Dialog",Font.BOLD,15));
        sign_f4.add(l4);
        sign_f4.add(CalendarSwing.sign_name);//회원가입 닉네임 텍스트필드
        CalendarSwing.west_pane.add(sign_f4);

        CalendarSwing.sign_error.setFont(new Font("Dialog",Font.BOLD,20));
        CalendarSwing.west_pane.add(CalendarSwing.sign_error); //에러메세지 (이미 존재하는 id 또는 닉네임)

        JPanel sign_f5 = new JPanel(new FlowLayout());
        sign_f5.setBackground(Color.cyan);
        sign_ok.setFont(new Font("Dialog",Font.BOLD,15));
        CalendarSwing.sign_cancel.setFont(new Font("Dialog",Font.BOLD,15));
        sign_f5.add(sign_ok); //회원가입 성공하면 빈칸으로
        sign_f5.add(CalendarSwing.sign_cancel); //회원가입 취소해도 빈칸으로
        CalendarSwing.west_pane.setBackground(Color.cyan);
        CalendarSwing.west_pane.add(sign_f5);
        CalendarSwing.west_pane.revalidate();

    }
    public static String login(){
        int sw=0;
        String SelectSql = "SELECT * FROM member\n";
        ResultSet resultSet = null;
        try {
            resultSet = stmt.executeQuery(SelectSql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        new ArrayList();

        while (sw==0) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
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
            if (memberBean.getId().equals(id.getText()) && password.getText().equals(password.getText())) {
                return "로그인 성공";
            }
        }
        return "로그인 불가";
    }
    public static String search(){
        int sw=0;
        String SelectSql = "SELECT * FROM member WHERE member_id = " +"'"+id.getText()+"'";
        ResultSet resultSet = null;
        try {
            resultSet = stmt.executeQuery(SelectSql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        new ArrayList();
        while (sw==0) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            MemberBean memberBean = new MemberBean();
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



            k = memberBean.getName();
            System.out.println(k);
            return k;
        }
        return "로그인 불가";
    }
    public static void id() throws SQLException {  //회원 가입 입니다 !
        if (sign_ok.getText().equals("") || sign_pw.getText().equals("") ||
                sign_name.getText().equals("") || sign_pwcheck.getText().equals("")) {
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
                try {
                    if (!resultSet.next()) break;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                MemberBean memberBean = new MemberBean();
                memberBean.setId(resultSet.getString("member_id"));
                memberBean.setName(resultSet.getString("member_name"));
                memberBean.setPassword(resultSet.getString("member_pw"));

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
                } else if (!(sign_pw.getText().equals(sign_pwcheck.getText()))) {
                    sw = 1;
                    sign_error.setText("다시확인 비밀번호 에러");
                }
            }
            if (sw == 0) {
                System.out.println("@#@#");
                System.out.println("@#@#");
                String sql = "INSERT INTO member(`member_group_code`, `member_pw`, `member_name`, `member_id`)\n";
                sql += " VALUES (1, '" + sign_pw.getText() + "', '" + sign_name.getText() + "', '" + sign_id.getText() + "')";

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
