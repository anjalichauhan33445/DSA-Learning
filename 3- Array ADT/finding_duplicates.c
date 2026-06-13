#include<stdio.h>

int main(){
    int arr[10] = {3,6,8,8,10,12,12,12,15};
    int last_duplicate = 0;

    for(int i  = 0; i<10; i++){
        if(arr[i]!=last_duplicate && arr[i]==arr[i+1]){
            printf("Duplicate element: %d\n",arr[i]);
            last_duplicate = arr[i];
        }
    }
    return 0;
}