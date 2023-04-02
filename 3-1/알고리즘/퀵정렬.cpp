#include<iostream>
using namespace std;

void print(int data[], int size){
    for(int i=0; i < size; i++){
        cout << data[i] << " ";
    }
}

void quickSort(int data[], int start, int end){
    if(start >= end) return;

    int key = start; //피봇
    int i = start +1, j = end, temp; 

    while(i <= j){ //엇갈릴 때까지 반복
        while(i <= end && data[i] <= data[key]){ // 키 값보다 큰 값을 만날 때까지
            i++;
        }
        while(j > start && data[j] >= data[key]){ // 키 값보다 작은 값을 만날 때까지
            j--; 
        }

        if(i > j){// 현재 엇갈린 상태면 키 값과 교체
        // 엇갈렷다는 말은 탐색을 마쳤다는 말이다
            temp = data[j];
            data[j] = data[key];
            data[key] = temp;
        }else{
            temp = data[i];
            data[i] =data[j];
            data[j] = data[i];
        }
    }

    quickSort(data, start, j -1);
    quickSort(data, j+1, end);

}

int main(){
    int size = 10;
    int data[10] = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

    quickSort(data, 0, size-1);
    print(data, size);
}