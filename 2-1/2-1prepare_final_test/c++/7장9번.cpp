#include<iostream>
using namespace std;

class Circle{
private:
    int radius;
public:
    Circle(int radius=0){this->radius = radius;}
    void show(){cout <<"radius = "<<radius<< " 인 원"<<endl;}
    friend Circle operator+(int num, Circle op);
};

Circle operator+(int num, Circle op){
    op.radius += num;
    return op;
}

int main(){
    Circle a(5),b(4);
    b = 1+a;
    a.show();
    b.show();
}