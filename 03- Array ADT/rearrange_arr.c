#include <stdio.h>
#include<stdlib.h>

struct Array{
    int A[20];
    int size;
    int length;
};

// Display function
void Display(struct Array arr){
    printf("\nElements in the array are:\n");
    for(int i = 0; i < arr.length; i++){
        printf("%d\n", arr.A[i]);
    }
}
void swap(int *x, int * y){
    int temp;
    temp = *x;
    *x = *y;
    *y = temp;

}


void Rearrange(struct Array *arr){
    int i = 0;
    int j = arr->length-1;

    while(i<j){
        while(arr->A[i]<0) i++;
        while(arr->A[j]>=0) j--;

        if(i<j) swap(&arr->A[i],&arr->A[j]);
    }
}



int main(){
    struct Array arr = {{80,-3,30,-40,50},20,5};
    Display(arr);
    Rearrange(&arr);

    Display(arr);


    return 0;
}