package right;
import com.mysql.jdbc.Connection;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import main.*;

import static main.CalendarSwing.*;


public class todo {
    public static void getTodo() throws SQLException { //디비에서 할 일 불러옴
        CalendarSwing.todo_list.removeAllElements();

        try {
            //ToDO 디비 불러오기

            //String sql = "SELECT * FROM post ORDER BY idx ASC";
            String sql = "SELECT * FROM post WHERE post_team = '" + selectGroup
                    +"' AND post_year = '" + selectYear +"' AND post_month = '" +selectMonth + "' AND post_day = '" + selectDay
                    + "' ORDER BY idx ASC";
            ResultSet Rs = stmt.executeQuery(sql);
            while(Rs.next()){ //조건 문 걸어서 년 월 일 맞다면 포스트 저장하기
                    CalendarSwing.todo_list.add(Rs.getString("post_text"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //오른쪽-할일목록 보기
    public static void setTodo() throws SQLException {
        CalendarSwing.east_pane.removeAll();

        JLabel east_l = new JLabel();
        CalendarSwing.east_pane.add(east_l);
        east_l.setBorder(BorderFactory.createEmptyBorder(15 , 30, 0 , 220));
        CalendarSwing.east_pane.setBackground(Color.cyan);

        getTodo();
        //할일 보기 제목 및 프레임 크기설정

        JLabel todo_label = new JLabel("<html>"+CalendarSwing.selectMonth+"월 "+CalendarSwing.selectDay+"일<br>"+"이 날의 할 일 </html>");
        todo_label.setHorizontalAlignment(SwingConstants.CENTER);
        todo_label.setFont(new Font("Dialog",Font.BOLD,20));
        todo_label.setBorder(BorderFactory.createEmptyBorder(50 , 0, 50 , 0));
        CalendarSwing.east_pane.add(todo_label);

        //todo JLabel을 CalenderSwing에 배열로 선언
        //쭉 추가로 나열하는 반복문(벡터값만큼만 반복)
        for(int i=0;i< CalendarSwing.todo_list.size(); i++){
            CalendarSwing.l[i] = new JLabel((i+1)+". " + CalendarSwing.todo_list.get(i));
            CalendarSwing.l[i].setFont(new Font("Dialog",Font.PLAIN,15));
            CalendarSwing.l[i].setHorizontalAlignment(SwingConstants.CENTER);
            CalendarSwing.east_pane.add(CalendarSwing.l[i]);
        }
        JPanel p =new JPanel(new FlowLayout());
        p.removeAll();
        p.setBackground(Color.cyan);

        CalendarSwing.change.setPreferredSize(new Dimension(80,30));
        p.add(CalendarSwing.change);//할일 목록 수정 페이지로 전환
        CalendarSwing.east_pane.add(p);
    }

    //오른쪽-할일 목록 수정
    public static void changeTodo(){
        CalendarSwing.east_pane.removeAll();
        CalendarSwing.east_pane.setSize(100,100);
        JLabel east_l = new JLabel();
        CalendarSwing.east_pane.add(east_l);
        east_l.setBorder(BorderFactory.createEmptyBorder(15 , 30, 15 , 210));
        //할일 수정 제목 및 프레임 크기 설정
        JLabel todo_label = new JLabel("<html>"+CalendarSwing.selectMonth+"월 "+CalendarSwing.selectDay+"일<br>"+"이 날의 할 일 </html>");
        todo_label.setHorizontalAlignment(SwingConstants.CENTER);
        todo_label.setFont(new Font("Dialog",Font.BOLD,20));
        todo_label.setBorder(BorderFactory.createEmptyBorder(50 , 0, 50 , 0));
        CalendarSwing.east_pane.add(todo_label);

        //벡터크기만큼 텍스트필드로 받아서 나열 (수정때문에 할일 보기 목록에있는걸 그대로 받아옴)
        for(int i=0;i<CalendarSwing.todo_list.size();i++){
            JPanel p = new JPanel(new FlowLayout());
            JLabel l = new JLabel((i+1)+". ");
            l.setFont(new Font("Dialog",Font.PLAIN,15));
            l.setHorizontalAlignment(SwingConstants.CENTER);
            p.add(l);
            CalendarSwing.change_list[i] = new JTextField(CalendarSwing.todo_list.get(i),8);
            CalendarSwing.change_list[i].setFont(new Font("Dialog",Font.PLAIN,15));
            p.add(CalendarSwing.change_list[i]);
            CalendarSwing.east_pane.add(p);
            p.setBackground(Color.cyan);
        }

        //추가버튼 누르면 빈 텍스트필드를 추가하고 화면 새로고침함
        for(int i=0;i<CalendarSwing.todoAdd_count;i++){

            JPanel p = new JPanel(new FlowLayout());
            JLabel l = new JLabel((i+CalendarSwing.todo_list.size()+1)+". ");
            l.setFont(new Font("Dialog",Font.PLAIN,15));
            l.setHorizontalAlignment(SwingConstants.CENTER);
            p.add(l);
            CalendarSwing.change_list[i+CalendarSwing.todo_list.size()] = new JTextField(8);
            CalendarSwing.change_list[i+CalendarSwing.todo_list.size()].setFont(new Font("Dialog",Font.PLAIN,15));
            p.add(CalendarSwing.change_list[i+CalendarSwing.todo_list.size()]);
            CalendarSwing.east_pane.add(p);
            p.setBackground(Color.cyan);
        }
        JPanel p =new JPanel(new FlowLayout());
        p.setBackground(Color.cyan);


        CalendarSwing.change_add.setPreferredSize(new Dimension(60,30));

        p.add(CalendarSwing.change_add); //할일 추가버튼

        CalendarSwing.change_complet.setPreferredSize(new Dimension(60,30));

        p.add(CalendarSwing.change_complet);//할일 수정 버튼

        CalendarSwing.change_cancel.setPreferredSize(new Dimension(60,30));

        p.add(CalendarSwing.change_cancel);//할일 수정 취소 버튼
        CalendarSwing.east_pane.add(p);
    }
}
