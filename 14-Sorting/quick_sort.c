#include<stdio.h>
#include<limits.h>


void Swap(int *i,int *j){
    int temp = *i;
    *i = *j;
    *j = temp;
}
int partition(int A[], int l, int h){
    int i = l,j = h;
    int pivot = A[l];

    do{
        do{
            i++;
        }while(A[i]<=pivot);

        do{
            j--;
        }while(A[j]>pivot);

        if(i<j){
            Swap(&A[i],&A[j]);
        }
    }
    while(i<j);
    Swap(&A[l],&A[j]);
    return j;
}


void QuickSort(int A[], int l, int h){
    int j;
    if(l<h){
        j = partition(A,l,h);
        QuickSort(A,l,j);
        QuickSort(A,j+1,h);
    }
}
int main(){
    int arr[] = {90,34,67,12,57,23,456,2,89,3,67,90,35,INT_MAX}, n= 13;
    QuickSort(arr,0,n);
    printf("The array After Sorting:\n");
    for(int i = 0; i<n;i++){
        printf("%d ",arr[i]);
    }
    return 0;
}