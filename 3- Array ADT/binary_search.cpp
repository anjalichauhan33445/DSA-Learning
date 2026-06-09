#include<iostream>
#include<stdio.h>
using namespace std;

int binarySearch(int arr[],int low, int high,int key){
    int mid = low+(high-low)/2;
    while(low<=high){
        if(arr[mid]==key) return mid;
        else if(arr[mid]<key) low = mid+1;
        else high = mid-1;
        mid = low+(high-low)/2; 
    }return -1;
}

int main(){
    int arr[10] = {10,20,30,40,50,60,70,80,90,100};
    int low = 0;
    int high = 9;

    cout << binarySearch(arr,low,high,20) << "\n";
    return 0;
    
}