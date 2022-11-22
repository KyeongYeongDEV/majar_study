#include<iostream>
#include<fstream>
using namespace std;
#define MAXSIZE 129

struct Node{
    int freq;
    char ch;
    Node *left,*right;
};
int Hsize = 0;

void insertMinHeap(Node *node, Node item){
    int i= ++Hsize;

	//  트리를 거슬러 올라가면서 부모 노드와 비교하는 과정
	while ((i != 1) && (item.freq < node[i / 2].freq)) {
		node[i] = node[i / 2];
		i /= 2;
	}
    
	node[i].ch = item.ch;
    node[i].freq = item.freq;
}

Node* deleteMinHeap(Node *node){
    int parent=1, child=2;
	Node *item = (Node*)malloc(sizeof(Node)); //루트노드
    item->ch= node[1].ch;
    item->freq=node[1].freq;
    Node temp = node[Hsize--]; //말단노드
    
    while(child <= Hsize){
        // 현재 노드의 자식노드 중 더 작은 자식노드를 찾는다.
		if ((node[parent * 2].freq >= 0) && (node[(parent * 2) + 1].freq >= 0)) {
            if ((node[parent * 2].freq) < (node[(parent * 2) + 1].freq))
                child = parent * 2;
            else
                child = (parent * 2) + 1;
        }
        if (temp.freq <= node[child].freq) break;
        // 한 단계 아래로 이동
		node[parent] = node[child];
		parent = child;
		child *= 2;
    }
    node[parent] = temp;
    return item;
}

void insertMaxHeap(Node *node, Node *item){
    int i= ++Hsize;

	//  트리를 거슬러 올라가면서 부모 노드와 비교하는 과정
	while ((i != 1) && (item->freq > node[i / 2].freq)) {
		node[i] = node[i / 2];
		i /= 2;
	}
    
	node[i].ch = item->ch;
    node[i].freq = item->freq;
}

void makeHuffmanTree(Node *node){
    Node *item = (Node*)malloc(sizeof(Node));
    item->ch = '\0';

    while(Hsize !=2){
        Node *n1 = deleteMinHeap(node);
        if(Hsize == 1){
            item->freq = n1->freq;
            item->left = n1;
        }else{
            Node *n2 = deleteMinHeap(node);

            item->freq = n1->freq + n2->freq;
            item->left = n1;
            item->right = n2;
        }
        insertMaxHeap(node, item);
    }
}

void encoding(Node *node){
    // 문자 별로 레벨과 좌우에 따라 0 || 1 를 저장
    // 각 리프에 있는 문자의 0, 1값 저장하기
}

void decoding(Node *node){
    //저정되어 있는 0,1에 따른 문자를 계산

}

int main(){
    fstream in("ds.txt");
    string text;
    int freq[128]= {0};
    Node heap;
    Node node[MAXSIZE];
    Node huffmanTree[Hsize];

    if(in.fail()){cout<<"파일을 여는 데 실패했습니다.\n"; return 0;}
    while(!in.eof()){
        getline(in,text);
        /* 이곳에서 각 문자의 빈도수를 저장할 것 */
        for(int i=0; i< text.length(); i++){
            freq[text[i]]++;
        }
        freq['\n']++;
    }

    for(int i=0; i < 128;i++){
        if(freq[i]){
            heap.ch = i;
            heap.freq = freq[i];
            insertMinHeap(node, heap);
        }
    }
    makeHuffmanTree(node);

}