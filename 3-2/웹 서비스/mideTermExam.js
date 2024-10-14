// // map 배열의 각각의 값을 변환 새로운 배열을 만들어준다.
// // ex) 집에 4개의 바나나가 있는데, 이걸 바나나우유로 바꾸고 싶어
// const bananas = ['바나나1', '바나나2', '바나나3', '바나나4'];
// const bananaMilk = bananas.map(banana => banana + '우유')
// console.log(bananaMilk)  // [ '바나나1우유', '바나나2우유', '바나나3우유', '바나나4우유' ]

// // filter 배열의 조건에 맞는 값만 골라서 새로운 배열을 만들어준다.
// const fruits = ['바나나', '사과', '바나나', '포도', '바나나'];
// const onlyBananas = fruits.filter(fruit => fruit === '바나나');
// console.log(onlyBananas); // [ '바나나', '바나나', '바나나' ]


// // reduce 함수   배열을 순회하면서 모든 요소를 하나의 값으로 축약합니다. (예: 합계, 곱셈, 평균 등
// /**
//  * array.reduce((accumulator, currentValue, index, array) => { ... }, initialValue);
//     accumulator: 이전 반복에서 누적된 값입니다.
//     currentValue: 현재 순회 중인 배열의 요소입니다.
//     initialValue: 누적 값의 초기값입니다. (선택적)
//     const total = values.reduce((acc, score) => acc + score, 0);
//     시: values 배열이 [85, 78, 88]이라면, reduce()는 다음과 같이 동작합니다:

//     첫 번째 반복:
//     acc = 0, score = 85
//     새로운 acc = 0 + 85 = 85

//     두 번째 반복:
//     acc = 85, score = 78
//     새로운 acc = 85 + 78 = 163

//     세 번째 반복:
//     acc = 163, score = 88
//     새로운 acc = 163 + 88 = 251
//     최종적으로 total 변수에는 값 251이 저장됩니다
//  */


// // map, filter 예제
// // 1. map 숫자 배열 [1, 2, 3, 4, 5]에 각각 2를 곱한 배열을 만들어 보세요.
// const numbers1 = [1, 2, 3, 4, 5];
// const doubled = numbers1.map(number => number * 2);
// console.log(doubled);//[ 2, 4, 6, 8, 10 ]
// // 2. filter 숫자 배열 [10, 15, 20, 25, 30] 중에서 20보다 큰 숫자만 골라내 보세요.
// const numbers2 = [10, 15, 20, 25, 30];
// const biggerThan20 = numbers2.filter(number=> number >= 20);
// console.log(biggerThan20);
// //3. map, filter 배열 [5, 12, 19, 22, 25]에서 20보다 작은 숫자만 고른 다음, 각 숫자에 3을 더한 배열을 만들어 보세요.
// const number3 = [5, 12, 19, 22, 25];
// const smallerThan20 = number3.filter(number => number < 20);
// const plus3 = smallerThan20.map(number => number + 3);
// console.log(plus3);// [8, 15, 22]
// //4. 학생 점수 배열 [75, 85, 95, 65, 70, 55] 중에서 60점 이상인 학생들만 골라내고, 이 학생들의 점수에 5점을 더해 새 배열을 만들어 보세요.
// const number4 = [75, 85, 95, 65, 70, 55];
// const biggerThan60 = number4.filter(number => number >= 60);
// const newScore = biggerThan60.map(score => score + 5 );
// console.log(newScore);// [80, 90, 100, 70, 75]
// //5. 조금 어렵게
// /*
// 학생별 평균 점수를 계산합니다.

// 예를 들어, Alice의 평균 점수는 (85 + 78 + 88) / 3 = 83.67입니다.
// 평균 점수 80 이상인 학생만 필터합니다.

// 필터된 학생들의 각 과목 점수를 모두 제곱한 배열로 변환합니다.

// 예: Alice의 과목 점수는 [85, 78, 88] → [85², 78², 88²] → [7225, 6084, 7744]
// 최종 결과는 다음과 같은 객체 배열 형태로 반환되어야 합니다:
// 
// const students = [
//     { name: "Alice", scores: { math: 85, english: 78, science: 88 } },
//     { name: "Bob", scores: { math: 90, english: 92, science: 87 } },
//     { name: "Charlie", scores: { math: 70, english: 65, science: 60 } },
//     { name: "Dave", scores: { math: 82, english: 81, science: 89 } },
// ];

// // 평균 점수를 계산하는 함수
// function calculateAverage(scores) {
//     const values = Object.values(scores);
//     const total = values.reduce((acc, score) => acc + score, 0);
//     return total / values.length;
// }

// // 문제 해결
// const result = students
//     .filter(student => calculateAverage(student.scores) >= 80) // 평균 점수 80 이상 필터
//     .map(student => ({
//         name: student.name,
//         squaredScores: Object.values(student.scores).map(score => score ** 2)
//     }));

// console.log(result);
// /*
// [
//     { name: 'Alice', squaredScores: [ 7225, 6084, 7744 ] },
//     { name: 'Bob', squaredScores: [ 8100, 8464, 7569 ] },
//     { name: 'Dave', squaredScores: [ 6724, 6561, 7921 ] }
// ]
// */


