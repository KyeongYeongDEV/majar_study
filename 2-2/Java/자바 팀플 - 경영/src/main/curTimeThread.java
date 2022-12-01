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
            String tmp;

            if(second >=0 && second< 10){
                tmp = "0"+second;
            }else{
                tmp = String.valueOf(second);
            }
            String clock =   "<html>" + "  현재 시각"+"<br>"+hour+ ":" + min + ":" + tmp;

            timeLabel.setText(clock);
        }
    }
}
