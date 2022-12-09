import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class hw8장6번 extends JFrame {
    JLabel lbl = new JLabel("label"); //
    FileReader fileReader1 = null; // 1번 파일을 받아 줄 파일 리더
    FileReader fileReader2 = null;// 2번 파일을 받아 줄 파일 리더 
    FileWriter fileWriter = null; //파일을 저장을 할 때 사용

    int cnt = 0;

    public hw8장6번() { //기본 정보를 설정
        setTitle("JFileChooser"); 
        setDefaultCloseOperation(3);
        Container c = getContentPane();
        c.add(lbl);
        createMenu(); // 메뉴를 불러옵니다

        setSize(300,300);
        setVisible(true);
    }

    public void createMenu(){
        JMenuBar mb = new JMenuBar(); //메뉴바 생성
        JMenu fileMenu = new JMenu("file"); //메뉴바에 넣을 파일메뉴
        JMenuItem open = new JMenuItem("open"); //파일 메뉴 안에 넣을 open 메뉴 아이템
        JMenuItem save = new JMenuItem("save"); // 파일 메뉴 안에 넣을 save 메뉴 아이템

        open.addActionListener(new ac()); //이벤트 추가
        save.addActionListener(new ac()); //이벤트 추가
        fileMenu.add(open); //open 메뉴 아이템 추가
        fileMenu.add(save); //save 메뉴 아이템 추가
        mb.add(fileMenu); //메뉴바에 파일 메뉴 추가
        setJMenuBar(mb);
    }

    class ac implements ActionListener{ //액션이벤트 클래스
        private JFileChooser chooser;

        public ac(){
            chooser = new JFileChooser();
        }

        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getActionCommand().equals("open")){ //open을 누르면
                FileNameExtensionFilter filter = new FileNameExtensionFilter("txtFile","txt"); //텍스트 파일 형식
                chooser.setFileFilter(filter);
                int ret = chooser.showOpenDialog(null);
                if(ret == JFileChooser.APPROVE_OPTION){ //파일을 선택을 했다면
                    if(cnt == 0){ //이전에 선택된 파일이 없다 즉 첫 번째 파일
                        String path = chooser.getSelectedFile().getPath(); //파일 경로를 저장
                        try {
                            fileReader1 = new FileReader(path+"\\"); //경로에 있는 파일을 읽어온다
                        } catch (FileNotFoundException ex) { //에러 잡기
                            throw new RuntimeException(ex);
                        }
                        cnt++;
                        lbl.setText("first file open"); //첫 번째 파일이 추가 되었다는 걸 알려준다.
                    }
                    else if(cnt==1){ //첫 번째 파일일 저장되어 있다면 
                        String path = chooser.getSelectedFile().getPath(); //아래는 위의 식과 동일
                        try {
                            fileReader2 = new FileReader(path+"\\");
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                        cnt++;
                        lbl.setText("second file open");
                    }
                }
            }
            else if(e.getActionCommand().equals("save")){ //저장을 누른 경우
                int ret = chooser.showSaveDialog(null);
                if(ret == JFileChooser.APPROVE_OPTION){
                    String path = chooser.getSelectedFile().getPath(); //두개이 파일을 합친 정보를 저장할 파일의 경로를 불러온다
                    try {
                        fileWriter = new FileWriter(path+"\\"); //경로에 있는 파일을 불러온다
                        int c;
                        while((c = fileReader1.read())!=-1){ //첫 번째 파일 읽기
                            fileWriter.write((char)c); //불러온 파일에 추가
                            System.out.print((char)c); //파일 정보를 눈으로 확인하기 위해 출력
                        }
                        while((c = fileReader2.read())!=-1){ // 두 번째 파일 정보 읽기
                            fileWriter.write((char)c);//불러온 파일에 추가
                            System.out.print((char)c);//파일 정보를 눈으로 확인하기 위해 출력
                        }
                        fileWriter.flush(); //파일 추가
                        fileWriter.close();
                        lbl.setText(chooser.getSelectedFile().getName() + " save"); //저장을 완료 했다고 띄워주기
                    } catch (IOException ex) { //에러 잡기
                        throw new RuntimeException(ex);
                    }
                }

            }
        }
    }
    public static void main(String[] args) {
            new hw8장6번();
    }
}