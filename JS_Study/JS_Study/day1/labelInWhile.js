var dan = 2;

outside : while(dan < 10){
    var num = 1;
    while(num < 10){
        if(dan == 6 && num == 1){
            break outside;
        }
        console.log(dan + "*" + num + "=" + dan*num);
        num++;
    }
    dan++;
}

console.log("=========");

here : for(let dan = 2; dan<10; dan++){
    for(let num= 1; num<10; num++) {
        if (dan >= 6) {
            break here;
        }
        console.log(dan+"*"+num+"="+dan*num);
    }
}