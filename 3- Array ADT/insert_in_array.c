#include <stdio.h>

struct Array{
    int A[20];
    int size;
    int length;
};

// Display function
void Display(struct Array arr){
    printf("Elements in the array are:\n");
    for(int i = 0; i < arr.length; i++){
        printf("%d\n", arr.A[i]);
    }
}

// Append or Add function [Inserts at last index]
void Append(struct Array *arr, int x){
    if(arr->length < arr->size){
        arr->A[arr->length] = x;
        arr->length++;
    }
    else{
        printf("The element can't be inserted!\n");
    }
}

// Insert function
void Insert(struct Array *arr, int index, int x){
    if(index >= 0 && index < arr->length){
        for(int i = arr->length; i > index; i--){
            arr->A[i] = arr->A[i - 1];
        }
        arr->A[index] = x;
        arr->length++;
    }
    else{
        printf("Sorry, the element cannot be inserted!\n");
    }
}

int main(){
    struct Array arr = {{10,20,30,40,50},20,5};

    Display(arr);

    
    Insert(&arr, 4, 15);

    Display(arr);

    return 0;
}