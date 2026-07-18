#include<stdio.h>
#include<stdlib.h>

struct Node{
    int data;
    struct Node *next;
} *front=NULL, *Rear=NULL;

void enqueue(int x){
    struct Node *t = (struct Node*)malloc(sizeof(struct Node));

    if(t==NULL){
        printf("The Queue is Full\n");
        return;
    }
    t->data = x;
    t->next = NULL;

    if(front==NULL) front=Rear = t;
    else{
        Rear->next = t;
        Rear = t;
    }
    
}


int dequeue(){
    struct Node *p;
    int x = -1;
    if(front==NULL){
        printf("The Queue is Empty\n");
        return x;
    }
    p = front;
    x = p->data;
    front = front->next;
    if(front==NULL){
        Rear=NULL;
    }
    free(p);
    return x;

    
}

void Display(){
    struct Node *p = front;
    if(front==NULL){
        printf("The Queue is Empty");
        return;
    }

    while(p){
        printf("%d ",p->data);
        p = p->next;
    }
}

int main(){

    enqueue(10);
    enqueue(20);
    enqueue(30);
    enqueue(40);
    Display();
    printf("\nElement %d was dequeued\n",dequeue());
    Display();

    

    return 0;
}