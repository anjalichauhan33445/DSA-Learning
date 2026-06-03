#include<stdio.h>


// iterative method 
int fib_l(int n){
    if(n<=1){
        return n;
    }
    int sum = 0;
    int first = 0;
    int second = 1;
    for(int i = 2; i<=n;i++){
        sum = first+second;
        first = second;
        second = sum;
    
    }
    return sum;
}

// excessive recursion
int fib_e(int n){
    if(n<=1) return n;
    return fib_e(n-2)+fib_e(n-1);
}

// using memoization 

int fib_m(int n){
    static int F[10];
    
    static int initialized = 0;

    if(!initialized){
        for(int i = 0; i < 10; i++)
        F[i] = -1;
        initialized = 1;
    }

    if(n<=1){
        F[n] = n;
        return F[n];
    }
    else {
        if(F[n-2]==-1) F[n-2] = fib_m(n-2);
        if(F[n-1]==-1) F[n-1] = fib_m(n-1);
    }
    return F[n-2]+F[n-1];

}

int main(){
    printf("Loops %d, Excessive Recursion: %d, Memoization: %d ", fib_l(5), fib_e(5), fib_m(5));
    return 0;
}