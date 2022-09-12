package hel;

class point{
	private int x,y;
	
	point(){//�⺻ ������
		x=0;
		y=0;
	}
	point(int x, int y){//������ �����ε�
		this.x = x;
		this.y = y;
	}
	
	public int get_x() {
		return x;
	}
	
	public int get_y() {
		return y;
	}
	
	protected void move(int x,int y) {//x�� y�� ���� �޾� �ʱ�ȭ�� �� ���
		this.x = x;
		this.y = y;
	}
	
}

class colorpoint extends point{
	private String color;
	
	colorpoint(){
		super();//�θ�Ŭ������ ������ ȣ��
		this.color = "BLACK";
	}
	colorpoint(int x,int y){
		super(x,y);
		this.color = "BLACK";
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setXY(int x, int y) {
		move(x,y); //�θ� Ŭ������ protected �żҵ带 �̿��ؼ� ���� �ʱ�ȭ
	}
	public String toString() {
		String str = this.color + "���� (" + get_x() + "," + get_y() + ")�� ��";
		return str;
	}
	
	
}

public class HI {
	 public static void main(String[] args) {
		colorpoint zeropoint = new colorpoint();//(0,0) ��ġ�� black �� ��
		System.out.println(zeropoint.toString()+"�Դϴ�.");
		
		colorpoint cp = new colorpoint(10,10);
		cp.setXY(5,5);
		cp.setColor("RED");
		System.out.println(cp.toString() + "�Դϴ�.");
	}
}
