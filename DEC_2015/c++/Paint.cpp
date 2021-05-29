#include <iostream>
using namespace std;
int main() {
	freopen("paint.in","r",stdin);
	freopen("paint.out","w",stdout);
	int a,b,c,d;
	cin >> a >> b;
	cin >> c >> d;
	if (b<c){
		cout << (b-a)+(d-c);
	}else if (c>a){
		if (b<d){
			cout << (d-a);
		}else{
			cout << (b-a);
		}
	}else if (d>a){
		if (b<d){
			cout << (d-c);
		}else{
			cout << (b-c);
		}
	}else{
		cout << (b-a)+(d-c);
	}
	return 0;
}
