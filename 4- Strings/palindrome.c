#include<stdio.h>
#include<stdbool.h>

void toLower(char *s){
   for(int i = 0; s[i]!='\0'; i++){
        if(s[i]>=65 && s[i]<=90){
            s[i] = s[i]+32;
        }
    }
}

bool isPalindrome(char *s){
    int i,j;
    for(j = 0; s[j]!='\0'; j++){}
    j = j-1;
    toLower(s);

    for(int i = 0; i<j; i++,j--){
        if(s[i]!=s[j]) return false;
    }
    return true;
}

int main(){
    char str[] = "madam";
    
    if(isPalindrome(str)) printf("%s is a palindrome\n",str);
    else printf("%s isn't a palindrome\n",str);

    return 0;
}