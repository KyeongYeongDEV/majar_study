import com.mysql.jdbc.Connection;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.desktop.SystemEventListener;
import java.awt.event.*;
import java.sql.*;
import java.util.*;


public class CalendarSwing extends JFrame implements  ItemListener, ActionListener {


    Font fnt = new Font("굴림체", Font.BOLD, 20);
    Font title_fnt = new Font("굴림체", Font.BOLD, 40);

    //메인 pane
    JPanel main_topPane = new JPanel(new BorderLayout());

    //메인 pane에 login 팬
    JPanel login_pane = new JPanel(new BorderLayout());
    JTextField id = new JTextField(8);
    JTextField password = new JTextField(8);
    JButton login_btn = new JButton("Login");
    JButton sign_btn = new JButton("회원가입");



    //메인 pane 오른쪽팬
    JPanel mainright_pane = new JPanel();

    //왼쪽 pane
    JPanel west_pane = new JPanel(new GridLayout(8, 1));

    //db문







    //회원가입
    JTextField sign_id = new JTextField(5); //회원가입 id
    JTextField sign_pw = new JTextField(5);//회원가입 비번
    JTextField sign_pwcheck = new JTextField(5);//회원가입 비번체크
    JTextField sign_name = new JTextField(5);//회원가입 닉네임
    JButton sign_ok = new JButton("회원가입");//회원가입하기
    JButton sign_cancel = new JButton("취소");//회원가입취소
    JLabel sign_error = new JLabel(); //에러메세지 ex)이미 존재하는 아이디,비밀번호가 너무 긺



    //그룹보기pane
    JPanel groupView_pane = new JPanel(new GridLayout(9,1));
    JComboBox<String> group_combo = new JComboBox<String>();

    JList<String> person_List = new JList<String>();
    JButton group_manage=new JButton("그룹 관리");
    JButton group_exit=new JButton("나가기");

    //그룹관리pane
    JPanel groupManage_pane = new JPanel(new GridLayout(0,1));

    JTextField join_name = new JTextField(5);
    JTextField join_code = new JTextField(5);
    JButton groupJoin_btn = new JButton("그룹가입");

    JTextField create_name = new JTextField(5);
    JTextField create_code = new JTextField(5);
    JButton groupCreate_btn = new JButton("그룹생성");

    JTextField change_name = new JTextField(5);
    JTextField change_code = new JTextField(5);
    JButton groupChange_btn = new JButton("그룹변경");

    JButton groupBack_btn = new JButton("뒤로가기");

    //할일목록 pane
    JPanel east_pane=new JPanel(new GridLayout(10,1));

    JButton change_cancel = new JButton("취소");
    JButton change_complet = new JButton("완료");
    JButton change = new JButton("수정");
    //Todo 여기부터 변경
//    String[] todo_list = {"청소하기","빨래하기","운동하기","밥먹기","술먹기","과제하기"};
    Vector<String> todo_list ;
    String selectGroup,selectYear,selectMonth, selectDay;

    JTextField []change_list;
    //Todo 여기 변경


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

