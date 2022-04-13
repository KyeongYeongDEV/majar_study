#include<iostream>
using namespace std;
//5�� 12��
class Dept {
private:
	int size; //scores �迭�� ũ��
	int* scores;//���� �Ҵ� ���� ���� �迭�� �ּ�

public:
	Dept(int size) {
		this->size = size;
		scores = new int[size];
	}

	~Dept() {
		delete scores;
	}
	int getsize() { return size; }
	void read();//size��ŭ Ű���忡�� ������ �о� scores �迭�� ����
	bool isover60(int index); //index�� �л��� ������ 60���� ũ�� true ����
};

void Dept::read() {
	int num = 0;
	cout << "10�� ���� �Է�" << endl;

	for (int i = 0; i < size; i++) {
		cin >> num;
		scores[i] = num;
	}
}

bool Dept::isover60(int index) {
	if (scores[index] > 60) { return 1; }
	else { return 0; }
}

int countpass(Dept &dept) {//��������� �̿��Ѵ�.
	//dept �а��� 60�� �̻����� ����ϴ� �л��� �� ����
	int count = 0;
	for (int i = 0; i < dept.getsize(); i++) {
		if (dept.isover60(i))
			count++;
	}
	return count;
}

int main() {
	Dept com(10);//�� 10���� �ִ� �а�
	com.read(); //�� 10���� �л����� ������ Ű����κ��� �о� scores �迭�� ����
	int n = countpass(com);//com �а��� 60�� �̻����� ����� �л��� ���� ����
	cout << "60�� �̻��� " << n << "��";
}