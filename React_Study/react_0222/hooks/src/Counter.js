import React, {useState} from 'react';

const Counter = () => {
    // [state명, setter] = useState(초깃값)
    const [count, setCount] = useState(0);


    return (
        <div>
            <p>count: {count}</p>
            <button onClick={() => setCount(count + 1)}>+1 버튼</button>
            <button onClick={() => setCount(count - 1)}>-1 버튼</button>
        </div>
    );
};

export default Counter;