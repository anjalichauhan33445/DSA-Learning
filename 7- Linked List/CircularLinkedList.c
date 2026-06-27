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

void Insert(int pos, int x){
    struct Node *p = head;
    struct Node *t;
   
    

    if(pos==0){
        t = (struct Node*)malloc(sizeof(struct Node));
        t->data = x;
        if(head==NULL){
            head = t;
            head->next = head;
        }
        else{
        while(p->next!=head){
            p = p->next;
        }
       t->next = head;
       p->next = t;
       head = t;
             }
    }
    else{
         p = head;
    for(int i = 0; i<pos-1; i++){
        p = p->next;
    }
    t = (struct Node*)malloc(sizeof(struct Node));
    t->data = x;
    t->next = p->next;
    p->next = t;
    


}
}

int main(){
    int arr[] = {20};
    create(arr,1);
    Insert(0,90);
    display(head);
    return 0;
}