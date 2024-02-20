import React, {useState} from 'react';

const EventPracticeFunction = () => {
    // state명, state update 함수명
    const [message, setMessage] = useState('');
    const handleChange = (e) => {
        setMessage(e.target.value);
    }

    return (
        <div>
            <h1>이벤트 연습 - 함수 </h1>
            <input type='text' name='message' placeholder='입력해 주세요.' 
            onChange={handleChange}
            />
            <h3>message: {message}</h3>
            <hr/>
        </div>
    );
};

export default EventPracticeFunction;