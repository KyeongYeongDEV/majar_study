// 1번 문제
//다음과 같은 숫자 배열이 주어졌습니다. 이 배열에서 짝수만 필터링하여 새 배열을 만드세요.
const numbers = [3, 10, 7, 6, 22, 19, 14, 8, 1, 25];

const result1 = numbers.filter( (number) => number % 2 === 0)
console.log(result1)

//2번 문제
//다음과 같은 사용자 이름 배열이 주어졌습니다. 이름이 **"A"**로 시작하는 사람들만 필터링하여 새 배열을 반환하세요. 대소문자를 구분하지 않습니다.
const names = ["Alice", "bob", "Andrew", "Chris", "anna", "Brian"];
const result2 = names.filter((name) => name[0] === 'a' || name[0] === 'A');
console.log(result2);

//3번문제
//아래와 같은 사용자 객체 배열이 주어집니다. 나이가 30세 이상인 사용자들만 필터링하여 새 배열을 반환하세요.
const users = [
    { id: 1, name: "Alice", age: 25 },
    { id: 2, name: "Bob", age: 35 },
    { id: 3, name: "Chris", age: 28 },
    { id: 4, name: "David", age: 30 },
    { id: 5, name: "Eva", age: 42 }
];

const result3 = users.filter((user) => user.age >= 30);
console.log(result3);

//4번
//아래와 같은 중첩된 배열이 주어졌습니다. 각 배열의 합이 50 이상인 배열만 필터링하여 새 배열을 만드세요.
const data = [
    [12, 15, 23],
    [5, 5, 10],
    [25, 25, 5],
    [30, 10, 10],
    [3, 7, 1]
];

const result4 = data.filter((d) => (d[0] + d[1] + d[2]) >= 50 )
console.log(result4);
