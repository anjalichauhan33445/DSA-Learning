#include<stdio.h>
#include<stdlib.h>
struct Element{
    int i;
    int j;
    int x;
};

struct Sparse{
    int m; 
    int n;
    int num;
    struct Element *e;
};

void create(struct Sparse *s){
    printf("Enter the dimension of the matrix:\n");
    scanf("%d%d", &s->m,&s->n);
    printf("Enter the number of non-zero elements:\n");
    scanf("%d",&s->num);

    s->e = (struct Element *)malloc(s->num*sizeof(struct Element));

    printf("Enter the elements in the array\n");

    for(int i = 0; i<s->num; i++){
        scanf("%d%d%d",&s->e[i].i,&s->e[i].j,&s->e[i].x);
    }
}

void display(struct Sparse s){
    int k = 0;
    for(int i =0; i<s.m; i++){
        for(int j = 0; j<s.n; j++){
            if(k< s.num && i==s.e[k].i && j==s.e[k].j){
                printf("%d ",s.e[k++].x);
            }
            else{
                printf("0 ");
            }
        }
        printf("\n");
    }
}


int main(){
    struct Sparse s;
    create(&s);
    display(s);
    return 0;
}