    public CalendarSwing() throws SQLException {

        super("달력");
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.setBackground(Color.black); //블랙할지 다른색할지는 정해봐야할듯
        date = Calendar.getInstance();//현재의 날짜 시간 객체 생성 및 객체를 받아온다.
        year = date.get(Calendar.YEAR);//캘린더에서 년을 받아와서 미리생성해놓은 year에 주입
        month = date.get(Calendar.MONTH) + 1; //월을 받아와서 month에 대입

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
        JPanel pw_p = new JPanel(new FlowLayout());


        //id비번 라벨값과 텍스트필드 넣기
        id_p.add(id_l);
        id_p.add(id);
        pw_p.add(pw_l);
        pw_p.add(password);
        id.setBorder(null); //텍스트박스 테두리 없애기
        password.setBorder(null);

        login_pane.add(BorderLayout.NORTH,id_p);
        login_pane.add(BorderLayout.CENTER,pw_p);

        JPanel login_btnpane = new JPanel(new FlowLayout());
        sign_btn.addActionListener(this);
        login_btnpane.add(sign_btn);
        login_btnpane.add(login_btn);
        login_pane.add(BorderLayout.SOUTH,login_btnpane);
        login_pane.setBorder(BorderFactory.createEmptyBorder(15 , 50, 15 , 30));
        main_topPane.add(BorderLayout.WEST,login_pane);


        //메인 오른쪽 팬
        mainright_pane.setSize(100,100);
        JLabel right_l = new JLabel("여기에 머넣지?");
        mainright_pane.add(right_l);
        mainright_pane.setBorder(BorderFactory.createEmptyBorder(15 , 0, 0 , 160));
        main_topPane.add(BorderLayout.EAST,mainright_pane);


        //왼쪽 pane(기본)
        //회원가입 레이아웃 기본 설정
        /*west_pane.setSize(100,100);
        JLabel west_l = new JLabel();
        west_pane.add(west_l);
        west_l.setBorder(BorderFactory.createEmptyBorder(0 , 35, 0 , 210));
        west_pane.setBackground(Color.cyan);*/
        setgroupView();
        c.add(BorderLayout.WEST,west_pane);

        //오른쪽pane
        setTodo();
        c.add(BorderLayout.EAST,east_pane);

        //아래쪽pane
        setD_day();
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
        west_pane.setSize(100,100);
        JLabel west_l = new JLabel();
        west_pane.add(west_l);
        west_l.setBorder(BorderFactory.createEmptyBorder(0 , 30, 15 , 210));

        //할일 레이아웃 라벨추가
        JLabel sign_label = new JLabel("회원가입");
        sign_label.setHorizontalAlignment(SwingConstants.CENTER);
        sign_label.setFont(new Font("Dialog",Font.BOLD,25));
        sign_label.setBorder(BorderFactory.createEmptyBorder(0 , 0, 50 , 0));
        west_pane.add(sign_label);

        //쭉 추가로 나열하는 반복문
        JPanel sign_f1 = new JPanel(new FlowLayout());
        JLabel l1 = new JLabel("    아이디:");
        sign_f1.setBackground(Color.cyan);
        l1.setFont(new Font("Dialog",Font.BOLD,15));
        sign_id.setFont(new Font("Dialog",Font.BOLD,15));
        sign_f1.add(l1);
        sign_f1.add(sign_id);
        west_pane.add(sign_f1);

        JPanel sign_f2 = new JPanel(new FlowLayout());
        JLabel l2 = new JLabel("비밀번호:");
        sign_f2.setBackground(Color.cyan);
        sign_pw.setFont(new Font("Dialog",Font.BOLD,15));
        l2.setFont(new Font("Dialog",Font.BOLD,15));
        sign_f2.add(l2);
        sign_f2.add(sign_pw);
        west_pane.add(sign_f2);

        JPanel sign_f3 = new JPanel(new FlowLayout());
        JLabel l3 = new JLabel("다시확인:");
        sign_f3.setBackground(Color.cyan);
        sign_pwcheck.setFont(new Font("Dialog",Font.BOLD,15));
        l3.setFont(new Font("Dialog",Font.BOLD,15));
        sign_f3.add(l3);
        sign_f3.add(sign_pwcheck);
        west_pane.add(sign_f3);

        JPanel sign_f4 = new JPanel(new FlowLayout());
        JLabel l4 = new JLabel("    닉네임:");
        sign_f4.setBackground(Color.cyan);
        sign_name.setFont(new Font("Dialog",Font.BOLD,15));
        l4.setFont(new Font("Dialog",Font.BOLD,15));
        sign_f4.add(l4);
        sign_f4.add(sign_name);
        west_pane.add(sign_f4);

        sign_error.setFont(new Font("Dialog",Font.BOLD,20));
        west_pane.add(sign_error);

        JPanel sign_f5 = new JPanel(new FlowLayout());
        sign_f5.setBackground(Color.cyan);
        sign_ok.setFont(new Font("Dialog",Font.BOLD,15));
        sign_cancel.setFont(new Font("Dialog",Font.BOLD,15));
        sign_cancel.addActionListener(this);
        sign_f5.add(sign_ok);
        sign_f5.add(sign_cancel);
        west_pane.setBackground(Color.cyan);
        west_pane.add(sign_f5);
    }

