#include<iostream>
using namespace std;

class Statistics{
    int *arr,cnt;

public:
    Statistics(){
        cnt=0;
        arr = new int[8];
    }
    
    Statistics& operator<<(int num){
        this->arr[cnt++] = num;

        return *this;
    }

    bool operator!(){
        if( arr == nullptr) return false;
        else return true;
    }

    void operator>>(int &arg){
        int sum=0;
        for(int i=0; i < cnt; i++){
            sum += arr[i];
        }
        arg =  sum / cnt;
    }

    void operator~(){
        for(int i = 0; i< cnt; i++){
            cout<< arr[i] << " ";
        }
        cout<<endl;
    }
};

int main(){
    Statistics stat;
    if(!stat) cout << "현재 통계 데이터가 없습니다."<<endl;

    int x[5];
    cout<< "5개의 정수를 입력하라>>";
    for(int i=0; i<5; i++){
        cin >> x[i];//x[]에 정수입력
    }

    for(int i=0; i < 5; i++){
        stat << x[i]; //x[i] 값을 통계 객체에 삽입한다.
    }
    stat << 100 <<200; //100,200을 통계 객체에 삽입한다.
    ~stat;//통계 데이타를 모두 출력한다.

    int avg;
    stat >> avg;//통계 객체로부터 평균을 받는다.
    cout << "avg="<<avg <<endl;//평균을 출력한다.
}