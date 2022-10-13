#include<iostream>
using namespace std;

struct Stack{
    int top;
    int size;
    int *arr;
};

// 스택
Stack create(int size){
    Stack s;
    s.arr = (int*)malloc(sizeof(int) * size);
    s.size = size;
    s.top=0;
    return s;
}

bool is_full(Stack *s){
    if(s->top == s->size) {return true;}
    else{return false;}
}

bool is_empty(Stack *s){
    if(s->top == 0){return true;}
    else{return false;}
}

void push(Stack *s, int item){
    if(::is_full(s)){
        cout<< "ERROR_STACKFULL\n";
    }
    else{
        s->arr[s->top++] = item;    
    }    
}

int pop(Stack *s){
    if(::is_empty(s)){
        cout<< "ERROR_STACKEMPTY\n";
        
    }
    else{
        s->top--;
        int tmp = s->arr[s->top];
        
        return tmp;
    }
}

int peek(Stack s){
    if(::is_empty(&s)){
        cout<< "ERROR_STACKEMPTY\n";
        return 0;
    }
    else{
        return s.arr[s.top-1];
    }
}

// 큐 -----------------------------------------

void init(Stack *s){
    for(int i=0; i < s->top; s++){
        s->arr[i] = 0;
    }
    s->top =0;
    cout << "init"<<endl;
}

void enqueue(Stack *s, int e){
    if(is_full(s)){
        cout <<"ERROR_QUEUEFULL"<<endl;
    }
    else{ 
        s->arr[s->top++] = e;
    }
}

int dequeque(Stack *s){
    if(::is_empty(s)){
        cout <<"ERROR_QUEUEEMPTY"<<endl;
        return 0;
    }
    else{
        int tmp = s->arr[0];
        int arr[s->top];

        for(int i=0; i < s->top-1; i++){
            arr[i] = s->arr[i+1];
        }
       
        for(int i=0; i< s->top; i++){
            s->arr[i] = arr[i];
        }

        s->top--;

        return tmp;
    }
}

int peek2(Stack *s){
    if(::is_empty(s)){
          cout <<"ERROR_QUEUEEMPTY"<<endl;
          return 0;
    }
    else{
        return s->arr[0];
    }
}

void printQueue(Stack *s){
    cout << "현재 큐 원소 모두 출력" <<endl;
    for(int i=0; i <s->top; i++){
        cout << s->arr[i] <<endl;
    }
}

/*
3번 문제
단점
1. 배열을 사용하기 때문에 저장공간의 낭비가 생깁니다.
2. 원형 큐를 구현할 수 없습니다

해결법
양뱡향 링키드 리스트를 이용하여 구현하면 위의 문제점들이 해결이 됩니다.


*/

int main(){
    //스택 예시

    Stack s = create(2);

    cout <<"pop :"<<pop(&s) <<endl;
    push(&s,6);
    push(&s,5);
    push(&s,4);
    
    cout <<"peek :"<<peek(s) <<endl;

    cout <<"pop :"<<pop(&s) <<endl;
    cout <<"pop :"<<pop(&s) <<endl;


    //큐 예시
    Stack q = create(2);

    enqueue(&q,10);
    enqueue(&q,9);
    enqueue(&q,8);

    cout<< "peek2 :"<< peek2(&q)<<endl;
    cout <<"dequeque :"<< dequeque(&q)<<endl;
    cout <<"dequeque :"<< dequeque(&q)<<endl;


    init(&s);
    enqueue(&s,8);
    enqueue(&s,7);
    
    printQueue(&s);

    cout<< "peek2 :"<< peek2(&s)<<endl;
    cout <<"dequeque :"<< dequeque(&s)<<endl;
    cout <<"dequeque :"<< dequeque(&s)<<endl;

    return 0;  
}