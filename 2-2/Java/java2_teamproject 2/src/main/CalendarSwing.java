package main;

import com.mysql.jdbc.Connection;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Vector;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import left.*;
import right.*;
//ToDo 추가
import java.time.LocalDate; //현재 시간을 받아줌

import static main.CalendarSwing.stmt;


public class CalendarSwing extends JFrame implements  ItemListener, ActionListener {
    public static Font fnt = new Font("굴림체",Font.BOLD, 20);
    public static Font title_fnt = new Font("굴림체",Font.BOLD,40);

    //메인 pane
    public static JPanel main_topPane = new JPanel(new BorderLayout());

    //메인 pane에 login 팬
    public static JPanel login_pane=new JPanel(new BorderLayout());
    public static JTextField id = new JTextField(8);
    public static JTextField password = new JTextField(8);
    public static JButton login_btn = new JButton("Login");
    public static JButton sign_btn = new JButton("회원가입");



    //메인상단 pane 오른쪽팬
    public static JPanel mainright_pane = new JPanel();

    //왼쪽 pane
    public static JPanel west_pane = new JPanel(new GridLayout(0,1));

    //회원가입
    public static JTextField sign_id = new JTextField(5); //회원가입 id
    public static JTextField sign_pw = new JTextField(5);//회원가입 비번
    public static JTextField sign_pwcheck = new JTextField(5);//회원가입 비번체크
    public static JTextField sign_name = new JTextField(5);//회원가입 닉네임
    public static JButton sign_ok = new JButton("회원가입");//회원가입하기
    public static JButton sign_cancel = new JButton("취소");//회원가입취소
    public static JLabel sign_error = new JLabel(); //에러메세지 ex)이미 존재하는 아이디,비밀번호가 너무 긺

    //그룹보기pane
    public static JComboBox<String> group_combo = new JComboBox<String>(); //그룹콤보박스에 들어갈 combo

    public static JLabel group_name = new JLabel("학교"); //그룹이름
    public static JLabel group_code = new JLabel("inje"); //그룹코드
    public static JList<String> person_List = new JList<String>();//그룹원 리스트
    public static JButton group_manage=new JButton("그룹 관리");// 그룹관리페이지로(groupManage)
    public static JButton group_exit=new JButton("그룹 탈퇴");//그룹나가기 추후 구현필요
    public static Vector<String> group_v = new Vector<String>(); //그룹원리스트에 추가될 벡터



    //그룹관리pane

    public static JTextField join_name = new JTextField(5); //가입할 그룹이름
    public static JTextField join_code = new JTextField(5); //가입할 그룹 코드
    public static JButton groupJoin_btn = new JButton("그룹가입"); //그룹가입하기 기능구현

    public static JTextField create_name = new JTextField(5); // 생성할 그룹 이름
    public static JTextField create_code = new JTextField(5);//생성할 그룹 코드
    public static JButton groupCreate_btn = new JButton("그룹생성");//그룹생성하기 기능구현

    public static JTextField update_name = new JTextField(5);//변경할 그룹 이름-> 페ㅐ이지들어오면 현재 선택했던 이름이 들가야댐
    public static JTextField update_code = new JTextField(5);//변경할 그룹 코드->페ㅐ이지들어오면 현재 선택했던 코드이 들가야댐
    public static JButton groupUpdate_btn = new JButton("그룹변경");//그룹변경하기 기능 구현

    public static JButton groupBack_btn = new JButton("뒤로가기");//그룹뷰 페이지로 전환

    //할일목록 pane
    public static JPanel east_pane=new JPanel(new GridLayout(10,1)); //오른쪽pane ->오늘할일,추가 등등 페이지

    public static JButton change_cancel = new JButton("취소"); //오늘할일 취소->보기페이지로 전환
    public static JButton change_complet = new JButton("완료");//오늘할일 저장->보기페이지로 전환
    public static JButton change_add = new JButton("추가");//오늘할일 추가->보기페이지로 전환
    public static JButton change = new JButton("수정");//오늘할일 수정페이지로 전환
    //ToDo 여기부터
    public static JTextField []change_list=new JTextField[7];//오늘할일 저장할 텍스트필드들
    public static Vector<String> todo_list = new Vector<String>(); //할 일을 저장해주는 벡터
    public static String selectGroup,selectYear,selectMonth = "", selectDay=""; //버튼을 눌렀을 때 그룹 정보, 년, 월, 일 저장

    public static JLabel[] l = new JLabel[7];
    //ToDo 여기까지
    public static int todoAdd_count = 0; //추가버튼 누를 떄 몇개인지 카운트


    //아래쪽 pane
    public static JPanel south_pane=new JPanel(new BorderLayout());

