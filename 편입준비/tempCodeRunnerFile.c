#include<stdio.h>

int main(){
	int a = 196, b = 162;

	while(a % b != 0){
		int tmp = a % b;
		a = b;
		b = tmp;
	}
	int result = a;

	printf("%d", result);
}