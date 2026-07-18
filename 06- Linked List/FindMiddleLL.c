#include<stdio.h>
#include<stdlib.h>

struct Node {
    int data;
    struct Node *next;
} *first = NULL, *last = NULL;

void create(int arr[], int n){
    first = (struct Node*)malloc(sizeof(struct Node));
    first->data = arr[0];
    first->next = NULL;
    last = first;

    for(int i =1; i<n; i++){
        struct Node *t = (struct Node*)malloc(sizeof(struct Node));
        t->data = arr[i];
        t->next = last->next;
        last->next = t;
        last = t;
    }

}

void Display(){
    struct Node *p = first;

    while(p){
       printf("%d\n",p->data);
       p = p->next;
    }
   
}

int FindMiddle(){
    int x = -1;
    struct Node *p,*q;
    p = q = first;

    while(q){
        q = q->next;
        if(q) p = p->next;
        q = q ? q->next:NULL;
        
    }
    return p->data;
}

int main(){
    int arr[] = {10,20,30,40,50};
    create(arr,5);
    Display();
    printf("The middle element is %d\n",FindMiddle());
    return 0;
}
