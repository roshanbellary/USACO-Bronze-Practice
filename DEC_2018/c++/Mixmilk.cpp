#include <iostream>
using namespace std;
int m[3];
int c[3];
void pour(int i, int j){
    if (c[j]-m[j]>=m[i]){
        m[j]+=m[i];
        m[i]=0;
    }else{
        m[i]-=(c[j]-m[j]);
        m[j]=c[j];
    }
}
int main(){
    freopen("mixmilk.in","r",stdin);
    freopen("mixmilk.out","w",stdout);
    for (int i=0;i<3;i++){
        int store;
        cin >> store;
        c[i] = store;
        cin >> store;
        m[i] = store;
    }
    for (int i=0;i<33;i++){
        pour(0,1);
        pour(1,2);
        pour(2,0);
    }
    pour(0,1);
    cout << m[0] << "\n";
    cout << m[1] << "\n";
    cout << m[2] << "\n";
    return 0;
}