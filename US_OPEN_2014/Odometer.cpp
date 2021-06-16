#include <iostream>
#include <string>
using namespace std;
int X,Y;
int main(){
    freopen("odometer.in","r",stdin);
    freopen("odometer.out","w",stdout);
    cin >> X >> Y;
    long nums = 0;
    for (int s=1;s<=17;s++){
        for (int d=1;d<10;d++){
            for (int i=1;i<=s;i++){
                string store="";
                for (int j=0;j<i;j++){
                    store+=to_string(d);
                }
                for (int z=i;z<s;z++){
                    store+=to_string(0);
                }
                for (int a=0;a<store.length();a++){
                    if (store.substr(a,1)!="0"){
                        int num = store[a]-'0';
                        for (int j=0;j<num;j++){
                            string store2=store;
                            store2=store2.substr(0,a)+to_string(num)+store2.substr(a+1);
                            if (store2.length()>0){
                                long long store3=stol(store2);
                                if ((store3>=X)&&(store3<=Y)) {nums++; cout << store3 << " 1 " << endl;}
                            }
                        }
                    }else{
                        for (int j=1;j<9;j++){
                            string store2=store;
                            store2=store2.substr(0,a)+to_string(j)+store2.substr(a+1);
                            if (store2.length()>0){
                                long long store3=stol(store2);
                                if ((store3>=X)&&(store3<=Y)) {nums++; cout << store3 <<" 2 "<< endl;}
                            }
                        }
                        break;
                    }
                }
            }
        }
    }
    cout << nums;
}