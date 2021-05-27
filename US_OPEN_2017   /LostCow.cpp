#include <iostream>
#include <cmath>
using namespace std;
int x,y;
int simulate(){
	int start=x;
	int temp=x;
	int count=0;
	int distance=0;
	if (y>x){
		while (y>=x+pow(-2,count)){
			start=x+pow(-2,count);
			distance+=abs(start-temp);
			temp=start;
			count++;
		}
		distance+=abs(y-temp);
	}
	else{
		while (y<=x+pow(-2,count)){
			start=x+pow(-2,count);
			distance+=abs(start-temp);
			temp=start;
			count++;
		}
		distance+=abs(y-temp);
	}
	return distance;
}
int main() {
	freopen("lostcow.in","r",stdin);
	freopen("lostcow.out","w",stdout);
	cin >> x >> y;
	cout << simulate();
	return 0;
}
