#include<stdio.h>

long long fact(int n){
    if(n==0 || n==1) return 1;
    else{
        return fact(n-1)*n;
    }
}
long long ncr(int n, int r)
{
long num = fact(n);
long den = fact(r)* fact(n-r);
return num/den;
}

long long NCR(int n, int r){
    if(r==0 || n==r) return 1;
    else{
        return NCR(n-1, r-1) + NCR(n-1, r);
    }
}
int main(){
    printf("\nPossible Selections: %lld\n", ncr(5,2));
    printf("Using Recursion:\nPossible Selections: %lld\n", NCR(5,2));
    return 0;
}