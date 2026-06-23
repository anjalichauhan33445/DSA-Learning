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

int main(){
    int arr[] = {10,20,30,40,50};

    create(arr,5);
    Rdisplay(first);
    struct Node *temp = RSearch(first,20);
    printf("The number of nodes are: %d\n",Rcount(first));
    printf("The sum of all the nodes are: %d\n",Rsum(first));
    printf("The maximum element in the Linked List is: %d\n",Rmax(first));
    
    if(temp){
        printf("The element %d is at %p location\n",20,(void *)temp);
    }
    
    
    return 0;
}