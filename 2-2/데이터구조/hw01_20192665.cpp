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
    Polynomial P_tmp;

    ret1->hight = A.hight - B.hight;

    for(int i=0; i< 100; i++){
        ret1->farr[i] = 0;
        ret2->farr[i] = 0;
    }

    for(int i=0; i< B.hight; i++){
        int n_tmp=0;
         //몫 저장
        ret1->farr[(A.hight) -(B.hight)] += A.farr[i] / B.farr[0];

        
        for(int j=0; j < 100; j++){ //임시변수 초기화
            P_tmp.farr[i]= 0;
        }
        //B랑 ret1이랑 곱하기 tmp에 저장
        Polynomial mult_tmp[B.hight+1];
        for(int j =0; j < B.hight; j++){//임시변수 초기화
            for(int k =0; k < 100; k++){
                mult_tmp[j].farr[k]=0;
            }
        }
        for(int j =0; j <ret1->hight+1 ; j++){
            for(int q= 0; q< B.hight+1; q++){
                mult_tmp[n_tmp].farr[j+q] = ret1->farr[j] * B.farr[q];
            }
            mult_tmp[n_tmp].hight = ret1->hight + (B.hight -j);
            n_tmp++;
        }
       

---------------------------------------
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


        //A와 tmp를 더한다.
        A.hight = P_tmp.hight;
        int h_tmp = A.hight - P_tmp.hight;
        for(int j = h_tmp; j < P_tmp.hight+1; j++){
            A.farr[j] += P_tmp.farr[j];
        }
    }

    //끝나고 남은 A가 나머지값이다
    for(int i=0; i < 100; i++){ //ret2 초기화
            ret2->farr[i]= 0;
    }
    for(int i =0; i < A.hight; i++){
        ret2->farr[i] = A.farr[i];
    }
    ret2->hight = A.hight;
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

void print_div_Polynomial(Polynomial _in1, Polynomial _in2){//나누기 결과를 출력해주는 함수
    cout << "나머지 결과 :"<<endl;
    cout << "몫 :";
    for(int i=0 ; i < _in1.hight; i++){
        if( i ==0 && _in1.farr[i]){
            continue;
        }
        if(_in1.farr[i] == 0){
            cout << "0.0x^"<<_in1.hight - i;

            if(_in1.farr[i+1] < 0){ //음수이면
                continue; 
            }
            else{
              cout << '+';
            }
        }
        else{
            cout << _in1.farr[i]<<"x^"<<_in1.hight-i;
            if(_in2.farr[i+1] < 0){ //음수이면
                continue; 
             }
            else{
                cout << '+';
            }
        }
    }
    cout << _in1.farr[_in1.hight];
    cout<<endl;
    if(_in2.farr[0] != 0){
        cout << "나누기 :";
        for(int i=0; i < _in2.hight+1; i++){
            if(_in1.farr[i] == 0){
                cout << "0.0x^"<<_in1.hight - i;
            }
            else{
                cout << _in1.farr[i]<<"x^"<<_in1.hight-i;
            }
        }
    }
    
}

int main(){
    // Polynomial A = {5, {3, 6, 0, 0, 0, 10}};
    // Polynomial B = {4, {7, 0, 5, 0, 1}};

    // Polynomial A = {4, {7, 0, 5, 0, 1}};
    // Polynomial B = {5, {3, 6, 0, 0, 0, 10}};

    // Polynomial A = {1, {1,1}};
    // Polynomial B = {1, {1,-1}};

    Polynomial A = {2, {1,0,-1}};
    Polynomial B = {1, {1,1}};


    Polynomial ret;
    Polynomial ret1;//몫
    Polynomial ret2;//나머지
    
    cout << "A :";
    print_Polynomial(A);
    cout<< "B :";
    print_Polynomial(B);
    
    add_Poly(A, B, &ret);
    cout << "더하기 결과 : ";
    print_Polynomial(ret);

    sub_Poly(A, B, &ret);
    cout << "빼기 결과 : ";
    print_Polynomial(ret);

    mult_Poly(A, B, &ret);
    cout << "곱하기 결과 : ";
    print_Polynomial(ret);

    div_Poly(A, B, &ret1, &ret2);
    print_div_Polynomial(ret1,ret2); // 프린트도 새로 만들기




    return 0;
}