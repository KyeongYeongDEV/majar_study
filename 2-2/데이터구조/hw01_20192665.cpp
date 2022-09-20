#include <iostream>
#include <math.h>
using namespace std;

typedef struct Polynomial{
    int hight;
    float farr[100];
} Polynomial;

void add_Poly(Polynomial A, Polynomial B, Polynomial *ret){
    int tmp=0;
    if (A.hight == B.hight){ //차수가 같은 결우
        ret->hight = A.hight;
        
        for(int i=0; i < A.hight+1; i++){
            ret->farr[i] = A.farr[i]  + B.farr[i];
        }
    }
    else if (A.hight > B.hight){ // A의 차수가 큰 경우
        ret->hight = A.hight;
        int h_tmp = A.hight - B.hight;

        for (int i = 0; i < B.hight + 1; i++) {// 차수 +1(상수항)
            if (i == 0){
                for (int j = 0; j < h_tmp; j++){
                    ret->farr[tmp++] = A.farr[j];
                }
            }

            ret->farr[tmp++] = A.farr[i + h_tmp] + B.farr[i];
        }
    }
    else{ // B의 차수가 큰 경우
        ret->hight = B.hight;
        int h_tmp = B.hight - A.hight;

        for (int i = 0; i < A.hight + 1; i++){ // 차수 +1(상수항)
            if (i == 0){
                for (int j = 0; j < h_tmp; j++) {
                    ret->farr[tmp++] =  B.farr[j];
                }
            }

            ret->farr[tmp++] = B.farr[i + h_tmp] + A.farr[i];
        }
    }
}
void sub_Poly(Polynomial A, Polynomial B, Polynomial *ret) {
    if(A.hight == B.hight){
        ret->hight = A.hight;

        for(int i =0; i < A.hight+1; i++){
            ret->farr[i] = A.farr[i] - B.farr[i];
        }
    }
    else if(A.hight > B.hight){
        ret->hight = A.hight;
        int tmp=0, h_tmp = A.hight - B.hight;

        for(int i=0 ; i <B.hight; i++) {
            if(i ==0){
                for(int j=0; j < h_tmp; j++){
                    ret->farr[tmp++] = A.farr[j];
                }
            }
            ret->farr[tmp++] = A.farr[i+h_tmp] - B.farr[i];
        }
    }
    else{

    }
}
void mult_Poly(Polynomial A, Polynomial B, Polynomial *ret){

}
void div_Poly(Polynomial A, Polynomial B, Polynomial *ret1, Polynomial *ret2){//ret1 = 몫 ret2 = 나머지

}


void print_Polynomial(Polynomial _in){
    for (int i = 0; i < _in.hight ; i++){
        cout<<_in.farr[i]<<".0x^"<<_in.hight-i;
        if(_in.farr[i+1] < 0){ //음수이면
            cout << '-';
        }
        else{
            cout << '+';
        }
    }
    cout<<_in.farr[_in.hight] << ".0"<<endl;
}

int main(){
    Polynomial A = {5, {3, 6, 0, 0, 0, 10}};
    // Polynomial B = {4, {7, 0, 5, 0, 1}};

    // Polynomial A = {4, {7, 0, 5, 0, 1}};
    Polynomial B = {5, {3, 6, 0, 0, 0, 10}};


    Polynomial ret;

    add_Poly(A, B, &ret);

    print_Polynomial(ret);

    return 0;
}