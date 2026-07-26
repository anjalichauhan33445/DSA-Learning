#include<stdio.h>

int main(){
     int arr[] = {35,11,16,67,25};
    int n = 5;

    for(int i = 0; i<n; i++){
        int j,k;
        for(j = k = i; j<n;j++){
            if(arr[j]<arr[k]){
                k = j;
            }
        }
        int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }

    printf("Array after Sorting:\n");
    for(int i = 0; i<n;i++){
        printf("%d ",arr[i]);
    }
    return 0;
}