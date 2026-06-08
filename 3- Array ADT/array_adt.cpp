#include<iostream>
#include<stdio.h>

using namespace std;

struct Array{
int *A;
int size;
int length;
};


void Display(struct Array arr){
    cout<< "Elements in the array are:\n";
    for(int i = 0; i<arr.length; i++){ 
        cout<<arr.A[i]<<" ";
    }
}
int main(){
    Array arr;
    int n;
    cout<<"Enter the size of the array\n";
    cin>>n;
    arr.size = n;
    arr.A = new int[n];
    arr.length = 0;

    cout<<"Enter the elements in the array\n";

    for(int i = 0; i < n ; i++){
        cin>>arr.A[i];
    }
    arr.length = n;

    Display(arr);
}