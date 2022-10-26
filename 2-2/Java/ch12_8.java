import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;


class Circle{ //원 그리기 클래스 
	int x,y,w,h;
	public Circle(int x,int y,int w,int h) { //파라미터값으로 초기화
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
	}
}
public class ch12_8 extends JFrame{
	class MyPanel extends JPanel{
		Vector<Circle> v=new Vector<Circle>(); //Circle 백터 생성
		int fromx,fromy,tox,toy; //원 크기 좌표
		public MyPanel() {
			setLayout(null);
			addMouseListener(new MouseAdapter(){ //마우스 이벤트 처리
				@Override
				public void mousePressed(MouseEvent e) { //마우스 클릭시
					fromx=e.getX(); //시작 x,y 좌표 
					fromy=e.getY();
				}
				@Override
				public void mouseReleased(MouseEvent f) {
					tox=f.getX(); //끝 x,y 좌표
					toy=f.getY();
					int w,h;
					w=fromx-tox;
					h=fromy-toy;
					if(w<0) w=-w; //음수값일 경우
					if(h<0) h=-h;
					// ===========완전 동그란 원을 만들고 싶은 경우 =========
					if(w<=h) 
						v.add(new Circle(fromx,fromy,w,w));
					else if(w>h)
						v.add(new Circle(fromx,fromy,h,h));
					// ===========타원도 상관없이 만들고 싶은 경우 =========
					// v.add(new Circle(fromx,fromy,w,h));
					repaint();
				}
			});
		}
		@Override
		public void paintComponent(Graphics g) { //원 그리기
			super.paintComponent(g);
			for(int i=0;i<v.size();i++) {
				Circle c=v.get(i);
				setForeground(Color.MAGENTA);
				g.drawOval(c.x, c.y, c.w, c.h);
			}
		}
	}
	
	MyPanel panel=new MyPanel();
	public ch12_8() {//타이틀, 종료, 패널, 사이즈, Visible 설정
		setTitle("draw circles");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(800,400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ch12_8();
	}

}