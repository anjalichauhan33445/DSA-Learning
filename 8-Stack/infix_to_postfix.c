#include<stdio.h>
#include<stdlib.h>
#include<string.h>


struct Stack{
    int Top;
    int size;
    char *S;
};

void push(struct Stack *st, char x){
    if(st->Top == st->size-1) return;
    st->Top++;
    st->S[st->Top] = x;
}

char pop(struct Stack *st){
    char x = '\0';
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

char stackTop(struct Stack st){
    if(st.Top==-1) return '\0';
    return st.S[st.Top];
}

//Conversion for Basic expressions including operators like +,*,-,/

int pre(char ch){
    
    if(ch=='+' || ch == '-') return 1;
    if(ch=='*' || ch == '/') return 2;
    return 0;

}

char *convert1(char *exp){
    struct Stack st;
    st.Top = -1;
    st.size = strlen(exp);
    st.S = (char *)malloc(st.size * sizeof(char));
    char *postfix = (char *)malloc((strlen(exp)+1)*sizeof(char));
    int i = 0,j = 0;

    while(exp[i]!='\0'){
        if(isOperand(exp[i])){
            postfix[j++] = exp[i++];
        }
        else{
            if(pre(exp[i])>pre(stackTop(st))){
                push(&st,exp[i]);
                i++;
            }
            else{
                postfix[j++] = pop(&st);
            }
            
        }
    }
    while(!isEmpty(st)){
        postfix[j++] = pop(&st);
    }
    postfix[j] = '\0';
    free(st.S);
    return postfix;
}

int outPre(char ch){
    if(ch=='+'|| ch=='-') return 1;
    if(ch=='*'|| ch=='/') return 3;
    if(ch=='^') return 6;
    if(ch=='(') return 7;
    if(ch==')') return 0;
    return -1;
}

int inPre(char ch){
    if(ch=='+'|| ch=='-') return 2;
    if(ch=='*'|| ch=='/') return 4;
    if(ch=='^') return 5;
    if(ch=='(') return 0;
    return -1;
}

char *convert2(char *exp){
    struct Stack st;
    st.Top = -1;
    st.size = strlen(exp);
    st.S = (char *)malloc(strlen(exp));
    char *postfix = (char *)malloc(strlen(exp)+1);
    int i = 0,j = 0;
    while(exp[i]!='\0'){
        if(isOperand(exp[i])){
            postfix[j++] = exp[i++];
        }
        else{
            if(outPre(exp[i])==inPre(stackTop(st))){
                pop(&st);
                i++;
            }
            else if(outPre(exp[i])>inPre(stackTop(st))){
                push(&st,exp[i]);
                i++;
            }
            else{
                postfix[j++] = pop(&st);
            }
        }
    }
    while(!isEmpty(st)){
        postfix[j++] = pop(&st);
    }
    postfix[j] = '\0';

    return postfix;
}

int main(){
    char exp[] = "a+b*(c^d-e)^(f+g*h)-i";
    char *ans  = convert2(exp);
    printf("%s\n",ans);
    free(ans);
    return 0;
}