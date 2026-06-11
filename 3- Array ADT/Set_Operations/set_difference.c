#include<stdio.h>
#include<stdlib.h>

struct Array{
    int A[20];
    int size;
    int length;
};

void Display(struct Array arr){
    printf("The elements in the array are:\n");
    for(int i = 0; i < arr.length; i++){
        printf("%d ", arr.A[i]);
    }
}

//Method 1
struct Array * Set_Difference1(struct Array *arr1, struct Array *arr2){
    struct Array *arr3;
    arr3 = (struct Array*)malloc(sizeof(struct Array));

    arr3->size = arr1->length+arr2->length;
    arr3->length = 0;

    for(int i = 0; i<arr1->length; i++){
        int check = 1;
        for(int j = 0; j<arr2->length; j++){
            if(arr1->A[i]==arr2->A[j]){
                check = 0;
            }
        }
        if(check ==1){
            arr3->A[arr3->length++] = arr1->A[i];
        }
    }
    return arr3;
}


//Method-2 O(m+n)
struct Array *Set_Difference2(struct Array *arr1, struct Array *arr2){
    struct Array *arr3;
    arr3 = (struct Array*)malloc(sizeof(struct Array));

    arr3->size = arr1->length+arr2->length;
    arr3->length = 0;
    int i,j,k;
    i = j = k = 0;
    while(i<arr1->length && j<arr2->length){
        if(arr1->A[i]<arr2->A[j]) arr3->A[k++] = arr1->A[i++];
        else if(arr2->A[j]<arr1->A[i]) j++;
        else{
            i++;
            j++;
        }
    }
    for(;i<arr1->length; i++){
        arr3->A[k++] = arr1->A[i];
    }

    arr3->length = k;
    return arr3;
    
}

int main(){
    struct Array arr1 = {{10,20,30,40,50},20,5};
    struct Array arr2 = {{40,50,60,70,80},20,5};

    struct Array *arr3 = Set_Difference2(&arr1, &arr2);
    Display(*arr3);
    return 0;
}