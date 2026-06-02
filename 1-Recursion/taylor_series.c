#include<stdio.h>

float expo(int x, int n){
    static float p = 1, f =1;
    float res;
    if(n==0) return 1;
    else  {
         res =  expo(x, n-1);
         p = p*x;
         f = f*n;
         return res+(p/f);
    }
}

int main(){
    printf("%f ", expo(1,4));
    return 0;
}