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

struct Array *Merge(struct Array *arr1, struct Array *arr2){
   Array *arr3 = new Array();

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

int main(){
    Array arr1 = {{10,20,30,40,50},10,5};
    Array arr2 = {{60,70,80,90,100},10,5};
    Array *arr3 = Merge(&arr1, &arr2);
    Display(*arr3);
    



    
    
    
}