    //ToDO 여기부터
    public static Vector<String>D_day = new Vector<String>(7);
    public static Vector<String>D_day_dummy= new Vector<String>(7);
//ToDO 여기껴지 수정


    //캘린더 pane
    public static JPanel calPane = new JPanel(new BorderLayout());

    //캘린더상단
    public static JPanel cal_topPane = new JPanel();
    public static JButton prevBtn= new JButton("이전");//이전버튼
    public static JButton nextBtn= new JButton("다음");//다음버튼
    public static JComboBox<Integer> yearCombo = new JComboBox<Integer>();//년도 콤보박스 추가
    public static JComboBox<Integer> monthCombo = new JComboBox<Integer>();//월 콤보박스 추가
    public static JLabel yearLBl = new JLabel("년");//"년" 표시 라벨
    public static JLabel monthLBl = new JLabel("월");//"월" 표시 라벨

    //캘린더중앙
    public static JPanel centerPane = new JPanel(new BorderLayout());//가운데 패널 생성후 레이아웃 설정
    public static JPanel titlePane = new JPanel(new GridLayout(1,7));//타이틀을 생성시킬 패널을 생성하고 레이아웃 설정
    public static String title[] = {"일","월","화","수","목","금","토"};
    public static JPanel dayPane = new JPanel(new GridLayout(0,7));//날짜가 나오는 패널

    //달력관련 데이터
    public static Calendar date;//달력주입
    public static int year;
    public static int month; //년,월 주입

    Container c = getContentPane();

