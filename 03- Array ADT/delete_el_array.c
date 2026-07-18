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

int Delete(struct Array *arr, int index){
    int x = 0;

    if(index >= 0 && index < arr->length){
        x = arr->A[index];

        for(int i = index; i < arr->length - 1; i++){
            arr->A[i] = arr->A[i + 1];
        }

        arr->length--;
        return x;
    }
    else{
        printf("Sorry, Deletion couldn't be performed!\n");
    }

    return 0;
}

int main(){
    struct Array arr = {{10,20,30,40,50},20,5};

    Display(arr);

    printf("The element deleted is : %d\n", Delete(&arr,4));

    Display(arr);

    return 0;
}