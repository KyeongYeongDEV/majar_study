#include<iostream>
using namespace std;

class printer{
private:
    string model,manufacturer;
    int printedCount,availableCount;//인쇄 매수, 인쇄종이잔량
public:
    printer(string model,string manufacturer,int availablecount){
        this->model = model;
        this->manufacturer = manufacturer;
        this->availableCount = availablecount;
        printedCount = 0;
    }
    void print(){
        cout <<model<<", "<<manufacturer<< ", 남은 종이 "<< availableCount-printedCount;
    }
    int get_availablecount(){
        return availableCount-printedCount;
    }
    void set_printedCount(int page){
        printedCount+=page;
    }

};

class printInkJet : public printer{
private:
    int availableInk;
public:
    printInkJet(string model,string manufacuter,int availablecount,int availableInk):
    printer(model,manufacuter,availablecount){this->availableInk = availableInk;}

    void check_can_print(int page){
        if(get_availablecount()-page >=0 && availableInk - page >= 0){
            cout<<"프린트하였습니다."<<endl;
            set_printedCount(page);
            availableInk -= page;
        }else{
            cout<<"용지가 부족하여 프린트할 수 없습니다."<<endl;
        }
    }
    void print(){
        printer::print();
        cout<<", 남은잉크 "<< availableInk <<endl;
    }
};

class printLaser : public printer{
private:
    int availableToner;
public:
    printLaser(string model,string manufacuter,int availablecount,int availableToner):
    printer(model,manufacuter,availablecount){this->availableToner = availableToner;}

    void check_can_print(int page){
        if(get_availablecount()-page >=0 && availableToner - page >= 0){
            cout<<"프린트하였습니다."<<endl;
            set_printedCount(page);
            availableToner -= page;
        }else{
            cout<<"용지가 부족하여 프린트할 수 없습니다."<<endl;
        }
    }

    void print(){
        printer::print();
        cout<<", 남은토너 "<<availableToner<<endl;
    }

};


int main(){
    printInkJet Ink("Officejet V40","HP",5,10);
    printLaser Laser("SCX-6x45","삼성전자",3,20);

    int page=0,num=0;
    cout<<"현재 작동중인 2대의 프린터는 아래와 같다"<<endl;
    cout<<"잉크젯 :";
    Ink.print();
    cout<< "레이저 :";
    Laser.print();
    cout<<endl<<endl;

    while(true){
        cout<<"프린터(1:잉크젯, 2:레이저)와 매수 입력>> ";
        cin >> num>>page;
        if(num ==1){
            Ink.check_can_print(page);
            Ink.print();
            Laser.print();
        }else{
            Laser.check_can_print(page);
            Ink.print();
            Laser.print();         
        }
        char ch=0;
        cout<< "계속 프린트 하시겠습니까(y/n)>>";
        cin >>ch;
        if(ch == 'n'){return 0;}
        cout<<endl;
    }
}