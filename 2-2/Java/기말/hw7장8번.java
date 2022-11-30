import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class MD extends JDialog{ //다이얼로그를 관리해주는 클래스
    private JLabel label = new JLabel("이름과 포인 입력하시오"); 
    private JTextField tf = new JTextField();
    private JButton Btn = new JButton("확인");
    private HashMap<String, Integer> map = new HashMap<String,Integer>(); //이름 정보와 포인더를 저장해 줄 해쉬맵

    public MD(JFrame frame, String title){
        super(frame,title,true); //프래임과 타이틀 정보를 받아 모달 창을 띄워줍니다.
        this.setLayout(null);
        this.add(label); //모달창에서 필요한 레이블, 텍스트필드, 버튼 추가
        this.add(tf);        
        this.add(Btn);

        label.setBounds(45,10,100,20); //각 요소들의 위치 지정
        tf.setBounds(45,50,100,20);
        Btn.setBounds(45,90,100,20);

        Btn.addActionListener(new ActionListener(){ //버튼에 클릭 이벤트 추가
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);//버튼 클릭시 모달 창이 사라지게 합니다.
            }
        });
        setSize(300,300); //모달창 크기 지정
    }


    public String calculateBtn(){
        String result = "";
        

        if(tf.getText().equals("그만")){
            
        }

        if(!tf.getText().equals("")){ //값이 입력이 되었다면
            StringTokenizer ST = new StringTokenizer(tf.getText(), " "); //토크나이저 후 앞 뒤 공백 제거
            String name = ST.nextToken().trim(); //이름 얻기
            int point = Integer.parseInt(ST.nextToken().trim()); //포인트 얻기
    
            if(map.get(name) != null){ //이미 있는 이름이라면
                int tmp = (int) map.get(name);
                map.put(name,tmp+point); //해당하는 이름에 원래 포인트에 새로 들어온 포인트 합치기
            }else{
                map.put(name, point); //새로운 이름이라면 그 이름에 포인트 추가
            }
        }
    
        Set<String> keys = map.keySet(); //이름들 받기
        Iterator<String> it = keys.iterator(); //반복문을 돌리기 위해 Iterator에 키의 iterator 저장
        
        while(it.hasNext()){ //반복문을 돌리면서 
            String getName = it.next(); //key 값과
            int score = (int) map.get(getName);// value 값을 받아와
            result += "("+getName+", " +score + ") "; //String 변수에 저장
        }
        tf.setText(""); //모달창을 띄울 때 텍스트필드 초기화
        return result;//이름과 포인트 정보가 저장된 String 변수 반환
    }
}

public class hw7장8번 extends JFrame{
    private MD modal; 
    private JLabel label;
    private JButton JB;

    public hw7장8번(){
        setTitle("6번 과제 1번");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        modal = new MD(this, "입력창");//모달 생성
        JB = new JButton("입력"); //버튼 생성
        label = new JLabel("점수 상태"); // 레이블 생성
        
        JB.addActionListener(new ActionListener(){ //버튼에 이벤트 추가
            @Override
            public void actionPerformed(ActionEvent e){ //클릭 이벤트
                modal.setVisible(true); //모달 창을 띄워준다.

                String result = modal.calculateBtn(); //모달 클래스의 이름과 포인트를 계산해 주는 함수 호출
                if(result.equals("true")) return ;
                
                label.setText(result); //위의 함수 결과값으로 레이블
            }
        });
        c.add(label);
        c.add(JB);

        setVisible(true);
    }
    
    public static void main(String[] args){
        new hw7장8번();
    }
}
