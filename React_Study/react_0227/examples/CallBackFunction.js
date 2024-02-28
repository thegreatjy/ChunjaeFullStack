
function increase(number, callback){
    // 1초 뒤에 callback 함수 실행
    setTimeout(
        () => {callback(number);},1000 // 1000=1초
    );
}

const CallBackFunction = () => {
            {
                increase(1, (result) => {
                    console.log(result);
                    increase(2, (result) => {
                        console.log(result);
                    })
                })
            }
};

CallBackFunction();