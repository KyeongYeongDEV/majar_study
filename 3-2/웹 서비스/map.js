//1번
//주어진 숫자 배열의 각 요소를 제곱한 새 배열을 반환하세요.
const numbers = [1, 2, 3, 4, 5];
const result1= numbers.map((number) => number ** 2)
console.log(result1);

//2번
//사용자 정보가 담긴 객체 배열이 주어집니다. 각 사용자의 **이름(name)**만 추출한 새 배열을 만들어 보세요.
const users = [
    { id: 1, name: 'Alice', age: 25 },
    { id: 2, name: 'Bob', age: 30 },
    { id: 3, name: 'Charlie', age: 35 }
];  
const result2 = users.map((user) => user.name);
console.log(result2);

//3번
// 중첩된 2차원 배열을 1차원 배열로 변환하세요.
const nestedArray = [[1, 2], [3, 4], [5, 6]];
const result3 = nestedArray.map((num) => num).flat(); //flat() 이 한 줄로 변환해줌
console.log(result3);

//4번
//문자열 배열의 각 문자열의 길이를 요소로 가지는 새 배열을 반환하세요.
const fruits = ['apple', 'banana', 'cherry'];
const result4 = fruits.map((fruit) => fruit.length);
console.log(result4);

//5번
// 사용자 정보가 담긴 객체 배열에서 나이가 30 이상인 사람에게만 isAdult 필드를 추가하고, 새 배열을 반환하세요.
//단, 30 미만인 사람은 기존 객체를 유지해야 합니다.
const users2 = [
    { id: 1, name: 'Alice', age: 25 },
    { id: 2, name: 'Bob', age: 30 },
    { id: 3, name: 'Charlie', age: 35 }
];  

const result5 = users2.map((user) => user.age >= 30 ? {...user, idAdult : true} : user);
console.log(result5);

//6번문제
// 각 사용자의 firstName과 lastName을 조합해 fullName 필드를 추가한 새 배열을 반환하세요.
const users3= [
    { id: 1, firstName: 'John', lastName: 'Doe' },
    { id: 2, firstName: 'Jane', lastName: 'Smith' },
    { id: 3, firstName: 'Emily', lastName: 'Johnson' }
];  

const fullname = users3.map((user) => ({...user, fulName : `${user.firstName} ${user.lastName}`}));
console.log(fullname);


//7번
// 사용자 배열이 주어졌을 때, 각 사용자의 나이에 따라 새로운 필드를 추가하고, VIP인 경우에는 사용자 이름을 모두 대문자로 변환한 새 배열을 반환하세요.
const users4 = [
    { id: 1, name: 'Alice', age: 25 },
    { id: 2, name: 'Bob', age: 17 },
    { id: 3, name: 'Charlie', age: 40 }
];

const VIP_age = users4.map((user) => {
    let result;
    if(user.age >= 35) {
        result = {...user, status : 'VIP'}
    }else if(user.age >= 18) {
        result = {...user, status : 'Regular'}
    }else{
        result = {...user, status : 'Minor'}
    }

    return  result;
})

console.log(VIP_age);

