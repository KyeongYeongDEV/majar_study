package left;

import javax.swing.*;
import java.awt.*;
import main.CalendarSwing;

public class group {
    //왼쪽-그룹 보기
    public static void setgroupView(){
        CalendarSwing.west_pane.removeAll();
        //그룹 정보 타이틀 및 프레임 크기 설정
        JPanel group_top = new JPanel(new GridLayout(2,1));
        JLabel group_title = new JLabel("그룹 정보");
        group_title.setBorder(BorderFactory.createEmptyBorder(0 , 70, 0, 90));
        group_title.setHorizontalAlignment(SwingConstants.CENTER);
        group_title.setFont(new Font("Dialog",Font.BOLD,25));
        group_top.add(group_title);

        //그룹선택 콤보박스
        JPanel combo = new JPanel(new FlowLayout());
        CalendarSwing.group_combo.addItem("학교");
        CalendarSwing.group_combo.addItem("회사");
        CalendarSwing.group_combo.addItem("가족");


        CalendarSwing.group_combo.setPreferredSize(new Dimension(90,30));
        combo.add(CalendarSwing.group_combo);
        combo.setBackground(Color.cyan);
        combo.setFont(new Font("Dialog",Font.BOLD,30));
        group_top.add(combo);
        group_top.setBackground(Color.cyan);
        CalendarSwing.west_pane.add(group_top);

        //그룹정보보여주는 라벨들
        JPanel group_content_pane = new JPanel(new GridLayout(3,2,10,15));
        group_content_pane.setBackground(Color.cyan);
        JLabel l1 = new JLabel("이름:");
        l1.setHorizontalAlignment(SwingConstants.RIGHT);
        l1.setVerticalAlignment(SwingConstants.TOP);
        l1.setFont(new Font("Dialog",Font.BOLD,20));
        CalendarSwing.group_name.setVerticalAlignment(SwingConstants.TOP);
        CalendarSwing.group_name.setFont(new Font("Dialog",Font.BOLD,20));
        group_content_pane.setPreferredSize(new Dimension(150,50));
        group_content_pane.add(l1);
        group_content_pane.add(CalendarSwing.group_name); //보여줄 그룹 이름 ->콤보박스 선택하면 바껴야함

        JLabel l2 = new JLabel("code:");
        l2.setHorizontalAlignment(SwingConstants.RIGHT);
        l2.setVerticalAlignment(SwingConstants.TOP);
        l2.setFont(new Font("Dialog",Font.BOLD,20));
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

        CalendarSwing.group_v.add("문준호");//그룹원 리스트에 들어갈 테스트값 ->콤보박스 바뀌면 처리해야함
        CalendarSwing.group_v.add("이성현");
        CalendarSwing.group_v.add("최경영");

        CalendarSwing.person_List.setListData(CalendarSwing.group_v);
        CalendarSwing.person_List.setVisibleRowCount(3);
        CalendarSwing.person_List.setFixedCellWidth(90);
        JPanel flow_list = new JPanel(new FlowLayout());
        flow_list.setBorder(BorderFactory.createEmptyBorder(0 ,0 , 0, 20));
        flow_list.setBackground(Color.cyan);

        flow_list.add(new JScrollPane(CalendarSwing.person_List)); //벡터만 손보면 되서 딱히 손 댈거 없을듯
        group_content_pane.add(flow_list);
        list_panel.setBackground(Color.cyan);
        CalendarSwing.west_pane.setBackground(Color.cyan);
        CalendarSwing.west_pane.add(group_content_pane);

        JPanel group_manage_btn = new JPanel(new FlowLayout());
        group_manage_btn.setBorder(BorderFactory.createEmptyBorder(100 ,0 , 0, 0));
        group_manage_btn.setBackground(Color.cyan);


        group_manage_btn.add(CalendarSwing.group_manage);//그룹관리페이지로 전환 기능 구현
        group_manage_btn.add(CalendarSwing.group_exit);//그룹탈퇴 기능 구현
        CalendarSwing.west_pane.add(group_manage_btn);
        CalendarSwing.west_pane.revalidate();
    }

