#include<stdio.h>
#include<stdlib.h>

struct Node{
    struct Node *prev;
    int data;
    struct Node *next;
} *head = NULL;


void create(int arr[], int n){
    head = (struct Node *)malloc(sizeof(struct Node));
    head->data = arr[0];
    head->prev = head;
    head->next = head;
    
    
}

int main(){
    int arr[] = {10,20,30,40,50};
    create(arr,5);
    return 0;
}