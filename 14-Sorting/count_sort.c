#include<stdio.h>
#include<stdlib.h>

int* countSort(int arr[], int n){
    int max = 0;
    int *ans = (int *)malloc(n * sizeof(int));
    for(int i = 0; i<n;i++){
        if(arr[i]>max) max = arr[i];
    }
    int freq[max+1];
    for(int i = 0; i<max+1;i++){
        freq[i] = 0;
    }

    for(int i = 0; i<n;i++){
        freq[arr[i]]++;
    }
    int i =0;
    int j = 0;
    while(i<max+1){
        if(freq[i]!=0){
            ans[j++] = i;
            freq[i]--;
        }
        else{
            i++;
        }
    }
    return ans;

}
int main(){
    int arr[] = {30,20,10,60,40};
    int n = 5;

    int *ans = countSort(arr,n);
    printf("Array after Sorting:\n");
    for(int i = 0; i<n;i++){
        printf("%d ",ans[i]);
    }
    return 0;
}