    public CalendarSwing() throws SQLException {
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
        JLabel id_l = new JLabel("            id : ");
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
        west_l.setBorder(BorderFactory.createEmptyBorder(0 , 35, 0 , 220));
        west_pane.setBackground(Color.cyan);
        c.add(BorderLayout.WEST,west_pane);

        //오른쪽pane


        for(int i=0; i<7; i++){
            change_list[i]=new JTextField(10); //그냥 텍필 재정의해주는 반복문
        }
        todo.setTodo(); //오늘의 할일 프레임 호출
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
            JButton lbl = new JButton("<html>" + String.valueOf(day)+ "<br></html>" );//라벨선언해주는데 String.value 는 형변환

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
                //todo 선택된 그룹과 년월일을 저장
                @Override //
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
                        east_pane.removeAll();
                        todo.setTodo();
                        east_pane.repaint();
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
    //ToDO 디데이 수정
    public void setD_day(){
        System.out.println("1");
        JPanel D_dayTitle = new JPanel(new GridLayout(1,7));

        //Todo 현재 시간 저장
        LocalDate now = LocalDate.now();
        int curYear = now.getYear();
        int curMonth =now.getMonthValue();
        int curDay = now.getDayOfMonth();


        if(selectGroup == null){ //초기 화면에는 그룹이 없음
            D_day_dummy.add(+ curYear + "년 "+curMonth+ "월 "+ curDay+"일");
            D_day.add("D-day");

        }else{
            System.out.println("들어옴");

            //ToDo 디데이 저장하기

            try {
                String sql = "SELECT * FROM post ORDER BY post_year , post_month, post_day, idx ASC"; //년 월 일 기준으로 정렬한 채 가져오기

                ResultSet Rs = stmt.executeQuery(sql);

                while(Rs.next()){

                    String postTeam  = Rs.getString("post_team");

                    int postYear = Integer.parseInt(Rs.getString("post_year"));
                    int postMonth = Integer.parseInt(Rs.getString("post_month"));
                    int postDay = Integer.parseInt(Rs.getString("post_day"));

                    if(postTeam.equals(CalendarSwing.selectGroup) &&//선택된 그룹과 같은 그룹이고
                            postYear >= curYear && postMonth >= curMonth && postDay >= curDay)  //년 월 일이 현재와 같거나 크다면
                    { //ToDo

                        Calendar cal = Calendar.getInstance();
                        cal.set(postYear,  postMonth, postDay);

                        long dDay = cal.getTimeInMillis(); // 1000분의 1초로 계산
                        long nowDay = System.currentTimeMillis();
                        long result = dDay - nowDay;// 남은 시간: ms : 1000분의 1초 단위

                        long dayTemp = (result / 1000 / 60 / 60 / 24) -30; //디데이 날짜 기준 계산

                        if(dayTemp == 0){
                            D_day.add("D-day");
                        }else{
                            D_day.add("D-"+Long.toString(dayTemp)); //디데이 저장
                        }

                        D_day_dummy.add(Rs.getString("post_text")); //내용 저장

                    }
                    if(D_day.size() == 7)break; //7개가 저장이 된다면 있다면 종료
                }
                south_pane.repaint();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        for(int i=0;i<D_day.size(); i++){
            JLabel lbl = new JLabel(D_day.get(i), JLabel.CENTER);
            lbl.setFont(fnt);
            D_dayTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            lbl.setForeground(Color.red);
            D_dayTitle.add(lbl);
        }
        JPanel D_daycontent = new JPanel(new GridLayout(1,7));
        for(int i=0;i<D_day.size();i++){
            JLabel lbl = new JLabel(D_day_dummy.get(i),JLabel.CENTER);
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
            todo.changeTodo();
        }
        else if(obj == sign_btn){//화면전환 회원가입페이지로
            sign.setSign();
        }
        else if(obj == sign_ok){//회원가입하기
            west_pane.removeAll();
            west_pane.setSize(100,100);
            JLabel west_l = new JLabel();
            west_pane.add(west_l);
            west_l.setBorder(BorderFactory.createEmptyBorder(0 , 30, 15 , 220));
            west_pane.setBackground(Color.cyan);
        }
        else if(obj == sign_cancel){//회원가입취소
            west_pane.removeAll();
            west_pane.setSize(100,100);
            JLabel west_l = new JLabel();
            west_pane.add(west_l);
            west_l.setBorder(BorderFactory.createEmptyBorder(0 , 30, 15 , 220));
            west_pane.setBackground(Color.cyan);
        }
        else if(obj == groupBack_btn){//화면전환 그룹설정->그룹보기
            group.setgroupView();
            west_pane.repaint();
        }
        else if(obj == group_manage){//화면전환 그룹보기-> 그룹설정
            group.setgroupManage();
            west_pane.repaint();
        }
        else if(obj == login_btn){//로그인하기
            group.setgroupView();

            //ToDo 로그인이 됐을 때 - 그룹 콤버박스에 있는 그룹으로 정보 추가인
            selectGroup = group_combo.getSelectedItem().toString();
            setD_day();
            west_pane.repaint();

            //south_pane.repaint();
        }
    }

    class mouse extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e){
            JButton obj = (JButton) e.getSource();
            if (obj == change_add){//그룹추가
                if(todoAdd_count+todo_list.size()<7){//벡터값 7개까지만 가능하도록
                    todoAdd_count++;//추가를 누르면 추가카운트수만큼 텍스트필드 추가댐
                    todo.changeTodo();
                }
            }
            // 완료버튼
            else if(obj == change_complet){
                //ToDo 누른 버튼에 해당하는 그룹, 날짜의 포스트 row 다 삭제
                String sql = " DELETE FROM post " + " WHERE post_day = " +selectDay+ " AND post_month = "+selectMonth
                        + " AND post_year = " + selectYear +" AND post_team = '" +selectGroup + "'";
                try {
                    stmt = (Statement) con.createStatement();
                    int res = stmt.executeUpdate(sql);
                    if(res > 0) {
                        System.out.println("삭제 성공");
                    }

                } catch (SQLException err) {
                    err.printStackTrace();
                }

                for(int i=0; i <7; i++){
                    if(change_list[i].getText().equals("")) continue; //빈칸이면 그냥 건너 뛰기

                    //텍박 앞에 숫자 긁어와서 idx column에 쓰기
                    sql =" INSERT INTO post VALUE('"+selectYear+"','" +selectMonth+"','"+selectDay+"','"+change_list[i].getText()+"','"+selectGroup+"','"+l[i].getText()+"')";
                    stmt = null;
                    try {
                        stmt = (Statement) con.createStatement();
                        int res = stmt.executeUpdate(sql);
                        if(res > 0) {
                            System.out.println("삽입 성공");
                        }

                    } catch (SQLException err) {
                        err.printStackTrace();
                    }

                    //텍박에 있는 텍스트 날짜 그룹 디비에 insert
                }
                //ToDo 수정이 완료되면 디데이 수정
                setD_day();
                try {
                    todo.setTodo();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            else if(obj == change_cancel){//그룹수정취소소
                try {
                    todo.setTodo();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
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
    public static Connection con =null;
    public static String server = "127.0.0.1:3306"; // MySQL 서버 주소
    public static String database = "Java_project"; // MySQL DATABASE 이름
    public static String user_name = "root"; //  MySQL 서버 아이디
    public static String password5 = "dkdldnjs7098"; // MySQL 서버 비밀번호
    public static Statement stmt;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = (Connection) DriverManager.getConnection("jdbc:mysql://" + server + "/" + database + "?useSSL=false", user_name, password5);
        stmt = (Statement) con.createStatement(); // Query 작업을 실행하기 위한 객체.



        new CalendarSwing();
    }
}