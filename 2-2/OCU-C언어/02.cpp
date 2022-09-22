#include <stdio.h>

int main()
{
    int gram = 0;            // gram 수를 입력 받아 줄 변수, 입력과 동시에 초기화
    float Kg = 0;            // gram을 Kg으로 변환한 후 저장해 줄 변수
    short int Change_Kg = 0; //환산값을 대입 받는 변수
    scanf("%d", &gram);      // short int를 받아주기 위해 서식문자 "%hd" 사용

    Kg = gram * 0.001; // gram을 Kg으로 변환

    printf("%d g = %.3f kg\n", gram, Kg);
    /*
     입력 받은 gram과 Kg으로 변환한 수를 소수점 3자리수로 출력
     "gram"이 "short int"형이기 때문에 "%lf"로 값을 출력할 시 경고가 발생합니다.
     그렇게 때문에 명시적으로 형변환을 해주면 이 문제를 해결할 수 있습니다.
     */

    Change_Kg = Kg;

    printf("Kg: %lf\tChange_Kg: %lf", Kg, (double)Change_Kg);
    /*
     short int 형을 long float형으로 출력을 하려고 했기 때문에 출력이 불가합니다.
     이 같은 경우도 명시적 형변환을 통해 해결할 수 있습니다.
     값의 소수점이 잘리는 이유는 값을 Change_Kg 변수에 저장을 할 때 실수형이 정수형으로 바이트가 줄어들면서
     데이터 손실이 일어났기 때문입니다.
     */

    return 0;
}