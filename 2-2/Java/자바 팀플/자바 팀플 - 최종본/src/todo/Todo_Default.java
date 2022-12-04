package todo;

import javax.swing.*;
import java.awt.*;

import static main.CalendarSwing.east_pane;

public class Todo_Default {
    public void todo_default(){
        east_pane.removeAll();
        JLabel east_l = new JLabel();
        east_pane.add(east_l);
        east_l.setBorder(BorderFactory.createEmptyBorder(0, 35, 0, 220));
        east_pane.setBackground(new Color(0XD1F7FF));//new Color(0xA2E8DB) //이전 색
    }
}
