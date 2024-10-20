//1번
//사용자 배열에서 나이가 30 이상인 사람들의 이름만 추출하여 새 배열로 반환하세요.
const users = [
    { id: 1, name: 'Alice', age: 25 },
    { id: 2, name: 'Bob', age: 35 },
    { id: 3, name: 'Charlie', age: 32 },
    { id: 4, name: 'David', age: 28 }
];  

const result = users
    .filter(user => user.age >= 30) // 나이 30 이상만 남기기
    .map(user => user.name); // 이름만 추출
    
console.log(result); // ['Bob', 'Charlie']

//2번
//나이가 35 이상인 사용자만 선택한 후, 이메일을 마스킹하세요.
//이메일 마스킹 형식: 예를 들어 **alice@example.com**은 **al***@example.com**으로 변환합니다.

const users2 = [
    { id: 1, name: 'Alice', age: 25, email: 'alice@example.com' },
    { id: 2, name: 'Bob', age: 40, email: 'bob@example.com' },
    { id: 3, name: 'Charlie', age: 35, email: 'charlie@example.com' },
    { id: 4, name: 'David', age: 28, email: 'david@example.com' }
];

const result2 = users2
    .filter(user => user.age >= 35)
    .map(user => ({name : user.name, email : `${user.email[0]+user.email[1]}***@example.com`}))
console.log(result2)

// 3번 
//주문 배열에서 가격이 100 이상인 주문만 선택하세요.
//선택된 주문의 **가격에 부가세 10%**를 더해 새 배열로 반환하세요
const orders = [
    { id: 1, product: 'Laptop', price: 120 },
    { id: 2, product: 'Phone', price: 80 },
    { id: 3, product: 'Tablet', price: 200 },
    { id: 4, product: 'Monitor', price: 99 }
];  

const result3 = orders
    .filter(order => order.price >= 100)
    .map(order => ({
        product : order.product,
        finalPrice : order.price * 1.1
    }));
console.log(result3);


//4번
//고객 배열에서 **VIP 등급(나이 40 이상)**인 고객만 선택하고, 주소가 없는 고객은 제외합니다.
//선택된 고객의 이름은 대문자로 변환하세요.
const customers = [
    { id: 1, name: 'Alice', age: 25, address: 'Seoul' },
    { id: 2, name: 'Bob', age: 45, address: 'Busan' },
    { id: 3, name: 'Charlie', age: 40, address: null },
    { id: 4, name: 'David', age: 50, address: 'Incheon' }
];

const result4 = customers
    .filter(customer => customer.age >= 40 && customer.address !== null)
    .map(customer => ({
        name : customer.name.toUpperCase(),
        age : customer.age,
        address : customer.address
    }));
console.log(result4); 