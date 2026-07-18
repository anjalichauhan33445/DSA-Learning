
#ifndef STACK_H
#define STACK_H

#include <stdio.h>
#include <stdlib.h>


struct Node;

struct Stack{
    int Top;
    int size;
    struct Node ** S;
};

void createStack(struct Stack *st,int size){
    st->Top = -1;
    st->size = size;
    st->S = (struct Node **)malloc(st->size*sizeof(struct Node*));
}

void Push(struct Stack *st,struct Node* x){
    if(st->Top == st->size-1){
        printf("Stack Overflow\n");
    }
    else{
        st->Top++;
        st->S[st->Top] = x;
    }
}

struct Node *Pop(struct Stack *st){
    struct Node* x = NULL;
    if(st->Top==-1){
        printf("Stack Underflow..\n");
    }
    else{
        x = st->S[st->Top];
        st->Top--;
    }
    return x;

}


struct Node* stackTop(struct Stack st){
    if(st.Top==-1) return NULL;
    else return st.S[st.Top];
}

int isFull(struct Stack st){
    if(st.Top == st.size-1)
        return 1;
    else
        return 0;
}

int isEmptyStack(struct Stack st){
    if(st.Top == -1){
        return 1;
    }
    else{
        return 0;
    }
}

#endif