#include<stdio.h>
#include<stdlib.h>

struct Queue{
    int size;
    int front;
    int Rear;
    int *Q;
};


void Display(struct Queue q){
    if(q.front==q.Rear){
        printf("The Queue is Empty\n");
        return;
    }
    int i = (q.front+1)%q.size;
    while(i!=(q.Rear+1)%q.size){
        printf("%d\n",q.Q[i]);
        i = (i+1)%q.size;
    }

}

void enqueue(struct Queue *q, int x){
    if((q->Rear+1)%q->size==q->front){
        printf("The queue is Full\n");
        return;
    }
    q->Rear = (q->Rear+1)%q->size;
    q->Q[q->Rear] = x;
    
}

int dequeue(struct Queue *q){
    int x = -1;
    if(q->front==q->Rear){
        printf("The queue is Empty\n");
        return x;
    }

    q->front = (q->front+1)%q->size;
    x = q->Q[q->front];
    
    return x;

}

int main(){
    struct Queue q;
    printf("Enter the size of Queue\n");
    scanf("%d",&q.size);
    q.front = q.Rear = 0;
    q.Q = (int *)malloc(q.size*sizeof(int));

    enqueue(&q,10);
    enqueue(&q,20);
    enqueue(&q,30);
    enqueue(&q,40);
  
    printf("Element %d deleted from Queue\n",dequeue(&q));
    
    enqueue(&q,50);
    
    Display(q);
    
    free(q.Q);
    return 0;
}