import React, {useEffect, useState} from 'react';

const Info = () => {
    const [name, setName] = useState('');

    useEffect(
        () => {
            console.log('rendering 완료');
            console.log("name", name);

            // 관찰(추적)하고 있는 값이 갱신 직전에 실행된다. beforeUpdateSnapshot
            return() => {
                console.log('clean up', {name});
            }
        }, [name]
    );
    

    return (
        <div>
            <input type='text' onChange={(e) => setName(e.target.value)}/><br/>
            name: {name}
        </div>
    );
};

export default Info;