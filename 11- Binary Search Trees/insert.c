#include<stdio.h>
#include<stdlib.h>

struct Node{
    struct Node *lchild;
    int data;
    struct Node *rchild;
} *root = NULL;

void Insert(int key){
    struct Node *t;
    struct Node *r = NULL;
    struct Node *p = root;

    if(root==NULL){
        t = (struct Node*)malloc(sizeof(struct Node));
        t->data = key;
        t->lchild = t->rchild = NULL;
        root = t;
        return;
    }
    while(p!=NULL){
        r = p;
        if(key < p->data){
            p = p->lchild;
        }
        else if(key>p->data){
            p = p->rchild;
        }
        else 
            return;
    }

    t = (struct Node*)malloc(sizeof(struct Node));
    t->data = key;
    t->lchild = t->rchild = NULL;

    if(r->data<t->data) r->rchild = t;
    else r->lchild = t;



}


// struct Node *RInsert(struct Node *p, int key){
//     struct Node *t;

//     if(p==NULL){
//         t = (struct Node *)malloc(sizeof(struct Node));
//         t->data = key;
//         t->lchild = t->rchild = NULL;
//         return t;
//     }
//     if(key<p->data){
//         p->lchild = RInsert(p->lchild,key);
//     }
//     else if(key>p->data){
//         p->rchild = RInsert(p->rchild,key);
//     }
//     return p;
// }


void InOrder(struct Node *p){
    if(p){ 
        InOrder(p->lchild);
        printf("%d ",p->data);
        InOrder(p->rchild);
        
    }
}

int main(){
    
    Insert(30);
    Insert(20);
    Insert(40);
    Insert(10);
    Insert(25);
    Insert(35);
    Insert(50);
    InOrder(root);

    return 0;
}