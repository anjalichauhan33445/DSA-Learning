#include<stdio.h>

int exponent(int m, int n){
    if(n==0){
        return 1;
    }
    return exponent(m,n-1)*m;
}

// optimized version
int exponent_op(int m, int n){
    if(n==0) return 1;
    if(n%2==0){
        return exponent_op(m*m, n/2);
    }
    return m*(exponent_op(m*m, (n-1)/2));
}

int exp_loops(int m, int n){
    int res = 1;
    int i = 1;
    while(i<=n){
        res = res * m;
        i++;
    }
    return res;
}
int main(){
    printf("%d ",exponent(2,3));
    printf("%d ",exponent_op(2,3));
    printf("%d ", exp_loops(2,3));
    return 0;
}