#include<iostream>
using namespace std;

class Stack{
    int *arr,top;
public:
    Stack(){
        top=0;
        arr = new int[3];
    }
    Stack& operator<<(int num){
        arr[top++] = num;
        return *this;
    }
    bool operator!(){
        if(top == 0)return true;
        else return false;
    }

    void operator>>(int &x){
        x = arr[--top];
        
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