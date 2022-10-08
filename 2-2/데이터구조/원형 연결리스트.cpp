#include<iostream>
using namespace std;

typedef int element;
struct Node{
    element data;
    struct Node *link;
};

Node* insert_last(Node *head, element data){
    Node *tmp = (Node*)malloc(sizeof(Node));
    tmp->data = data;

    if(head == NULL){
        head= tmp;
    }
    else{
        Node *horse = head->link;

        while(horse != NULL){
            horse = horse->link;
        }
        
        horse = tmp;
        head = horse;
    }
    return head;
}


Node* insert_first(Node *head, int data){ //리스트의 시작 부분에 항목을 삽입하는 함수
    Node *tmp = (Node*)malloc(sizeof(Node));
    tmp->data = data;

    if(head == NULL){
        head = tmp;
        head->link = head;
    }
    else{
        tmp->link = head->link;
        head->link = tmp;
    }

    return head;
}

void print_list(Node *head){
    Node *tmp = head;

    if(tmp == NULL){
        cout << "NULL";
    }
    else{
        cout << tmp->data<< "-> ";
        tmp = tmp->link;
        while(tmp != head){
            cout << tmp->data<< "-> ";
            tmp = tmp->link;
        }   
    }
    
    cout<<endl;
}

int main(){
    Node *head = NULL;

    // head = insert_last(head, 20);
    // head = insert_last(head, 30);
    // head = insert_last(head, 40);
    head = insert_first(head, 10);
    head = insert_first(head, 20);
    head = insert_first(head, 30);

    print_list(head);
}