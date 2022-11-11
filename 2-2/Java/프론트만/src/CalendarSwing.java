import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Vector;

public class CalendarSwing extends JFrame implements  ItemListener, ActionListener {
    Font fnt = new Font("굴림체",Font.BOLD, 20);
    Font title_fnt = new Font("굴림체",Font.BOLD,40);

    //메인 pane
    JPanel main_topPane = new JPanel(new BorderLayout());

    //메인 pane에 login 팬
    JPanel login_pane=new JPanel(new BorderLayout());
    JTextField id = new JTextField(8);
    JTextField password = new JTextField(8);
    JButton login_btn = new JButton("Login");
    JButton sign_btn = new JButton("회원가입");

    //메인상단 pane 오른쪽팬
    JPanel mainright_pane = new JPanel();

    //왼쪽 pane
    JPanel west_pane = new JPanel(new GridLayout(0,1));

    //회원가입
    JTextField sign_id = new JTextField(5); //회원가입 id
    JTextField sign_pw = new JTextField(5);//회원가입 비번
    JTextField sign_pwcheck = new JTextField(5);//회원가입 비번체크
    JTextField sign_name = new JTextField(5);//회원가입 닉네임
    JButton sign_ok = new JButton("회원가입");//회원가입하기
    JButton sign_cancel = new JButton("취소");//회원가입취소
    JLabel sign_error = new JLabel(); //에러메세지 ex)이미 존재하는 아이디,비밀번호가 너무 긺

    //그룹보기pane
    JComboBox<String> group_combo = new JComboBox<String>(); //그룹콤보박스에 들어갈 combo

    JLabel group_name = new JLabel("학교"); //그룹이름
    JLabel group_code = new JLabel("inje"); //그룹코드
    JList<String> person_List = new JList<String>();//그룹원 리스트
    JButton group_manage=new JButton("그룹 관리");// 그룹관리페이지로(groupManage)
    JButton group_exit=new JButton("그룹 탈퇴");//그룹나가기 추후 구현필요
    Vector<String> group_v = new Vector<String>(); //그룹원리스트에 추가될 벡터



    //그룹관리pane

    JTextField join_name = new JTextField(5); //가입할 그룹이름
    JTextField join_code = new JTextField(5); //가입할 그룹 코드
    JButton groupJoin_btn = new JButton("그룹가입"); //그룹가입하기 기능구현

    JTextField create_name = new JTextField(5); // 생성할 그룹 이름
    JTextField create_code = new JTextField(5);//생성할 그룹 코드
    JButton groupCreate_btn = new JButton("그룹생성");//그룹생성하기 기능구현

    JTextField update_name = new JTextField(5);//변경할 그룹 이름-> 페ㅐ이지들어오면 현재 선택했던 이름이 들가야댐
    JTextField update_code = new JTextField(5);//변경할 그룹 코드->페ㅐ이지들어오면 현재 선택했던 코드이 들가야댐
    JButton groupUpdate_btn = new JButton("그룹변경");//그룹변경하기 기능 구현

    JButton groupBack_btn = new JButton("뒤로가기");//그룹뷰 페이지로 전환

    //할일목록 pane
    JPanel east_pane=new JPanel(new GridLayout(10,1)); //오른쪽pane ->오늘할일,추가 등등 페이지

    JButton change_cancel = new JButton("취소"); //오늘할일 취소->보기페이지로 전환
    JButton change_complet = new JButton("완료");//오늘할일 저장->보기페이지로 전환
    JButton change_add = new JButton("추가");//오늘할일 추가->보기페이지로 전환
    JButton change = new JButton("수정");//오늘할일 수정페이지로 전환
    JTextField []change_list=new JTextField[7];//오늘할일 저장할 텍스트필드들

    Vector<String> todo_v = new Vector<String>(); //오늘할일 저장할 벡터
    int todoAdd_count = 0; //추가버튼 누를 떄 몇개인지 카운트


    //아래쪽 pane
    JPanel south_pane=new JPanel(new BorderLayout());
    String []D_day = {"D-1","D-2","D-3","D-4","D-5","D-6","D-7"};
    String []D_day_dummy = {"친구","회사","가족","학교","모임","연인","휴식"};



    //캘린더 pane
    JPanel calPane = new JPanel(new BorderLayout());

