#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct Node{
    int data;
    struct Node* next;
};
struct Node *first = NULL;
struct Node *last = NULL;


void create(int arr[], int n){
    if(n == 0){
    first = NULL;
    return;
        }
    struct Node* t;
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

void display(struct Node *head){
   
    struct Node* p = head;
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

int max(struct Node* p){
    int max = INT32_MIN;
    while(p!=NULL){
        if(p->data > max) max = p->data;
        p = p->next;
    }
    return max;
}

int Rmax(struct Node *p){
    int x;
    if(p==NULL){
        return INT32_MIN ;
    }
    x = Rmax(p->next);
    return x>p->data?x:p->data;
}


// Move to Front 
struct Node* LSearch(struct Node *p, int key){
   struct Node* q = NULL; 
   while(p!=NULL){
    if(key==p->data){
        
        if(q!=NULL){
        q->next = p->next;
        p->next = first;
        first = p;
        return p;
        }
    }
    q = p;
    p = p->next;
   }
   return NULL;
}

struct Node* RSearch(struct Node* p, int key){
    if(p==NULL){
        return NULL;
    }
    if(key==p->data){
        return p;
    }
    return RSearch(p->next, key);
}
void InsertFirst(int x){
    struct Node *t = (struct Node*)malloc(sizeof(struct Node));
    t->data = x;
    t->next = first;
    first = t;
}

void Insert(int pos, int x){
    if(pos==0){
        InsertFirst(x);
        return;
    }
    struct Node *t = (struct Node*)malloc(sizeof(struct Node));
    t->data = x;
    struct Node* p = first;
    for(int i = 0; i<pos-1 && p; i++){
        p = p->next;
    }
    t->next = p->next;
    p->next = t;

    
}
void InsertLast(int x){
    struct Node *t = (struct Node*)malloc(sizeof(struct Node));
    t->data = x;
    t->next = NULL;
    if(first==NULL){
        first = last = t;
    }
    else{
        last->next = t;
        last = t;
    }
}

void InsertSorted(int x){
    struct Node* p = first;
    struct Node* q = NULL;

    struct Node *t = (struct Node*)malloc(sizeof(struct Node));
    t->data = x;
    t->next = NULL;
    if(first==NULL){
        first = last = t;
    }
    else{
    while(p && p->data<x){
        q = p;
        p = p->next;
    }
    if(q==NULL){
        t->next = first;
        first = t;
    }
    else{
    t->next = q->next;
    q->next = t;

    if(p==NULL){
        last = p;
    }
    }
}
}


int delete(int pos){
    int x = -1;
    struct Node *p, *q;
    

    if(pos==1){
        p = first;
        x = p->data;
        first = first->next;
        free(p);

    }
    else{
        q = NULL;
        p = first;
        for(int i = 0; i<pos-1 && p; i++){
        q = p;
        p = p->next;
    }
    if(p){
    q->next = p->next;
    x = p->data;
    free(p);
    }
}
    return x;
    
}



bool isSorted(){

    
    struct Node* p = first;
    int x = INT32_MIN;
    while(p!=NULL){
        if(p->data<x){
            return false;
        }
        x = p->data;
        p = p->next;
    }
    return true;
}


// Remove duplicate elements from a sorted linked list
void removeDup(){
    if(first==NULL) return;
    struct Node *p = first;
    struct Node *q = first->next;

    while(q!=NULL){
        if((p->data!=q->data)){
            p = q;
            q = q->next;
        }
        else{
            p->next = q->next;
            free(q);
            q = p->next;
        }
    }
}

int main(){
    int arr[] = {3,5,5,8,8,8};
    create(arr,6);

    printf("Before removal\n");
    display(first);

    if(isSorted()){
    removeDup();
    }

    printf("After Removal\n");
    display(first);
    

    
    
    return 0;
}