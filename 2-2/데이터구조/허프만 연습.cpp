#include<iostream>
#include<fstream>

using namespace std;
#define MAX_ELEMENT 129

typedef struct{
    int key;
}element;

typedef struct{
    element heap[MAX_ELEMENT];
    int heapSize;
}HeapType;

struct Node{
    char ch; //문자
    int freq; //빈도
    Node *left, *right;
};

typedef struct { //바이너리
    char ch;
    string code;
}HCode;
HCode huffmanCode[128];

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

   // cout << h->heap[i].key << " ";
}
//min으로 할 거면 부등호 반대
element deleteMaxHeap(HeapType *h){
    int parent =1, child =2;
    //반환할 루트노드와 끌어올릴 말단노드
    element item = h->heap[1],
            temp = h->heap[(h->heapSize)--];
    int tmp  = --h->heapSize;
    // cout <<h->heap[tmp].key << " ";
    
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
    fstream in("ds.txt");
    string text;
    int freq[128]={0};

    HeapType *heap = create();
    init(heap);
    
    // if(in.fail()){cout<<"파일을 여는 데 실패했습니다.\n"; return 0;}

    // while(!in.eof()){
    //     getline(in,text);
    //     /* 이곳에서 각 문자의 빈도수를 저장할 것 */
    //     for(int i=0; i< text.length(); i++){
    //         freq[text[i]]++;
    //         //cout <<text[i];
    //     }
    //     freq['\n']++;
    // }
    // element e;
    // element t;
    // for(int i=0; i < 128;i++){
    //     if(freq[i]){
    //         e.key = freq[i];
    //         insertMaxHeap(heap,e);
    //     }
    // }

    // for(int i=1;i <=heap->heapSize; i++){
    //     t = deleteMaxHeap(heap);
    //     cout << "<"<<t.key <<">  ";
    // }
    
    element r={1};
    for(int i=1; i<=5; i++){
        
        insertMaxHeap(heap,r);
    }
    for(int i=1; i<=5; i++){
        r = deleteMaxHeap(heap);
        cout << r.key << "  "; 
    }

    // insertMaxHeap(heap,e1);
    // insertMaxHeap(heap,e2);
    // insertMaxHeap(heap,e3);
    // insertMaxHeap(heap,e4);
    // insertMaxHeap(heap,e5);
    // for(int i=1; i<= 5; i++){
    //     printf("%d ",heap->heap[i].key);
    // }
    // e = deleteMaxHeap(heap);
	// printf("\n< %d > ", e.key);
    // e = deleteMaxHeap(heap);
	// printf("< %d > ", e.key);
    // e = deleteMaxHeap(heap);
	// printf("< %d > ", e.key);
    // e = deleteMaxHeap(heap);
	// printf("< %d > ", e.key);
    // e = deleteMaxHeap(heap);
	// printf("< %d > ", e.key);

    in.close();
	free(heap);
	return 0;
}
