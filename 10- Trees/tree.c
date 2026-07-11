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

void IinOrder(struct Node *p){
    struct Stack stk;
    struct Node *t = p;
    createStack(&stk,100);

    while(t!=NULL || !isEmptyStack(stk)){
        if(t!=NULL){
            Push(&stk,t); 
            t = t->lchild;
        }
        else{
            t = Pop(&stk);
            printf("%d ",t->data);
            t = t->rchild;
        }
    }    
}

void IpostOrder(struct Node *p){
        struct Node *t = p;
        struct Stack1 stk;
        createStack1(&stk,100);

        while(t!=NULL || !isEmptyStack1(stk)){
            if(t!=NULL){
                Push1(&stk,(long int)t);
                t = t->lchild;
            }
            else{
                long int temp = Pop1(&stk);
                if(temp>0){
                    Push1(&stk, -temp);
                    t = ((struct Node *)temp)->rchild;
                }
                else{
                    temp = -temp;
                    printf("%d ",((struct Node *)temp)->data);
                    t = NULL;
                }
            }
        }

}
void levelOrder(struct Node *p){
    struct Queue q;
    create(&q,100);

    printf("%d ",p->data);
    enqueue(&q,p);

    while(!isEmpty(q)){
        p = dequeue(&q);
        if(p->lchild){
            printf("%d ",p->lchild->data);
            enqueue(&q,p->lchild);
        }
        if(p->rchild){
            printf("%d ",p->rchild->data);
            enqueue(&q,p->rchild);
        }
    }

}

int main(){
    createTree();
    
    printf("Level Order Traversal\n");
    levelOrder(root);

    // printf("\nIterative Traversal\n");
    // IpostOrder(root);


    // printf("Pre Order Traversal\n");
    // preOrder(root);

    // printf("In-Order Traversal\n");
    // InOrder(root);

    // printf("\nIterative version\n");
    // IinOrder(root);

    
    
    
    return 0;

}
