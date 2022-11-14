#include<iostream>
#include<fstream>
using namespace std;
#define MAXSIZE 129

typedef struct{
    char first;
    int second;
}map;

struct Node{
    map heap[MAXSIZE];
    int heapSize; //1부터 시작 (루트노드)
};

struct HNode{
    int freq;
    char ch;
    map left, right;
};int Hsize = 0;

//생성함수
Node* create(){
    Node *newnode = (Node*)malloc(sizeof(Node));
    newnode->heapSize =0;
    return newnode;
}

void insertMinHeap(Node* h, map item){
	int i= ++(h->heapSize);

	//  트리를 거슬러 올라가면서 부모 노드와 비교하는 과정
	while ((i != 1) && (item.second < h->heap[i / 2].second)) {
		h->heap[i] = h->heap[i / 2];
		i /= 2;
	}
	h->heap[i] = item;     // 새로운 노드를 삽입
}

map deleteMinHeap(Node* h){
	int parent=1, child=2;
	map item = h->heap[1], //루트노드
            temp = h->heap[(h->heapSize)--]; //말단노드

	while (child <= h->heapSize) {
		// 현재 노드의 자식노드 중 더 작은 자식노드를 찾는다.
		if ((h->heap[parent * 2].second >= 0) && (h->heap[(parent * 2) + 1].second >= 0)) {
            if ((h->heap[parent * 2].second) < (h->heap[(parent * 2) + 1].second))
                child = parent * 2;
            else
                child = (parent * 2) + 1;
        }
		if (temp.second <= h->heap[child].second) break;
		// 한 단계 아래로 이동
		h->heap[parent] = h->heap[child];
		parent = child;
		child *= 2;
	}
	h->heap[parent] = temp;
	return item;
}

void huffmanInsertMaxHeap(HNode *huffmanTree, HNode item){
    int i = ++Hsize;

    while((i !=1) && (item.freq > huffmanTree[i /2 ].freq)){
        huffmanTree[i] = huffmanTree[i/2];
        i /= 2;
    }
    huffmanTree[i] = item;
}

void makeHTree(Node *h, HNode *huffmanTree){
    map m1 = deleteMinHeap(h);
    HNode item;
    if(h->heapSize >=1){
        //작은 거 두 개 빼주고
        map m2 = deleteMinHeap(h);
        //새로운 노드에 넣어준다.
        item.freq = m1.second + m2.second; //빈도수 합
        item.left = m1; //좌
        item.right= m2; //우
        huffmanInsertMaxHeap(huffmanTree,item);
    }else{
        item.freq = m1.second;
        item.left = m1;
        huffmanInsertMaxHeap(huffmanTree,item);
    }
}

int main(){
    fstream in("ds.txt");
    string text;
    int freq[128]= {0};
    Node *heap =(Node*)malloc(sizeof(Node));
    heap->heapSize=0;

    
    if(in.fail()){cout<<"파일을 여는 데 실패했습니다.\n"; return 0;}
    while(!in.eof()){
        getline(in,text);
        /* 이곳에서 각 문자의 빈도수를 저장할 것 */
        for(int i=0; i< text.length(); i++){
            freq[text[i]]++;
        }
        freq['\n']++;
    }
    map m = {'\0',0};
    for(int i=0; i < 128; i++){
        if(freq[i]){
            m.first = i;
            m.second= freq[i];
            insertMinHeap(heap,m);
        }
    }
    
    //빈도수 힙 확인
    int Hsize = heap->heapSize;
    // for(int i=1; i <=Hsize; i++){
    //     map m = deleteMinHeap(heap);
    //     cout << m.first << " - "<< m.second << "  "; 
    // }

    //허프만 트리 만들기
    HNode huffmanTree[heap->heapSize];
    while(heap->heapSize){
        makeHTree(heap,huffmanTree);
    }
    cout << Hsize;
    // cout<< huffmanTree[1].freq<< "  ";
}