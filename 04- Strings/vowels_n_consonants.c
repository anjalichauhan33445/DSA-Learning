#include<stdio.h>

void countVowelsConsonants(char *s){
    int consonants = 0;
    int vowels = 0;
    for(int i = 0; s[i]!=0; i++){
        if(s[i]=='A'||s[i]=='E' || s[i]=='I' || s[i]=='O'|| s[i]=='U'||s[i]=='a'||s[i]=='e'||s[i]=='i'||s[i]=='o'||s[i]=='u') vowels++;
        else if(s[i]>=65 && s[i]<=90 || s[i]>=90 && s[i]<=122) consonants++;
    }
    printf("The number of vowels in the String are: %d\n",vowels);
    printf("The number of vowels in the Consonants are: %d\n",consonants);
}

int main(){
    char s[] = "Let's try to count vowels and consonants.";
    countVowelsConsonants(s);
    return 0;
}