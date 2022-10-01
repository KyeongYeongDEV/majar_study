#include<iostream>
using namespace std;

struct Stack{
    int top; //큐에서는 사용 안함
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
    if(q->size == 0){return true;}
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
        cout <<"ERROR_QUEUEEMPTY"<<endl;
        return 0;
    }
    else{
        int tmp = q->arr[0];

        int arr[q->size];
        for(int i=0; i < q->size-1; i++){
            arr[i] = q->arr[i+1];
        }
       
        for(int i=0; i< q->size; i++){
            q->arr[i] = arr[i];
        }
        q->size--;
        return tmp;
    }
}

int peek(Stack *q){
    if(::is_empty(q)){
          cout <<"ERROR_QUEUEEMPTY"<<endl;
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