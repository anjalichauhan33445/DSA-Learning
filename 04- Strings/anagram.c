#include<stdio.h>
#include<stdbool.h>


void toLower(char *s){

    for(int i = 0; s[i]!='\0'; i++){
        if(s[i]>=65 && s[i]<=90) s[i] = s[i]+32;
    }

}

int length(char *s){
    int length = 0;
    for(int i = 0; s[i]!='\0';i++){
        length++;
    }
    return length;
}

bool isAnagram(char *s1, char *s2){
    
    int H[26] = {0};

    if(length(s1)!=length(s2)) return false;
    toLower(s1);
    toLower(s2);

    for(int i = 0; s1[i]!='\0';i++){
        H[s1[i]-'a']++;
    }
    for(int i = 0; s2[i]!='\0';i++){
        H[s2[i]-'a']--;
        if(H[s2[i]-'a']<0) return false; 
    }
    return true;
}

int main(){
    char s1[] = "icecream";
    char s2[] = "icecream";
    if(isAnagram(s1,s2)){
        printf("yeah");
    }
    else printf("NAh");
    return 0;
}