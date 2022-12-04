package sign;

import main.CalendarSwing;

import javax.swing.*;
import java.awt.*;

import static main.CalendarSwing.*;
import static main.CalendarSwing.sign_ok;

public class Set_Sign {
    public void setSign(){
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
        sign_f1.setBackground(new Color(0XD1F7FF));
        l1.setFont(new Font("Dialog",Font.BOLD,15));
        CalendarSwing.sign_id.setFont(new Font("Dialog",Font.BOLD,15));
        sign_f1.add(l1);
        sign_f1.add(CalendarSwing.sign_id); //회원가입 id 텍스트필드
        CalendarSwing.west_pane.add(sign_f1);

        JPanel sign_f2 = new JPanel(new FlowLayout());
        JLabel l2 = new JLabel("비밀번호:");
        sign_f2.setBackground(new Color(0XD1F7FF));
        sign_pw.setFont(new Font("Dialog",Font.BOLD,15));
        l2.setFont(new Font("Dialog",Font.BOLD,15));
        sign_f2.add(l2);
        sign_f2.add(sign_pw); //회원가입 비밀번호 텍스트필드
        CalendarSwing.west_pane.add(sign_f2);

        JPanel sign_f3 = new JPanel(new FlowLayout());
        JLabel l3 = new JLabel("다시확인:");
        sign_f3.setBackground(new Color(0XD1F7FF));
        sign_pwcheck.setFont(new Font("Dialog",Font.BOLD,15));
        l3.setFont(new Font("Dialog",Font.BOLD,15));
        sign_f3.add(l3);
        sign_f3.add(sign_pwcheck);//회원가입 비밀번호 체크
        CalendarSwing.west_pane.add(sign_f3);

        JPanel sign_f4 = new JPanel(new FlowLayout());
        JLabel l4 = new JLabel("    닉네임:");
        sign_f4.setBackground(new Color(0XD1F7FF));
        CalendarSwing.sign_name.setFont(new Font("Dialog",Font.BOLD,15));
        l4.setFont(new Font("Dialog",Font.BOLD,15));
        sign_f4.add(l4);
        sign_f4.add(CalendarSwing.sign_name);//회원가입 닉네임 텍스트필드
        CalendarSwing.west_pane.add(sign_f4);

        CalendarSwing.sign_error.setFont(new Font("Dialog",Font.BOLD,20));
        CalendarSwing.west_pane.add(CalendarSwing.sign_error); //에러메세지 (이미 존재하는 id 또는 닉네임)

        JPanel sign_f5 = new JPanel(new FlowLayout());
        sign_f5.setBackground(new Color(0XD1F7FF));
        sign_ok.setFont(new Font("Dialog",Font.BOLD,15));
        CalendarSwing.sign_cancel.setFont(new Font("Dialog",Font.BOLD,15));
        sign_f5.add(sign_ok); //회원가입 성공하면 빈칸으로
        sign_f5.add(CalendarSwing.sign_cancel); //회원가입 취소해도 빈칸으로
        CalendarSwing.west_pane.setBackground(new Color(0XD1F7FF));
        CalendarSwing.west_pane.add(sign_f5);
        CalendarSwing.west_pane.revalidate();

    }
}
