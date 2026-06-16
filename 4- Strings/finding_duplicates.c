#include<stdio.h>

char * toLower(char *s){
     for(int i = 0; s[i]!='\0'; i++){
        if(s[i]>=65 && s[i]<=90) 
            s[i] = s[i]+32;
    }
    return s;
}

void duplicate1(char *s){
    toLower(s);
    
    for(int i = 0; s[i]!='\0'; i++){
        int count = 1;
        if(s[i]=='*') continue;
        for(int j = i+1; s[j]!='\0'; j++){
            if(s[i]==s[j]){
                count++;
                s[j] = '*';
            }
        }
        if(count>1) printf("%c appeared %d times\n",s[i],count);
        
    }
}

void duplicate2(char *s){
    int H[26] = {0};
    toLower(s);
    for(int i = 0; s[i]!='\0'; i++){
        H[s[i]-97]++;
    }

    for(int i = 0; i<16; i++){
        if(H[i]>1){
            printf("%c appeared %d times\n",i+97,H[i]);
        }
    }
}

int main(){
    char s[] = "Ice Cream";
    //duplicate1(s);
    duplicate2(s);
    return 0;
}