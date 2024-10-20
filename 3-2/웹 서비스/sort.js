const numbers = [40, 100, 1, 5, 25, 10];

numbers.sort(); // 잘못된 결과
console.log(numbers); // [1, 10, 100, 25, 40, 5]


numbers.sort((a, b) => a - b); // 오름차순 정렬
console.log(numbers); // [1, 5, 10, 25, 40, 100]

numbers.sort((a, b) => b - a); // 내림차순 정렬
console.log(numbers); // [100, 40, 25, 10, 5, 1]


//객체 정렬
const users = [
    { id: 1, name: "Alice", age: 25 },
    { id: 2, name: "Bob", age: 35 },
    { id: 3, name: "Chris", age: 28 }
  ];
  
  // 나이를 기준으로 오름차순 정렬
  users.sort((a, b) => a.age - b.age);
  console.log(users);
  /*
  [
    { id: 1, name: 'Alice', age: 25 },
    { id: 3, name: 'Chris', age: 28 },
    { id: 2, name: 'Bob', age: 35 }
  ]
  */
  
//문자열 정렬

const names = ["alice", "Bob", "charlie", "David"];

names.sort((a, b) => a.toLowerCase().localeCompare(b.toLowerCase()));
console.log(names); // ['alice', 'Bob', 'charlie', 'David']

  //다중 조건 정렬
  const people = [
    { name: "Alice", age: 30 },
    { name: "Bob", age: 25 },
    { name: "Chris", age: 30 },
    { name: "David", age: 25 }
  ];
  
  // 나이순 → 같은 나이면 이름순으로 정렬
  people.sort((a, b) => {
    if (a.age === b.age) {
      return a.name.localeCompare(b.name); // 이름순 정렬
    }
    return a.age - b.age; // 나이순 정렬
  });
  
  console.log(people);
  /*
  [
    { name: 'Bob', age: 25 },
    { name: 'David', age: 25 },
    { name: 'Alice', age: 30 },
    { name: 'Chris', age: 30 }
  ]
  */
  