#include <iostream>
#include <vector>
using namespace std;
int N, M;
vector<vector<int> > l;
vector<bool> v;
vector<int> type;
bool works = true;
int num = 0;
void dfs(int j, int val){
    type[j]=val;
    if (val==2) num++;
    for (int i=0;i<l[j].size();i++){
        if (type[l[j][i]]==val){
            works=false;
            break;
        }else if (type[l[j][i]]==0){
            if (val==2) dfs(l[j][i],1);
            else dfs(l[j][i],2);
        }
    }
}
void dfs2(int j){
    v[j]=true;
    for (int i=0;i<l[j].size();i++){
        if (!v[l[j][i]]){
            dfs2(l[j][i]);
        }
    }
}
int main(){
    freopen("decorate.in","r",stdin);
    freopen("decorate.out","w",stdout);
    cin >> N >> M;
    for (int i=0;i<N;i++){
        l.push_back(vector<int>());
        type.push_back(0);// F=1, J=2
        v.push_back(false);
    }
    for (int i=0;i<M;i++){
        int a, b;
        cin >> a >> b;
        l[a-1].push_back(b-1);
        l[b-1].push_back(a-1);
    }
    vector<int> interesting;
    for (int i=0;i<N;i++){
        if (!v[i]){
            interesting.push_back(i);
            dfs2(i);
        }
    }
    int maximum = 0;
    for (int j=0;j<interesting.size();j++){
        int store1, store2;
        fill(type.begin(),type.end(),0);
        num=0;
        dfs(interesting[j],1);
        store1=num;
        fill(type.begin(),type.end(),0);
        num=0;
        dfs(interesting[j],2);
        store2=num;
        maximum+=max(store1,store2);
    }
    if (!works) cout << -1;
    else cout << maximum;
}