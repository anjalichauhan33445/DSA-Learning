// program to compare two strings
#include<stdio.h>
#include <stdbool.h>

void toLower(char *s){

    for(int i = 0; s[i]!='\0'; i++){
        if(s[i]>=65 && s[i]<=90) s[i] = s[i]+32;
    }

}

bool comp(char *s1, char *s2){
    int i,j;
    i = j = 0;

    toLower(s1);
    toLower(s2);

    while((s1[i]!='\0' && s2[j]!='\0')){
        if(s1[i]!= s2[j]){
            return false;
        }
        i++;
        j++;
    }
    return true;
}

int main(){
    // lower and upper cases treated as the same :)
    char s1[] = "Pasta";
    char s2[] = "pasta";
    bool result = comp(s1,s2);
    if(result){
        printf("%s and %s are equal\n",s1,s2);
    }
    else printf("%s and %s are not equal\n",s1,s2);
    return 0;
}