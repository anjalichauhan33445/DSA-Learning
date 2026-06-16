#include<stdio.h>

char * toLower(char *s){
     for(int i = 0; s[i]!='\0'; i++){
        if(s[i]>=65 && s[i]<=90) 
            s[i] = s[i]+32;
    }
    return s;
}
    
char * toUpper(char *s){
    for(int i = 0; s[i]!='\0'; i++){
        if(s[i]>=97 && s[i]<=122) 
            s[i] = s[i]-32;
    }
    return s;
}

int main(){
    char str[] = "India Gate";
    printf("%s\n",toLower(str));
    printf("%s\n",toUpper(str));

    return 0;
}