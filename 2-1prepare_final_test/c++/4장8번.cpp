#include<iostream>
using namespace std;

class Circle{
    int radius;
public:
    void setRadius(int radius);//반지름을 설정한다.
    double getArea();//면적을 리턴한다.
};
void Circle::setRadius(int radius){
    this->radius = radius;
}

double Circle::getArea(){
    return radius* radius *3.14;
}

int main(){
    int circle_num=0,num=0,cnt=0;
    cout <<"원의 개수 >>";
    cin>>circle_num;
    Circle circle[circle_num];

    for(int i=0;i<circle_num;i++){
        cout <<"원 "<<i+1 <<"의 반지름 >>";
        cin >>num;
        circle[i].setRadius(num);
        if(circle[i].getArea() >100){cnt++;}
    }

    cout << "면적이 100보다 큰 원은 " << cnt<<"개 입니다.";

    return 0;
}