#include<iostream>
using namespace std;

class Name{
private:
    string name;
public:
    Name(){this->name = "---";}

    string get_name(){
        return name;
    }
    void set_name(string name){
        this->name = name;
    }
};

class Reservation{
private:
    Name passenger_info[3][8];
    string reser_name;
    int seat_number;
public:
    Reservation(){
        reser_name = "";
        seat_number = 0;
    }
    void print_seat(int num){
        for(int i=0; i<8; i++){
            cout << passenger_info[num-1][i].get_name()<< "   ";
        }
        cout<<endl;
    }
    void run(){
        int num = 0,time=0,seat=0;
        string name;
        cout <<"**** 한성 항공에 오신 것을 환영합니다. ****"<<endl<<endl;
        while(true){
            cout << "예약:1, 취소:2, 보기:3, 끝내기:4>>";
            cin >> num;

            switch(num){
                case 1://예약 
                    cout << "07시:1, 12시:2, 17시:3>>";
                    cin>>time;

                    switch(time){
                        case 1: 
                            cout<< "07시:  ";
                            print_seat(time);
                            cout <<"좌석 번호 입력 >> ";
                            cin>>seat;
                            cout << "이름 입력>> ";
                            cin >> name;
                            passenger_info[time-1][seat-1].set_name(name);
                            break;

                        case 2:
                            cout<< "12시:  ";
                            print_seat(time);
                            cout <<"좌석 번호 입력 >> ";
                            cin>>seat;
                            cout << "이름 입력>> ";
                            cin >> name;
                            passenger_info[time-1][seat-1].set_name(name);
                            break;
                        case 3:
                            cout<< "17시:  ";
                            print_seat(time);
                            cout <<"좌석 번호 입력 >> ";
                            cin>>seat;
                            cout << "이름 입력>> ";
                            cin >> name;
                            passenger_info[time-1][seat-1].set_name(name);
                            break;
                    }

                    break;
                case 2://취소
                    cout << "07시:1, 12시:2, 17시:3>>";
                    cin>>time;
                    print_seat(time);

                    cout<<"좌석 번호 >> ";
                    cin >> seat;
                    cout << "이름 입력>> ";
                    cin >> name;

                    passenger_info[time-1][seat-1].set_name("---");
                    break;

                case 3://보기
                    cout<<"07시:    ";
                    print_seat(1);
                    cout<<"12시:    ";
                    print_seat(2);
                    cout<<"17시:    ";
                    print_seat(3);
                    cout<<endl;
                    break;
                case 4://끝내기
                    cout << "예약 시스템을 종료합니다.";
                    return;
                default:
                    cout<<"1~4사이의 수를 입력해주세요 ";
            }
        }
    }
    
};

int main(){
    Reservation RE;
    RE.run();
}