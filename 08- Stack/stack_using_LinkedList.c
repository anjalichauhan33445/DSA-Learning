#include<stdio.h>
#include<stdlib.h>

struct Node{
    int data;
    struct Node *next;
} *Top = NULL;

int isEmpty(){
    return Top? 0:1;
}

int isFull(){
    struct Node *t = (struct Node *)malloc(sizeof(struct Node));
    if(t){
        free(t);
        return 0;
    }
    return 1;
}

int stackTop(){
    if(Top) return Top->data;
    return -1;
}

void push(int x){ 
    if(isFull())
        printf("Stack Overflow..\n");
    else{
        struct Node *t = (struct Node *)malloc(sizeof(struct Node));
        t->data = x;
        t->next = Top;
        Top = t;

    }    
}

int pop(){
    int x = -1;
    if(isEmpty()){
        printf("Stack Underflow..\n");
    }

    else{    
    struct Node *p = Top;
    Top = Top->next;
    x = p->data;
    free(p);
    }
    return x;
    
}

void Display(){
    struct Node *p = Top;
    while(p){
        printf("%d\n",p->data);
        p = p->next;
    }
}

int Peek(int pos){
    struct Node *p = Top;
    for(int i = 0; p!=NULL && i< pos-1; i++){
        p = p->next;
    }
    if(p) return p->data;
    return -1;
}

int main(){

    push(10);
    push(20);
    push(30);
    push(40);
    Display();
    
    printf("The Element at position %d is  %d\n",3,Peek(3));
    
    return 0;
}