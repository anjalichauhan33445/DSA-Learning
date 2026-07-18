#include<stdio.h>
#include "Stack.h"

struct Node{
    struct Node *lchild;
    int data;
    struct Node *rchild;
} *root = NULL;



void create(int pre[], int n){
    int i = 0;
    struct Stack stk;
    struct Node *p, *t;
    stk.size = n;
    stk.Top = -1;
    stk.S = (struct Node **)malloc(stk.size*sizeof(struct Node*));
    root  = (struct Node*)malloc(sizeof(struct Node));
    root->data = pre[i++];
    root->lchild = root->rchild = NULL;
    p = root;

    while(i<n){
        if(pre[i]<p->data){
            t = (struct Node*)malloc(sizeof(struct Node));
            t->data = pre[i++];
            t->lchild = t->rchild = NULL;
            p->lchild = t;
            Push(&stk,p);
            p = t;
        }
        else if(isEmptyStack(stk) || pre[i]<stackTop(stk)->data){
            t = (struct Node*)malloc(sizeof(struct Node));
            t->data = pre[i++];
            t->lchild = t->rchild = NULL;

            p->rchild = t;
            p = t;

        }
        else{
            p = Pop(&stk);
        }
    }

}
void InOrder(struct Node *p){
    if(p){ 
        InOrder(p->lchild);
        printf("%d ",p->data);
        InOrder(p->rchild);
        
    }
}

int main(){
    int pre[] = {30,20,10,15,25,40,50,45};
    create(pre,8);
    InOrder(root);

    return 0;
}