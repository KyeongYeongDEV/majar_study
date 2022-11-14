#include<iostream>
#include<fstream>
using namespace std;
#define MAX_ELEMENT 128

struct element{
    char ch;
	int key;
} ;

typedef struct {
	element *heap;
	int heapSize;
} HeapType;
// 생성 함수
HeapType* create(){
	return (HeapType*)malloc(sizeof(HeapType));
}
// 초기화 함수
void init(HeapType* h){
	h->heapSize = 0;
    h->heap = NULL;
}
// 삽입 함수
// 현재 요소의 개수가 heap_size인 히프 h에 item을 삽입한다.
void insertMinHeap(HeapType* h, element item){
	int i= ++(h->heapSize);

	//  트리를 거슬러 올라가면서 부모 노드와 비교하는 과정
	while ((i != 1) && (item.key < h->heap[i / 2].key)) {
		h->heap[i] = h->heap[i / 2];
		i /= 2;
	}
	h->heap[i] = item;     // 새로운 노드를 삽입
}


// 삭제 함수
element deleteMinHeap(HeapType* h){
	int parent=1, child=2;
	element item = h->heap[1], //루트노드
            temp = h->heap[(h->heapSize)--]; //말단노드

	while (child <= h->heapSize) {
		// 현재 노드의 자식노드 중 더 작은 자식노드를 찾는다.
		if ((h->heap[parent * 2].key >= 0) && (h->heap[(parent * 2) + 1].key >= 0)) {
            if ((h->heap[parent * 2].key) < (h->heap[(parent * 2) + 1].key))
                child = parent * 2;
            else
                child = (parent * 2) + 1;
        }
		if (temp.key <= h->heap[child].key) break;
		// 한 단계 아래로 이동
		h->heap[parent] = h->heap[child];
		parent = child;
		child *= 2;
	}
	h->heap[parent] = temp;
	return item;
}


int main(){
    fstream in("ds.txt");
    string text;
    element freq[128]={0,' ',NULL,NULL};
    HeapType *heap = create();
    init(heap);
    
    if(in.fail()){cout<<"파일을 여는 데 실패했습니다.\n"; return 0;}
    while(!in.eof()){
        getline(in,text);
        /* 이곳에서 각 문자의 빈도수를 저장할 것 */
        for(int i=0; i< text.length(); i++){
            freq[text[i]].key++;
        }
        freq['\n'].key++;
    }
    //빈도수와 문자 저장
    element e={0,' '};
    for(int i=0; i < 128;i++){
        if(freq[i].key){
            e.key = freq[i].key;
            e.ch = i;
            insertMinHeap(heap,e);
            // cout << heap->heap[heap->heapSize].key<< " ";
        }
    }
    
    int HSize = heap->heapSize;

    //허프만 트리 만들기
    //makeHuffmanTree(heap);
    

    // element e;
    // for(int i=5; i>= 1; i--){
    //     e.key=i;
    //     e.ch = 'd';
    //     insertMinHeap(heap,e);
    // }
    // for(int i =1; i<=5; i++){
    //     e = deleteMinHeap(heap);
    //     cout << e.key<< " "<< e.ch<< " / " ;
    // }

    in.close();
	free(heap);
	return 0;
}
