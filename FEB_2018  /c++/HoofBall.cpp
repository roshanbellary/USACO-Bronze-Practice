#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main(){
    int N;
    freopen("hoofball.in","r",stdin);
    freopen("hoofball.out","w",stdout);
    cin >> N;
    int c[N];
    for (int i=0;i<N;i++){
        cin >> c[i];
    }
    sort(c, c+N);
    int p[N];
    int count = 1;
    p[0]=1;
    p[N-1]=N-2;
    for (int i=1;i<N-1;i++){
        if ((c[i+1]-c[i])<(c[i]-c[i-1])){
            p[i]=i+1;
        }else{
            p[i]=i-1;
        }
    }
    for (int i=0;i<N-1;i++){
        if ((p[i]==i+1)&&(p[i+1]==i)){
            if (i!=0){
                count++;
            }
        }
    }
    
    cout << count;
    return 0;
}