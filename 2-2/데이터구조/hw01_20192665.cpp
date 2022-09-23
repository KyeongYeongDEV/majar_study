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
    int n_tmp=0;
    Polynomial *P_tmp;

    //곱하기 
    if(A.hight >= B.hight){
        P_tmp = (Polynomial*)malloc(sizeof(Polynomial) * A.hight);
            for(int i=0; i < A.hight; i++){ //초기화
                for(int j=0; j < 100; j++){
                P_tmp[i].farr[j] =0;
            }
        }
        for(int i=0; i < B.hight+1; i++){ //모든 차수 다 곱하기
            for(int j=0; j < A.hight+1; j++){ 
                P_tmp[n_tmp].farr[i+j] = B.farr[i] * A.farr[j]; 
            }
            P_tmp[n_tmp].hight = B.hight+(A.hight-i);
            n_tmp++;
        }
    }
    else{
        P_tmp = (Polynomial*)malloc(sizeof(Polynomial) * B.hight);
        for(int i=0; i < B.hight; i++){ //초기화
            for(int j=0; j < 100; j++){
                P_tmp[i].farr[j] =0;
           }
        }
        for(int i=0; i < A.hight+1; i++){ //모든 차수 다 곱하기
            for(int j=0; j < B.hight+1; j++){ 
                P_tmp[n_tmp].farr[i+j] = A.farr[i] * B.farr[j]; 
            }
            P_tmp[n_tmp].hight = A.hight+(B.hight-i);
            n_tmp++;
        }
    }

    for(int i=0; i < P_tmp[0].hight+1; i++){ //ret 초기화
        ret->farr[i] = P_tmp[0].farr[i];
    }
    ret->hight = P_tmp[0].hight;

    //곱한 걸 더해주기
    for(int i=1; i < n_tmp; i++){ //P_tmp의 크기만큼 돌려서 ret에 더해준다.
        int tmp = 0;

        if(P_tmp[i].hight == ret->hight){//차수가 같다
            for(int j = 0 ; j< P_tmp[i].hight + 1; j++){
                ret->farr[j] += P_tmp[i].farr[j];
            }
        }
        else if(P_tmp[i].hight > ret->hight){ 
            int h_tmp = P_tmp[i].hight - ret->hight;

            for(int j =0; j < ret->hight+1; j++){
                if(j ==0){
                    float r_tmp[100]={0,};
                    for(int q =0; q < ret->hight; q++){//ret arr를 임시저장
                        r_tmp[q]= ret->farr[q];
                        ret->farr[q] = 0;
                    }

                    for(int k=0; k < h_tmp; k++){
                        ret->farr[tmp++] += P_tmp[i].farr[k];
                    }
                    for(int q = h_tmp; q < ret->hight+1; q++){
                         r_tmp[q]+= P_tmp[i].farr[q];
                    }
                }

                ret->farr[tmp++] += P_tmp[i].farr[j+h_tmp];
            }
            ret->hight = P_tmp[i].hight; //더 큰 차수로 바꿔준다.
        }
        else{
            int h_tmp = ret->hight- P_tmp[i].hight;
            for(int q =0; q < ret->hight+1; q++){
                if(P_tmp[i].farr[q]==0){continue;}
                else{
                    ret->farr[q] += P_tmp[i].farr[q];
                }
            }
        }
    }
    
}

void div_Poly(Polynomial A, Polynomial B, Polynomial *ret1, Polynomial *ret2){//ret1 = 몫 ret2 = 나머지
    //큰 수에서 작은 수 나누는 거랑
    //작은 수에서 큰 수 나누는 경우 생각해야 함
}


void print_Polynomial(Polynomial _in){
    for (int i = 0; i < _in.hight ; i++){
        if(i==0 && _in.farr[0]==0){continue;}

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

int main(){
    Polynomial A = {5, {3, 6, 0, 0, 0, 10}};
    // Polynomial B = {4, {7, 0, 5, 0, 1}};

    // Polynomial A = {4, {7, 0, 5, 0, 1}};
    // Polynomial B = {5, {3, 6, 0, 0, 0, 10}};

    // Polynomial A = {1, {1,1}};
    Polynomial B = {1, {1,-1}};

    Polynomial ret;

    
    cout << "A :";
    print_Polynomial(A);
    cout<< "B :";
    print_Polynomial(B);

    mult_Poly(A, B, &ret);
    cout << "곱하기 결과 : ";
    print_Polynomial(ret);

    // sub_Poly(A, B, &ret);
    // cout << "빼기 결과 : ";
    // print_Polynomial(ret);

    return 0;
}