#include<iostream>


using namespace std;

void pattern7(int n){
    for(int i = 0; i<n;i++){
        for(int j = n-i-1; j>0;j--){
            cout<<" ";
        }
        for(int j = 0; j<2*i+1; j++){
            cout<<"*";
        }
        for(int j = n-i-1; j>=0; j--){
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
        for(int j = 0; j < 2*(n-i)-1; j++){
            cout<<"*";
        }
        for(int j = 0; j<i ; j++ ){
            cout<<" ";
        }
        cout<<endl;
    }
}

void pattern9(int n){
    for(int i = 0; i<n ;i++){
        for(int j = n-i-1; j>0;j--){
            cout<<" ";
        }
        for(int j = 0; j<2*i+1; j++){
            cout<<"*";
        }
        for(int j = n-1-i; j>=0; j--){
            cout<<" ";
        }
        cout<<endl;
    }
    for(int i = 0; i<n ;i++){
        for(int j = 0; j<i ; j++ ){
            cout<<" ";
        }
        for(int j = 0; j < 2*(n-i)-1; j++){
            cout<<"*";
        }
        for(int j = 0; j<i ; j++ ){
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

void pattern12(int n){
    int spaces = 2*(n-1);
    for(int i = 1; i<=n; i++){
        for(int j = 1; j<=i; j++){
            cout<<j;
        }

        for(int j = 1; j<=spaces; j++){
            cout<<" ";
        }

        for(int j = i; j>=1 ; j--){
            cout<<j;
        }
        cout<<endl;
        spaces-=2;
    }
}

void pattern13(int n){
    int num = 0;
    for(int i = 0; i<n; i++){
        for(int j = 0; j<=i; j++){
            num++;
            cout<<num<<" ";
        }
        cout<<endl;
    }
}

void pattern14(int n){
    
    for(int i = 0; i<n; i++){
       char ch = 'A';
        for(int j = 0; j<=i; j++){
            cout<<char(ch)<<" ";
            ch++;
        }
        cout<<endl;
    }
}

void pattern15(int n){
    
    for(int i = 0; i<n; i++){
        char ch = 'A';
        for(int j = i; j<n; j++){
            cout<<char(ch)<<" ";
            ch++;
        }
        cout<<endl;
    }
}


void pattern16(int n){
    char ch = 'A';
    for(int i = 0; i<n; i++){
        for(int j = 0; j<=i; j++){
            cout<<ch<<" ";
        }
        cout<<endl;
        ch++;
    }
}


void pattern17(int n){
    for(int i = 0; i<n;i++){
        for(int j = n-i-1; j>0;j--){
            cout<<" ";
        }

        char ch = 'A';
        int breakpoint = (2*i+1)/2;
        for(int j = 0; j<2*i+1; j++){
            cout<<ch;
            if(j<breakpoint )ch++;
            else ch--;

            
        }
        for(int j = n-i-1; j>=0; j--){
            cout<<" ";
        }
        cout<<endl;
    }
}


void pattern18(int n){
    
    for(int i=0; i<n; i++){
        for(char ch = 'E'-i;ch<='E'; ch++){
            cout<<ch<<" ";
        }
        cout<<endl;
       }
    }

void pattern19(int n){
    for(int i = 0; i<n ; i++){
        for(int j = 0; j<n-i; j++){
            cout<<"*";
        }
        for(int j = 0; j<2*i; j++){
            cout<<" ";
        }
        for(int j = 0; j<n-i; j++){
            cout<<"*";
        }
        cout<<endl;
    }

    for(int i = 1; i<= n; i++){
        for(int j = 1; j<=i; j++){
            cout<<"*";
        }
        for(int j = 1; j<=2*(n-i); j++){
            cout<<" ";
        }
        for(int j = 1; j<=i; j++){
            cout<<"*";
        }
        cout<<endl;

    }

}


int main(){
    // pattern7(5);
   
    // pattern8(5);

    // pattern9(5);

    // pattern10(5);
    
    //pattern11(5);
    //pattern13(5);
    //pattern16(5);
    //pattern17(4);
    //pattern18(5);
    pattern19(5);


}