#include<stdio.h>
 
//문제 1
// int main(){
//     int var =1; //4byte 크기의 정수형 변수 var를 선언 및 숫자 1로 초기화한다.
//     //int car =1 //세미 콜론은 안 적어줬기 때문에 컴파일러가 이 줄이 끝났는지 인식하지 못하기 때문에 오류가 발생합니다.
//     if(car = var-1) //조건문으로 같은지를 확인할 때 부등호를 하나만 쓰는 것이 아니라 "=="과 같이 써주어야 한다.
//         printf('YES');//문자열을 출력하려면 큰따옴표(")로 받아줘야 한다. 작은 따옴표는 문자를 다룰 때 사용한다.
//     else   
//         printf('NO')
// }

//문제2

int main(){
    int number =0;  //정수를 입력 받을 정수형 변수 하나를 선언 및 초기화
    printf("정수를 입력해 주세요 >> ");
    scanf("%d",&number); //선언한 정수형 변수에 정수 하나를 입력 받는다.

    if(number % 2 == 0){// 만약 입력 받은 값이 짝수이면 다음을 출력
        //변수를 2로 나누었을 때 나머지가 0이라면 그 정수는 짝수이다
        //이 방법으로 정수가 홀수인지 짝수인지 알 수 있다.
        printf("정수 %d은(는) 짝수임",number);
    }
    else{//입력 받은 값이 홀수이면 다음을 출력
        printf("정수 %d은(는) 홀수임",number);
    }
}