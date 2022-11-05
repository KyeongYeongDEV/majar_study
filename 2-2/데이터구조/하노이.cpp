#include<iostream>
using namespace std;

void hanoi_tower(int n, char from, char tmp, char to){
    if(n ==1) cout << "원판 1을 "<<from <<"에서"  << to<<"으로 옮긴다."<<endl;
    else{
        hanoi_tower(n-1,from,to,tmp);
        cout << "원판 "<<n<<"을 " << from<< "에서" <<to<< "으로 옮긴다."<<endl;
        hanoi_tower(n-1,tmp,from,to);
    }
}

int main(){
    hanoi_tower(4,'A','B','C');
    return 0;
}