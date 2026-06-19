#include<iostream>
#include<stdio.h>
using namespace std;

class Symmetric{
    private:
        int *A;
        int n;
    
    public:
    
    Symmetric(int n);
    void set(int i, int j, int x);
    int get(int i, int j);
    void display();

    ~Symmetric(){delete []A;}

};

Symmetric :: Symmetric(int n){
    this->n = n;
    int size = n*(n+1)/2;
    A = new int[size];

    for(int i = 0; i < size; i++)
        A[i] = 0;
}

void Symmetric :: set(int i, int j, int x){
    if(i>=j){
        A[i*(i-1)/2 + (j-1)] = x;
    }
    else{
        A[j*(j-1)/2 + (i-1)] = x;
    }
}


int Symmetric :: get(int i, int j){
    if(i>=j){
        return A[i*(i-1)/2 + (j-1)];
    }
    else {
        return A[j*(j-1)/2 + (i-1)];
    }
}

void Symmetric :: display(){
    for(int i = 1; i<=n; i++){
        for(int j = 1; j<=n; j++){
            cout<<get(i,j)<<" ";
        }
        cout<<endl;
    }
}
int main(){
    cout<<"Enter the size of the array:\n";
    int n;
    cin>>n;
    Symmetric arr(n);
    cout<<"Enter lower triangulr matrix\n";

    for(int i = 1; i<=n; i++){
        for(int j = 1; j<=i; j++){
            int x;
            cin>>x;
            arr.set(i,j,x);
        }
    }
    cout<<endl;
    arr.display();

}