    //그룹관리페이지
    public static void setgroupManage(){
        CalendarSwing.west_pane.removeAll();

        CalendarSwing.west_pane.setBackground(Color.cyan);
        JPanel group_manage_pane = new JPanel(new GridLayout(5,1));
        group_manage_pane.setBackground(Color.cyan);

        //그룹관리프레임 제목
        JLabel group_title = new JLabel("그룹 설정");
        group_title.setBorder(BorderFactory.createEmptyBorder(0 , 70, 0, 90));
        group_title.setHorizontalAlignment(SwingConstants.CENTER);
        group_title.setFont(new Font("Dialog",Font.BOLD,25));
        group_manage_pane.add(group_title);


        //그룹가입pane
        JPanel manage_top = new JPanel(new GridLayout(3,1));

        JPanel join_pane_top = new JPanel(new FlowLayout());
        JLabel lb1_1 = new JLabel("가입할 그룹 이름:");
        join_pane_top.setBackground(Color.cyan);
        join_pane_top.add(lb1_1);
        join_pane_top.add(CalendarSwing.join_name); //가입할 그룹 이름
        manage_top.add(join_pane_top);

        JPanel join_pane_mid = new JPanel(new FlowLayout());
        JLabel lb1_2 = new JLabel("가입할 그룹 코드:");
        join_pane_mid.setBackground(Color.cyan);
        join_pane_mid.add(lb1_2);
        join_pane_mid.add(CalendarSwing.join_code); //가입할 그룹 코드
        manage_top.add(join_pane_mid);

        JPanel join_btn_pane = new JPanel(new FlowLayout());
        join_btn_pane.setBackground(Color.cyan);
        CalendarSwing.groupJoin_btn.setSize(50,50);
        join_btn_pane.add(CalendarSwing.groupJoin_btn); //그룹 가입하기 버튼
        manage_top.add(join_btn_pane);

        group_manage_pane.add(manage_top);

        //그룹생성pane
        JPanel manage_mid = new JPanel(new GridLayout(3,1));

        JPanel create_pane_top = new JPanel(new FlowLayout());
        create_pane_top.setBackground(Color.cyan);
        JLabel lb2_1 = new JLabel("생성할 그룹 이름:");
        create_pane_top.add(lb2_1);
        create_pane_top.add(CalendarSwing.create_name);//생성할 그룹 이름
        manage_mid.add(create_pane_top);

        JPanel create_pane_mid = new JPanel(new FlowLayout());
        create_pane_mid.setBackground(Color.cyan);
        JLabel lb2_2 = new JLabel("생성할 그룹 코드:");
        create_pane_mid.add(lb2_2);
        create_pane_mid.add(CalendarSwing.create_code);//생성할 그룹 코드
        manage_mid.add(create_pane_mid);

        JPanel create_btn_pane = new JPanel(new FlowLayout());
        create_btn_pane.setBackground(Color.cyan);
        CalendarSwing.groupCreate_btn.setSize(50,50);
        create_btn_pane.add(CalendarSwing.groupCreate_btn);//그룹생성 버튼
        manage_mid.add(create_btn_pane);

        group_manage_pane.add(manage_mid);

        //그룹변경
        JPanel manage_bot = new JPanel(new GridLayout(3,1));

        JPanel update_pane_top = new JPanel(new FlowLayout());
        update_pane_top.setBackground(Color.cyan);
        JLabel lb3_1 = new JLabel("변경할 그룹 이름:");
        update_pane_top.add(lb3_1);
        update_pane_top.add(CalendarSwing.update_name);//변경할 그룹 이름
        manage_bot.add(update_pane_top);

        JPanel update_pane_mid = new JPanel(new FlowLayout());
        update_pane_mid.setBackground(Color.cyan);
        JLabel lb3_2 = new JLabel("변경할 그룹 코드:");//변경할 그룹 코드
        update_pane_mid.add(lb3_2);
        update_pane_mid.add(CalendarSwing.update_code);
        manage_bot.add(update_pane_mid);

        JPanel update_btn_pane = new JPanel(new FlowLayout());
        update_btn_pane.setBackground(Color.cyan);
        CalendarSwing.groupUpdate_btn.setSize(50,50);
        update_btn_pane.add(CalendarSwing.groupUpdate_btn); //그룹 변경 버튼
        manage_bot.add(update_btn_pane);

        group_manage_pane.add(manage_bot);

        JPanel back_btn_pane = new JPanel(new FlowLayout());
        CalendarSwing.groupBack_btn.setSize(50,50);
        back_btn_pane.setBackground(Color.cyan);
        back_btn_pane.setBorder(BorderFactory.createEmptyBorder(35 , 0, 0 , 0));

        back_btn_pane.add(CalendarSwing.groupBack_btn);//그냥 페이지전환 뒤로가기버튼
        group_manage_pane.add(back_btn_pane);

        CalendarSwing.west_pane.add(group_manage_pane);
        CalendarSwing.west_pane.revalidate();
    }
}
