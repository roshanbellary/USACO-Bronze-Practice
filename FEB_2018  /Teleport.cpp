#include <iostream>
using namespace std;
int main(){
    freopen("teleport.in","r",stdin);
    freopen("teleport.out","w",stdout);
    int a,b,c,d;
    cin >> a >> b >> c >> d;
    int distance = abs(b-a);
    if ((abs(a-c)+abs(b-d))<distance){
        distance=abs(a-c)+abs(b-d);
    }
    if ((abs(a-d)+abs(b-c))<distance){
        distance=abs(a-d)+abs(b-c);
    }
    cout << distance;
}