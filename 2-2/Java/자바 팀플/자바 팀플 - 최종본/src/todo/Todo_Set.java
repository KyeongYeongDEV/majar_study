package todo;

import main.CalendarSwing;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Todo_Set {

    Todo_Get todoGet = new Todo_Get();
    //오른쪽-할일목록 보기
    public void setTodo() throws SQLException {
        CalendarSwing.east_pane.removeAll();

        JLabel east_l = new JLabel();
        CalendarSwing.east_pane.add(east_l);
        east_l.setBorder(BorderFactory.createEmptyBorder(15 , 30, 0 , 220));
        CalendarSwing.east_pane.setBackground(new Color(0XD1F7FF));

        todoGet.getTodo();
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
        p.setBackground(new Color(0XD1F7FF));

        CalendarSwing.change.setPreferredSize(new Dimension(80,30));
        p.add(CalendarSwing.change);//할일 목록 수정 페이지로 전환
        CalendarSwing.east_pane.add(p);
    }
}
