#include<stdio.h>
#include<stdlib.h>

struct Node{
    int data;
    struct Node *next;
} *Top = NULL;


void push(int x){
    struct Node *t = (struct Node *)malloc(sizeof(struct Node));
    if(t==NULL)
        printf("Stack Overflow..\n");
    else{
        t->data = x;
        t->next = Top;
        Top = t;

    }    
}

int pop(){
    int x = -1;
    if(Top==NULL){
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

int isEmpty(){
    return Top? 0:1;
}

int main(){
    // push(10);
    // push(20);
    // push(30);
    // push(40);
    Display();
    if(isEmpty()) printf("The stack is empty\n");
    else printf("The stack isn't Empty\n");
    

   
    return 0;
}