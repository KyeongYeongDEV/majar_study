package main;


import javax.swing.*;
import java.util.*;

class curTimeThread extends Thread{
    private JLabel timeLabel;

    public curTimeThread(JLabel timeLabel){
        this.timeLabel = timeLabel;
    }

    @Override
    public void run(){
        while(true){
            Calendar c= Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int min = c.get(Calendar.MINUTE);
            int second = c.get(Calendar.SECOND);

            String clock = Integer.toString(hour);
            clock += ":" + min + ":" + second;

            timeLabel.setText(clock);
        }
    }
}
