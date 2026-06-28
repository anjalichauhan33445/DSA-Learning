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

int Length(){
    struct Node *p = head;
    int ct = 0;
    do{
        ct++;
        p = p->next;
    }
    while(p!=head);

    return ct;
}
void Insert(int pos, int x){
    struct Node *p = head;
    struct Node *t;
   
    if(pos<0 || pos>Length()) return;

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

int Delete(int pos){
    int x = -1;
    struct Node *p,*q;
    p = head;
    if(pos<1 || pos>Length()) return x;
    if(pos==1){
        while(p->next!=head){
            p = p->next;
        }
        x = head->data;
        if(p==head){
            free(head);
            head = NULL;
        }
        else{
        p->next = head->next;
      
        free(head);
        head = p->next;
        }
    }
    else{
    for(int i = 0; i<pos-2; i++){
        p = p->next;
    }
    q = p->next;
    p->next = q->next;
    x = q->data;

    free(q);
}
    return x;

}

int main(){
    int arr[] = {10,20,30,40,50};
    create(arr,5);
    printf("\nBefore Deletion\n");
    display(head);

    printf("\n%d deleted from the List\n",Delete(1));
    printf("\nList After Deletion\n");
    display(head);
    
    return 0;
}