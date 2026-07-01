#include<stdio.h>
#include<stdlib.h>

struct Node{
    struct Node *prev;
    int data;
    struct Node *next;
} *head = NULL;
struct Node *last = NULL;


int Length(){
    if(head == NULL)
        return 0;
        
    struct Node *p = head;
    int ct = 0;
    do{
        ct++;
        p = p->next;
    }
    while(p!=head);
    return ct;
}

void create(int arr[], int n){  
    head = (struct Node *)malloc(sizeof(struct Node));
    head->data = arr[0];
    head->prev = head;
    head->next = head;
    last = head;

    for(int i = 1; i<n ; i++){
        struct Node *t =(struct Node *)malloc(sizeof(struct Node));
        t->data = arr[i];
        t->prev = last;
        t->next = last->next;
        last->next = t;
        head->prev = t;
        last = t;
    }
    
}

void Insert(int pos, int x){

    if(pos<0 || pos>Length()) return;
    if(pos==0){

        struct Node *t = (struct Node*)malloc(sizeof(struct Node));

        if(head){
        t->data = x;
        t->next = head;
        t->prev = head->prev;
        head->prev->next = t;
        head->prev = t;
        head = t;
        }
        else{
            t->data = x;
            t->prev = t;
            t->next = t;
            head = t;
            last = t;
        }

    }
    else{
        struct Node *p = head;
        for(int i = 0; i<pos-1; i++){
            p = p->next;
        }

        struct Node *t = (struct Node*)malloc(sizeof(struct Node));
        
        t->data = x;
        t->prev = p;
        t->next = p->next;
        p->next->prev = t;
        p->next = t;
    }
}

void Display(){
    struct Node *p = head;
    do{
        printf("%d\n",p->data);
        p = p->next;
    }
    while(p!=head);

}

int main(){
    int arr[] = {10,20,30,40,50};
    create(arr,5);
    Insert(5,100);
    Display();
    return 0;
}