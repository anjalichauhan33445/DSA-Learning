#include<iostream>


using namespace std;

void pattern7(int n){
    for(int i = 0; i<n;i++){
        for(int j = n-1-i; j>0;j--){
            cout<<" ";
        }
        for(int k = 0; k<2*i+1; k++){
            cout<<"*";
        }
        for(int l = n-1-i; l>=0; l--){
            cout<<" ";
        }
        cout<<endl;
    }
}

void pattern8(int n){
    for(int i = 0; i<n ;i++){
        for(int j = 0; j<i ; j++ ){
            cout<<" ";
        }
        for(int k = 0; k < 2*(n-i)-1; k++){
            cout<<"*";
        }
        for(int l = 0; l<i ; l++ ){
            cout<<" ";
        }
        cout<<endl;
    }
}

void pattern9(int n){
    for(int i = 0; i<n ;i++){
        for(int j = n-1-i; j>0;j--){
            cout<<" ";
        }
        for(int k = 0; k<2*i+1; k++){
            cout<<"*";
        }
        for(int l = n-1-i; l>=0; l--){
            cout<<" ";
        }
        cout<<endl;
    }
    for(int i = 0; i<n ;i++){
        for(int j = 0; j<i ; j++ ){
            cout<<" ";
        }
        for(int k = 0; k < 2*(n-i)-1; k++){
            cout<<"*";
        }
        for(int l = 0; l<i ; l++ ){
            cout<<" ";
        }
        cout<<endl;
    }
    
}

void pattern10(int n){
    for(int i = 0; i<n ;i++){
        for(int j = 0; j<i+1; j++){
            cout<<"*";
        }
        cout<<endl;
    }
    for(int i = 1; i<n; i++){
        for(int j = i; j<n; j++){
            cout<<"*";
        }
        cout<<endl;
    }
}

void pattern11(int n){
    for(int i = 0; i< n; i++){
        for(int j = 0 ; j<i+1 ;j++){
            if((i+j)%2==0) cout<<"1 ";
            else cout<<"0 ";
        }
        cout<< endl;
    }
}

int main(){
    // pattern7(5);
   
    // pattern8(5);

    // pattern9(5);

    // pattern10(5);
    
    //pattern11(5);


}