#include<iostream>
#include<stdio.h>

using namespace std;

struct Array{
int A[20];
int size;
int length;
};

// Display function
void Display(struct Array arr){
    cout<< "Elements in the array are:\n";
    for(int i = 0; i<arr.length; i++){ 
        cout<<arr.A[i]<<"\n";
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
    Array arr = {{10,20,30,40,50},20,5};

    Display(arr);
    cout<< "\n" <<LinearSearch(&arr,50) << "\n";
    Display(arr);
    
    
}