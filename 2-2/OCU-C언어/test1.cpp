#include<stdio.h> 

int values = 2;
extern sub();

void main() {
    sub();
    printf("%d", values);
}