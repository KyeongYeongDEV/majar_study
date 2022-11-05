#include <stdio.h> // 배열과 포인터의 관계 2
int a[] = { 1, 2, 3, 4, 5 }; // 명칭, 초기값 변경 불가
int *p[] = { a, a+1, a+2, a+3, a+4 }; // 명칭, 수형, 초기값 변경 불가
int **pp = p;
/* (질의 1) 위의 3 개 문장에 의해 정의된 배열 a와 p의 논리적 관계와 
 포인터 pp와 배열 p 논리적 관계를 그림으로 그려서 자세히 설명하라. */
int main(void)
{
    for(int i = 0; i< 4; i++){
        printf("%d", pp[1][i]);
    }
}







// #include<stdio.h>
// #include<string.h>

// int main(){
//     int cnt =0;
//     char get_str[200]={1};

//     gets(get_str);
//     for(int i=0; i< (int)(strlen(get_str)); i++){
//         if(get_str[i] == '\0') break;
//         if(get_str[i] == ' '){
//             for(int j = i-1; j>= cnt;j--){
//                 printf("%c",get_str[j]);
//             }
//             if(cnt==0)printf(" ");
            
//             cnt = i;
//         }
//     }
//     for(int i = (int)(strlen(get_str))-1; i >= cnt+1; i--){
//         printf("%c",get_str[i]);
//     }

// }//I had eggs this morning