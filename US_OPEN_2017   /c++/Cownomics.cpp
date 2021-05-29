#include <iostream>
#include <string>
#include <vector>
#include <set>
#include <iterator>
using namespace std;
int N, M;
vector<string> s;
vector<string> p;
int counts=0;
void form(){
	for (int j=0;j<M;j++){
		set<string> store1;
		set<string, greater<string> >::iterator itr;
		set<string, greater<string> >::iterator itr2;
		set<string> store2;
		bool works = true;
		for (int i=0;i<N;i++){
			store1.insert(s[i].substr(j,1));
			store2.insert(p[i].substr(j,1));
			for (itr=store1.begin();itr!=store1.end();itr++){
				for (itr2=store2.begin();itr2!=store2.end();itr2++){
					if ((*itr)==(*itr2)){
						works=false;
					}
				}
			}
		}
		if (works){
			counts++;
		}
	}
}
int main() {
	freopen("cownomics.in","r",stdin);
	freopen("cownomics.out","w",stdout);
	cin >> N >> M;
	for (int i=0;i<N;i++){
		string store;
		cin >> store;
		s.push_back(store);
	}
	for (int i=0;i<N;i++){
		string store;
		cin >> store;
		p.push_back(store);
	}
	form();
	cout << counts;
	return 0;
}
