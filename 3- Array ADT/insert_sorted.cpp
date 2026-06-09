// Insert an element such that the sorted array remains sorted

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

int Insert(struct Array *arr, int x){
    int i = arr->length-1;
    
    while(arr->A[i] > x){
        arr->A[i+1] = arr->A[i];
        i--;
    }
    arr->A[i+1] = x;
    arr->length++;
    return i+1;
}


int main(){
    Array arr = {{10,20,30,40,50},20,5};

    Display(arr);
    Insert(&arr,35);
    cout<<"After Inserting:\n";
    Display(arr);
    
    
}