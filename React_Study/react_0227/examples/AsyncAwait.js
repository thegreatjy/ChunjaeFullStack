function increase(number){
    const promise = new Promise(
        (resolve, reject) => {
            setTimeout(
                () => {
                    resolve(number);
                }, 1000
            );
        }
    );

    return promise;
}

async function runTask(){
    // await: increase 함수가 끝날 때까지 기다리는 것을 보장한다.
    let result = await increase(1);
    console.log(result);
    result = await increase(2);
    console.log(result);
}

runTask();