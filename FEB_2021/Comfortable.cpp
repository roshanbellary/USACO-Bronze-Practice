#include <cstdio>
#include <iostream>
#include <vector>
using namespace std;
bool board[1000][1000]={};
bool check(int x, int y){
	if (!board[x][y]){
		return false;
	}
	int count=0;
	if (x>0){
		if (board[x-1][y]){
			count++;
		}
	}
	if (x<999){
		if (board[x+1][y]){
			count++;
		}
	}
	if (y>0){
		if (board[x][y-1]){
			count++;
		}
	}
	if (y<999){
		if (board[x][y+1]){
			count++;
		}
	}
	if (count==3){
		return true;
	}else{
		return false;
	}
}
int main(int argc, char **argv) {
	int n;
	cin >> n;
	int count=0;
	for (int i=0;i<n;i++){
		int x;
		cin >> x;
		int y;
		cin >> y;
		int sum=0;
		if (x>0){
			if (check(x-1,y)){sum--;}
		}
		if (x<999){
			if (check(x+1,y)){sum--;}
		}
		if (y>0){
			if (check(x,y-1)){sum--;}
		}
		if (y<999){
			if (check(x,y+1)){sum--;}
		}
		board[x][y]=true;
		if (check(x,y)){
			count++;
		}
		if (x>0){
			if (check(x-1,y)){sum++;}
		}
		if (x<999){
			if (check(x+1,y)){sum++;}
		}
		if (y>0){
			if (check(x,y-1)){sum++;}
		}
		if (y<999){
			if (check(x,y+1)){sum++;}
		}
		count+=sum;
		cout<<count<<"\n";
	}
	return 0;
}
