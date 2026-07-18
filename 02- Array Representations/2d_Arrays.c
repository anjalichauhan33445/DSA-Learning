#include<stdio.h>
#include<stdlib.h>
 
 int main(){
    // create array in stack
    int arr1[3][4] = {{1,2,3,4},{1,2,3,4},{1,2,3,4}};

    printf("Array 1\n");
    for(int i = 0; i<3 ; i++){
        for(int j = 0 ;j< 4; j++){
            printf("%d ",arr1[i][j]);
        }
        printf("\n");
    }

    // create array of pointers in the stack but actual array of elements in the heap.

    int *arr2[3]; // pointer array of size 3 stored in stack.

    // inside heap
    arr2[0] = (int *)malloc(4*sizeof(int)); 
    arr2[1] = (int *)malloc(4*sizeof(int));
    arr2[2] = (int *)malloc(4*sizeof(int));

    //taking inputs for the array2
    printf("Enter the elements in the array:\n");
    for(int i = 0; i<3 ; i++){
        for(int j = 0 ;j< 4; j++){
            printf("Row: %d Column: %d\n",i+1, j+1);
            scanf("%d",&arr2[i][j]);
        }
    }
    printf("Array 2nd\n");
    for(int i = 0; i<3 ; i++){
        for(int j = 0 ;j< 4; j++){
            printf("%d ",arr2[i][j]);
        }
        printf("\n");
    }


    // create both pointer array and actual array in the heap

    int **arr3 = (int **)malloc(3*sizeof(int *));
    arr3[0] = (int *)malloc(4*sizeof(int)); 
    arr3[1] = (int *)malloc(4*sizeof(int));
    arr3[2] = (int *)malloc(4*sizeof(int));

    printf("Enter the elements in the array:\n");
    for(int i = 0; i<3 ; i++){
        for(int j = 0 ;j< 4; j++){
            printf("Row: %d Column: %d\n",i+1, j+1);
            scanf("%d",&arr3[i][j]);
        }
    }
    printf("Array 3rd\n");
    for(int i = 0; i<3 ; i++){
        for(int j = 0 ;j< 4; j++){
            printf("%d ",arr3[i][j]);
        }
        printf("\n");
    }


    

    return 0;
 }