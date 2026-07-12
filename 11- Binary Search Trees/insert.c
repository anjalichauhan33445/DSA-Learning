#include<stdio.h>
#include<stdlib.h>

struct Node{
    struct Node *lchild;
    int data;
    struct Node *rchild;
};


struct Node *RInsert(struct Node *p, int key){
    struct Node *t;

    if(p==NULL){
        t = (struct Node *)malloc(sizeof(struct Node));
        t->data = key;
        t->lchild = t->rchild = NULL;
        return t;
    }
    if(key<p->data){
        p->lchild = RInsert(p->lchild,key);
    }
    else if(key>p->data){
        p->rchild = RInsert(p->rchild,key);
    }
    return p;
}


void InOrder(struct Node *p){
    if(p){ 
        InOrder(p->lchild);
        printf("%d ",p->data);
        InOrder(p->rchild);
        
    }
}

int main(){
    struct Node *root = NULL;
    root = RInsert(root,30);
    RInsert(root,20);
    RInsert(root,40);
    RInsert(root,10);

    InOrder(root);

    return 0;
}