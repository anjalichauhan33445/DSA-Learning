#include<stdio.h>
#include<stdlib.h>

struct Stack{
    int Top;
    int size;
    int *A;
};

void Display(struct Stack st){
    for(int i = st.Top; i>=0; i--){
        printf("%d\n",st.A[i]);
    }
}
void Push(struct Stack *st,int x){
    if(st->Top == st->size-1){
        printf("Stack Overflow\n");
    }
    else{
        st->Top++;
        st->A[st->Top] = x;
    }
}

int Pop(struct Stack *st){
    int x = -1;
    if(st->Top==-1){
        printf("Stack Underflow..\n");
    }
    else{
        x = st->A[st->Top];
        st->Top--;
    }
    return x;

}

int Peek(struct Stack st, int pos){
    int x = -1;
    
    if(pos<=0 || pos>st.Top+1){
        printf("Invalid Position\n");
    }
    else{
        x = st.A[st.Top-pos+1];
    }
    return x;
}
int main(){
    struct Stack st;
    st.size = 5;
    st.Top = -1;
    st.A = (int *)malloc(st.size*sizeof(int));

    Push(&st,10);
    Push(&st,20);
    Push(&st,30);
    Display(st);
    
    printf("The element at position %d is %d\n",0,Peek(st,0));

    free(st.A);
    return 0;
}