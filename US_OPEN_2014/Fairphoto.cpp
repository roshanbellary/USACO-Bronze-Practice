#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
class Cow{
    public:
        bool t;
        int x;
};
int N;
vector<Cow> f;
bool sorts(Cow &a, Cow &b){
    return (a.x<b.x);
}
int main(){
    freopen("fairphoto.in","r",stdin);
    freopen("fairphoto.out","w",stdout);
    int area = 0;
    cin >> N;
    int g = 0;
    int h = 0;
    for (int i=0;i<N;i++){
        int a;
        char b;
        Cow store;
        cin >> a >> b;
        store.x=a;
        if (b=='G') {store.t=true;g++;} //Gs are true Hs are false
        else {store.t=false; h++;}
        f.push_back(store);
    }
    sort(f.begin(),f.end(),sorts);
    vector<int> dpg(N);
    vector<int> dph(N);
    int count = 0;
    int num = 0;
    for (int i=0;i<N;i++){
        if (f[i].t){
            if (i!=0) {
                dpg[i]=dpg[i-1]+1;
                dph[i]=dph[i-1];
            }
            else {
                dpg[0]=1;
                dph[0]=0;
            }
        }else{
            if (i!=0) {
               dph[i]=dph[i-1]+1;
               dpg[i]=dpg[i-1];
            }
           else {
               dph[0]=1;
               dpg[0]=0;
           }
        }
    }
    int maximum = 0;
    for (int i=0;i<N;i++){
        if (f[i].t) continue;
        int val = dpg[i];
        int j=i+1;
        while (j<N){
            if (dpg[j]==val){
                j++;
            }else{
                break;
            }
        }
        maximum=max(maximum,f[j-1].x-f[i].x);
        i=j-1;
    }
    for (int i=0;i<N;i++){
        if (!f[i].t) continue;
        int val = dph[i];
        int j=i+1;
        while (j<N){
            if (dph[j]==val){
                j++;
            }else{
                break;
            }
        }
        maximum=max(maximum,f[j-1].x-f[i].x);
        i=j-1;
    }
    vector<pair<int,int> > diff(N);
    for (int i=0;i<N;i++){
        int val = dpg[i]-dph[i];
        diff[i]=pair<int,int>(val,i);
    }
    sort(diff.begin(),diff.end());
    for (int i=0;i<N;i++){
        int j=i;
        while (j<N){
            if (diff[j].first<=diff[i].first){
                j++;
            }else{
                break;
            }
        }
        if (j==i+1) continue;
        else maximum=max(maximum, f[diff[j-1].second].x-f[diff[i].second+1].x);
        i=j-1;
    }
    cout << maximum;
}