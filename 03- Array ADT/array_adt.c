#include <stdio.h>
#include <stdlib.h>

struct Array{
    int *A;
    int size;
    int length;
};

void Display(struct Array arr){
    printf("The elements in the array are:\n");
    for(int i = 0; i < arr.length; i++){
        printf("%d ", arr.A[i]);
    }
}

int main(){
    struct Array arr;
    int n;

    printf("Enter the size of the array\n");
    scanf("%d", &n);

    arr.size = n;
    arr.A = (int *)malloc(n * sizeof(int));
    arr.length = 0;

    printf("Enter the elements in the array\n");

    for(int i = 0; i < n; i++){
        scanf("%d", &arr.A[i]);
    }

    arr.length = n;

    Display(arr);

    free(arr.A);

    return 0;
}