#include<stdio.h>
#include<limits.h>

void Swap(int *i, int *j){
    int temp = *i;
    *i = *j;
    *j = temp;
}

int Partition(int arr[], int low, int high){
    int i = low;
    int j = high;
    int p = arr[low];

    while(i<j){
        while(i<=high && arr[i]<=p){
            i++;
        }
        while(j>=low && arr[j]>p){
            j--;
        }
        if(i<j)
        {
            Swap(&arr[i],&arr[j]);
        }
        
    }
    Swap(&arr[j],&arr[low]);
    return j;
}

void QuickSort(int arr[], int low, int high){
    if(low<high){
        int pivot = Partition(arr,low,high);
        QuickSort(arr,low,pivot-1);
        QuickSort(arr,pivot+1,high);

    }
}

int main(){
    int arr[] = {90,34,67,12,57,23,456,2,89,3,67,90,35}, n= 13;
    QuickSort(arr,0,n-1);
    printf("The array After Sorting:\n");
    for(int i = 0; i<n;i++){
        printf("%d ",arr[i]);
    }
    return 0;
}