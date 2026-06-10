#include<stdio.h>

struct Array{
int A[20];
int size;
int length;
};

// Display function
void Display(struct Array arr){
    printf("Elements in the array are:\n");
    for(int i = 0; i<arr.length; i++){
        printf("%d\n", arr.A[i]);
    }
}

void swap(int *x, int * y){
    int temp;
    temp = *x;
    *x = *y;
    *y = temp;

}

int LinearSearch(struct Array *arr, int key){
    for(int i = 0; i<arr->length; i++){
        if(arr->A[i]==key){
            // Move to front
            swap(&arr->A[i],&arr->A[0]);
            //swap(&arr->A[i], &arr->A[i-1]); Transposition, However condition must be used for index 0
            return i;
        }
    }
    return -1;
}

int main(){
    struct Array arr = {{10,20,30,40,50},20,5};

    Display(arr);
    printf("\n%d\n", LinearSearch(&arr,50));
    Display(arr);

    return 0;
}