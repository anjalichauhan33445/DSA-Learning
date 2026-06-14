#include<iostream>
#include<stdio.h>
using namespace std;

class Diagonal{
    private:
        int *A;
        int n;
    
    public:
    
    Diagonal(int n);
    void set(int i, int j, int x);
    int get(int i, int j);
    void display();

    ~Diagonal(){delete []A;}

};

Diagonal :: Diagonal(int n){
    this->n = n;
    A = new int[n];

    for(int i = 0; i < n; i++)
        A[i] = 0;
}

void Diagonal :: set(int i, int j, int x){
    if(i==j){
        A[i-1] = x;
    }
}

int Diagonal :: get(int i, int j){
    if(i==j){
        return A[i-1];
    }
    else return 0;
}

void Diagonal :: display(){
    for(int i = 0; i<n; i++){
        for(int j = 0; j<n; j++){
            if(i==j) cout<< A[i]<<" ";
            else cout<< "0 ";
        }
        cout<<endl;
    }
}
int main(){
    Diagonal arr(5);
    arr.set(1,1,1); arr.set(2,2,2); arr.set(3,3,3); arr.set(4,4,4); arr.set(5,5,5);
    cout<<arr.get(2,2);
    cout<<endl;
    arr.display();

}