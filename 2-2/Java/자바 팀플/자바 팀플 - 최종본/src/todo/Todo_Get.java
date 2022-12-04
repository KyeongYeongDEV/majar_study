package todo;

import main.CalendarSwing;

import java.sql.ResultSet;
import java.sql.SQLException;

import static main.CalendarSwing.*;

public class Todo_Get {
    public void getTodo() throws SQLException { //디비에서 할 일 불러옴
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
}
