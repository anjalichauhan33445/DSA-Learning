#include<iostream>
#include<stdio.h>

using namespace std;

class UpperTriangularMatrix{
    private:
        int *A;
        int n;

    public:
        UpperTriangularMatrix(int n);
        void set(int i,int j, int x);
        int get(int i, int j);
        void display();

        ~UpperTriangularMatrix(){delete []A;}

};

UpperTriangularMatrix :: UpperTriangularMatrix(int n){
    this->n = n;
    int size = n*(n+1)/2;
    A = new int[size];
    for(int i = 0; i<size; i++) 
        A[i] = 0;
}
void UpperTriangularMatrix :: set(int i, int j, int x){
    if(i>=j){
        int index = (i*(i-1)/2) + j-1;
        A[index] = x;
    }
}

int UpperTriangularMatrix :: get(int i , int j){
     if(i>=j){
        int index = (i*(i-1)/2) + j-1;
        return A[index];
    }
    return 0;
}


void UpperTriangularMatrix :: display(){
    for(int i = 1; i<=n; i++){
        for(int j = 1; j<=n; j++){
            if(i>=j){
                cout<<get(i,j)<<" ";
            }
            else cout<< "0 ";
        }
        cout<<endl;
    }
}

int main(){
    int n;
    cout<<"Enter the size of matrix\n";
    cin>>n;
    UpperTriangularMatrix arr(n);
    int x;
    for(int i = 1; i<=n; i++){
        for(int j = 1; j<=n; j++){
            printf("Enter the %d %d element\n",i,j);
            cin>>x;
            arr.set(i,j,x);
        }
    }
    arr.display();

    return 0;
}