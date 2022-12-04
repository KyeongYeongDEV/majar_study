package 기말;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


class MDIA extends JDialog{
	private JLabel label1  = new JLabel("1번 파일 경로");
	private JLabel label2 = new JLabel("2번 파일 경로");
	private JTextField fileName1 = new JTextField();
	private JTextField fileName2 = new JTextField();
	private JButton Btn1 = new JButton("입력 완료");
	

	public MDIA(JFrame frame, String title){
		super(frame,title,true);
		this.setLayout(new GridLayout(3,2));
		this.add(label1);
		this.add(fileName1);
		this.add(label2);
		this.add(fileName2);
		this.add(Btn1);
		
		Btn1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				
				// file2 = new File(fileName2.getText());

				// try{
				// 	File file1 = new File(fileName1.getText());
				// 	FileReader Reader1 = new FileReader(file1);
				// 	int singleCh = 0;
				// 	while((singleCh = Reader1.read()) != -1){
				// 		System.out.print((char)singleCh);
				// 	}
				// 	Reader1.close();

				// } catch (FileNotFoundException er) {
				// 	// TODO: handle exception
				// }catch(IOException err){
				// 	System.out.println(err);
				// }

				// try //file 입력 스트림을 생성
				// {
				// 	FileReader Reader1 = new FileReader(file1);
				// 	FileReader Reader2 = new FileReader(file2);
				// 	 //스트림으로 입력 버퍼를 생성
				// 	BufferedReader BufReader1 = new BufferedReader(Reader1);
				// 	BufferedReader BufReader2 = new BufferedReader(Reader2);

				// 	List<String> Lines = new ArrayList<String>();
				// 	String Line = "";
				// 	//텍스트 내용을 한 줄씩 읽어와 aLine에 담고, 이를 aLines에 add 함.
				// 	while((Line = BufReader1.readLine()) != null) {
				// 		Lines.add(Line);
				// 	}
				// 	BufReader1.close();
				// 	for(int i = 0 ; i < Lines.size() ; i++) {
				// 		System.out.println(i + " 번 행 데이터 : " + Lines.get(i));
				// 	}
				// } catch (IOException e1) {
				// 	// TODO Auto-generated catch block
				// 	e1.printStackTrace();
				// }

			}
		});

		setSize(400,150);
	}
}



public class hw8장6번 extends JFrame{
	private MDIA mod;
	private JButton jb;
	private JLabel jl;

	public hw8장6번(){
		setTitle("과제 8장 6번");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c= getContentPane();
		c.setLayout(new FlowLayout());

		mod= new MDIA(this, "파일 선택");
		jb = new JButton("파일 선택 창 띄우기");
		jl= new JLabel("계산 결과 출력");

		jb.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				mod.setVisible(true);

			}
		});
		c.add(jb);
		setSize(300,300);
		setVisible(true);

    }
    public static void main(String[] args) {
		new hw8장6번();
	}
}