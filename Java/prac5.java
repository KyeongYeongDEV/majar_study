package prac;
import java.util.Scanner;
//4�� 8��
class phone{
	private String name;
	private String tel;
	
	public phone(String name, String tel) { //�����ڸ� ���� �ʱ�ȭ
		this.name = name;// this�� ��ü ���� ������ ����
		this.tel = tel;
	}
	
	public String get_name() {//�̸��� �������ش�.
		return this.name;
	}
	
	public String get_tel() {//��ȣ�� �������ش�.
		return this.tel;
	}
}

class phonebook{
	Scanner scan = new Scanner(System.in);
	private phone pho[]; //��ü �迭 ����
	private int get_num;//�ο����� �޾��� ����
	
	public phonebook() {// �����ڿ��� �ο����� �ް� 
		System.out.print("�ο��� >>");
		get_num = scan.nextInt();
		
		pho = new phone[get_num];//�� �ο����� ������ŭ ��ü�迭�� ������ش�.
	}
	
	public void get() {
		for(int i =0; i < get_num; i++) {//�� �ޱ�
			System.out.print("�̸��� ��ȭ��ȣ(�̸��� ��ȭ��ȣ�� ��ĭ ���� �Է�>>");
			String name = scan.next();
			String tel = scan.next();
			pho[i] = new phone(name,tel);// �Է� ���� ���� phoneŬ������ �����ڷ� �ʱ�ȭ���ش�.
		}
		System.out.print("����Ǿ����ϴ�...");		
			
	}
	
	public void run() {//�������ִ� �޼ҵ�
		while(true) {//���ѹݺ�
			boolean check = false; //�̸��� �ִ��� Ȯ���� ���� ����	
			int check_num =0;
			
			System.out.print("�˻��� �̸� >>");
			String get_name = scan.next();
			
			if(get_name.equals("�׸�")) {//�׸��� �ԷµǸ� ����
				break;
			}
			
			for(int i=0; i < get_num; i++) { // for���� ���� �̸� �˻�
				if(get_name.equals(pho[i].get_name())) {
					check = true; //�ִٸ�  true
					check_num = i; //�̸��� �ִ� �迭�� ��ġ�� ����
					break;//�̸��� ã�Ҵٸ� ���̻��� �ݺ��� �ð� ����� ����
				}
			}
			if(check) {//ã�� �̸��� �ִٸ� 
				System.out.println(get_name + "�� ��ȣ�� " + pho[check_num].get_tel() + "�Դϴ�.");
				check = false;
			}
			else {//ã�� �̸��� ���ٸ�
				System.out.println(get_name + "�� �����ϴ�.");
			}
		}
	}
}


public class prac {
	public static void main(String args[]) {
		phonebook P = new phonebook(); //phonebook ��ü ����
		P.get();
		P.run();
	}
}
