#include<iostream>
using namespace std;

class ArrayUtillty{
public:
    static int* concat(int s1[], int s2[], int size); //두 개 연결한 새로운 객체 도석 생성 및 포인트 리ㅎ턴

    static int* remove(int s1[], int s2[], int size, int& retsize); //1에서 2에 있는 걸 삭제한 새로운 배열 동적 생성
    //크기는 retsizedp wjsekf retsize가 0인 ruddn NULL리턴
};
int* ArrayUtillty::concat(int s1[], int s2[], int size){
    int cnt=0, *tmp;
    tmp = new int[size*2];
    
    for(int i=0; i< size; i++){
        tmp[cnt++] = s1[i];
    }
    for(int i=0; i< size; i++){
        tmp[cnt++] = s2[i];
    }

    int *tmp2 = new int[cnt-1];

    for(int i = 0; i < cnt; i++){
        tmp2[i]= tmp[i];
    }
    delete[] tmp;

    return tmp2;
}

int* ArrayUtillty::remove(int s1[], int s2[], int size, int& retsize){
    int *tmp = new int[size];
    int cnt =0;
    bool check = false;

    for(int i = 0; i < size; i++){
        for(int j =0; j <size; j++){
            if (s1[i] == s2[j]){
                check = true;
                break;
            }
        }
        if(check != true){
            tmp[cnt++] = s1[i]; 
        }
        check = false;       
    }
    
    int *tmp2 = new int [cnt-1];
    for(int i=0; i < cnt; i++){
        tmp2[i] = tmp[i];
    }

    delete[] tmp;
    retsize = cnt;

    return tmp2;
}

int main(){
    int x[5],y[5],size =5,retsize=0;

    cout <<"정수 5개를 입력하라. 배열 x에 삽입한다.";
    for(int i =0; i < 5; i++){
        cin >> x[i];
    }

    cout <<"정수 5개를 입력하라. 배열 y에 삽입한다.";
    for(int i =0; i < 5; i++){
        cin >> y[i];
    }
    int * con_tmp = ArrayUtillty::concat(x,y,size);
    cout <<"합친 정수 배열을 출력한다."<<endl;
    for(int i=0; i < size*2; i++){
        cout << con_tmp[i]<<" ";
    }
    cout<<endl;

    int *re_tmp = ArrayUtillty::remove(x,y,size,retsize);
    
    cout << "배열 x[]에서 y[]를 뺀 결과를 출력한다. 개수는 "<< retsize<<endl;
    for(int i = 0; i < retsize; i++){
        cout << re_tmp[i] << " ";
    }


}