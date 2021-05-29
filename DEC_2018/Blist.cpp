#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
class Cow{
    public:
        int s;
        int e;
        int b;
};
vector<Cow> l;
bool comp(Cow const &a, Cow const &b){
    return (b.s>a.s);
}
int main(){
    freopen("blist.in","r",stdin);
    freopen("blist.out","w",stdout);
    int N;
    cin >> N;
    for (int i=0;i<N;i++){
        int s,e,b;
        cin>> s >> e >> b;
        Cow n;
        n.s=s;
        n.e=e;
        n.b=b;
        l.push_back(n);
    }
    sort(l.begin(), l.end(), comp);
    int buckets = 0;
    int time=0;
    int check = 0;
    for (int i=0;i<N;i++){
        time = l[i].s;
        for (int j=i-1;j>check;j++){
            if (l[j].e<time){
                buckets+=l[j].b;
                check=j;
            }
        }
        if (l[i].b>=buckets){
            buckets=0;
        }else{
            buckets-=l[i].b;
        }
    }
    cout << buckets;
}