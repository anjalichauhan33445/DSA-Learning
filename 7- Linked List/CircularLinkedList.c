#include<stdio.h>
#include<stdlib.h>

struct Node{
    int data;
    struct Node *next;
} *head;

void create(int arr[],int n){
    struct Node *last;
    head =(struct Node*) malloc(sizeof(struct Node));
    head->data = arr[0];
    head->next = head;
    last = head;

    for(int i = 1;i<n; i++){
        struct Node *t = (struct Node*) malloc(sizeof(struct Node));
        t->data = arr[i];
        t->next = last->next;
        last->next = t;
        last = t;

    }
}

void display(struct Node *h){

        do{
            printf("%d\n",h->data);
            h = h->next;
        }
        while(h!=head);
}

void RDisplay(struct Node *h){
    static int flag = 0;
    if(h!=head || flag == 0){
        flag = 1;
        printf("%d\n",h->data);

        RDisplay(h->next);
    }
    flag = 0;
}
int main(){
    int arr[] = {10,20,30,40,50};
    create(arr,5);
    RDisplay(head);
    return 0;
}