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

struct Sparse *add(struct Sparse *s1, struct Sparse *s2){
    if(s1->m!= s2->m || s1->n !=s2->n){
        return NULL;
    }
    struct Sparse *sum;
    int i,j,k;
    i = j = k = 0; 
    sum = (struct Sparse*)malloc(sizeof(struct Sparse));
    sum->m = s1->m;
    sum->n = s1->n;
    sum->e = (struct Element *)malloc((s1->num+s2->num)*sizeof(struct Element));

    

    while(i<s1->num && j<s2->num){
        if(s1->e[i].i< s2->e[j].i){
            sum->e[k++] = s1->e[i++];
        }
        else if(s1->e[i].i> s2->e[j].i){
            sum->e[k++] = s2->e[j++];
        }
        else{
            if(s1->e[i].j< s2->e[j].j){
                sum->e[k++] = s1->e[i++];
            }
            else if(s1->e[i].j> s2->e[j].j){
                sum->e[k++] = s2->e[j++];
            }
            else{
                sum->e[k] = s1->e[i];
                sum->e[k++].x = s1->e[i].x + s2->e[j].x;
                i++;
                j++;
            }
        }
    }
    while(i < s1->num)
    sum->e[k++] = s1->e[i++];

    while(j < s2->num)
    sum->e[k++] = s2->e[j++];

    sum->num = k;
    return sum;
}


int main(){
    struct Sparse s1;
    struct Sparse s2;
    
    create(&s1);
    create(&s2);
    display(s1);
    display(s2);

    struct Sparse *res = add(&s1,&s2);
    if(res){
        display(*res);
    }
    else{
        printf("Addition Not Possible\n");
    }
  
}