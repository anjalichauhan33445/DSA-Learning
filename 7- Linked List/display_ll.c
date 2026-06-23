#include<stdio.h>
#include<stdlib.h>

struct Node{
    int data;
    struct Node* next;
}*first;


void create(int arr[], int n){
    if(n == 0){
    first = NULL;
    return;
        }
    struct Node* t,*last;
    first = (struct Node*)malloc(sizeof(struct Node));
    first->data = arr[0];
    first->next = NULL;
    last = first;

    for(int i = 1; i<n; i++){
        t = (struct Node*)malloc(sizeof(struct Node));
        t->data = arr[i];
        t->next = NULL;
        last->next = t;
        last = t;
    }
}
void display(){
   
    struct Node* p = first;
    while(p){
        printf("%d\n",p->data);
        p = p->next;
    }
}
int main(){
    int arr[] = {10,20,30,40,50};
    create(arr,5);
    display();
    
    
    return 0;
}