import React, { useCallback, useMemo, useRef, useState } from 'react';

const getAverage = (numbers) => {
    console.log('getAverage() 실행', numbers);  //getAverage() 호출하면 number state가 변하면 계속 실행된다.
    if(numbers.length == 0) return 0;

    const sum = numbers.reduce((a,b) => a+b);
    return sum / numbers.length;
}

const set1 = new Set();




const Average = () => {
    const [number, setNumber] = useState('');
    const [list, setList] = useState([]);
    const onClick = useCallback(() => {
        setList(list.concat(parseInt(number)));
        setNumber('');
        inputEl.current.focus();
    }, [list, number]);
    const inputEl = useRef(null);

    set1.add(onClick);
    console.log('==', set1, '==');

    const avg = useMemo(() =>  getAverage(list), [list]);

    return (
        <div>
            <input name='number' value={number} ref={inputEl} onChange={(e) => {return setNumber(e.target.value)}} />
            <button onClick={onClick}>등록</button>
            <ul>
                {list.map((value, index) => {return <li key={index}>{value}</li>})}
            </ul>
            <p>평균: <b>{avg}</b></p>
        </div>
    );
};

export default Average;