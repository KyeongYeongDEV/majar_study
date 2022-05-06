#include<iostream>
using namespace std;

class SortedArray{
    private: 
    int size;//현재 배열의 크기
    int *p;//정수 배열에 대한 포인터
    void sort();//정수 배열을 오름차순으로 정렬

    public:
    SortedArray();
    SortedArray(SortedArray& src);//복사생성자
    SortedArray(int p[],int size);//생성자, 정수 배열과 크기를 전달받음
    ~SortedArray();//소멸자
    SortedArray operator+(SortedArray& op2); //현재 배열에 op2 배열 추가
    SortedArray& operator=(const SortedArray& op2); //배열의 원소 출력
};




int main(){
    int n[] = {2,10,6};
    int m[] = {10,7,8,30};
    SortedArray a(n,3), b(m,4),c;   

    c = a +b;

    a.show(); b.show(0); c.show();
}