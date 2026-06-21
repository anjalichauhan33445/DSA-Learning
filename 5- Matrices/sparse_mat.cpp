#include<iostream>
using namespace std;

class Element{
   public: 
    int i;
    int j;
    int x;
};
class Sparse{
    private:
        int m;
        int n;
        int num;
        Element *ele;
    
    public:
    Sparse(int m, int n, int num){
        this->m = m;
        this->n = n;
        this->num = num;

        ele = new Element[this->num];
  
    }
    ~Sparse(){delete [] ele;}
    Sparse operator+(Sparse &s);
    friend istream & operator >> (istream &is, Sparse &s);
    friend ostream & operator << (ostream &os, Sparse &s);
};    
    

Sparse Sparse :: operator+(Sparse &s){
    Sparse *sum = new Sparse(m,n,num+s.num);
    if(m!=s.m || n!=s.n){
        throw "Dimensions don't match";
    }
    int i,j,k;
    i = j = k = 0;

    while(i<num && j<s.num){
        if(ele[i].i<s.ele[j].i){
            sum->ele[k++] = ele[i++];
        }
        else if(ele[i].i>s.ele[j].i){
            sum->ele[k++] = s.ele[j++];
        }
        else{
            if(ele[i].j<s.ele[j].j){
                sum->ele[k++] = ele[i++];
            }
            else if(ele[i].j>s.ele[j].j){
                sum->ele[k++] = s.ele[j++];
            }
            else{
                sum->ele[k] = s.ele[i];
                sum->ele[k++].x = ele[i++].x + s.ele[j++].x;
            }
        }
    }
    for(; i<num; i++) sum->ele[k++] = ele[i];
    for(; j<s.num; j++) sum->ele[k++] = s.ele[j];

    sum->num = k;
    return *sum;
}

istream & operator >> (istream &is, Sparse &s){
    printf("Enter the data for each element\n");
    for(int i = 0; i<s.num; i++){
        cin>>s.ele[i].i>>s.ele[i].j>>s.ele[i].x;
    }
    return is;
}

ostream & operator << (ostream &os, Sparse &s){
    int k = 0;
    for(int i = 0 ; i<s.m; i++){
        for(int j = 0;j<s.n;j++){
            if(k<s.num && s.ele[k].i==i && s.ele[k].j==j){
                cout<<s.ele[k++].x<<" ";
            }
            else{
                printf("0 ");
            }
        }
        printf("\n");
    }
    return os;
}



int main(){
    Sparse s1(5,5,5);
    Sparse s2(5,5,5);
    cout<<"First Matrix\n";
    cin>>s1;
    cout<<s1;

     cout<<"Second Matrix\n";
    cin>>s2;
   
    cout<<s2;

    Sparse sum = s1+s2;
    cout<<"Summed Matrix:\n";
    cout<<sum;
}