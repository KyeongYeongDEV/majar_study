#include<iostream>
using namespace std;

struct Stack{
    int top;
    int size;
    int max_size;
    int *arr;
};

Stack create(int max_size){
    Stack q;
    q.arr = (int*)malloc(sizeof(int) * max_size);
    q.max_size = max_size;
    q.size=0;
    q.top =0;
    return q;
}

void init(Stack *q){
    for(int i=0; i < q->size; q++){
        q->arr[i] = 0;
    }
    q->size =0;
    q->top=0;
    cout << "init"<<endl;
}

bool is_empty(Stack *q){
    if(q->size == -1){return true;}
    else{return false;}
}
 
bool is_full(Stack *q){
    if(q->size == q->max_size) {return true;}
    else{return false;}
}

void enqueue(Stack *q, int e){
    if(is_full(q)){
        cout <<"ERROR_QUEUEFULL"<<endl;
    }
    else{ 
        q->arr[q->size++] = e;
    }
}

int dequeque(Stack *q){
    if(::is_empty(q)){
        cout <<"1ERROR_QUEUEEMPTY"<<endl;
        return 0;
    }
    else{
        q->size--;
        int tmp = q->arr[q->top];
        q->top++;
        if(q->top == q->size){}

        return tmp;
    }
}

int peek(Stack *q){
    if(::is_empty(q)){
          cout <<"2ERROR_QUEUEEMPTY"<<endl;
          return 0;
    }
    else{
        
        return q->arr[0];
    }
}

int main(){
    Stack q = create(2);

    enqueue(&q,10);
    enqueue(&q,9);
    enqueue(&q,8);

    cout<< "peek :"<< peek(&q)<<endl;
    cout <<"dequeque :"<< dequeque(&q)<<endl;
    cout <<"dequeque :"<< dequeque(&q)<<endl;
    cout <<"dequeque :"<< dequeque(&q)<<endl;


    init(&q);
    enqueue(&q,8);
    enqueue(&q,7);

    cout<< "peek :"<< peek(&q)<<endl;
    cout <<"dequeque :"<< dequeque(&q)<<endl;
    cout <<"dequeque :"<< dequeque(&q)<<endl;

    return 0;  
}