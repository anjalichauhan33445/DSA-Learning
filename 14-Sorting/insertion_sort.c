#include<stdio.h>

int main(){
    int arr[] = {35,11,16,67,25};
    int n = 5;

    for(int i = 1; i<n; i++){
        int j = i-1;
        int x = arr[i];
        while(j>-1 && arr[j]>x){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = x;
    }
    printf("Array after Sorting:\n");
    for(int i = 0; i<n;i++){
        printf("%d ",arr[i]);
    }

    return 0;
}