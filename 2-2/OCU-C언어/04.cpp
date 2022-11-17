#include<stdio.h>
#include<stdlib.h>
#include<time.h>

int getIncome(){ //첫 연봉
    int first_income=0;
    scanf("%d",&first_income);

    return first_income;
}

float getRate(float income){
    srand(time(0));
    int rate =  rand()%5+1; //랜덤값 1~5
    income += income * rate /100; //물가 인상률 계산 및 적용

    return income; 
}

void calcIncomeTax(float income, int year){
    //실수령액 계산 및 출력
    // 연봉 - 근로소득세액
    float tax =0;
    //조건문으로 연봉에 따른 세금을 계산해준다.
    if(income <=1000){//1000만원 이하이다
        tax = income *0.08;
    }
    else if(income <=4000){ //1000만원 초과 4000만원 이하
        tax = 1000 * 0.08 + (income-1000) * 0.17;
    }
    else if(income <= 8000){ //4000 초과 8000이하
        tax = 1000 * 0.08 + (4000-1000) * 0.17 + (income-4000) *0.26;
    }
    else{ //8000 초과
        tax = 1000 * 0.08 + (4000-1000) * 0.17 + (8000-4000) *0.26+ (income-8000)*0.35;
    }
    printf("%d년 연봉 : %.0lf\t세금 : %.0lf\t",year+1,income,tax);
    printf("%d년 실질 수령액 : %.0lf\n", year+1,income-tax);//소수점 자리는 출력하지 않는다.
}

int main(){
    float income=0.0; // 

    for(int i=0; i< 5; i++){
        //임의의 5명에 대한 30년간 임금과 세금을 계산하고 출력함
        printf("%d번째 임원의 초봉 입력 : ",i+1);
        income = getIncome(); //첫 해의 연봉을 입력 받음
        for(int year =0; year <30; year++){
            //30년간 임금과 세금을 년도 별로 계산함
            //매년 임금과 그에 따른 세금 계산하고 출력
            calcIncomeTax(income,year);
            //다음 해 물가 인상률에 의한 임금 계산
            income = getRate(income);
        }
        printf("\n");
    }
    return 0;
}