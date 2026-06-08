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

int Delete(struct Array *arr, int index){
    int x = 0;
    if(index>=0 && index < arr->length){
         x = arr->A[index];
        for(int i = index ; i<arr->length-1; i++){
            arr->A[i] = arr->A[i+1]; 
        }
        arr->length--;
        return x;
       
    }
    else{
        cout<< "Sorry, Deletion couldn't be performed!\n";
    }
    return 0;
}


int main(){
    Array arr = {{10,20,30,40,50},20,5};
    

    Display(arr);
    cout<<"The element deleted is : "<<Delete(&arr,4)<< "\n";
    
    Display(arr);

}