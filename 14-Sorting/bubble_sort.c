#include<stdio.h>


int main(){
    int arr[] = {30,20,10,60,40};
    int n = 5;
    int flag;
    for(int i = 0; i<n-1; i++){
        int flag = 0;
        for(int j = 0; j<n-1-i; j++){
            if(arr[j]>arr[j+1]){
                flag = 1;
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
        if(flag==0) break;
    }

    printf("Array after Sorting:\n");
    for(int i = 0; i<n;i++){
        printf("%d ",arr[i]);
    }

    return 0;
}