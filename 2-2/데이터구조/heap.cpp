#include<iostream>
using namespace std;
#define MAX_ELEMENT 20

typedef struct{
    int key;
}element;

typedef struct{
    element heap[MAX_ELEMENT];
    int heap_size; //heap 안 저장된 요소의 개수
}HeapType;

HeapType *create(){
    return (HeapType*)malloc(sizeof(HeapType));
}

void init(HeapType *h){
    h->heap_size = 0;
}

void insertMaxHeap(HeapType *h, element item){ //Max Heap은 root노드가 값이 젤 큼
    int i;

    //처음 넣는 거라면 i가 1이된다.
    i = ++(h->heap_size);

    //새로 넣으려는 노드의 부모노드 찾기
    //부모노드보다 내가 작거나 && 내가 root가 될 때까지 반복
    while(item.key > h->heap[i/2].key && (i != 1)){
        //내가 더 크면 부모노드 자리에 내가 올라감
        h->heap[i] = h->heap[i/2];
        //while 한 번 더 돌면 원래 부모였던 노드의, 보모노드 값 -> 
        //즉 할아버지할머니 노드 랑 나랑 비교하게 되는 것
        i = i/2;
    }
    h->heap[i] = item;
}

element deleteMaxHeap(HeapType *h){
    element item, temp;
    item = h->heap[1]; //루트
    temp = h->heap[h->heap_size]; //힙 배열의 마지막 값
    
    h->heap_size--; //전체 사이즈 줄이기
    
    int parent, child;
    parent = 1;
    child = 2;
    while(child <= h->heap_size){
        if((child < h->heap_size) && (h->heap[child].key < h->heap[child+1].key)) child++;
        if(temp.key >= h->heap[child].key) break;

        h->heap[parent] = h->heap[child];
        parent = child;
        child *= 2;
    }
    h->heap[parent] = temp;
    return item;
}

void heapSort(element a[], int n){
    int i;
    HeapType *h;
    h = create();
    init(h);

    //값을 히프에 넣고
    for(int i =0; i <n; i++){
        insertMaxHeap(h,a[i]);
    }

    //최대값부터 배열 뒤쪽에 넣는다
    for(int i=n-1; i >=0; i--){
        a[i] = deleteMaxHeap(h);
    }

    free(h);
}

int main(){
    /* 힙 예제 */
    element e1 = { 3 }, e2 = { 5 }, e3 = { 1 }, e4 = { 7 }, e5 = { 4 };
	element a1;
	HeapType* heap;

	heap = create();
	init(heap);

	insertMaxHeap(heap, e1);
	insertMaxHeap(heap, e2);
	insertMaxHeap(heap, e3);
	insertMaxHeap(heap, e4);
	insertMaxHeap(heap, e5);


	for (int k = 1; k <= heap->heap_size; k++)
		printf("%d ", heap->heap[k]);

	a1 = deleteMaxHeap(heap);
	printf("\n\nmax값 인출 %d\n\n", a1.key);
	for (int k = 1; k <= heap->heap_size; k++)
		printf("%d ", heap->heap[k]);

	free(heap);

    /* 정렬 예제*/
    cout<<endl;
    element list[5] = { 3, 5, 1, 7, 4 };
	heapSort(list, 5);

	for (int i = 0; i < 5; i++)
		printf("%3d", list[i].key);
} 