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
    printf("%d was deleted\n",dequeue_rear(&q));
    
    Display(q);
    return 0;
}