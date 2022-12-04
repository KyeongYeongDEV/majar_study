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
            int hourTmp = c.get(Calendar.HOUR_OF_DAY);
            int minTmp = c.get(Calendar.MINUTE);
            int secondTmp = c.get(Calendar.SECOND);
            String hour, min, second;

            if(hourTmp >=0 && hourTmp< 10){
                hour = "0"+hourTmp;
            }else{
                hour = String.valueOf(hourTmp);
            }
            if(minTmp >=0 && minTmp< 10){
                min = "0"+minTmp;
            }else{
                min = String.valueOf(minTmp);
            }

            if(secondTmp >=0 && secondTmp< 10){
                second = "0"+secondTmp;
            }else{
                second = String.valueOf(secondTmp);
            }
            String clock =   "<html>" + "  현재 시각"+"<br>"+hour+ ":" + min + ":" + second;

            timeLabel.setText(clock);
        }
    }
}
