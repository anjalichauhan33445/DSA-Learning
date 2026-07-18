#include<stdio.h>
#include<string.h>
#include<stdlib.h>

struct Stack{
    int size;
    int Top;
    char *S;
};

int isEmpty(struct Stack st){
    return st.Top==-1?1:0;
}
void push(struct Stack * st, char x){
    if(st->Top==st->size-1) return;
    st->Top++;
    st->S[st->Top] = x;
}

int pop(struct Stack *st){
    int x  = -1;
    if(st->Top==-1) return x;
    x = st->S[st->Top];
    st->Top--;
    return x;
}

//rounded brackets only
int isBalanced1(char *exp){
    struct Stack st;
    st.size = strlen(exp);
    st.Top = -1;
    st.S = (char*)malloc(st.size*sizeof(char));

    for(int i = 0; exp[i]!='\0'; i++){
        if(exp[i]=='('){
            push(&st,exp[i]);
        }
        else if(exp[i]==')'){
            if(isEmpty(st)) return 0;
            else{
                pop(&st);
            }
        }
    }
    return isEmpty(st)? 1 : 0;
}

int isBalanced2(char *exp){
    struct Stack st;
    st.Top = -1;
    st.size = strlen(exp);
    st.S = (char *)malloc(st.size*sizeof(char));

    for(int i = 0; exp[i]!='\0'; i++){
        if(exp[i]=='(' || exp[i]=='[' || exp[i]=='{'){
            push(&st,exp[i]);
        }
        else if(exp[i]==')' || exp[i]==']' || exp[i]=='}'){
            if(isEmpty(st))
                return 0;
            char ch = pop(&st);
            if(!(exp[i]-ch==1 && exp[i]==')' 
                || exp[i]-ch==2 && exp[i]==']'
                || exp[i]-ch==2 && exp[i]=='}')) return 0;
        }
    }
    return isEmpty(st)?1:0;
}

int main(){
    char exp[] = "{([a+b]*[c-d])/e}";
    if(isBalanced2(exp)){
        printf("The expression is Balanced\n");
    }
    else{
        printf("The expression is not Balanced\n");
    }
    return 0;
}

