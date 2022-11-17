#include<stdio.h>
#include<stdlib.h>

struct wage {
    long int salary; // 연봉액, 단위는 일원
    int rate; // 임금인상율, 단위는 %
    long int tax; // 세금액, 단위는 일원
    long int net; // 실질임금액, 단위는 일원
};

struct jikwon {
    char name[100]; // 최대 100자의 영문자로 된 이름
    struct wage pays[10]; // 10년간 임금 정보 내포된 구조체
};

int getIncome() { //첫 연봉을 입력 받고 리턴해주는 함수
    int first_income = 0;
    scanf_s("%d", &first_income,sizeof(first_income));

    return first_income;
}

int getRate() {//연봉 인상률을 랜덤으로 받고 리턴해주는 함수
    int rate = (rand() % 7) + 2; //랜덤값 2~8 공통적으로 적용됨
    return rate;
}

void calcIncomeTax(jikwon* jw, int i, int j) { //연봉에 따른 세금을 구해주는 함수
    //조건문으로 연봉에 따른 세금을 계산해준다.
    if (jw[i].pays[j].salary <= 1000) {//1000만원 이하이다
        jw[i].pays[j].tax = jw[i].pays[j].salary * 0.08;
    }
    else if (jw[i].pays[j].salary <= 4000) { //1000만원 초과 4000만원 이하
        jw[i].pays[j].tax = 1000 * 0.08 + (jw[i].pays[j].salary - 1000) * 0.17;
    }
    else if (jw[i].pays[j].salary <= 8000) { //4000 초과 8000이하
        jw[i].pays[j].tax = 1000 * 0.08 + (4000 - 1000) * 0.17 + (jw[i].pays[j].salary - 4000) * 0.26;
    }
    else { //8000 초과
        jw[i].pays[j].tax = 1000 * 0.08 + (4000 - 1000) * 0.17 + (8000 - 4000) * 0.26 + (jw[i].pays[j].salary - 8000) * 0.35;
    }
}

void calcSalary(jikwon* jw, int i, int j) {//세금을 제외한 연봉을 계산해주는 함수
    jw[i].pays[j].net = jw[i].pays[j].salary - jw[i].pays[j].tax; 
    if (j < 9) { //다음 해에 받을 연봉 계산 10년차에는 11년 걸 계산할 필요가 없으므로 10년차까지만 계산
        jw[i].pays[j + 1].salary = jw[i].pays[j].salary + (jw[i].pays[j].salary * jw[i].pays[j].rate * 0.01);
    }
}

void init(jikwon* jw) { //구조체 배열을 초기화해주는 함수
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 10; j++) {
            jw[i].pays[j].net = 0;
            jw[i].pays[j].rate = 0;
            jw[i].pays[j].salary = 0;
            jw[i].pays[j].tax = 0;
        }
    }
}

void Run() { // 기능을 실행 시켜주는 함수
    jikwon* jw = (jikwon*)malloc(sizeof(jikwon) * 5); //직원 5명 구조체 배열 생성
    init(jw);// 구조체 초기화

    for (int i = 0; i < 5; i++) { //직원 5명
        printf("%d번 직원의 이름을 입력하시오", i + 1);
        scanf_s("%s", jw[i].name,sizeof(jw[i].name));
        printf("%s님의 연봉을 입력하시오.(만원)", jw[i].name);
        jw[i].pays[0].salary = getIncome();

        for (int j = 0; j < 10; j++) { //10년간의 세금, 연봉인상률
            calcIncomeTax(jw, i, j); //연봉 별세금 계산
            jw[i].pays[j].rate = getRate(); //연봉 인상률
            calcSalary(jw, i, j); //연봉 계산
        }
    }
    for (int i = 0; i < 5; i++) { //출력
        for (int j = 0; j < 10; j++) {
            if (j == 9) { //10년차의 연봉인상률은 출력하지 않습니다.
                printf("%s님의 %d년차 연봉 : %ld0,000원, 세금: %ld0,000원, 실질임금: %ld0,000원\n\n", jw[i].name, j + 1, jw[i].pays[j].salary, jw[i].pays[j].tax, jw[i].pays[j].net);
            }
            else { 
                printf("%s님의 %d년차 연봉 : %ld0,000원, 세금: %ld0,000원, 실질임금: %ld0,000원, 연봉인상률 %d\%\n", jw[i].name, j + 1, jw[i].pays[j].salary, jw[i].pays[j].tax, jw[i].pays[j].net, jw[i].pays[j].rate);
            }
        }
    }
}

int main() {
    Run();  //실행
    return 0;
}

/*
최경영
1000
김철수
9500
사랑이
4500
윌슨
3800
천인국
8100
*/
