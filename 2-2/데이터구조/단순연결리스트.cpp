#include<iostream>
using namespace std;

struct Node{
    int data;
    struct Node *link;
};

Node* insert_first(Node *head, int data){ //리스트의 시작 부분에 항목을 삽입하는 함수
    Node *tmp = (Node*)malloc(sizeof(Node));

    tmp->data = data;
    tmp->link = head;

    head = tmp;


    return head;
}


Node* delete_first(Node *head){
    Node *tmp = head;
    head = head->link;
    free(tmp);

    return head;
}


void print_list(Node *head){
    Node *tmp = head;
    while ( tmp != NULL){
        cout  <<tmp->data<< ">>";
        tmp = tmp->link;
    }
    cout << "NULL\n";
}

int main(){
    Node *head  = NULL;

    for(int i=0; i < 5; i++){
        head = insert_first(head, i);
        print_list(head);
    }

    for(int i=0; i <5; i++){
        head = delete_first(head);
        print_list(head);
    }

    return 0;
}