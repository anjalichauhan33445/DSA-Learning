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

int evaluate(struct Polynomial p, int x){
    int sum = 0;
    for(int i = 0; i<p.n; i++){
        sum += p.t[i].Coeff*(int)pow(x,p.t[i].Exp);
    }
    return sum;
}

struct Polynomial create(int n){
    struct Polynomial p;
    p.n = n;
    p.t = (struct Term *)malloc(p.n*sizeof(struct Term));

    printf("Enter the coefficients and exponents\n");
    for(int i = 0; i<p.n; i++){
        printf("For term %d\n", i+1);
        scanf("%d%d",&p.t[i].Coeff,&p.t[i].Exp);
    }
    return p;
}

struct Polynomial * add(struct Polynomial p1, struct Polynomial p2){
    struct Polynomial *p3;
    p3 = (struct Polynomial *)malloc(sizeof(struct Polynomial));

    p3->n = p1.n+p2.n;
    p3->t = (struct Term*)malloc(p3->n*sizeof(struct Term));
    int i,j,k;
    i = j = k = 0;
    
    while(i<p1.n && j<p2.n){
        if(p1.t[i].Exp>p2.t[j].Exp){
            p3->t[k++] = p1.t[i++];
        }
        else if(p1.t[i].Exp< p2.t[j].Exp){
            p3->t[k++] = p2.t[j++];
        }
        else{
            p3->t[k].Exp = p1.t[i].Exp;
            p3->t[k++].Coeff = p1.t[i++].Coeff+ p2.t[j++].Coeff; 
        }

        
    }
    for(;i<p1.n; i++){
        p3->t[k++] = p1.t[i];
    }
    for(;j<p2.n; j++){
        p3->t[k++] = p2.t[j];
    }
    p3->n = k;
    return p3;
}

void display(struct Polynomial p){
    for(int i = 0; i < p.n; i++){
        printf("%dx^%d", p.t[i].Coeff, p.t[i].Exp);

        if(i != p.n - 1)
            printf(" + ");
    }
    printf("\n");
}
int main(){
    printf("Enter the number of terms for polynomial 1:\n");
    int n,m;
    scanf("%d",&n);
    struct Polynomial p1 = create(n);
    printf("Enter the number of terms for poynomial 2:\n");
    scanf("%d",&m);
    struct Polynomial p2 = create(m);

    struct Polynomial *res = add(p1,p2);
    
    display(*res);


    free(p1.t);
    free(p2.t);
    free(res->t);
    free(res);
    return 0;
}