import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class MyModalDialog extends JDialog{
    private JLabel label  = new JLabel("두 수를 더합니다.");
    private JTextField textField1 = new JTextField(10);
    private JTextField textField2 = new JTextField(10);
    private JButton btn = new JButton("Add");

    public MyModalDialog(JFrame frame, String title){
        super(frame, title, true);
        this.setLayout(null);
        this.add(label);
        this.add(textField1);
        this.add(textField2);
        this.add(btn);

        label.setBounds(45, 10, 100, 20);
        textField1.setBounds(45, 50, 100, 20);
        textField2.setBounds(45, 90, 100, 20);
        btn.setBounds(45, 130, 100, 20);

        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }
        }); 
        setSize(200,200);
    }

    public String calcResult(){
        String result;
        if(textField1.getText().length() == 0 || textField2.getText().length() == 0){
            result = "계산 결과 출력";
        }else{
            int tmp1 =Integer.parseInt(textField1.getText()) ;
            int tmp2 =Integer.parseInt(textField2.getText());  
            result =  Integer.toString(tmp1+tmp2);
                    
        }
        textField1.setText("");
        textField2.setText("");
        return result;
    }
}

public class ch14_6 extends JFrame{
    private MyModalDialog dialog;
    private JButton calculateBtn;
    private JLabel resultLabel;

    public ch14_6(){
        setTitle("다이얼로그 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        dialog = new MyModalDialog(this, "Calculation Dialog");
        calculateBtn  = new JButton("calculate");
        resultLabel = new JLabel("계산 결과 출력");
        resultLabel.setBackground(Color.GREEN);
        resultLabel.setOpaque(true);

        calculateBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dialog.setVisible(true);

                String result = dialog.calcResult();
                resultLabel.setText(result);
            }
        });
        c.add(calculateBtn);
        c.add(resultLabel);

        setSize(300,300);
        setVisible(true);
    }
    
    public static void main(String[] args){
        new ch14_6();
    }
} 