#include <iostream>
#include <math.h>
using namespace std;

typedef struct Polynomial{
    int hight;
    float farr[100];
} Polynomial;

void add_Poly(Polynomial A, Polynomial B, Polynomial *ret);
void sub_Poly(Polynomial A, Polynomial B, Polynomial *ret);
void mult_Poly(Polynomial A,  Polynomial B, Polynomial *ret);
void div_Poly(Polynomial A, Polynomial B, Polynomial *ret1, Polynomial *ret2);
void print_Polynomial(Polynomial _in);

int main(){
    Polynomial A = {5, {3, 6, 0, 0, 0, 10}};
    // Polynomial B = {4, {7, 0, 5, 0, 1}};

    // Polynomial A = {4, {7, 0, 5, 0, 1}};
    Polynomial B = {5, {3, 6, 0, 0, 0, 10}};

    Polynomial ret;

    mult_Poly(A, B, &ret);

    print_Polynomial(ret);

    return 0;
}

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

        for(int i=0 ; i <B.hight+1; i++) {
            if(i ==0){
                for(int j=0; j < h_tmp; j++){
                    ret->farr[tmp++] = A.farr[j];
                }
            }
            ret->farr[tmp++] = A.farr[i+h_tmp] - B.farr[i];
        }
    }
    else{
        ret->hight = B.hight;
        int tmp=0, h_tmp = B.hight - A.hight;

        for(int i=0 ; i <A.hight+1; i++) {
            if(i ==0){
                for(int j=0; j < h_tmp; j++){
                    ret->farr[tmp++] = -B.farr[j];
                }
            }
            ret->farr[tmp++] = A.farr[i] - B.farr[i+h_tmp];
        }
    }
}
void mult_Poly(Polynomial A,  Polynomial B, Polynomial *ret){
    int n_tmp=0, max_hight = 0;
    ret->hight = A.hight + B.hight;

    if(A.hight >= B.hight){ 
        Polynomial P_tmp[B.hight];

        for(int i=0; i < B.hight+1; i++){ //모든 차수를 다 곱함
            for(int j=0; j < A.hight+1; j++){ 
                P_tmp[n_tmp].farr[(B.hight-i)+(A.hight-j)-1] += B.farr[i] * A.farr[j]; 
            }
            n_tmp++;
        }
        //곱한 걸 더해주기
        for(int i=0; i < B.hight; i++){
        }
    }
    else{

    }
}
void div_Poly(Polynomial A, Polynomial B, Polynomial *ret1, Polynomial *ret2){//ret1 = 몫 ret2 = 나머지
    //큰 수에서 작은 수 나누는 거랑
    //작은 수에서 큰 수 나누는 경우 생각해야 함
}


void print_Polynomial(Polynomial _in){
    for (int i = 0; i < _in.hight ; i++){
        cout<<_in.farr[i]<<".0x^"<<_in.hight-i;
        if(_in.farr[i+1] < 0){ //음수이면
            continue; 
        }
        else{
            cout << '+';
        }
    }
    cout<<_in.farr[_in.hight] << ".0"<<endl;
}