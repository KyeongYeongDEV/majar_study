#include <stdio.h>
int arr[] = { 1, 2, 3, 4, 5 }; // 명칭, 초기값 변경 불가
void main(void)
{
 int inx, *ptr; 
 for(inx = 1; inx < 5; inx++) 
 printf("%d \n", arr[inx]); 

 for(ptr = &arr[1]; ptr <= &arr[4] ; ptr++)
 printf("%d \n", *ptr);

    return 0;
 }



// #include <stdio.h>

// int reset(void); // reset() 함수 원형 선언
// int next(int); // next() 함수 원형 선언
// int index = 1; // 변수의 수형, 이름, 초기값은 수정 불가

// int main()  {
//     int index, jdex; // 변수의 수형, 이름, 초기값은 수정 불가
//     index = reset();
//     for(jdex = 1; jdex <= 3; jdex++)
//     {
//         printf("%d\n", index); //printf를 통해 지역변수 index를 출력
//         next(index);    
//         //지역 변수의 값을 바꾸고 싶으면 파라미터를 넘길 때
//         // 그냥 변수명만 넘기는 것이 아닌 주소값으로 넘겨야 다른 함수에서 수정이 일어나면
//         // 그 주소의 값이 수정되기 때문에 지역변수의 값도 수정되어 있습니다.
//         //하지만 이번 과제의 코드의 경우 함수원형을 수정할 수 없으므로 next()함수로 
//         //지역변수 index의 값은 바꿀 수 없습니다.
//         //값을 더한 수를 출력하고 싶으면 index = next(index); 로 지역변수값을 초기화 시키거나
//         //printf("%d\n", next(index)); 이렇게 출력해야 합니다.
//     }
//     return 0;
// }



// int reset(void){
//  return (index); 
// } 

// int next(int jdx){
//  jdx = ++index; 
//  return jdx;
// }

