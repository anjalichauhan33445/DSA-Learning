#include<stdio.h>

int main(){
    int arr[10] = {8,3,6,4,6,5,8,2,6,7};
    int arr1[10] = {8,3,6,4,6,5,8,2,6,7};
    //Method-1
    int n = 10;
    int H[9] = {0};
    

    for(int i = 0; i<n-1; i++){
        int count = 1;
        for(int j = i+1; j<n; j++){
            if(arr[i]==arr[j] && arr[i]!=-1){
                count++;
                arr[j] = -1;
            }
        }
        if(count>1) printf("%d appeared %d times\n", arr[i],count);
    }

    //Method-2
    printf("\nMethod 2\n");
    for(int i = 0; i<n; i++){
        H[arr1[i]]++;
    }

    for(int i = 0; i<9; i++){
        if(H[i]>1){
            printf("%d appeared %d times\n",i,H[i]);
        }
    }

    return 0;
} 