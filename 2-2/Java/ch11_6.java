import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ch11_6 extends JFrame{
    public ch11_6(){
        setTitle("TextArea Practice Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c  = getContentPane();
        JSlider js = new JSlider(0,100,0); 
        JTextArea jta = new JTextArea();

        c.setLayout(new GridLayout(3,1));
        
        js.setMajorTickSpacing(20);//큰 눈금의 간격
        js.setMinorTickSpacing(5); //작은 눈금의 간격
        js.setPaintLabels(true);//true이면 슬라이더의 눈금의 숫자를 보이게 한다. false면 감춘다.
        js.setPaintTicks(true);//true이면 슬라이더의  눈그믈 보이게 한다. false면 감춘다.

        js.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e){//슬라이더의 위치가 변하면
                JSlider temp = (JSlider)e.getSource(); //슬라이스가 몇번째 위치에 잇는지 저장
                String text = jta.getText();// 적혀있는 문자열 저장
                if (text.length() <= js.getValue()){//텍스트의 수가 더 적다면 
                    js.setValue(text.length()); //슬라이스의 값을 0;
                }
                else{
                    jta.setText(text.substring(0,temp.getValue()));
                    //문자열의 0부터 슬라이스의 위치까지만 띄운다.
                }
            }
        });

        jta.addKeyListener(new KeyAdapter(){ 
            public void keyTyped(KeyEvent e){//TextArea에 입력이 되면
                JTextArea t = (JTextArea)e.getSource();//TextArea에 있는 string받아 새로운 TextArea 생성
                String text = t.getText();//기존 TextArea에 있는 문자열을 string에 저장
                if(text.length() <= 100){ //길이가 100이하라면
                    js.setValue(text.length()); //string의 크기로 세팅
                }
                else{//길이가 100을 초가한다면
                    text = text.substring(0,99); //크기를 100으로 앞에서부터 잘라
                    jta.setText(text); //저장
                }
            }
        });

        c.add(jta);
        c.add(js);
        setSize(300,300);
        setVisible(true);
    }
    public static void main(String[] args){
        new ch11_6();
    }
}
