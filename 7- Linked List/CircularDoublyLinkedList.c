#include<stdio.h>
#include<stdlib.h>

struct Node{
    struct Node *prev;
    int data;
    struct Node *next;
} *head = NULL;


void create(int arr[], int n){
    struct Node *last;
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
    Display();
    return 0;
}