    //캘린더상단
    JPanel cal_topPane = new JPanel();
    JButton prevBtn= new JButton("이전");//이전버튼
    JButton nextBtn= new JButton("다음");//다음버튼
    JComboBox<Integer> yearCombo = new JComboBox<Integer>();//년도 콤보박스 추가
    JComboBox<Integer> monthCombo = new JComboBox<Integer>();//월 콤보박스 추가
    JLabel yearLBl = new JLabel("년");//"년" 표시 라벨
    JLabel monthLBl = new JLabel("월");//"월" 표시 라벨

    //캘린더중앙
    JPanel centerPane = new JPanel(new BorderLayout());//가운데 패널 생성후 레이아웃 설정
    JPanel titlePane = new JPanel(new GridLayout(1,7));//타이틀을 생성시킬 패널을 생성하고 레이아웃 설정
    String title[] = {"일","월","화","수","목","금","토"};
    JPanel dayPane = new JPanel(new GridLayout(0,7));//날짜가 나오는 패널

    //달력관련 데이터
    Calendar date;//달력주입
    int year;
    int month; //년,월 주입

    Container c = getContentPane();

    public CalendarSwing() {
        super("공유캘린터 자바 팀프로젝트");

        c.setLayout(new BorderLayout());
        c.setBackground(Color.black); //블랙할지 다른색할지는 정해봐야할듯
        date = Calendar.getInstance();//현재의 날짜 시간 객체 생성 및 객체를 받아온다.
        year = date.get(Calendar.YEAR);//캘린더에서 년을 받아와서 미리생성해놓은 year에 주입
        month = date.get(Calendar.MONTH) + 1; //월을 받아와서 month에 대입

        sign_cancel.addActionListener(this); //회원가입 취소 버튼 이벤트
        sign_btn.addActionListener(this);//회원가입버튼 이벤트
        login_btn.addActionListener(this);//로그인버튼 이벤트
        group_manage.addActionListener(this);//그룹관리버튼이벤트
        group_combo.addActionListener(this);//콤보박스 선택시 이름이랑 code 관련된 할일목록 버튼에 나타나게 기능 구현
        groupBack_btn.addActionListener(this);//페이지전환 그룹설정->그룹보기로
        change.addActionListener(this);//페이지전환 할일보기->할일수정
        mouse m = new mouse();
        change_add.addMouseListener(m);//할일 추가 기능 구현
        change_complet.addMouseListener(m); //할일 저장 기능 구현
        change_cancel.addMouseListener(m); //할일 취소 기능 구현

        //메인 상단
        JLabel title=new JLabel("2022 자바2 팀프로젝트");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(title_fnt);
        title.setBackground(new Color(221, 232, 137));
        setLayout(new BorderLayout(10,10));
        main_topPane.setBackground(new Color(221, 232, 137));
        main_topPane.add(BorderLayout.CENTER,title);

        //로그인 팬
        JLabel id_l = new JLabel("                id : ");
        JLabel pw_l=new JLabel("password : ");
        JPanel id_p = new JPanel(new FlowLayout());
        id_p.setBackground(Color.pink);
        JPanel pw_p = new JPanel(new FlowLayout());
        pw_p.setBackground(Color.pink);


        //id비번 라벨값과 텍스트필드 넣기
        id_p.add(id_l);
        id_p.add(id);
        pw_p.add(pw_l);
        pw_p.add(password);
        id.setBorder(null); //텍스트박스 테두리 없애기
        password.setBorder(null);

        login_pane.add(BorderLayout.NORTH,id_p); //아이디 비번텍스트필드 프레임
        login_pane.add(BorderLayout.CENTER,pw_p);

        JPanel login_btnpane = new JPanel(new FlowLayout()); //로그인과 회원가입 버튼 프레임
        login_btnpane.add(sign_btn);
        login_btnpane.add(login_btn);
        login_btnpane.setBackground(Color.pink);

        login_pane.add(BorderLayout.SOUTH,login_btnpane);
        login_pane.setBackground(Color.pink);
        login_pane.setBorder(BorderFactory.createEmptyBorder(15 , 50, 15 , 30));
        main_topPane.add(BorderLayout.WEST,login_pane);


        //메인 오른쪽 팬 ->딱히 신경안써도되는 부분
        mainright_pane.setSize(100,100);
        JLabel right_l = new JLabel();
        mainright_pane.add(right_l);
        mainright_pane.setBorder(BorderFactory.createEmptyBorder(15 , 0, 0 , 250));
        mainright_pane.setBackground(Color.pink);
        main_topPane.add(BorderLayout.EAST,mainright_pane);


        //왼쪽 pane(기본)
        //회원가입 레이아웃 기본 설정
        west_pane.setSize(100,100);
        JLabel west_l = new JLabel();
        west_pane.add(west_l);
        west_l.setBorder(BorderFactory.createEmptyBorder(0 , 35, 0 , 210));
        west_pane.setBackground(Color.cyan);
        c.add(BorderLayout.WEST,west_pane);

        //오른쪽pane
        todo_v.add("청소하기");//임시값 넣었음 -> 버튼누르면 디비값 열리게 하면 될듯
        todo_v.add("빨래하기");
        todo_v.add("운동하기");

        for(int i=0;i<7;i++){
            change_list[i]=new JTextField(5); //그냥 텍필 재정의해주는 반복문
        }
        setTodo(); //오늘의 할일 프레임 호출
        c.add(BorderLayout.EAST,east_pane);

        //아래쪽pane
        setD_day(); //디데이 아래쪽에 호출
        c.add(BorderLayout.SOUTH,south_pane);

        c.add(BorderLayout.NORTH,main_topPane);//메인 상단에 pane추가
        c.add(BorderLayout.CENTER,calPane);//메인 중간에 cal추가

        calPane.add(BorderLayout.NORTH, cal_topPane); //상하좌우 가운데로 나뉘어서 레이아웃 설정,위쪽에 대입시키고 pane삽입

        //달력 상단
        cal_topPane.setBackground(new Color(191, 232, 232)); //배경색 주입
        cal_topPane.add(prevBtn);
        prevBtn.setFont(fnt);
        cal_topPane.add(yearCombo);
        yearCombo.setFont(fnt);
        cal_topPane.add(yearLBl);
        yearLBl.setFont(fnt);
        cal_topPane.add(monthCombo);
        monthCombo.setFont(fnt);
        cal_topPane.add(monthLBl);
        monthLBl.setFont(fnt);
        cal_topPane.add(nextBtn);
        nextBtn.setFont(fnt);

        //현재 년,월 설정
        setYear();
        setMonth();

        //title호출
        setCalendarTitle();  //요일을 만들어놓은 메소드
        centerPane.add(BorderLayout.NORTH, titlePane); //센터패널의 위쪽에 타이틀을 넣는다(요일)
        calPane.add(BorderLayout.CENTER,centerPane);

        //날짜만들기
        centerPane.add(dayPane); //센터패널에 날짜패널 추가
        setDay();

        //--------기능이벤트 추가----------
        prevBtn.addActionListener(this);
        nextBtn.addActionListener(this);
        //년월이벤트 다시 등록
        yearCombo.addItemListener(this);
        monthCombo.addItemListener(this);

        //JFrame의 설정들
        setSize(1820, 980);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    //왼쪽 - 회원가입
    public void setSign(){
        west_pane.removeAll();
        //회원가입 레이아웃 기본 설정

        JLabel west_l = new JLabel();
        west_pane.add(west_l);
        west_l.setBorder(BorderFactory.createEmptyBorder(0 , 30, 15 , 211));

        //회원가입 타이틀, 프레임공간 설정
        JLabel sign_label = new JLabel("회원가입");
        sign_label.setHorizontalAlignment(SwingConstants.CENTER);
        sign_label.setFont(new Font("Dialog",Font.BOLD,25));
        sign_label.setBorder(BorderFactory.createEmptyBorder(0 , 0, 50 , 0));
        west_pane.add(sign_label);

        //입력할 회원정보 쭉 나열
        JPanel sign_f1 = new JPanel(new FlowLayout());
        JLabel l1 = new JLabel("    아이디:");
        sign_f1.setBackground(Color.cyan);
        l1.setFont(new Font("Dialog",Font.BOLD,15));
        sign_id.setFont(new Font("Dialog",Font.BOLD,15));
        sign_f1.add(l1);
        sign_f1.add(sign_id); //회원가입 id 텍스트필드
        west_pane.add(sign_f1);

        JPanel sign_f2 = new JPanel(new FlowLayout());
        JLabel l2 = new JLabel("비밀번호:");
        sign_f2.setBackground(Color.cyan);
        sign_pw.setFont(new Font("Dialog",Font.BOLD,15));
        l2.setFont(new Font("Dialog",Font.BOLD,15));
        sign_f2.add(l2);
        sign_f2.add(sign_pw); //회원가입 비밀번호 텍스트필드
        west_pane.add(sign_f2);

        JPanel sign_f3 = new JPanel(new FlowLayout());
        JLabel l3 = new JLabel("다시확인:");
        sign_f3.setBackground(Color.cyan);
        sign_pwcheck.setFont(new Font("Dialog",Font.BOLD,15));
        l3.setFont(new Font("Dialog",Font.BOLD,15));
        sign_f3.add(l3);
        sign_f3.add(sign_pwcheck);//회원가입 비밀번호 체크
        west_pane.add(sign_f3);

        JPanel sign_f4 = new JPanel(new FlowLayout());
        JLabel l4 = new JLabel("    닉네임:");
        sign_f4.setBackground(Color.cyan);
        sign_name.setFont(new Font("Dialog",Font.BOLD,15));
        l4.setFont(new Font("Dialog",Font.BOLD,15));
        sign_f4.add(l4);
        sign_f4.add(sign_name);//회원가입 닉네임 텍스트필드
        west_pane.add(sign_f4);

        sign_error.setFont(new Font("Dialog",Font.BOLD,20));
        west_pane.add(sign_error); //에러메세지 (이미 존재하는 id 또는 닉네임)

        JPanel sign_f5 = new JPanel(new FlowLayout());
        sign_f5.setBackground(Color.cyan);
        sign_ok.setFont(new Font("Dialog",Font.BOLD,15));
        sign_cancel.setFont(new Font("Dialog",Font.BOLD,15));
        sign_f5.add(sign_ok); //회원가입 성공하면 빈칸으로
        sign_f5.add(sign_cancel); //회원가입 취소해도 빈칸으로
        west_pane.setBackground(Color.cyan);
        west_pane.add(sign_f5);
        west_pane.revalidate();
    }

    //왼쪽-그룹 보기
    public void setgroupView(){
        west_pane.removeAll();
        //그룹 정보 타이틀 및 프레임 크기 설정
        JPanel group_top = new JPanel(new GridLayout(2,1));
        JLabel group_title = new JLabel("그룹 정보");
        group_title.setBorder(BorderFactory.createEmptyBorder(0 , 70, 0, 60));
        group_title.setHorizontalAlignment(SwingConstants.CENTER);
        group_title.setFont(new Font("Dialog",Font.BOLD,25));
        group_top.add(group_title);

        //그룹선택 콤보박스
        JPanel combo = new JPanel(new FlowLayout());
        group_combo.addItem("학교");
        group_combo.addItem("회사");
        group_combo.addItem("가족");


        group_combo.setPreferredSize(new Dimension(90,30));
        combo.add(group_combo);
        combo.setBackground(Color.cyan);
        combo.setFont(new Font("Dialog",Font.BOLD,30));
        group_top.add(combo);
        group_top.setBackground(Color.cyan);
        west_pane.add(group_top);

        //그룹정보보여주는 라벨들
        JPanel group_content_pane = new JPanel(new GridLayout(3,2,10,15));
        group_content_pane.setBackground(Color.cyan);
        JLabel l1 = new JLabel("이름:");
        l1.setHorizontalAlignment(SwingConstants.RIGHT);
        l1.setVerticalAlignment(SwingConstants.TOP);
        l1.setFont(new Font("Dialog",Font.BOLD,20));
        group_name.setVerticalAlignment(SwingConstants.TOP);
        group_name.setFont(new Font("Dialog",Font.BOLD,20));
        group_content_pane.setPreferredSize(new Dimension(150,50));
        group_content_pane.add(l1);
        group_content_pane.add(group_name); //보여줄 그룹 이름 ->콤보박스 선택하면 바껴야함

        JLabel l2 = new JLabel("code:");
        l2.setHorizontalAlignment(SwingConstants.RIGHT);
        l2.setVerticalAlignment(SwingConstants.TOP);
        l2.setFont(new Font("Dialog",Font.BOLD,20));
        group_code.setVerticalAlignment(SwingConstants.TOP);
        group_code.setFont(new Font("Dialog",Font.BOLD,20));
        group_content_pane.add(l2);
        group_content_pane.add(group_code);//보여줄 코드 이름 ->콤보박스 선택하면 바껴야함

        JPanel list_panel= new JPanel(new GridLayout(0,2));
        JLabel l3 = new JLabel("그룹원:");
        l3.setHorizontalAlignment(SwingConstants.RIGHT);
        l3.setVerticalAlignment(SwingConstants.TOP);
        l3.setFont(new Font("Dialog",Font.BOLD,20));
        group_content_pane.add(l3);

        group_v.add("문준호");//그룹원 리스트에 들어갈 테스트값 ->콤보박스 바뀌면 처리해야함
        group_v.add("이성현");
        group_v.add("최경영");

        person_List.setListData(group_v);
        person_List.setVisibleRowCount(3);
        person_List.setFixedCellWidth(90);
        JPanel flow_list = new JPanel(new FlowLayout());
        flow_list.setBorder(BorderFactory.createEmptyBorder(0 ,0 , 0, 20));
        flow_list.setBackground(Color.cyan);

        flow_list.add(new JScrollPane(person_List)); //벡터만 손보면 되서 딱히 손 댈거 없을듯
        group_content_pane.add(flow_list);
        list_panel.setBackground(Color.cyan);
        west_pane.setBackground(Color.cyan);
        west_pane.add(group_content_pane);

        JPanel group_manage_btn = new JPanel(new FlowLayout());
        group_manage_btn.setBorder(BorderFactory.createEmptyBorder(100 ,0 , 0, 0));
        group_manage_btn.setBackground(Color.cyan);


        group_manage_btn.add(group_manage);//그룹관리페이지로 전환 기능 구현
        group_manage_btn.add(group_exit);//그룹탈퇴 기능 구현
        west_pane.add(group_manage_btn);
        west_pane.revalidate();
    }

    //그룹관리페이지
    public void setgroupManage(){
        west_pane.removeAll();

        west_pane.setBackground(Color.cyan);
        JPanel group_manage_pane = new JPanel(new GridLayout(5,1));
        group_manage_pane.setBackground(Color.cyan);

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
        join_pane_top.setBackground(Color.cyan);
        join_pane_top.add(lb1_1);
        join_pane_top.add(join_name); //가입할 그룹 이름
        manage_top.add(join_pane_top);

        JPanel join_pane_mid = new JPanel(new FlowLayout());
        JLabel lb1_2 = new JLabel("가입할 그룹 코드:");
        join_pane_mid.setBackground(Color.cyan);
        join_pane_mid.add(lb1_2);
        join_pane_mid.add(join_code); //가입할 그룹 코드
        manage_top.add(join_pane_mid);

        JPanel join_btn_pane = new JPanel(new FlowLayout());
        join_btn_pane.setBackground(Color.cyan);
        groupJoin_btn.setSize(50,50);
        join_btn_pane.add(groupJoin_btn); //그룹 가입하기 버튼
        manage_top.add(join_btn_pane);

        group_manage_pane.add(manage_top);

        //그룹생성pane
        JPanel manage_mid = new JPanel(new GridLayout(3,1));

        JPanel create_pane_top = new JPanel(new FlowLayout());
        create_pane_top.setBackground(Color.cyan);
        JLabel lb2_1 = new JLabel("생성할 그룹 이름:");
        create_pane_top.add(lb2_1);
        create_pane_top.add(create_name);//생성할 그룹 이름
        manage_mid.add(create_pane_top);

        JPanel create_pane_mid = new JPanel(new FlowLayout());
        create_pane_mid.setBackground(Color.cyan);
        JLabel lb2_2 = new JLabel("생성할 그룹 코드:");
        create_pane_mid.add(lb2_2);
        create_pane_mid.add(create_code);//생성할 그룹 코드
        manage_mid.add(create_pane_mid);

        JPanel create_btn_pane = new JPanel(new FlowLayout());
        create_btn_pane.setBackground(Color.cyan);
        groupCreate_btn.setSize(50,50);
        create_btn_pane.add(groupCreate_btn);//그룹생성 버튼
        manage_mid.add(create_btn_pane);

        group_manage_pane.add(manage_mid);

        //그룹변경
        JPanel manage_bot = new JPanel(new GridLayout(3,1));

        JPanel update_pane_top = new JPanel(new FlowLayout());
        update_pane_top.setBackground(Color.cyan);
        JLabel lb3_1 = new JLabel("변경할 그룹 이름:");
        update_pane_top.add(lb3_1);
        update_pane_top.add(update_name);//변경할 그룹 이름
        manage_bot.add(update_pane_top);

        JPanel update_pane_mid = new JPanel(new FlowLayout());
        update_pane_mid.setBackground(Color.cyan);
        JLabel lb3_2 = new JLabel("변경할 그룹 코드:");//변경할 그룹 코드
        update_pane_mid.add(lb3_2);
        update_pane_mid.add(update_code);
        manage_bot.add(update_pane_mid);

        JPanel update_btn_pane = new JPanel(new FlowLayout());
        update_btn_pane.setBackground(Color.cyan);
        groupUpdate_btn.setSize(50,50);
        update_btn_pane.add(groupUpdate_btn); //그룹 변경 버튼
        manage_bot.add(update_btn_pane);

        group_manage_pane.add(manage_bot);

        JPanel back_btn_pane = new JPanel(new FlowLayout());
        groupBack_btn.setSize(50,50);
        back_btn_pane.setBackground(Color.cyan);
        back_btn_pane.setBorder(BorderFactory.createEmptyBorder(35 , 0, 0 , 0));

        back_btn_pane.add(groupBack_btn);//그냥 페이지전환 뒤로가기버튼
        group_manage_pane.add(back_btn_pane);

        west_pane.add(group_manage_pane);
        west_pane.revalidate();
    }

   //오른쪽-할일목록 보기
    public void setTodo(){
        east_pane.removeAll();

        JLabel east_l = new JLabel();
        east_pane.add(east_l);
        east_l.setBorder(BorderFactory.createEmptyBorder(15 , 30, 0 , 220));
        east_pane.setBackground(Color.cyan);

        //할일 보기 제목 및 프레임 크기설정
        JLabel todo_label = new JLabel("이 날의 할일");
        todo_label.setHorizontalAlignment(SwingConstants.CENTER);
        todo_label.setFont(new Font("Dialog",Font.BOLD,20));
        todo_label.setBorder(BorderFactory.createEmptyBorder(50 , 0, 50 , 0));
        east_pane.add(todo_label);

        //쭉 추가로 나열하는 반복문(벡터값만큼만 반복)
        for(int i=0;i< todo_v.size();i++){
            JLabel l = new JLabel((i+1) + todo_v.get(i));
            l.setFont(new Font("Dialog",Font.PLAIN,15));
            l.setHorizontalAlignment(SwingConstants.CENTER);
            east_pane.add(l);
        }
        JPanel p =new JPanel(new FlowLayout());
        p.setBackground(Color.cyan);


        change.setPreferredSize(new Dimension(80,30));
        p.add(change);//할일 목록 수정 페이지로 전환
        east_pane.add(p);
    }

    //오른쪽-할일 목록 수정
    public void changeTodo(){
        east_pane.removeAll();
        east_pane.setSize(100,100);
        JLabel east_l = new JLabel();
        east_pane.add(east_l);
        east_l.setBorder(BorderFactory.createEmptyBorder(15 , 30, 15 , 210));
        //할일 수정 제목 및 프레임 크기 설정
        JLabel todo_label = new JLabel("이 날의 할일");
        todo_label.setHorizontalAlignment(SwingConstants.CENTER);
        todo_label.setFont(new Font("Dialog",Font.BOLD,20));
        todo_label.setBorder(BorderFactory.createEmptyBorder(50 , 0, 50 , 0));
        east_pane.add(todo_label);

        //벡터크기만큼 텍스트필드로 받아서 나열 (수정때문에 할일 보기 목록에있는걸 그대로 받아옴)
        for(int i=0;i<todo_v.size();i++){
            JPanel p = new JPanel(new FlowLayout());
            JLabel l = new JLabel((i+1)+". ");
            l.setFont(new Font("Dialog",Font.PLAIN,15));
            l.setHorizontalAlignment(SwingConstants.CENTER);
            p.add(l);
            change_list[i] = new JTextField(todo_v.get(i),8);
            change_list[i].setFont(new Font("Dialog",Font.PLAIN,15));
            p.add(change_list[i]);
            east_pane.add(p);
            p.setBackground(Color.cyan);
        }

        //추가버튼 누르면 빈 텍스트필드를 추가하고 화면 새로고침함
        for(int i=0;i<todoAdd_count;i++){
            JPanel p = new JPanel(new FlowLayout());
            JLabel l = new JLabel((i+todo_v.size()+1)+". ");
            l.setFont(new Font("Dialog",Font.PLAIN,15));
            l.setHorizontalAlignment(SwingConstants.CENTER);
            p.add(l);
            change_list[i+todo_v.size()] = new JTextField(8);
            change_list[i+todo_v.size()].setFont(new Font("Dialog",Font.PLAIN,15));
            p.add(change_list[i+todo_v.size()]);
            east_pane.add(p);
            p.setBackground(Color.cyan);
        }
        JPanel p =new JPanel(new FlowLayout());
        p.setBackground(Color.cyan);


        change_add.setPreferredSize(new Dimension(60,30));

        p.add(change_add); //할일 추가버튼

        change_complet.setPreferredSize(new Dimension(60,30));

        p.add(change_complet);//할일 수정 버튼

        change_cancel.setPreferredSize(new Dimension(60,30));

        p.add(change_cancel);//할일 수정 취소 버튼
        east_pane.add(p);
    }

    //날짜설정
    public void setDay(){
        //요일
        date.set(year,month-1,1); //date를 세팅하고 요일을 1로 설정
        int week = date.get(Calendar.DAY_OF_WEEK); //요일값을 받아와서 저장
        //마지막날
        int lastDay = date.getActualMaximum(Calendar.DATE); //날짜가 셋팅된 Calender의 가장 큰 값
        //나중에 프린트로 테스트해봐야 자세히 알듯
        //공백
        for(int s=1;s<week;s++){
            JLabel lbl = new JLabel(" "); //들여쓰기
            dayPane.add(lbl);
        }

        //날씨추가
        for(int day=1; day<=lastDay; day++){
            JButton lbl = new JButton("<html>" + String.valueOf(day)+ "<br> test </html>" );//라벨선언해주는데 String.value 는 형변환
            lbl.setFont(fnt);
            lbl.setHorizontalAlignment(SwingConstants.LEFT);
            lbl.setVerticalAlignment(SwingConstants.TOP);
            //출력하는 날짜에대한 요일
            date.set(Calendar.DATE, day); //19->1
            int w=date.get(Calendar.DAY_OF_WEEK);//요일
            if(w==1) lbl.setForeground(Color.red);//요일중 일요일은 빨강
            else if(w==7) lbl.setForeground(Color.blue);//토요일은 파랑
            lbl.setContentAreaFilled(false);
            lbl.setBorder(new LineBorder(Color.black,1,false));
            dayPane.setBackground(Color.white);
            dayPane.add(lbl);
        }
    }

    //요일 설정
    public void setCalendarTitle(){
        for(int i=0;i<title.length; i++){ //만들어준 배열의 수만큼 반복(요일배열)
            JLabel lbl = new JLabel(title[i], JLabel.CENTER);
            lbl.setFont(fnt);
            if(i==0)lbl.setForeground(Color.red);//일요일포폰트 빨간색
            else if(i==6)lbl.setForeground(Color.blue);//토요일폰트 파란색
            titlePane.add(lbl); //타이틀패널에 라벨추가
        }
    }

    //년도 설정
    public void setYear(){
        for(int i=year-50;i<year+20;i++){
            yearCombo.addItem(i); //년도콤보박스에 추가
        }
        yearCombo.setSelectedItem(year);//이벤트와 연동시켜주기위해 추가
    }

    //월 설정
    public void setMonth(){
        for(int i=1;i<=12;i++){
            monthCombo.addItem(i);
        }
        monthCombo.setSelectedItem(month);//이벤트와 연동시키기위해 추가
    }

    //아래쪽 D-daypane
    public void setD_day(){
        JPanel D_dayTitle = new JPanel(new GridLayout(1,7));
        for(int i=0;i<D_day.length; i++){
            JLabel lbl = new JLabel(D_day[i], JLabel.CENTER);
            lbl.setFont(fnt);
            D_dayTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            lbl.setForeground(Color.red);
            D_dayTitle.add(lbl);
        }
        JPanel D_daycontent = new JPanel(new GridLayout(1,7));
        for(int i=0;i<D_day.length;i++){
            JLabel lbl = new JLabel(D_day_dummy[i],JLabel.CENTER);
            lbl.setFont(fnt);
            D_daycontent.setBorder(BorderFactory.createEmptyBorder(15, 0, 20, 0));
            lbl.setBackground(Color.white);
            D_daycontent.add(lbl);
        }
        JPanel D_daypane = new JPanel(new BorderLayout());
        D_daypane.add(BorderLayout.NORTH,D_dayTitle);

        D_daycontent.setBackground(Color.white);
        D_daypane.add(BorderLayout.CENTER,D_daycontent);
        south_pane.add(D_daypane);
    }

    //콤보박스 클릭이벤트
    @Override
    public void itemStateChanged(ItemEvent e) {//콤보박스가 변경되었을 때 발생
        year = (int)yearCombo.getSelectedItem();//콤보박스에서 선택된값을 저장
        month = (int)monthCombo.getSelectedItem();//콤보박스에서 선택된값을 저장

        dayPane.setVisible(false);
        dayPane.removeAll();//원래있던 날짜 지우기
        setDay();//날짜처리
        dayPane.setVisible(true);

        //패널을 안닫으면 화면이 지워지지않음
    }

    //버튼 이벤트
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == prevBtn){  //이전버튼을 눌렀을 때
            //이전 월을 눌렀을때
            prevMonth();
            setDayReset();//날을 초기화시키는 메소드
        }else if(obj == nextBtn){ //다음버튼을 눌렀을 때
            //다음월을 눌렀을 때
            nextMonth();
            setDayReset();
        }else if(obj == change){ //화면전환 할일보기->할일수정
            todoAdd_count=0;
            changeTodo();
        }
        else if(obj == sign_btn){//화면전환 회원가입페이지로
            setSign();
        }
        else if(obj == sign_ok){//회원가입하기
            west_pane.removeAll();
            west_pane.setSize(100,100);
            JLabel west_l = new JLabel();
            west_pane.add(west_l);
            west_l.setBorder(BorderFactory.createEmptyBorder(0 , 30, 15 , 210));
            west_pane.setBackground(Color.cyan);
        }
        else if(obj == sign_cancel){//회원가입취소
            west_pane.removeAll();
            west_pane.setSize(100,100);
            JLabel west_l = new JLabel();
            west_pane.add(west_l);
            west_l.setBorder(BorderFactory.createEmptyBorder(0 , 30, 15 , 210));
            west_pane.setBackground(Color.cyan);
        }
        else if(obj == groupBack_btn){//화면전환 그룹설정->그룹보기
            setgroupView();
            west_pane.repaint();
        }
        else if(obj == group_manage){//화면전환 그룹보기-> 그룹설정
            setgroupManage();
            west_pane.repaint();
        }
        else if(obj == login_btn){//로그인하기
            setgroupView();
            west_pane.repaint();
        }
    }

    class mouse extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e){
            JButton obj = (JButton) e.getSource();
            if (obj == change_add){//그룹추가
                if(todoAdd_count+todo_v.size()<7){//벡터값 7개까지만 가능하도록
                    todoAdd_count++;//추가를 누르면 추가카운트수만큼 텍스트필드 추가댐
                    changeTodo();
                }
            }
            else if(obj == change_complet){//그룹수정저장
                todo_v.removeAllElements();//완료누르면 벡터 초기화
                for(int i=0;i<7;i++){//저장할 텍스트필드배열이 7칸임
                    if(!change_list[i].getText().equals("")){//텍스트필드가 빈값이면 없다고 취급
                        todo_v.add(change_list[i].getText());//텍필이 안비어있을 때만 벡터에 추가 유동적으로 벡터관리를 위해
                    }
                }
                setTodo();
            }
            else if(obj == change_cancel){//그룹수정취소소
                setTodo();
            }
        }
    }




    private void setDayReset(){ //날짜 초기화 메소드
        //년월 이벤트 등록해제
        yearCombo.removeItemListener(this);
        monthCombo.removeItemListener(this); //이벤트 등록해제

        yearCombo.setSelectedItem(year);//콤보박스에서 선택되었던 값을 가져옴
        monthCombo.setSelectedItem(month);

        dayPane.setVisible(false);
        dayPane.removeAll();
        setDay();
        dayPane.setVisible(true);

        yearCombo.addItemListener(this);//이벤트 다시 등록
        monthCombo.addItemListener(this);
    }

    public void prevMonth(){ //이전 월버튼 클릭했을 때
        if(month==1){
            year--;
            month=12;
        }else {
            month--;
        }
    }

    public void nextMonth(){ //다음 월버튼을 클릭했을 때
        if(month==12){
            year++;
            month=1;
        }else {
            month++;
        }
    }
    //메인메소드
    public static void main(String[] args) {
        new CalendarSwing();
    }


}