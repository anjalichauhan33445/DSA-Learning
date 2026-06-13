#include<stdio.h>


int main(){
    //Sorted: Arrays of natural numbers
    int arr1[11] = {1,2,3,4,5,6,8,9,10,11,12};

    //Sorted: Array is not sequence of natural numbers
    int arr2[11] = {6,7,8,9,10,11,13,14,15,16,17};

    //Sorted: Array with Multiple missing elements
    int arr3[11] = {6,7,8,9,11,12,15,16,17,18,19};

    //Unsorted array
    int arr4[10] = {3,7,4,9,12,6,1,11,2,10};
    int H[13] = {0};

    //Array 1:
    //sum of natural numbers: n(n+1)/2
    int n = 12;
    int s = n*(n+1)/2;
    int sum = 0;
   

    printf("Array 1:\n");
    for(int i = 0; i<11; i++){
        sum+=arr1[i];
    }

    int num = s-sum;
    printf("The missing number is %d\n",num);

    //Array 2:
    int l = 6;
    int diff = 6;

    printf("\nArray 2:\n");
    for(int i = 0; i<11; i++){
        if(arr2[i]-i!=diff){
            printf("The missing element is %d\n",i+diff);
            diff++;
            break;
        }
    }


    int diff2 = 6;

    printf("\nArray 3:\n");
    for(int i = 0; i<11; i++){
        if(arr3[i]-i!=diff2){
            while(diff2<(arr3[i]-i)){
                printf("The missing Element is: %d\n",i+diff2);
                diff2++;
            }
        }
    }


printf("\nArray 4:\n");
for(int i = 0; i<10; i++){
    H[arr4[i]]++;
}

for(int i = 1; i<13; i++){
    if(H[i]==0){
        printf("Element Missing: %d\n",i);
    }
}





    
    return 0;
}