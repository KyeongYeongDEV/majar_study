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

typedef struct {
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
// typedef struct{
//     Node *data;
// }Vector;

// Vector *vector;
// int vecSize=0;
// void vecPushBack(Node *n){
//     vector[vecSize++] = (Vector*)malloc(sizeof(Vector));
//     vector[vecSize++] = n;
// }

typedef struct{
    Node *data;

}priorityQueue;
priorityQueue *pq;


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



Node* getNode(char ch, int freq, Node *left, Node *right){
    Node *newNode = (Node*)malloc(sizeof(Node));

    newNode->ch = ch;
    newNode->freq;
    newNode->left = left;
    newNode->right = right;

    return newNode;
}

typedef struct{
    char first;
    int second;
}Map;

bool comp(Node *l, Node *r){//힙 만들 때 사용할 비교
    return l->freq > r->freq;
}

bool isLeaf(Node *root){//루트에 자식이 없다면 참
    return root->left == nullptr && root->right == nullptr;
}
//허프만 트리 탐색 후 허프만코드 저장
void encode(Node *root, string str){
    if(root == nullptr){
        return;
    }
    //리프를 찾으면
    if(isLeaf(root)){
        huffmanCode[root->ch].code = (str != "") ? str:"1";
    }
    //재귀를 이용해 인코딩
    encode(root->left, str+"0");
    encode(root->right, str+"1");
}
//허프만 트리 탐색 후 인코딩된 문자열을 디코딩
void decode(Node *root, int &index, string str){
    if(root == nullptr){return ;}
    //리프노드를 찾으면
    if(isLeaf(root)){
        cout << root->ch;
        return;
    }
    index++;

    if(str[index]=='0'){
        decode(root->left, index,str);
    }else{  
        decode(root->right, index,str);
    }
}
//인코딩 및 디코딩 같이
void buildHuffmanTree(string text){
    //빈문자열
    if(text == " "){return;}
    //각 문자의 출현 빈도 계산
    //맵역할을 하는 구조체에 저장
    Map *freq;
    int textSize = 0; //불러온 문자열의 사이즈를 저장
    
    for(char ch : text)
        freq[ch].second++;
        textSize++;

    //허프만 트리의 라이브 노드를 저장할 우선 순위 대기열 만들기
    
}


int main(){
    fstream in("ds.txt");
    string text;
    
    if(in.fail()){cout<<"파일을 여는 데 실패했습니다.\n"; return 0;}

    while(!in.eof()){
        getline(in,text);
        cout << "입력한 문장의 길이:" << text.length() << endl;
		cout << "입력한 문장의 첫번째 문자:" << text[0] << endl;
        /* 이곳에서 각 문자의 빈도수를 저장할 것 */

    }

    element e1={5}, e2={4}, e3={3},e4={2},e5={1};
    element e;

    HeapType *heap;

    heap = create();
    init(heap);

    

    // insertMaxHeap(heap,e1);

    // for(int i=1; i<= 5; i++){
    //     printf("%d ",heap->heap[i].key);
    // }
    // e = deleteMaxHeap(heap);
	// printf("< %d > \n", e.key);
    in.close();
	free(heap);
	return 0;
}
