#include<stdio.h>

char *toggleCase(char *s){
    for(int i = 0; s[i]!=0; i++){
        if(s[i]>=65 && s[i]<=90) s[i] = s[i]+32;
        else if(s[i]>=90 && s[i]<=122) s[i] = s[i]-32;
    }
    return s;
}

int main(){
    char str[] = "Anjali Chauhan";
    printf("%s\n",toggleCase(str));
    return 0;
}