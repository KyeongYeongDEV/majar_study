package Group;

import main.CalendarSwing;

import javax.swing.*;
import java.awt.*;

public class Group_Manage {

    public static JLabel label = new JLabel();
    //그룹관리페이지
    public void setgroupManage(){
        CalendarSwing.west_pane.removeAll();

        CalendarSwing.west_pane.setBackground(new Color(0XD1F7FF));
        JPanel group_manage_pane = new JPanel(new GridLayout(6,1));
        group_manage_pane.setBackground(new Color(0XD1F7FF));

        //그룹관리프레임 제목
        JLabel group_title = new JLabel("그룹 설정");
        group_title.setBorder(BorderFactory.createEmptyBorder(0 , 70, 0, 60));
        group_title.setHorizontalAlignment(SwingConstants.CENTER);
        group_title.setFont(new Font("Dialog",Font.BOLD,25));
        group_manage_pane.add(group_title);


        //그룹가입pane
        JPanel manage_top = new JPanel(new GridLayout(3,1));

        JPanel join_pane_top = new JPanel(new FlowLayout());
        JLabel lb1_1 = new JLabel("가입할 그룹 이름:");
        join_pane_top.setBackground(new Color(0XD1F7FF));
        join_pane_top.add(lb1_1);
        join_pane_top.add(CalendarSwing.join_name); //가입할 그룹 이름
        manage_top.add(join_pane_top);

        JPanel join_pane_mid = new JPanel(new FlowLayout());
        JLabel lb1_2 = new JLabel("가입할 그룹 코드:");
        join_pane_mid.setBackground(new Color(0XD1F7FF));
        join_pane_mid.add(lb1_2);
        join_pane_mid.add(CalendarSwing.join_code); //가입할 그룹 코드
        manage_top.add(join_pane_mid);

        JPanel join_btn_pane = new JPanel(new FlowLayout());
        join_btn_pane.setBackground(new Color(0XD1F7FF));
        CalendarSwing.groupJoin_btn.setSize(50,50);
        join_btn_pane.add(CalendarSwing.groupJoin_btn); //그룹 가입하기 버튼
        manage_top.add(join_btn_pane);

        group_manage_pane.add(manage_top);

        //그룹생성pane
        JPanel manage_mid = new JPanel(new GridLayout(3,1));

        JPanel create_pane_top = new JPanel(new FlowLayout());
        create_pane_top.setBackground(new Color(0XD1F7FF));
        JLabel lb2_1 = new JLabel("생성할 그룹 이름:");
        create_pane_top.add(lb2_1);
        create_pane_top.add(CalendarSwing.create_name);//생성할 그룹 이름
        manage_mid.add(create_pane_top);

        JPanel create_pane_mid = new JPanel(new FlowLayout());
        create_pane_mid.setBackground(new Color(0XD1F7FF));
        JLabel lb2_2 = new JLabel("생성할 그룹 코드:");
        create_pane_mid.add(lb2_2);
        create_pane_mid.add(CalendarSwing.create_code);//생성할 그룹 코드
        manage_mid.add(create_pane_mid);

        JPanel create_btn_pane = new JPanel(new FlowLayout());
        create_btn_pane.setBackground(new Color(0XD1F7FF));
        CalendarSwing.groupCreate_btn.setSize(50,50);
        create_btn_pane.add(CalendarSwing.groupCreate_btn);//그룹생성 버튼
        manage_mid.add(create_btn_pane);

        group_manage_pane.add(manage_mid);

        //그룹변경
        JPanel manage_bot = new JPanel(new GridLayout(3,1));

        JPanel update_pane_top = new JPanel(new FlowLayout());
        update_pane_top.setBackground(new Color(0XD1F7FF));
        JLabel lb3_1 = new JLabel("변경할 그룹 이름:");
        update_pane_top.add(lb3_1);
        update_pane_top.add(CalendarSwing.update_name);//변경할 그룹 이름
        manage_bot.add(update_pane_top);

        JPanel update_pane_mid = new JPanel(new FlowLayout());
        update_pane_mid.setBackground(new Color(0XD1F7FF));
        JLabel lb3_2 = new JLabel("변경할 그룹 코드:");//변경할 그룹 코드
        update_pane_mid.add(lb3_2);
        update_pane_mid.add(CalendarSwing.update_code);
        manage_bot.add(update_pane_mid);

        JPanel update_btn_pane = new JPanel(new FlowLayout());
        update_btn_pane.setBackground(new Color(0XD1F7FF));
        CalendarSwing.groupUpdate_btn.setSize(50,50);
        update_btn_pane.add(CalendarSwing.groupUpdate_btn); //그룹 변경 버튼
        manage_bot.add(update_btn_pane);

        group_manage_pane.add(manage_bot);

        JPanel back_btn_pane = new JPanel(new FlowLayout());
        CalendarSwing.groupBack_btn.setSize(50,50);
        back_btn_pane.setBackground(new Color(0XD1F7FF));
        back_btn_pane.setBorder(BorderFactory.createEmptyBorder(35 , 0, 0 , 0));


        back_btn_pane.add(CalendarSwing.groupBack_btn);//그냥 페이지전환 뒤로가기버튼

        label.setHorizontalAlignment(SwingConstants.CENTER);
        group_manage_pane.add(label);
        group_manage_pane.add(back_btn_pane);

        CalendarSwing.west_pane.add(group_manage_pane);
        CalendarSwing.west_pane.revalidate();
    }
}
