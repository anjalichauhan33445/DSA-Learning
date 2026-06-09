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
    cout<< "\nElements in the array are:\n";
    for(int i = 0; i<arr.length; i++){ 
        cout<<arr.A[i]<<"\n";
    }
}

int Get(struct Array arr, int index){
    if(index>=0 && index< arr.length){
        return arr.A[index];
    }
    return -1;
}

void set(struct Array *arr, int index, int item){
    if(index>=0 && index< arr->length){
        arr->A[index] = item;
    }
}

int avg(struct Array arr){
    int sum = 0;
    for(int i = 0; i<arr.length; i++){
        sum+=arr.A[i];
    }
    return sum/(arr.length);
}

int max(struct Array arr){
    int max = arr.A[0];
    for(int i = 0; i<arr.length; i++){
        if(arr.A[i]>max) max = arr.A[i];
    }
    return max;
}

int min(struct Array arr){
    int min = arr.A[0];
    for(int i = 0; i<arr.length; i++){
        if(arr.A[i]<min) min = arr.A[i];
    }
    return min;
}

int main(){
    Array arr = {{10,20,30,40,50},20,5};

    Display(arr);
    cout<< "Element at index 2 is:\n";
    cout<<(Get(arr,2))<<"\n";

    set(&arr,2,100);

    cout<< "\nThe updated array after setting element at index 2 as 100-";
    Display(arr);

    cout<<"The maximum element in the array is: \n";
    cout<< max(arr)<<"\n";
    cout<<"The minimum element in the array is: \n";
    cout<< min(arr)<<"\n";

    cout<<"The average of the array is : \n";
    cout<<(avg(arr))<<"\n";

   
    
    
    
}