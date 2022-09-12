#include<iostream>
using namespace std;

class Matrix{
private:
    int arr[4];
public:
    Matrix(int a=0, int b =0,int c=0,int d =0){
        arr[0]= a;arr[1]= b;arr[2]=c ;arr[3]= d;
    }

    void operator>>(int x[]){
        for(int i =0; i < 4; i++){
            x[i] = arr[i];
        }
    }
    void operator<<(int y[]){
        for(int i=0; i < 4; i++){
            arr[i] = y[i];
        }
    }
    void show(){
        cout <<"Matrix = { ";
        for(int i=0; i< 4; i++){
            cout<< arr[i]<<" ";
        }
        cout<<"}"<<endl;
    }
};

int main(){
    Matrix a(4,3,2,1),b;
    int x[4],y[4]={1,2,3,4};

    a >> x; //a에 있는 걸 x에 넣기 
    b << y; //y에 있는 걸 b에 넣기

    for(int i=0; i <4; i++){//x출력
        cout <<x[i] <<' ';
    }
    cout << endl;

    b.show();
}