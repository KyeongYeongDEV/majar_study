#include<iostream>
using namespace std;

class Stack{
private:
    int size; // 최대 크기
    int *arr; //원소들을 저장
    int top; //현재 젤 높은 위치를 알려줌

public:
    Stack(int size){
        this->size = size;
        arr = (int*)malloc(sizeof(int) * size); //배열의 최대크기를 지정해 준다.
        top =0;
    }

    void create(size)
};

//구조체로 해야 할 듯
