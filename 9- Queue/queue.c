#include<stdio.h>
#include<stdlib.h>

struct Queue{
    int size;
    int front;
    int Rear;
    int *Q;
};

void Display(struct Queue q){

    for(int i = q.front+1; i<=q.Rear; i++){
        printf("%d\n",q.Q[i]);
    }
}

void enqueue(struct Queue *q, int x){
    if(q->Rear==q->size-1){
        printf("Queue is Full\n");
        return;
    }

    q->Rear++;
    q->Q[q->Rear] = x;
}

int dequeue(struct Queue *q){
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
    printf("Enter the size of Queue\n");
    scanf("%d",&q.size);
    q.front = q.Rear = -1;
    q.Q =malloc(q.size*sizeof(int));

    enqueue(&q,10);
    enqueue(&q,20);
    enqueue(&q,30);
    printf("%d was deleted from the queue\n",dequeue(&q));
    Display(q);

    free(q.Q);
    return 0;
}