#include<stdio.h>
#include<stdlib.h>
#include<math.h>

struct Term{
    int Coeff;
    int Exp;
};

struct Polynomial{
    int n;
    struct Term * t;
};

int main(){
    struct Polynomial p;
    printf("Enter the number of terms:\n");
    scanf("%d",&p.n);

    p.t = (struct Term *)malloc(p.n*sizeof(struct Term));

    printf("Enter the coefficients and exponents\n");
    for(int i = 0; i<p.n; i++){
        printf("For term %d\n", i+1);
        scanf("%d%d",&p.t[i].Coeff,&p.t[i].Exp);
    }

    int x = 5;
    int sum = 0;
    for(int i = 0; i<p.n; i++){
        sum+=p.t[i].Coeff*pow(x,p.t[i].Exp);
    }
    printf("The evaluated value is %d\n",sum);

    return 0;
}