#include<stdio.h>
#include<stdlib.h>
#include<string.h>

struct Stack{
    int size;
    int Top;
    int *S;
};

void push(struct Stack *st, int x){
    if(st->Top == st->size-1) return;
    st->Top++;
    st->S[st->Top] = x;
}

int pop(struct Stack *st){
    int x = -1;
    if(st->Top==-1) return x;
    x = st->S[st->Top];
    st->Top--;
    return x;
}

int isEmpty(struct Stack st){
    return st.Top==-1?1:0;
}

int isOperand(char ch){
    if(ch =='+' || ch =='-' || ch =='*' ||
         ch =='/' || ch =='^' || ch == '(' || ch==')') return 0;
    return 1; 
}

int stackTop(struct Stack st){
    if(st.Top==-1) return -1;
    return st.S[st.Top];
}

int evaluate(char *exp){
    struct Stack st;
    st.Top = -1;
    st.size = strlen(exp);
    st.S = malloc((st.size+1)*sizeof(int));

    for(int i = 0; exp[i]!='\0'; i++){
        if(exp[i]=='(' || exp[i]==')') continue;
        if(isOperand(exp[i])){
            push(&st,exp[i]-'0');
        }
        else{
            int x2 = pop(&st);
            int x1 = pop(&st);

            switch (exp[i])
            {
            case '+':
                push(&st,x1+x2);
                break;
            
            case '-':
                push(&st,x1-x2);
                break;

            case '*':
                push(&st,x1*x2);
                break;
            case '/':

                push(&st,x1/x2);
                break;
            
            default:
                break;
            }

        }
    }
    return pop(&st);
}

int main(){
    char exp[] = "35*62/+4-";
    printf("The result of the expression is %d\n",evaluate(exp));

    return 0;
}