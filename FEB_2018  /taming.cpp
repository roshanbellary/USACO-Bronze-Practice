#include <iostream>
#include <vector>
using namespace std;
int minr = 1;
int maxr = 1;
vector<int> a;
int main(){
    freopen("taming.in","r",stdin);
    freopen("taming.out","w",stdout);
    int N;
    cin >> N;
    for (int i=0;i<N;i++){
        int store;
        cin >> store;
        a.push_back(store);
    }
    int temp = 0;
    bool w = true;
    for (int i=0;i<N;i++){
        if (a[i]>=0){
            if (i-a[i]<temp){
                w = false;
                break;
            }else if (i-a[i]>temp){
                minr++;
                maxr+=(i-a[i]-temp);
                temp = i-a[i];
            }
        }
    }
    if (w){
        cout << minr << " " << maxr;
    }else{ cout << "-1";}
    return 0;
}