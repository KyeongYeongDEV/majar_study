#include<iostream>
using namespace std;

class Circle{
private:
    int radius;
public:
    Circle(int radius=0){this->radius = radius;}
    void show(){cout <<"radius = "<<radius<< " 인 원"<<endl;}
    friend Circle& operator++(Circle &a);
    friend Circle operator++(Circle &a,int num);
};

Circle& operator++(Circle &a){ //전위연산자
    a.radius++;
    return a;
}

Circle operator++(Circle &a,int num){//후위연산자
    Circle tmp = a;
    a.radius++;
    return tmp;
}

int main(){
    Circle a(5),b(4);
    ++a;
    b = a++;
    a.show();
    b.show();

}