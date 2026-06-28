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
int main(){
    int arr[] = {10,20,30,40,50};
    create(arr,5);
    printf("\nThe length of the Linked List is %d\n",Length());
    Display();
    return 0;
}