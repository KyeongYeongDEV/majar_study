#include<iostream>
#include<set>
using namespace std;

typedef struct Node{
    int data;
    struct Node *next;
    struct Node *prev; //사이클을 찾기 위해 추가
}Node;

bool Is_empty(Node *list){
    return (list == NULL);
}

bool is_full(Node *list){
    return 0;
}

Node* insert(Node *list, int pos,int item){ // pos 위치에 요소를 추가
    Node *tmp = (Node*)malloc(sizeof(Node));
    Node *find = list->next;
    tmp->data = item;
    tmp->next = NULL;
    tmp->prev = NULL;
    
    if(!Is_empty(list)){
        int cnt =1;
        while(cnt != pos-1){
            find = find->next;
            cnt++;
        }
        tmp->next = find->next;
        tmp->prev = find->next->prev;
        find->next->prev = tmp;
        find->next = tmp;
    }
    return list;
}


Node* insert_last(Node *list, int item){//맨 끝에 요소를 추가한다.
    Node *tmp = (Node*)malloc(sizeof(Node));
    tmp->data = item;

    if(Is_empty(list)){
        list = tmp;
        tmp->next = list;
        tmp->prev = list;
    }else{
        tmp->next = list->next;
        tmp->prev = list;
        list->next->prev = tmp;
        list->next = tmp;
        list = tmp;
    }
    return list;
}

Node* insert_first(Node *list, int item){//맨 처음에 요소를 추가한다.
    Node *tmp = (Node*)malloc(sizeof(Node));
    tmp->data = item;

    if(Is_empty(list)){ //첫 번째 요소가 없을 때
        list = tmp;
        tmp->next  = list;
        tmp->prev = list;
    }else{
        tmp->prev = list;
        tmp->next = list->next;
        list->next->prev = tmp;
        list->next = tmp;
    }
    return list;
}

Node* Delete(Node *list, int pos){//pos 위치의 요소를 제거한다.
    Node *tmp = list->next;
    int cnt =1;
    while(cnt != pos-1){
        tmp= tmp->next;
        cnt++;
    }
    tmp->next->prev = tmp->prev;
    tmp->prev->next = tmp->next;

    return list;
}

Node* clear(Node *list){//리스트의 모든 요소를 제거한다.
    list = NULL;
    return list;
}

int get_entry(Node *list, int pos){//pos위치의 요소를 반환한다.
    Node *head = list->next;
    int cnt=1;

    while(cnt != pos){
        head = head->next;
        cnt++;
    }

    return head->data;
}

int get_length(Node *list){//리스트의 길이를 구한다.
    int length=0;
    if(!Is_empty(list)){
        Node *head = list->next;
        length++;
        while(head != list){
            head = head->next;
            length++;
        }
    }
    
    return length;
}



void print_list(Node *list){ //리스트의 모든 요소 출력
    if(!Is_empty(list)){ 
        Node *head = list->next;
        cout<<"Linked List : ";
        while(head != list){
            cout<< head->data<<" -> ";
            head = head->next;
        }
        cout << head->data<<" -> " <<endl;
    }else{
        cout<<"List is empty"<<endl;
    }
    
}

int hasCycle(Node *list){
    if(list->data == list->prev->data) return 1;

    Node *head = list; 
    int arr[get_length(list)];
    int cnt=0;
    do{
        if(cnt != 0){
            for(int i=0; i< cnt; i++){
                if(head->data == arr[i]) return 1;
            }
        }
        arr[cnt++] = head->data;
        head = head->next;
    }while(head != list);

    return 0;
}

int main(){
    Node *tail = NULL;

    tail =insert_last(tail,20);
    
    tail =insert_first(tail,10);
    tail =insert_last(tail,30);

    tail = insert(tail,2,25);
    print_list(tail);
    cout <<"현재 리스트 길이 >> " << get_length(tail)<<endl;

    cout << "2번째값 >> " << get_entry(tail,2)<<endl;

    if(hasCycle(tail)){
        cout<<"Cycle!!"<<endl;
    }else{
        cout << "No Cycle!!"<<endl;
    }
    
    tail = Delete(tail,2);
    print_list(tail);

    tail = clear(tail);
    print_list(tail);
    cout <<"현재 리스트 길이 >> " << get_length(tail)<<endl;

    tail = clear(tail);
    tail =insert_last(tail,10);
    tail =insert_last(tail,20);
    tail =insert_last(tail,30);
    tail =insert_last(tail,40);
    if(hasCycle(tail)){
        cout<<"Cycle!!"<<endl;
    }else{
        cout << "No Cycle!!"<<endl;
    }

    tail = clear(tail);
    tail =insert_last(tail,10);
    tail =insert_last(tail,20);
    tail =insert_last(tail,30);
    tail =insert_last(tail,40);
    tail =insert_last(tail,20);
    if(hasCycle(tail)){
        cout<<"Cycle!!"<<endl;
    }else{
        cout << "No Cycle!!"<<endl;
    }

    return 0;
}