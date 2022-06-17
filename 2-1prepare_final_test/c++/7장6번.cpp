#include<iostream>
using namespace std;

class Matric{
private:
    int arr[4];
public:
    Matric(int a=0,int b=0,int c=0, int d=0){
        arr[0]=a;arr[1]=b;arr[2]=c;arr[3]=d;
    }
    void show(){
        cout <<"Matrix = { ";
        for(int i=0; i < 4; i++){
            cout <<arr[i]<<" ";
        }
        cout<<"}"<<endl;
    }

    friend Matric operator+(Matric a, Matric b);
    friend void operator+=(Matric &a, Matric &b);
    friend bool operator==(Matric a, Matric b);
};

Matric operator+(Matric a, Matric b){
    Matric tmp;
    for(int i=0; i < 4; i++){
        tmp.arr[i] = a.arr[i] + b.arr[i];
    }

    return tmp;
}

void operator+=(Matric &a, Matric &b){
    for(int i=0; i < 4; i++){
        a.arr[i] += b.arr[i];
    }
}

bool operator==(Matric a, Matric b){
    for(int i= 0; i < 4; i++){
        if(a.arr[i] != b.arr[i]){
            return false;
        }
    }
    return true;
}


int main(){
    Matric a(1,2,3,4), b(2,3,4,5),c;

    c= a+b;

    a += b;

    a.show();b.show();c.show();

    if(a == c){
        cout << "a and c are the same"<<endl;
    }
}