#include<iostream>
using namespace std;

class Printer{
protected:
    string model,manufacturer;
    int printedCount,availableCount;
public:
    Printer(string model, string manufacturer, int printedCount){
        this->model  = model;
        this-> manufacturer = manufacturer;
        this->printedCount = printedCount;
    }
    virtual void print(int pages)=0;//pages만큼 프린트한다.
    virtual void show() = 0; //현재 프린트의 모델, 제조사, 인쇄매수, 인쇄종이 잔량 출력
};

class InkJetPrinter:public Printer{
private:
    int availableInk;//잉크 잔량
public:
    InkJetPrinter(string model,string manufacturer, int printedCount, int availableCount)
    : Printer(model,manufacturer,printedCount){
        this->availableInk= availableCount;
    }
    void print(int page){
        if(printedCount - page <0 || availableInk-page < 0){
            cout <<"용지가 부족하여 프린트를 할 수 없습니다."<<endl;
        }else{
            printedCount -= page;
            availableInk-= page;
            cout << "프린트하였습니다."<<endl;;
        }
    }
    void show(){
        cout <<"잉크젯 : "<< model << ", " << manufacturer << ", 남은 종이 " << printedCount
                <<"장, 남은 잉크 " << availableInk << "\n";  
    }
};
class LaserPrinter : public Printer{
private:
    int availableToner; //토너 잔량
public:
    LaserPrinter(string model,string manufacturer, int printedCount, int availableCount)
    : Printer(model,manufacturer,printedCount){
        this->availableToner= availableCount;
    }
    void print(int page){
        if(printedCount - page <0 || availableToner-page < 0){
            cout <<"용지가 부족하여 프린트를 할 수 없습니다."<<endl;
        }else{
            printedCount -= page;
            availableToner-= page;
            cout << "프린트하였습니다."<<endl;;
        }
    }
    void show(){
        cout <<"잉크젯 : "<< model << ", " << manufacturer << ", 남은 종이 " << printedCount
                <<"장, 남은 잉크 " << availableToner << "\n";  
    }
};

int main(){
    InkJetPrinter ink("Officejet v40", "Hp", 5,10);
    LaserPrinter laser("SCX-6x45","삼성전자", 3, 20);

    cout<< "현재 작동중인 2 대의 프린터는 아래와 같다"<<endl;
    ink.show();
    laser.show();
    cout <<endl;

    while(1){
        cout << "프린터(1:잉크젯, 2:레이저)와 매수 입력 >> ";
        int print_num, page_num;
        cin >> print_num >> page_num;

        if(print_num == 1){
            ink.print(page_num);
        }else{
            laser.print(page_num);   
        }ink.show();laser.show();

        cout <<"계속 프린트하시겠습니까? (y/n)>>";
        char ch;
        cin >>ch;
        cout <<endl;
        if(ch != 'y') break;
    }
}