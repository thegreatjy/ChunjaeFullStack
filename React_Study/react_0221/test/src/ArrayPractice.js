// spread 연산자
const a = [1,2,3,4,5];
const b = a;    // a 참조
console.log(a == b);    // true
const c = [...a];   // a 배열을 복사
console.log(a == c);    // false


const obj = {a:1, b:2, c:3};
const obj2 = {...obj};
console.log(obj2);
console.log(obj == obj2);   // false. 복사이기 때문에 새 메모리가 할당된다.
const obj3 = {...obj2, c:4};
console.log(obj3);  // c:3이 4로 덮어쓰여지게 된다.

