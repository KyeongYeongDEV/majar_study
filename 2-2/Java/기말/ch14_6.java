import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyModalDialog extends JDialog{
    private JLabel label = new JLabel("두 수를 더합니다.");
    private JTextField textField1 = new JTextField(10); //값을 받아줄 텍스트필드 1
    private JTextField textField2 = new JTextField(10);//값을 받아줄 텍스트필드 2
    private JButton btn = new JButton("Add");
    public MyModalDialog(JFrame frame, String title){ //모달창 세팅
        super(frame, title, true);  
        this.setLayout(null); //레이아웃 설정
        this.add(label); //레이블 추가
        this.add(textField1); //값을 받아줄 텍스트필드 1 추가
        this.add(textField2); //값을 받아줄 텍스트필드 2 추가
        this.add(btn); //버튼 추가

        label.setBounds(45, 10, 100, 20); //레이블의 좌표와 크기 지정
        textField1.setBounds(45, 50, 100, 20); //텍스트필드1의 좌표와 크기 지정
        textField2.setBounds(45, 90, 100, 20);//텍스트필드2의 좌표와 크기 지정
        btn.setBounds(45, 130, 100, 20);//버튼의 좌표와 크기 지정

        btn.addActionListener(new ActionListener() { //버튼이 눌리면
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);//모달 창이 꺼진다.
            }
        });

        setSize(200, 200); //모달창 사이즈
    }
    public String calcResult(){
        String result;
        if(textField1.getText().length() == 0 || textField2.getText().length() == 0){ // 텍스트 필드 둘 중 하나라도 비어있다면
            result = "계산 결과 출력";//결과 값 세팅
        }
        else{// 텍스트 필드 두 개에 값이 들어와있다면
            result = Integer.toString(Integer.parseInt(textField1.getText()) + Integer.parseInt(textField1.getText()));//결과 값 세팅
        }

        textField1.setText("");//   텍스트 필드 비워주기
        textField2.setText("");//   텍스트 필드 비워주기
        return result;//결과 리턴
    }
}
public class ch14_6 extends JFrame{
    private MyModalDialog dialog; //모달 객체
    private JButton calculateBtn;
    private JLabel resultLabel;
    public ch14_6(){
        super("다이얼로그 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        dialog = new MyModalDialog(this, "Calculation Dialog");//모달 객체 기본설정
        calculateBtn = new JButton("calculate");
        resultLabel = new JLabel("계산 결과 출력");
        resultLabel.setOpaque(true); //바탕색 보이게 하기
        resultLabel.setBackground(Color.GREEN); //바탕 색 설정

        calculateBtn.addActionListener(new ActionListener() { //calculate 버튼을 눌렸을 때 이벤트
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(true);//모달 보이게 하기

                String result = dialog.calcResult();//모달에서 받은 결과값 저장
                resultLabel.setText(result); //결과값 레이블에 세팅
            }
        });
        container.add(calculateBtn);//버튼 추가
        container.add(resultLabel);//결과값 추가

        setSize(300, 300);
        setVisible(true);
    }
    public static void main(String[] args){
        new ch14_6();
    }
}