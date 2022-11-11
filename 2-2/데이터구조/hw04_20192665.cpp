#include<iostream>
using namespace std;
#define MAX_ELEMENT 200

typedef struct{
    int key;
}element;

typedef struct{
    element heap[MAX_ELEMENT];
    int heapSize;
}HeapType;
//생성함수
HeapType* create(){
    return (HeapType*)malloc(sizeof(HeapType));
}
//초기화 함수
void init(HeapType *h){
    h->heapSize=0;
}

//현재 요소의 개수가 heapSize인 히프 h에 item 삽입
//삽입함수
void insertMaxHeap(HeapType *h, element item){
    int i = ++(h->heapSize);

    while((i!=1) && (item.key > h->heap[i/2].key)){
        h->heap[i/2] = h->heap[i];
        i /= 2;
    }
    h->heap[i] = item;
}
//min으로 할 거면 부등호 반대
element deleteMaxHeap(HeapType *h){
    int parent =1, child =2;
    //반환할 루트노드와 끌어올릴 말단노드
    element item = h->heap[1],
            temp = h->heap[(h->heapSize)--];
    
    while(child <= h->heapSize){
        //자식 노드 중 더 큰 노드 찾기
        if(child < h->heapSize && (h->heap[child].key < h->heap[child+1].key)){ //값이 작은 노드를 위로 올려하기때문
            child++;
        }
        //temp가 자식보다 작거나 같다면
        if(temp.key >= h->heap[child].key) break;
        //스왑하고 레벨 하나 내리기
        h->heap[parent] = h->heap[child];
        parent = child;
        child *=2;
    }
    h->heap[parent] = temp;
    return item;
}

int main(){
    element e1={5}, e2={4}, e3={3},e4={2},e5={1};
    element e;

    HeapType *heap;

    heap = create();
    init(heap);

    insertMaxHeap(heap,e1);
    insertMaxHeap(heap,e2);
    insertMaxHeap(heap,e3);
    insertMaxHeap(heap,e4);
    insertMaxHeap(heap,e5);

    for(int i=1; i<= 5; i++){
        printf("%d ",heap->heap[i].key);
    }
    printf("\n");

    e = deleteMaxHeap(heap);
	printf("< %d > ", e.key);
	e = deleteMaxHeap(heap);
	printf("< %d > ", e.key);
	e = deleteMaxHeap(heap);
	printf("< %d > ", e.key);
    e = deleteMaxHeap(heap);
	printf("< %d > ", e.key);
    e = deleteMaxHeap(heap);
	printf("< %d > \n", e.key);

	free(heap);
	return 0;

}
