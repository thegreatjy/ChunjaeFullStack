function test(callback){
    callback(
        {
            'a':1,
            'key':'Enter',
            'list':[1,2,3]
        }
    ); // 파라미터로 넘어온 함수를 실행한다.
};

test(
    function(e){
        console.log(e);
        console.log(e['list']);
        test2(
            e.list,
            function(){
                console.log(2);
            }
        );
    }
);

//

function test2(list, callback){
    console.log(list);
    callback();
};

//test2();