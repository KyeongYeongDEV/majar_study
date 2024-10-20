// // // try-catch로 동기 코드의 오류 처리
// function divide(a, b) {
//     try{
//         if(b === 0){
//             throw new Error('0으로 나눌 수 없습니다');
//         }
//         return a / b;
//     } catch (error) {
//         console.error("오류 발생 :", error.message);
//         return 0;
//     }
// }

// console.log(divide(10, 2));
// console.log(divide(10, 0));

// // promise 기본 구조
// const myPromise = new Promise((resolve, reject) => { //(성공, 실패))
//     const success = true; // 성공 여부를 나타내는 임의의 조건
    
//     if (success){
//         resolve("작업이 성공했습니다");
//     } else{
//         reject("작업이 실패했습니당")
//     }
// })

// myPromise
//     .then((result) => { //작업에 성공하면 실행
//         console.log("성공 : ", result); 
//     })
//     .catch((error) => { // 작업에 실패하면 실행
//         console.error("실패", error);
//     })
//     .finally(() => { // 성공 여부와 상관없이 무조건 실행
//         console.log("작업이 완료 되었습니다");
//     })

// // 2초 후에 데이터를 반환하는 promise
// function fetchDate() {
//     return new Promise((resolve, reject) => {
//         setTimeout(() => {
//             const success1 = true;

//             if(success1) {
//                 resolve({ data : "서버에서 가져온 데이터!"});
//             } else {
//                 reject("데이터 가져오기 실패");
//             }
//         }, 2000) //2초 후에 실행
//     });
// }

// fetchDate()
//     .then((result) => {
//         console.log("데이터 : ", result);
//     })
//     .catch((error) => {
//         console.error("오류 : ", error);
//     })
//     .finally(() => {
//         console.log("데이터 요청이 종료되었습니다");
//     });

// //promise chaining
// function fetchUser(userId) {
//     return new Promise((reslove) => {
//         setTimeout(() => reslove({ id : userId, name : "Alice" }), 2000);
//     });
// }

// function fetchOrders(user) {
//     return  new Promise((resolve) => {
//         setTimeout( () => resolve([`Order1 for ${user.name}`, `Order2 for ${user.name}`]), 1000);
//     });
// }

// fetchUser(1)
//     .then((user) => {
//         console.log("사용자 정보 :", user);
//         return fetchOrders(user); //다음 promise 반환
//     })
//     .then((orders) => {
//         console.log("주문 내역 : ", orders);
//     })
//     .catch((error) => {
//         console.error("오류 발생 : ", error);
//     }); 


// promise 병렬 - 모든 promise가 성공해야 결과를 반환한다.

const promise1 = Promise.resolve("첫 번째 작업 성공");
const promise2 = Promise.reject("두 번째 작업 실패");
const promise3 = new Promise((resolve) => setTimeout(resolve, 1000, "세 번째 작업 성공"));

Promise.allSettled([promise1, promise2, promise3])
    .then((results) => {
        results.forEach((result, index) => {
            if (result.status === "fulfilled") {
                console.log(`작업 ${index + 1} 성공:`, result.value);
            } else {
                console.error(`작업 ${index + 1} 실패:`, result.reason);
            }
    });
});

/* ================================================
async/await로 Promise 사용
async/await는 Promise를 더 간결하게 사용하게 해줍니다. 아래는 Promise와 동일한 코드입니다.

javascript
코드 복사
async function fetchUserData(userId) {
  const user = await fetchUser(userId);
  const orders = await fetchOrders(user);
  console.log("사용자 정보:", user);
  console.log("주문 내역:", orders);
}

fetchUserData(1);
async/await의 장점:

비동기 코드를 동기식으로 작성할 수 있어 가독성이 높아짐
try-catch로 오류를 쉽게 처리할 수 있음
8️⃣ Promise와 async/await의 오류 처리
async/await에서도 try-catch를 사용해 오류를 처리합니다.

javascript
코드 복사
async function fetchDataWithErrorHandling() {
  try {
    const response = await fetch("https://invalid-url");
    const data = await response.json();
    console.log("데이터:", data);
  } catch (error) {
    console.error("오류 발생:", error.message);
  } finally {
    console.log("작업 완료");
  }
}

fetchDataWithErrorHandling();
*/