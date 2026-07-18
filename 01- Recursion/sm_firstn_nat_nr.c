#include<stdio.h>

int sum_recur(int n){
    if(n==0){
        return 0;
    }
    
    return sum_recur(n-1)+n;
}

int sum_loops(int n){
    int i = 1;
    int sum = 0;
    while(i<=n){
        sum+=i;
        i++;
    }
    return sum;
}

int sum_frmla(int n){
    int sum =(n*(n+1))/2;
    return sum;
}
int main(){
    int recur_result = sum_recur(10);
    int loop_result = sum_loops(10);
    int frmla_result = sum_frmla(10);
    printf("Recursion: %d, Loops: %d, Formula: %d ",recur_result,loop_result,frmla_result);

    return 0;
}