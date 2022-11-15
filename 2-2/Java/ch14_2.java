import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;

class MyPanel extends JPanel{
    private Image img; 
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this); //패널 사이즈에 맞게 이미지 그리기
    }
    public void setImg(Image img){ //패널에 그릴 이미지 세팅
        this.img = img;//이미지를 세팅한 후
        repaint();//다시 그린다
    }
}

class OpenActionListener implements ActionListener{
    private JFileChooser chooser;
    private MyPanel panel;
    public OpenActionListener(MyPanel panel){
        chooser = new JFileChooser();//파일탐색기 객체
        this.panel = panel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");//받아올 파일의 형식을 지정
        chooser.setFileFilter(filter);//파일 탐색기 열기

        int ret = chooser.showOpenDialog(null);
        if(ret != JFileChooser.APPROVE_OPTION){//만약에 파일 탐색기가 열렸었지만 아무 파일도 선택되지 않았다면
            JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);//아무 파일도 선택되지 않았다는 경고창을 띄워줍니단
            return;
        }
        String filePath = chooser.getSelectedFile().getPath(); //선택된 파일의 저장 위치를 변수에 저장
        ImageIcon icon = new ImageIcon(filePath);//선택한 이미지 파일을 이미지아이콘에 저장
        Image img = icon.getImage();//이미지 아이콘에 저장된 이미지를 이미지변수에 저장
        panel.setImg(img); //불러온 파일을 패널에 띄운다
    }
}

public class ch14_2 extends JFrame{
    private MyPanel panel = new MyPanel();
    public ch14_2(){//생성자에서 기본 세팅
        super("메뉴로 배경 이미지 로딩하기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        createMenu();
        setSize(400, 400);
        setVisible(true);
    }
    private void createMenu(){
        JMenuBar menuBar = new JMenuBar(); //메뉴바 생성
        JMenu fileMenu = new JMenu("파일");//메뉴바에 파일이라는 이름의 메뉴 생성
        JMenuItem openItem = new JMenuItem("열기");//파일이라는 메뉴를 누르면 나오면 메뉴아이템 생성

        openItem.addActionListener(new OpenActionListener(panel)); // 열기 메뉴에 이벤트 발생 시 위에서 선언해준 이벤트를 실행

        fileMenu.add(openItem); //파일메뉴에 메뉴아이템 추가
        menuBar.add(fileMenu); //메뉴바에 메뉴 추가
        setJMenuBar(menuBar);//메뉴와 메뉴 아이템이 추가되어 있는 메뉴바 추가
    }
    public static void main(String[] args){
        new ch14_2();
    }
}
