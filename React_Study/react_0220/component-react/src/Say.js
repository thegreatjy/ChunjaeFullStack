import React, {useState} from 'react';

const Say = () => {
    // value, function이 반환된다. 
    // '' 초깃값
    const [message, setMessage] = useState('');

    return (
        <div>
            <h1>{message}</h1>
            <button onClick={() => {
                setMessage('Hi');
            }}>입장</button>
            <button onClick={() => {
                setMessage('Bye');
            }}>퇴장</button>
        </div>
    );
};

export default Say;