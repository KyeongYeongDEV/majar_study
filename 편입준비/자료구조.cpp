#include<iostream>
#include<algorithm>
#include<stack>
#include<queue>
#include<vector>
#include<math.h>
using namespace std;

int n,m;
int arr[9] = {0,};
int visited[9] = {0,};
vector<int> v;

void dfs(int num, int cnt){
	if(cnt == m){
		for(int i=0; i < m; i++)
			cout << arr[i] << " ";
		cout << "\n";
		return ;
	}

	for(int i= num; i < v.size(); i++){
		arr[cnt] = v[i];
		dfs(i , cnt + 1);
	}
}

int main(){ cout.tie(0);cin.tie(0);ios::sync_with_stdio(0);
	cin >> n >> m;
	for(int i =0; i < n; i++){
		int tmp;
		cin >> tmp;
		v.push_back(tmp);
	}
	sort(v.begin(), v.end());
	dfs(0, 0);
}