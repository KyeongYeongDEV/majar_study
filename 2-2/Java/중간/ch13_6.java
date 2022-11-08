import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class bbThread extends Thread {
	private JLabel la;
	private Container c;
	int x, y;
	public bbThread(Container c,JLabel la,int x, int y) { //생성자 초기화
		this.la = la;
		this.c = c;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void run() { //사진을 이동 시키는 메소드
		la.setLocation(x,y); //사진을 담은 레이블을 위치를 처음에는 클릭한 위치에 띄어준다.
		c.add(la); //컨테이너에 추가
		while(true) {//무한루프로 사진을 위로 가게 해준다.
			try{
				if(y>=-50) {
					//버블 크기가 -50이라서
				y-=5;
				la.setLocation(x,y);//레이블 위치 이동
				sleep(20); //재우기
				}
				else if (y<-50) 
					c.remove(la); // 컨테이너 삭제
			}catch(InterruptedException e){ //에러 발생시 에러메시지 출력
				System.out.println("error");
			}
		}
	}
}


public class ch13_6
extends JFrame {
	JLabel la[] = new JLabel[40];
	ImageIcon bb_icon = new ImageIcon("/Users/kyeongyeong/Downloads/buble.png"); //이미지를 불러와서 저장
	bbThread bb[] = new bbThread[40];
	int i =0;
	public ch13_6() {
		super("버블 게임");//타이틀 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//종료
		Container c = getContentPane(); //컨테이서 생성
		c.setLayout(null); //레이아웃을 비워준다.
		setSize(700,700); //사이즈 설정
		setVisible(true); 
		for(int i=0;i<40;i++) {
			la[i] = new JLabel(); 
			la[i].setIcon(bb_icon);//클릭할 때마다 생성되는 아이콘을 레이블 배열에 저장해준다. 
			la[i].setSize(50,50);//아이콘 사이즈
			//c.add(la[i]);
		}
		
		c.addMouseListener(new MouseAdapter() { //마우스 이벤트 추가
			@Override
			public void mousePressed(MouseEvent e) { //클릭할 때마다 생성되는 아이콘을 레이블 배열에 저장해준다.
				bb[i] = new bbThread(c,la[i],e.getX(),e.getY()); //컨테이너에 아이콘과 좌표값을 넣은 스레드 추가
				bb[i].start();//스레드 실행
				i++;	
			}
		});
		c.requestFocus();//강제포커싱
	}
	
	public static void main(String [] args) {
		new ch13_6();
	}
}