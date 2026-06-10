#include <stdio.h>

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

int Get(struct Array arr, int index){
    if(index >= 0 && index < arr.length){
        return arr.A[index];
    }
    return -1;
}

void set(struct Array *arr, int index, int item){
    if(index >= 0 && index < arr->length){
        arr->A[index] = item;
    }
}

int avg(struct Array arr){
    int sum = 0;
    for(int i = 0; i < arr.length; i++){
        sum += arr.A[i];
    }
    return sum / arr.length;
}

int max(struct Array arr){
    int max = arr.A[0];
    for(int i = 0; i < arr.length; i++){
        if(arr.A[i] > max)
            max = arr.A[i];
    }
    return max;
}

int min(struct Array arr){
    int min = arr.A[0];
    for(int i = 0; i < arr.length; i++){
        if(arr.A[i] < min)
            min = arr.A[i];
    }
    return min;
}

int main(){
    struct Array arr = {{10,20,30,40,50},20,5};

    Display(arr);

    printf("Element at index 2 is:\n");
    printf("%d\n", Get(arr,2));

    set(&arr,2,100);

    printf("\nThe updated array after setting element at index 2 as 100-");
    Display(arr);

    printf("The maximum element in the array is:\n");
    printf("%d\n", max(arr));

    printf("The minimum element in the array is:\n");
    printf("%d\n", min(arr));

    printf("The average of the array is:\n");
    printf("%d\n", avg(arr));

    return 0;
}