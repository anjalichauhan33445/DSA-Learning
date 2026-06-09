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

void Reverse(struct Array *arr){
    
    for(int i = 0, j = arr->length-1; i<j; i++,j--){
        int temp = arr->A[i];
        arr->A[i] = arr->A[j];
        arr->A[j] = temp;
    }
}


int main(){
    Array arr = {{10,20,30,40,50},20,5};

    Display(arr);

    Reverse(&arr);
    cout<<"\nAfter Reversing\n";
    Display(arr);
    
    
    
    
}