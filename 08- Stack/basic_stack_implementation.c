#include<stdio.h>
#include<stdlib.h>

struct Stack{
    int Top;
    int size;
    int *A;
};

int main(){
    struct Stack st;
    printf("Enter the size of the stack:\n");
    scanf("%d",&st.size);
    st.A = (int *)malloc(st.size*sizeof(int));
    st.Top = -1;

    for(int i = 0; i<st.size; i++){
        printf("Enter the %d element:\n",i+1);
        st.Top++;
        scanf("%d",&st.A[st.Top]);
    }

    for(int i = st.size-1; i>=0; i--){
        printf("%d\n",st.A[i]);
    }
    
    return 0;
}