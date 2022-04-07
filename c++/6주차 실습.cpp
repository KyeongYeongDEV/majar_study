#include<iostream>
using namespace std;

//4�� 12��

class Circle {
private:
	int radius; //���� ��������
	string name; //���� �̸�

public:
	Circle();
	void setCircle(string name, int radius); //�̸��� ������ ����
	double getArea();
	string getName();
};

Circle::Circle() { radius = 0; name = ""; }

void Circle::setCircle(string name, int radius) {
	this->name = name;
	this->radius = radius;
}

double Circle::getArea() {
	int set = radius * radius * 3.14;
	return set;
}

string Circle::getName() {
	return name;
}

class CircleManager {
private:
	Circle* p;//Circle �迭�� ���� ������
	int size; //�迭�� ũ��
	
public:
	CircleManager(int size);//size ũ���� �迭�� ���� ����, ����ڷκ��� �Է� �Ϸ�
	~CircleManager();
	void searchByName(string Circle_Name);//����ڷκ��� ���� �̸��� �Է��޾� ���� ���
	void sreachByArea(double get_area);//����ڷκ��� ������ �Է¹޾� �������� ū ���� �̸� ���
};

CircleManager::CircleManager(int size) {
	this->size = size;
	p = new Circle[size];

	for (int i = 0; i < size; i++) {
		cout << "�� " << i + 1 << "�� �̸��� ������ >>";
		string a;
		int b;
		cin >> a >> b;
		p[i].setCircle(a, b);
		cout << endl;
	}
}

void CircleManager::searchByName(string Circle_Name) {
	for (int i = 0; i < size; i++) {
		if (p[i].getName() == Circle_Name) {
			cout << "������ ������ " << p[i].getArea() << endl;
			break;
		}
	}
}

void CircleManager::sreachByArea(double get_area){
	cout << get_area << "���� ū ���� �˻��մϴ�.\n";
	for (int i = 0; i < size; i++) {
		if (p[i].getArea() >= get_area) {
			cout << p[i].getName() << "�� ������ " << p[i].getArea() << ", ";
		}
	}
	cout << endl;
}

CircleManager::~CircleManager() {
	delete[] p;
} 

int main() {
	int num;
	cout << "���� ���� >> ";
	cin >> num;

	CircleManager M(num);

	cout << "�˻��ϰ��� �ϴ� ���� �̸� >> ";
	string Circle_name;
	cin >> Circle_name;
	M.searchByName(Circle_name);

	cout << "�ּ� ������ ������ �Է��ϼ��� >>";
	int num2; 
	cin >> num2;
	M.sreachByArea(num2);
}