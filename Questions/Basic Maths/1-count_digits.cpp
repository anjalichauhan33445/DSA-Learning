#include<iostream>

using namespace std;

int count_dig1(int num){
    int digit = 0;

    while(num>0){
        digit++;
        num = num/10;
    }
    return digit;
}

int count_dig2(int num){
    return (int)(log10(num)+1);
}
int main(){
    int num = 54682;
    cout<<count_dig1(num)<<endl;
    cout<<count_dig2(num)<<endl;
}