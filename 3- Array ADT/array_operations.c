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

int binarySearch(int arr[], int low, int high, int key){
    

    while(low <= high){
        int mid = low + (high - low) / 2;
        if(arr[mid] == key)
            return mid;
        else if(arr[mid] < key)
            low = mid + 1;
        else
            high = mid - 1;

        mid = low + (high - low) / 2;
    }

    return -1;
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

void Append(struct Array *arr, int x){
    if(arr->length < arr->size){
        arr->A[arr->length] = x;
        arr->length++;
    }
    else{
        printf("The element can't be inserted!\n");
    }
}

struct Array *Merge(struct Array *arr1, struct Array *arr2){
   struct Array *arr3 = (struct Array *)malloc(sizeof(struct Array));

   int i,j,k;
   i = j = k = 0;

   while(i<arr1->length && j<arr2->length){
    if(arr1->A[i]<arr2->A[j]){
        arr3->A[k++] = arr1->A[i++];
    }
    else{
        arr3->A[k++] = arr2->A[j++];
    }
   }

   for(; i<arr1->length;i++){
    arr3->A[k++] = arr1->A[i];
   }

   for(; j<arr2->length;j++){
    arr3->A[k++] = arr2->A[j];
   }

   arr3->length = arr1->length + arr2->length;
   arr3->size = 20;
   return arr3;
}


void Reverse(struct Array *arr){

    for(int i = 0, j = arr->length-1; i<j; i++,j--){
        int temp = arr->A[i];
        arr->A[i] = arr->A[j];
        arr->A[j] = temp;
    }
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