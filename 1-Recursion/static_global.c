#include<stdio.h>

/*
Static variables and global are created inside inside 
the code block section of the main memory.
Every method uses the same copy.
*/

// int x = 0; [also produces the same result]
int fun(int n){
    static int x = 0; 
    if(n>0){
        x++;           
        return fun(n-1)+x;
    }
    
    return 0;
}

int main(){
    int num = 5;
    int result = fun(num);
    printf("%d\n",result);

    return 0;
}

// output(result) -> 25 and x-> 5 at the end of the call.