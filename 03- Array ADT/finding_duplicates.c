#include<stdio.h>

int main(){
    int arr[10] = {3,6,8,8,10,12,12,12,15};
    int last_duplicate = 0;
    int H[16] = {0};


    //For printing Duplicates
    for(int i  = 0; i<10; i++){
        if(arr[i]!=last_duplicate && arr[i]==arr[i+1]){
            printf("Duplicate element: %d\n",arr[i]);
            last_duplicate = arr[i];
        }
    }

    //For counting duplicates
    
    for(int i = 0; i<9; i++){
        int count = 1;
        int j = 0;
        if(arr[i]==arr[i+1]) {
             j = i+1;
             while(arr[i]==arr[j]){
                j++;
                count++;
             }
             i = j-1;
             printf("%d appeared %d times\n",arr[i],count);
        }
    }
    


    //METHOD-2:
    printf("\nMethod 2:\n");

    for(int i = 0; i<10; i++){
        H[arr[i]]++;
    }

    for(int i = 0; i<16; i++){
        if(H[i]>1){
            printf("%d appeared %d times\n",i,H[i]);
        }
    }

return 0;
}