package Group;

import main.CalendarSwing;
import main.MemberBean;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static main.CalendarSwing.*;
import static sign.Sign_Search.k;

public class Group_Info {
    //왼쪽-그룹 보기
    public void setgroupView() throws SQLException {
        CalendarSwing.west_pane.removeAll();
        //그룹 정보 타이틀 및 프레임 크기 설정
        JPanel group_top = new JPanel(new GridLayout(2,1));
        JLabel group_title = new JLabel("그룹 정보");
        group_title.setBorder(BorderFactory.createEmptyBorder(0 , 70, 0, 60));
        group_title.setHorizontalAlignment(SwingConstants.CENTER);
        group_title.setFont(new Font("Dialog",Font.BOLD,25));
        group_top.add(group_title);

        //그룹선택 콤보박스
        JPanel combo = new JPanel(new FlowLayout());
        Statement stmt2 = con.createStatement(); // Query 작업을 실행하기 위한 객체.
        String SelectSql = "SELECT * FROM member WHERE member_name = "+"'"+k+"'";
        ResultSet resultSet = stmt2.executeQuery(SelectSql);
        ArrayList<MemberBean> list = new ArrayList<MemberBean>();

        group_combo.removeAllItems();
        int code=0;
        while (true) {
            if(!resultSet.next())
                break;
            if(resultSet==null)
                break;
            MemberBean memberBean = new MemberBean();
            memberBean.setId(resultSet.getString("member_id"));
            memberBean.setName(resultSet.getString("member_name"));
            memberBean.setPassword(resultSet.getString("member_pw"));
            memberBean.setGroup(resultSet.getString("member_group"));
            memberBean.setGroup_code(resultSet.getInt("member_group_code"));
            if(!memberBean.getGroup().equals("-")) {
                group_combo.addItem(memberBean.getGroup());
            }
        }



        CalendarSwing.group_combo.setPreferredSize(new Dimension(90,30));
        combo.add(CalendarSwing.group_combo);
        combo.setBackground(new Color(0XD1F7FF));
        combo.setFont(new Font("Dialog",Font.BOLD,30));
        group_top.add(combo);
        group_top.setBackground(new Color(0XD1F7FF));
        CalendarSwing.west_pane.add(group_top);
        //그룹정보보여주는 라벨들
        JPanel group_content_pane = new JPanel(new GridLayout(3,2,10,15));
        group_content_pane.setBackground(new Color(0XD1F7FF));
        JLabel l1 = new JLabel("이름:");

        l1.setHorizontalAlignment(SwingConstants.RIGHT);
        l1.setVerticalAlignment(SwingConstants.TOP);
        l1.setFont(new Font("Dialog",Font.BOLD,20));
        CalendarSwing.group_name.setVerticalAlignment(SwingConstants.TOP);
        CalendarSwing.group_name.setFont(new Font("Dialog",Font.BOLD,20));
        group_content_pane.setPreferredSize(new Dimension(150,50));
        group_content_pane.add(l1);

        if(group_combo.getItemCount()==0) {
            group_name.setText("");
            group_code.setText("");
            group_v.clear();
        }
        else
            group_name.setText(String.valueOf(group_combo.getSelectedItem()));

        group_content_pane.add(CalendarSwing.group_name); //보여줄 그룹 이름 ->콤보박스 선택하면 바껴야함


        JLabel l2 = new JLabel("code:");
        l2.setHorizontalAlignment(SwingConstants.RIGHT);
        l2.setVerticalAlignment(SwingConstants.TOP);
        l2.setFont(new Font("Dialog",Font.BOLD,20));

        // group_code.setText(String.valueOf(group_combo.getSelectedIndex()));
        CalendarSwing.group_code.setVerticalAlignment(SwingConstants.TOP);

        CalendarSwing.group_code.setFont(new Font("Dialog",Font.BOLD,20));
        group_content_pane.add(l2);
        group_content_pane.add(CalendarSwing.group_code);//보여줄 코드 이름 ->콤보박스 선택하면 바껴야함
        JPanel list_panel= new JPanel(new GridLayout(0,2));
        JLabel l3 = new JLabel("그룹원:");
        l3.setHorizontalAlignment(SwingConstants.RIGHT);
        l3.setVerticalAlignment(SwingConstants.TOP);
        l3.setFont(new Font("Dialog",Font.BOLD,20));
        group_content_pane.add(l3);



        CalendarSwing.person_List.setListData(CalendarSwing.group_v);
        CalendarSwing.person_List.setVisibleRowCount(3);
        CalendarSwing.person_List.setFixedCellWidth(90);
        JPanel flow_list = new JPanel(new FlowLayout());
        flow_list.setBorder(BorderFactory.createEmptyBorder(0 ,0 , 0, 20));
        flow_list.setBackground(new Color(0XD1F7FF));

        flow_list.add(new JScrollPane(CalendarSwing.person_List)); //벡터만 손보면 되서 딱히 손 댈거 없을듯
        group_content_pane.add(flow_list);
        list_panel.setBackground(new Color(0XD1F7FF));
        CalendarSwing.west_pane.setBackground(new Color(0XD1F7FF));
        CalendarSwing.west_pane.add(group_content_pane);

        JPanel group_manage_btn = new JPanel(new FlowLayout());
        group_manage_btn.setBorder(BorderFactory.createEmptyBorder(100 ,0 , 0, 0));
        group_manage_btn.setBackground(new Color(0XD1F7FF));


        group_manage_btn.add(CalendarSwing.group_manage);//그룹관리페이지로 전환 기능 구현
        group_manage_btn.add(CalendarSwing.group_exit);//그룹탈퇴 기능 구현
        CalendarSwing.west_pane.add(group_manage_btn);
        CalendarSwing.west_pane.revalidate();
    }
}
