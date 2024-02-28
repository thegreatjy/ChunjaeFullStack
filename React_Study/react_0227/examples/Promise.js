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

function print(number){
    console.log(number);
}

increase(1)
    .then(
        (result) => {
            console.log(result);
            return increase(2);
        }
    )
    .then(
        (result) => {
            console.log(result);
        }
    );