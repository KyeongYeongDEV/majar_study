

import java.io.*;
import java.util.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

class MDIA extends JDialog{
	private JLabel label1  = new JLabel("파일 1");
	private JLabel label2 = new JLabel("파일 2");
	private JButton Btn1 = new JButton("1번 파일 선택");
	private JButton Btn2 = new JButton("2번 파일 선택");
	File file1;
	File file2;

	public MDIA(JFrame frame, String title){
		super(frame,title,true);
		this.setLayout(new GridLayout(2,2));
		this.add(label1);
		this.add(Btn1);
		this.add(label2);
		this.add(Btn2);

		Btn1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				JFileChooser chooser = new JFileChooser();
				String path = chooser.getSelectedFile().getPath();
				
				file1 = new File(path +"/");
				try (FileReader filereader = new FileReader(file1)) {
					int singleCh = 0;
					while((singleCh = filereader.read()) != -1){
					System.out.print((char)singleCh);
					}
					filereader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		setSize(200,200);
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
