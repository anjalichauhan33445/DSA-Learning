
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
struct Stack1{
    int Top;
    int size;
    long int *S;
};

void createStack1(struct Stack1 *st,int size){
    st->Top = -1;
    st->size = size;
    st->S = (long int *)malloc(st->size*sizeof(long int));
}
void Push1(struct Stack1 *st, long int x){
    if(st->Top == st->size-1){
        printf("Stack Overflow\n");
    }
    else{
        st->Top++;
        st->S[st->Top] = x;
    }
}
long int Pop1(struct Stack1 *st){
    long int x = -1;
    if(st->Top==-1){
        printf("Stack Underflow..\n");
    }
    else{
        x = st->S[st->Top];
        st->Top--;
    }
    return x;

}
int isEmptyStack1(struct Stack1 st){
    if(st.Top == -1){
        return 1;
    }
    else{
        return 0;
    }
}

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