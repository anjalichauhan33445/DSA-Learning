#include<stdio.h>
#include<stdlib.h>
int length(char *s){
    int i = 0;
    int length = 0;
    while(s[i]!='\0'){
        i++;
    }
    length = i;
    return length;
}


//Method - 1

char *reverse1(char *s){
    char *rev_str = (char *)malloc(sizeof(char)*length(s) + 1);

    int i,j;
    i = j = 0;

    while(s[j]!='\0'){
        j++;
    }
    j = j-1;

    for(i = 0; j>=0; i++,j--){
        rev_str[i] = s[j];
    }
    rev_str[i] = '\0';
    return rev_str;
}

//Method - 2
char *reverse2(char *s){
    int j = 0;
    int temp;
    while(s[j]!='\0'){
        j++;
    }
    j = j-1;
    for(int i = 0; i<j; i++,j--){
        temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
    return s;
}

int main(){
    char str[] = "Pasta";
    //char *reversed = reverse1(str);
    //printf("%s\n",reversed);
    // printf("%s",str);

    char *reversed = reverse2(str);
    printf("%s\n",reversed);
    

    return 0;
}