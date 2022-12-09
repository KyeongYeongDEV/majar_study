#include<iostream>
#define MAX_HASH 10
#define HASH_KEY(key) key%MAX_HASH

using namespace std;

typedef struct Node{
    int id;
    Node* hashNext;
}Node;

Node* hashTable[MAX_HASH];

void  AddHashData(int key, Node* node){
    int hash_key = HASH_KEY(key);
    if (hashTable[hash_key] == NULL){
        hashTable[hash_key] = node;
    }
    else{
        node->hashNext = hashTable[hash_key];
        hashTable[hash_key] = node;
    }
}

void DelHashData(int id){
    int hash_key = HASH_KEY(id);
    if (hashTable[hash_key] == NULL)
        return;

    Node* delNode = NULL;
    if (hashTable[hash_key]->id == id){
        delNode = hashTable[hash_key];
        hashTable[hash_key] = hashTable[hash_key]->hashNext;
    }
    else{
        Node* node = hashTable[hash_key];
        Node* next = node->hashNext;
        while (next){
            if (next->id == id){
                node->hashNext = next->hashNext;
                delNode = next;
                break;
            }
            node = next;
            next = node->hashNext; 
        }
    }
    free(delNode); 
}

Node* SearchHashData(int id){
    int hash_key = HASH_KEY(id);
    if (hashTable[hash_key] == NULL)
        return NULL;

    if (hashTable[hash_key]->id == id){
        return hashTable[hash_key];
    }
    else{
        Node* node = hashTable[hash_key];
        while (node->hashNext){
            if (node->hashNext->id == id){
                return node->hashNext;
            }
            node = node->hashNext;
        }
    }
    return  NULL;
}

void PrintAllHashData(){
    for (int i = 0; i < MAX_HASH; i++){
        cout << "idx:" << i+1 << endl;
        if (hashTable[i] != NULL){
            Node* node = hashTable[i];
            while (node->hashNext){
                cout << node->id << " ";
                node = node->hashNext;
            }
            cout << node->id << endl;
        }
    }
    cout << endl << endl;;
}


int main(){
    
    int scoreIdx[11][5]={
        {95,78,23,89,23},
        {79,100,24,88,99},
        {24,82,21,79,23},
        {77,33,87,35,67},
        {80,78,86,54,23},
        {10,68,87,24,88},
        {57,98,54,89,19},
        {33,12,84,12,90},
        {98,87,88,99,30},
        {35,55,54,24,54},
        {28,85,100,80,86}
    };

    int saveidx[89] = { 0, };
    for (int i = 0; i < 11; i++){
        for(int j =0; j < 5; j++){
            Node* node = (Node*)malloc(sizeof(Node));
            node->id = scoreIdx[i][j];
            node->hashNext = NULL;
            AddHashData(node->id, node);
            saveidx[i] = node->id;
        }  
    }
    PrintAllHashData();

    //다 지우기
    for (int i = 0; i < 89 *2 ; i++)
    {
        DelHashData(saveidx[i]);
    }
    PrintAllHashData();

    
    return 0;
}
