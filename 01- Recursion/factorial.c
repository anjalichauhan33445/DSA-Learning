#include<stdio.h>

long long fact(int n){
    if(n<0){
        return -1;
    }
    if(n==0){
        return 1;
    }
    return fact(n-1)*n;
}

long long fact_loops(int n){
    int i = 1;
    int res = 1;
    while(i<=n){
        res = res*i; 
        i++;
    }
    return res;
    
}
int main(){
    printf("%lld ",fact(5));
    printf("%lld ",fact_loops(5));

    return 0;
}