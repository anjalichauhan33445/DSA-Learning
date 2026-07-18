#include<stdio.h>

int main(){
    char s[] = "Anjali";
    int i = 0;
    int length = 0;
    while(s[i]!='\0'){
        i++;
    }
    length = i;
    printf("The length of the array is %d ",length);
    return 0;
}