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

void Rdisplay(struct Node* p){
    
    if(p!=NULL){
        printf("%d\n",p->data);
        Rdisplay(p->next);

        //Display the elements in reverse order
        /*
        Rdisplay(p->next);
        printf("%d\n",p->data);
        */
    }


}

int count(struct Node *p){
    int count= 0;
    while(p!=NULL){
        count++;
        p = p->next;
    }
    return count;
}

int Rcount(struct Node *p){
    if(p==NULL){
        return 0;
    }
    return Rcount(p->next)+1;
}

int Sum(struct Node *p){
    int sum = 0;
    while(p!=NULL){
        sum+=p->data;
        p = p->next;
    }
    return sum;
}

int Rsum(struct Node *p){
    if(p==NULL){
        return 0;
    }
    return Rsum(p->next)+p->data; 
}

int main(){
    int arr[] = {10,20,30,40,50};
    create(arr,5);
    Rdisplay(first);
    printf("The number of nodes are: %d\n",Rcount(first));
    printf("The sum of all the nodes are: %d\n",Rsum(first));
    
    return 0;
}