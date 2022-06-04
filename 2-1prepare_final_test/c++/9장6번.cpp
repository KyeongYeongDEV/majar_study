#include<iostream>
using namespace std;

class AbstrackStack{
public:
    virtual bool push(int n) = 0; //스택에 n을 푸시한다. 스택이 full이면 false 리턴
    virtual bool pop(int &n) = 0; //스택에서 팝한 정수를 n에 저장하고 스택이 empty면 false 리턴

    virtual int size() =0;
};

class IntStack : public AbstrackStack{
private:
    int arr_size,*arr,top;

public:
    IntStack(int s=3){
        arr_size = s;
        top =0;
        arr = new int[arr_size];
    }

    ~IntStack(){delete[] arr;}

    virtual bool push(int n){
        if (top <= 100){
            arr[++top] = n;
            return true;
        } else return false;
    }

    virtual bool pop(int &n){
        if(top >0){
            n = arr[top--];
            return true;
        }else return false;
    }

    virtual int size(){
        return top;
    }

};

int main(){
    IntStack intstack(100);

    while(1){
        cout << "1: push    2: pop    3: show_size    4:exit"<<endl;
        int num;
        cout << "선택하세요>>" ;
        cin >> num;

        if(num ==1){  
            cout <<"push할 정수를 입력해주세요 >> "; 
            int push_num;
            cin >> push_num;
            if(intstack.push(push_num)){
                cout << "Success"<<endl;
            }else cout << "Fail.."<<endl;}
          
        else if(num==2){
            int pop_num=0;
            if(intstack.pop(pop_num)) cout << "pop : " <<pop_num<<endl;
            else cout <<"empty"<<endl;
        }
            
        else if(num ==3){
            cout <<"size : " << intstack.size()<<endl;
        }
            
        else if(num ==4){
            return 0;
        }
            
        else{
            cout <<"숫자 1~4중에 다시 입력하세요 " <<endl;
        }
    }
}