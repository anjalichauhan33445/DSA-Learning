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

struct Node *Search(int key){
    struct Node *p = root;
    while(p!=NULL){
        if(p->data==key){
            return p;
        }

        else if(p->data<key){
            p = p->rchild;
        }
        else{
            p = p->lchild;
        }
    }
    return NULL;
}

int Height(struct Node *root){
    int x = 0;
    int y = 0;
    if(root==NULL){
        return 0;
    }

    x = Height(root->lchild);
    y = Height(root->rchild);

    return x>y?x+1:y+1;
}

struct Node *InPre(struct Node *p){
    while(p && p->rchild!=NULL){
        p = p->rchild;
    }
    return p;
}

struct Node *InSucc(struct Node *p){
    while(p && p->lchild!=NULL){
        p = p->lchild;
    }
    return p;
}
struct Node *Delete(struct Node *p, int key){
    struct Node *q;

    if(p==NULL) return NULL;
    
    if(key<p->data){
        p->lchild = Delete(p->lchild,key);
    }
    else if(key>p->data){
        p->rchild = Delete(p->rchild,key);
    }
    else{
        if(p->lchild==NULL && p->rchild==NULL){
        if(p==root){
            root = NULL;
        }
        free(p);
        return NULL;
    }
        if(Height(p->lchild)>Height(p->rchild)){
            q = InPre(p->lchild);
            p->data = q->data;
            p->lchild = Delete(p->lchild,q->data);
        }
        else{
            q = InSucc(p->rchild);
            p->data = q->data;
            p->rchild = Delete(p->rchild,q->data);
        }
    }
    return p;
}

int main(){
    struct Node *temp;
    root = RInsert(root,30);
    RInsert(root,20);
    RInsert(root,40);
    RInsert(root,10);
    RInsert(root,25);
    RInsert(root,35);
    RInsert(root,50);
    
    InOrder(root);
    root = Delete(root,40);
    printf("\nElement 40 was deleted\n");

    return 0;
}