    //왼쪽-그룹설정
    public void setgroupView(){
        west_pane.removeAll();
        //회원가입 레이아웃 기본 설정
        west_pane.setSize(100,100);

        //할일 레이아웃 라벨추가
        JLabel group_title = new JLabel("그룹 정보");
        group_title.setBorder(BorderFactory.createEmptyBorder(0 , 70, 0, 70));
        group_title.setHorizontalAlignment(SwingConstants.CENTER);
        group_title.setFont(new Font("Dialog",Font.BOLD,25));
        west_pane.add(group_title);

        JPanel combo = new JPanel(new FlowLayout());
        group_combo.addItem("학교");
        group_combo.addItem("회사");
        group_combo.addItem("가족");

        group_combo.addActionListener(this);
        group_combo.setPreferredSize(new Dimension(80,30));
        combo.add(group_combo);
        combo.setBackground(Color.cyan);
        west_pane.add(combo);

        //쭉 추가로 나열하는 반복문
        JPanel group_content_pane = new JPanel(new GridLayout(0,2,5,5));
        group_content_pane.setBackground(Color.cyan);
        JLabel l1 = new JLabel("이름:");
        l1.setHorizontalAlignment(SwingConstants.RIGHT);
        l1.setFont(new Font("Dialog",Font.BOLD,20));
        JLabel group_name = new JLabel("학교");
        group_name.setFont(new Font("Dialog",Font.BOLD,20));
        group_content_pane.setPreferredSize(new Dimension(150,50));
        group_content_pane.add(l1);
        group_content_pane.add(group_name);

        JLabel l2 = new JLabel("code:");
        l2.setHorizontalAlignment(SwingConstants.RIGHT);
        l2.setFont(new Font("Dialog",Font.BOLD,20));
        JLabel group_code = new JLabel("inje");
        group_code.setFont(new Font("Dialog",Font.BOLD,20));
        group_content_pane.add(l2);
        group_content_pane.add(group_code);
        west_pane.add(group_content_pane);

        JLabel l3 = new JLabel("그룹원:");
        l3.setHorizontalAlignment(SwingConstants.RIGHT);
        l3.setFont(new Font("Dialog",Font.BOLD,20));
        group_code.setFont(new Font("Dialog",Font.BOLD,20));
        group_content_pane.add(l3);


        person_List.setVisibleRowCount(5);
        person_List.setFixedCellWidth(100);
        group_content_pane.add(group_code);
        west_pane.add(group_content_pane);



        west_pane.setBackground(Color.cyan);
    }
    //오른쪽-할일 가져오기
    public void getTodo() throws SQLException { //디비에서 할 일 불러옴
        todo_list = new Vector<String>();

        try {
            String sql = "SELECT * FROM post ";
            //ToDo sql문 수정해보기
           // sql+="WHERE + post_year = ' selectYear' AND post_month = '11' AND post_day = '1'";

            ResultSet Rs = stmt.executeQuery(sql);
//ToDo 큰따옴표 안에 내용은 테이블 row명  g("post_team").equals("아자아자"))//아자아자대신 selectGroup
            while(Rs.next()){ //조건 문 걸어서 년 월 일 맞다면 포스트 저장하기
                //ToDO 조건문만 수정하기

                if(  Rs.getString("post_day").equals(selectDay)&&
                        Rs.getString("post_year").equals(selectYear)&&
                        Rs.getString("post_month").equals(selectMonth)&&
                        Rs.getString("post_team").equals("아자아자"))
                {
                    todo_list.add(Rs.getString("post_text"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




//ToDo 할 일 수정
    public void changeTodo(){
        east_pane.removeAll();
        //할일 레이아웃 기본 설정
        east_pane.setSize(100,100);
        JLabel east_l = new JLabel();
        east_pane.add(east_l);
        east_l.setBorder(BorderFactory.createEmptyBorder(15 , 30, 15 , 210));
        //할일 레이아웃 라벨추가
        JLabel todo_label = new JLabel("이 날의 할일");
        todo_label.setHorizontalAlignment(SwingConstants.CENTER);
        todo_label.setFont(new Font("Dialog",Font.BOLD,20));
        todo_label.setBorder(BorderFactory.createEmptyBorder(50 , 0, 50 , 0));
        east_pane.add(todo_label);
        //ToDO 변경됨
        int size = todo_list.size();
        change_list = new JTextField[size];
        //쭉 추가로 나열하는 반복문
        for(int i=0;i<todo_list.size();i++){
            JPanel p = new JPanel(new FlowLayout());
            JLabel l = new JLabel(i+". ");
            l.setFont(new Font("Dialog",Font.PLAIN,15));
            l.setHorizontalAlignment(SwingConstants.CENTER);
            p.add(l);
            change_list[i] = new JTextField(todo_list.get(i));
            change_list[i].setFont(new Font("Dialog",Font.PLAIN,15));
            p.add(change_list[i]);
            east_pane.add(p);
            p.setBackground(Color.cyan);
        }
        JPanel p =new JPanel(new FlowLayout());
        p.setBackground(Color.cyan);
        change_complet.addActionListener(this);
        change_complet.setPreferredSize(new Dimension(80,30));
        p.add(change_complet);

        change_cancel.addActionListener(this);
        change_cancel.setPreferredSize(new Dimension(80,30));
        p.add(change_cancel);
        east_pane.add(p);
    }

    //오른쪽-할일목록
    public void setTodo() throws SQLException { //다시 그리기
        east_pane.removeAll();
        //할일 레이아웃 기본 설정
        east_pane.setSize(100,100);
        JLabel east_l = new JLabel();
        east_pane.add(east_l);
        east_l.setBorder(BorderFactory.createEmptyBorder(15 , 30, 0 , 220));
        east_pane.setBackground(Color.cyan);

        //할일 레이아웃 라벨추가
        //ToDo
        getTodo(); //여기에서 할 일 불러옴

        JLabel todo_label = new JLabel("이 날의 할일");
        todo_label.setHorizontalAlignment(SwingConstants.CENTER);
        todo_label.setFont(new Font("Dialog",Font.BOLD,20));
        todo_label.setBorder(BorderFactory.createEmptyBorder(50 , 0, 50 , 0));
        east_pane.add(todo_label);
        //쭉 추가로 나열하는 반복문

        //ToDo
        //화면에 나열해줌
        for(int i=0;i<todo_list.size();i++){
            JLabel l = new JLabel((i+1) + todo_list.get(i));
            l.setFont(new Font("Dialog",Font.PLAIN,15));
            l.setHorizontalAlignment(SwingConstants.CENTER);
            east_pane.add(l);
        }
        JPanel p =new JPanel(new FlowLayout());
        p.setBackground(Color.cyan);
        change.addActionListener(this);
        change.setPreferredSize(new Dimension(80,30));
        p.add(change);
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

        //날짜추가
        for(int day=1; day<=lastDay; day++){
            JButton lbl = new JButton("<html>" + String.valueOf(day)+ "<br> t</html>" );//라벨선언해주는데 String.value 는 형변환

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
            lbl.addActionListener(new ActionListener() {
                @Override //8<
                public void actionPerformed(ActionEvent e) {
                    selectGroup = group_combo.getSelectedItem().toString();//그룹 콤버박스
                    selectYear = yearCombo.getSelectedItem().toString();
                    selectMonth = monthCombo.getSelectedItem().toString();

                    String tmpDay = lbl.getText().substring(7,8);
                    if(tmpDay.equals("<")){
                        selectDay =  lbl.getText().substring(6,7);
                    }else{
                        selectDay =  lbl.getText().substring(6,8);
                    }


                    try {
                        setTodo();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
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
        }else if(obj == change){
            changeTodo();
        }else if(obj == change_complet){
            for(int i=0;i<6;i++){
                todo_list.set(i, change_list[i].getText());
            }
            try {
                setTodo();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }else if(obj == change_cancel){
            try {
                setTodo();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if(obj == sign_btn){
            setSign();
        }
        else if(obj == sign_cancel){
            west_pane.removeAll();
            west_pane.setSize(100,100);
            JLabel west_l = new JLabel();
            west_pane.add(west_l);
            west_l.setBorder(BorderFactory.createEmptyBorder(0 , 30, 15 , 210));
            west_pane.setBackground(Color.cyan);
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
    public static Connection con =null;
    public static String server = "127.0.0.1:3306"; // MySQL 서버 주소
    public static String database = "Java_project"; // MySQL DATABASE 이름
    public static String user_name = "root"; //  MySQL 서버 아이디
    public static String password5 = "dkdldnjs7098"; // MySQL 서버 비밀번호
    public static  Statement stmt;


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        con = (Connection) DriverManager.getConnection("jdbc:mysql://" + server + "/" + database + "?useSSL=false", user_name, password5);
        stmt = con.createStatement(); // Query 작업을 실행하기 위한 객체.



        new CalendarSwing();
    }

}