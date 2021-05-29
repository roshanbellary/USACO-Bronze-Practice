#include <iostream>
#include <cstdio>
using namespace std;
int main() {
	freopen("word.in","r",stdin);
	freopen("word.out","w",stdout);
	int l, c;
	cin >> l >> c;
	int length=0;
	string store;
	cin >> store;
	cout << store;
	length+=store.length();
	for (int i=1;i<l;i++){
		cin >> store;
		length+=store.length();
		if (length>c){
			length=store.length();
			cout << "\n"<<store;
		}else{
			cout << " " << store;
		}
	}
	return 0;
}
