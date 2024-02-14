let arr = [1,2,3];
console.log(arr);

// es6 부터 제공
// push
arr.push(4);
console.log(arr);

// concat: 새 배열을 생성한 후, 반환
arr.concat(5);
console.log(arr);

console.log(arr.concat(5));

arr = arr.concat(5);
console.log(arr);

// map
let result = arr.map(
    (currentValue) => {
        return currentValue + 10;
    }
);

console.log("result : ", result);

// reduce
arr = [1,3,5,7,9];
console.log("\narr : ", arr);
result = arr.reduce(
    (total, currentValue, currentIndex) => {
        console.log(total, currentValue, currentIndex, arr[currentIndex]);
        return total + currentValue * 5;
    }
);

console.log("result ", result);