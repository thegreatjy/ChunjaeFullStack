function test(){
    console.log("test");
}

// test();

setTimeout(test, 2000);  // 2초 뒤에 test 함수가 실행된다.
let sId = setInterval(test, 2000);  // 2초마다 test 함수 실행 
clearInterval(sId);