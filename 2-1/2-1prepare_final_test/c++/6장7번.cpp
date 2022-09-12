#include<iostream>
using namespace std;

class Random{
public:
    static void seed(){srand((unsigned)time(0));} //씨드설정
    static int nextInt(int min=0, int max = 32767);//min과 max 사이의 랜덤 정수 리턴
    static char nextAlphabet(); // 랜덤 알팟벳 문자 리턴
    static double nextDouble();//0보다 크거나 같고 1보다 작은 랜덤 실수 리턴
};


// int Random::nextInt(int min =0, int max = 32767){
//     return rand() % max + min;
// }

char Random::nextAlphabet(){
    int choice = rand() % 2;
    if(choice){
        return (char)(rand() % 26 + 65); //대문자
    } else{
        return (char)(rand() % 26 + 97); //소문자
    }
}

double Random::nextDouble(){
    return (double)rand() / (double)32767;
}

int main(){ //static은 객체생성을 하지 않아도 그냥 쓸 수 있다.
    int min = 1, max = 100, size = 10;
	Random::seed();//static은 객체생성을 하지 않아도 그냥 쓸 수 있다.
	cout << min << "에서 " << max << "까지 랜덤한 정수 " << size << "개를 출력합니다." << endl;
	for (int i = 0; i < size; i++)
		cout << Random::nextInt(min, max) << ' ';
	cout << endl;

	cout << "알파벳을 램덤하게 " << size << "개를 출력합니다." << endl;
	for (int i = 0; i < size; i++)
		cout << Random::nextAlphabet() << ' ';
	cout << endl;

	cout << "랜덤한 실수를 " << size << "개를 출력합니다." << endl;
	for (int i = 0; i < size; i++)
		cout << Random::nextDouble() << ' ';
	cout << endl;
}