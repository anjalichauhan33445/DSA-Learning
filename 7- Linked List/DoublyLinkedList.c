#include<stdio.h>
#include<stdlib.h>

struct Node{
    struct Node* prev;
    int data;
    struct Node* next;
}*first = NULL;

void create(int arr[], int n){
    struct Node *last;
    first = (struct Node*)malloc(sizeof(struct Node));
    first->prev = NULL;
    first->data = arr[0];
    first->next = NULL;
    last = first;

    for(int i = 1; i<n; i++){
        struct Node *t = (struct Node*)malloc(sizeof(struct Node));
        t->data = arr[i];
        t->prev = last;
        t->next = last->next;
        last->next = t;
        last = t;
    }
}
void Display(){
    struct Node* p = first;
    while(p){
        printf("%d\n",p->data);
        p = p->next;
    }
}

int Length(){
    int len = 0;
    struct Node *p =first;
    while(p){
        len++;
        p = p->next;
    }
    return len;
}

void Insert(int pos, int x){
    struct Node *t;
    if(pos<0 || pos>Length()) return;
    if(pos==0){
        t = (struct Node*)malloc(sizeof(struct Node));
        t->data = x;
        t->prev = NULL;
        t->next = first;
        first->prev = t;
        first = t;
    }
    else{
        struct Node *p = first;
        for(int i = 0; i<pos-1; i++){
            p = p->next;
        }
       t = (struct Node*)malloc(sizeof(struct Node));
       t->data = x;
       t->prev = p;
       t->next = p->next;
       if(p->next){
        p->next->prev = t;
       }
       p->next = t;
    }
}
int main(){
    int arr[] = {10,20,30,40,50};
    create(arr,5);
   
    Insert(5,100);    
    Display();
    
    return 0;
}