#include<stdio.h>


double taylor1(int x, int n){
    double s = 1;
    for(int i = n ;i>0 ;i--){
        s = 1+(x*s/i);
    }
    return s;
}

double taylor2(int x, int n){
    
    static double s = 1;
    if(n==0) return s;
    else{
        s = 1+(x*s/n);
        return taylor2(x, n-1);
    }
}

int main(){
    printf("%lf %lf",taylor1(1,10),taylor2(1,10) );
    return 0;
}