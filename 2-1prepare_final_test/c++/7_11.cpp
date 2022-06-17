#include<iostream>
using namespace std;

class Stack{
    int *arr,top;
public:
    Stack(){
        arr = new int[3];
        top=0;
    }

    

};


int main(){
    Stack stack;
    stack <<3 << 5 << 10; //순서대로 푸시
    while(true){
        if(!stack) break;

        int x;
        stack >> x; //스택의 탑에 있는 정수 팝
        cout << x << ' ';
    }
    cout << endl;
}