// 6. 더 고난도
/*
문제 요구 사항
학생별 과목 점수가 주어져 있습니다. 각 학생의 점수는 학기별로 나뉘어 있습니다.
1.각 학생의 모든 학기의 평균 점수를 계산하세요.
2.학생별 평균 점수가 80점 이상인 경우, 그 학생의 이름과 과목별 총합 점수를 객체로 반환해야 합니다.
3.이름 순으로 정렬된 객체 배열을 반환하세요.
4.만약 한 과목의 점수가 100점이라면, 그 과목의 점수는 2배로 처리하여 총합에 반영하세요.

//출력 예시
[
    { name: 'Alice', totalScores: { math: 165, english: 175, science: 180 } },
    { name: 'Charlie', totalScores: { math: 175, english: 400, science: 185 } }
]
*/

const calculateScore = (score) => {
    const values = Object.values(score);
    const total = values.reduce((prev, cur) => prev += cur);
    return total / values.length;
}
const students = [
    {
        name: "Alice",
        semesters: [
            { math: 85, english: 90, science: 88 },
            { math: 80, english: 85, science: 92 }
        ]
    },
    {
        name: "Bob",
        semesters: [
            { math: 70, english: 60, science: 80 },
            { math: 75, english: 65, science: 85 }
        ]
    },
    {
        name: "Charlie",
        semesters: [
            { math: 90, english: 100, science: 95 },
            { math: 85, english: 100, science: 90 }
        ]
    }
];





//========================================================================

// //배열 자르기  slice
// const arr = [1, 2, 3, 4, 5, 6];
// console.log(arr.slice(3)); // [4, 5, 6]

// //출력에서도 연산이 가능하다
// console.log(3 + '30'); // 330
// console.log(3 * '30'); // 90

// //객체에 값 추가
// const obj = {};
// obj.color = 'yellow';
// console.log(obj.color) //출력을 두 가지 방법으로 가능하다
// console.log(obj["color"]);

// // 객체를 이용해 변수 초화하기
// const query={ name: 'skk', age:'23'};
// const { name }=query;
// const { age }=query;
// console.log(query);
// console.log(name);
// console.log(age);

// //2차원 배열
// const a5 = [
//     [1, 3, 5],
//     [2, 4, 6],
// ];

// // 강제형변환 
// const numStr='33.3'
// const num =Number(numStr);
// const num1 = parseInt(numStr);
// /**
//  * Number()는 소수점 포함 숫자와 정수를 모두 변환하며, 문자열이 완전히 숫자 형식이어야 합니다.
//     parseInt()는 문자열을 정수로 변환하며, 소수점 이하는 버리고, 진수(radix) 옵션을 제공합니다.
//  */

// //객체 조건문
// let q = {a : 1};
// console.log(q === {a : 1}); //false
//  // q는 객체를 가리키는 주소이지, 객체 자체는 아님.


//  //얕은 복사와 깊은 복사
//  // 깊은 복사: JSON 방식을 사용 - 원본에 영향 x
// const deepCopy = JSON.parse(JSON.stringify(original));

// // 얕은 복사: Spread 연산자 사용 - 변경시 원본에 영향이 간다
// // 원본 객체의 주소값을 참조하는 것이다, 값을 복사한 것이 아니다
// const shallowCopy = { ...original };

// // c언어에서 포인터 적용한 것처럼 작동한다.
// function change_o(o) {
//     o.a = 999;
// };
// let o = {a: 1};
// change_o(o);
// console.log(o); // expect: {a: 999}

// // m 이상 n 이하의 무작위 정수를 return // 랜덤값
// function rand(m,n) {
//     return m + Math.floor((n-m+1)*Math.random());
// }

// //반복문 for 
// const player = {name : 'Thomas', rank : 'Midshipman', age : 25};
// for(let prop in player){
//     if(!player.hasOwnProperty(prop)) continue;
//     console.log(prop + ':' + player[prop]);
// }

// //문자열 자르기 함수
// let bigArrayOfNumbers = [32,4,11,7,8,9]
// for(let i=0; i<bigArrayOfNumbers.length; i++){
//     if(isPrime(bigArrayOfNumbers[i])) bigArrayOfNumbers.splice(i,1);
// }

// // 소수 구하기
// function isPrime(num){
//     if(num === 2){
//         return true;    
//     }
//     for(let i = 2; i <= Math.floor(Math.sqrt(num)); i++){
//         if(num % i === 0){
//             // 한 번이라도 나누어 졌으니 소수가 아니므로 return false
//             return false; 
//         }
//     }
//     // 나눠진 수가 없다면 해당 수는 소수이므로 return true
//     return true; 
// }

// //빈객체는 js에서 true 값이다 
// const suppliedOptions={};
// const options=suppliedOptions || {name :"Default"};
// console.log(options); // {}


// //배열 나머지 연산
// let[x,y, ...rest] = arr;

// //Math 수학 공식
// Math.floor(Math.sqrt(num))

//객체 안에 함수 선언 가능
// const o={
//     name:'Julie',
//     greetBackwards: function(){
//         const self=this;
//         function getReverseName(){
//             let nameBackwards='';
//             //console.log(this);

//             for(let i=self.name.length-1; i>=0; i--){
//                 nameBackwards+=self.name[i];
//             }
//             return nameBackwards;
//         }
//         return `${getReverseName()} si eman ym, olleH`;
//     },
// };
// console.log(o.greetBackwards());

// // 지역변수와 전역 변수
// {
//     //block 1
//     const x = 'blue';
//     console.log(x);
// }
// console.log(typeof x); // 객체 안에 x가 지역변수로 선언되어 있고 전역에는 x라는 변수가 없으므로 undefinded가 나온다.
// {
//     //block 2
//     const x = 3;
//     console.log(x);
// }
// console.log(typeof x); //이하 동문