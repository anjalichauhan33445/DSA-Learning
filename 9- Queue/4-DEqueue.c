#include<stdio.h>
#include<stdlib.h>

//DEqueue
struct Queue{
    int size;
    int front;
    int Rear;
    int *Q;
};

void Display(struct Queue q){

    for(int i  = q.front+1; i<=q.Rear; i++){
        printf("%d ",q.Q[i]);
    }
}

//enqueue using rear
void enqueue_rear(struct Queue *q, int x){
    if(q->Rear==q->size-1){
        printf("The Queue is Full\n ");
        return;
    }

    q->Rear++;
    q->Q[q->Rear] = x;
}

//dequeue using rear
int dequeue_rear(struct Queue *q){
    int x = -1;
    if(q->front==q->Rear){
        printf("The Queue is Empty\n");
        return -1;
    }
    x = q->Q[q->Rear];
    q->Rear--;
    return x;

}

void enqueue_front(struct Queue *q, int x){
    if(q->front==-1){
        printf("Cannot Insert\n");
        return;
    }
    
    q->Q[q->front] = x;
    q->front--;

}

int dequeue_front(struct Queue *q){

    int x = -1;
    if(q->front==q->Rear){
        printf("The Queue is Empty\n");
        return x;
    }
    q->front++;
    x = q->Q[q->front];
    return x;
    

}


int main(){
    struct Queue q;
    q.size = 5;
    q.front = q.Rear = -1;
    q.Q = (int *)malloc(q.size*sizeof(int));
    enqueue_rear(&q,10);
    enqueue_rear(&q,20);
    enqueue_rear(&q,30);
    enqueue_rear(&q,40);
    enqueue_rear(&q,50);
    
    printf("%d was deleted\n",dequeue_front(&q));
    
    
    Display(q);
    enqueue_front(&q,10);
    printf("\n");
    Display(q);
    return 0;
}