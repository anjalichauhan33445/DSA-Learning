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


void Display(){
    struct Node *p = Top;
    while(p){
        printf("%d\n",p->data);
        p = p->next;
    }
}

int main(){
    push(10);
    push(20);
    push(30);
    push(40);
    Display();

    //printf("Element %d deleted from the Stack:\n",pop());
    return 0;
}