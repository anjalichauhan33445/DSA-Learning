
#ifndef QUEUE_H
#define QUEUE_H

#include <stdio.h>
#include <stdlib.h>

struct Node{
    struct Node *lchild;
    int data;
    struct Node *rchild;
};

struct Queue{
    int size;
    int front;
    int Rear;
    struct Node **Q;
};


void create(struct Queue *q, int size){
    q->size = size;
    q->front = q->Rear = 0;
    q->Q = (struct Node **)malloc(q->size*sizeof(struct Node *));
}

void enqueue(struct Queue *q, struct Node *x){
    if((q->Rear+1)%q->size==q->front){
        printf("The queue is Full\n");
        return;
    }
    q->Rear = (q->Rear+1)%q->size;
    q->Q[q->Rear] = x;
    
}

struct Node *dequeue(struct Queue *q){
    struct Node *x = NULL;
    if(q->front==q->Rear){
        printf("The queue is Empty\n");
        return x;
    }

    q->front = (q->front+1)%q->size;
    x = q->Q[q->front];
    
    return x;

}

int isEmpty(struct Queue q){
    return q.front==q.Rear;
}
#endif