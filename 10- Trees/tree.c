#include<stdio.h>
#include<stdlib.h>
#include "Queue.h"
#include "Stack.h"
struct Node * root = NULL;

void createTree(){
    
    struct Node *p, *t;
    int x;
    struct Queue q;
    create(&q,100);

    printf("Enter root value\n");
    scanf("%d",&x);

    root = (struct Node*)malloc(sizeof(struct Node));
    root->data = x;
    root->lchild = root->rchild = NULL;
    enqueue(&q,root);

    while(!isEmpty(q)){
        p = dequeue(&q);
        printf("Enter left child for %d\n",p->data);
        scanf("%d",&x);

        if(x!=-1){
            t = (struct Node*)malloc(sizeof(struct Node));
            t->data = x;
            t->lchild = t->rchild = NULL;
            p->lchild = t;
            enqueue(&q,t);
        }

        printf("Enter right child for %d\n",p->data);
        scanf("%d",&x);
        if(x!=-1){
            t = (struct Node*)malloc(sizeof(struct Node));
            t->data = x;
            t->lchild = t->rchild = NULL;
            p->rchild = t;
            enqueue(&q,t);
        }
    }
}

void preOrder(struct Node *p){
    if(p){
        printf("%d ",p->data);
        preOrder(p->lchild);
        preOrder(p->rchild);
    }
}

void postOrder(struct Node *p){
    if(p){ 
        postOrder(p->lchild);
        postOrder(p->rchild);
        printf("%d ",p->data);
    }
}

void InOrder(struct Node *p){
    if(p){ 
        InOrder(p->lchild);
        printf("%d ",p->data);
        InOrder(p->rchild);
        
    }
}



void IpreOrder(struct Node *p){
    struct Stack stk;
    createStack(&stk,100);
    struct Node *t = p;
    while(t!=NULL || !isEmptyStack(stk)){
        if(t!=NULL){
            printf("%d ",t->data);
            Push(&stk,t);
            t = t->lchild;
        }
        else{
            t = Pop(&stk);
            t = t->rchild;
        }
    }
}

int main(){
    createTree();

    printf("Pre Order Traversal\n");
    preOrder(root);

    printf("\nIterative version\n");
    IpreOrder(root);

    // printf("Post Order Traversal\n");
    // postOrder(root);

    // printf("In-Order Traversal\n");
    // InOrder(root);
    
    return 0;

}
