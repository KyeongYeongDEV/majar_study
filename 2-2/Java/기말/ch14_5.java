import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.sound.sampled.*;
import java.io.*;

public class ch14_5 extends JFrame{
    Clip clip = null;
    File audioFile = null;

    public ch14_5(){
        Container c  = getContentPane();

        try{
            clip = AudioSystem.getClip();
            audioFile = new File("음원 파일 경로");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip.open(audioStream);
            clip.start();

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel lb = new JLabel(audioFile.getPath()+ "연주중");
        lb.setHorizontalAlignment(JLabel.CENTER);
        c.add(lb);

        c.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseExited(MouseEvent e){
                clip.stop();
                lb.setText(audioFile.getPath() + "연주 중단");
            }

            public void mouseEntered(MouseEvent e){
                if(!clip.isActive()){
                    clip.start();
                    lb.setText(audioFile.getPath() + "연주중");
                }
            }
        });

        setTitle("마우스 올리면 노래 나오기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        setVisible(true);
    }
    public static void main(String[] args){
        new ch14_5();
    }
    
}
