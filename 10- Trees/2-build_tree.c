#include<stdio.h>
#include<stdlib.h>


struct Node{
    struct Node *lchild;
    int data;
    struct Node *rchild;
};

int preIndex = 0;
struct Node* buildTree(int preorder[], int Inorder[], int start, int end){
    if(start>end) return NULL;
    struct Node *root = (struct Node *)malloc(sizeof(struct Node));
    root->data = preorder[preIndex++];
    root->lchild = root->rchild = NULL;

    if(start==end){
        return root;
    }
    int i;
    for(i = start; i<=end; i++){
        if(Inorder[i]==root->data)
            break;
    }
    root->lchild = buildTree(preorder,Inorder,start,i-1);
    root->rchild = buildTree(preorder,Inorder,i+1, end);
    return root;
}

void preOrder(struct Node *p){
    if(p){
        printf("%d ",p->data);
        preOrder(p->lchild);
        preOrder(p->rchild);
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
    int preorder[] = {4,7,9,6,3,2,5,8,1};
    int inOrder[] = {7,6,9,3,4,5,8,2,1};
    printf("PreOrder Traversal Given: 4,7,9,6,3,2,5,8,1\n");
    printf("InOrder Traversal Given: 7,6,9,3,4,5,8,2,1\n");
    struct Node *root = buildTree(preorder,inOrder,0,8);
    printf("PreOrder Traversal Generated: ");

    preOrder(root);

    printf("\nInOrder Traversal Generated: ");
    InOrder(root);
    
   


    return 0;
}