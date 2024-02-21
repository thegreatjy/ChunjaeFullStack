import React from 'react';

const Iteration = () => {
    const names = ['javascript', 'jQuery', 'React', '나가주세요 Choi'];
    const namesList = names.map((name, index) => {return <li key={index}>{name}</li>});

    return (
        <div>
            <ul>
                {namesList}
            </ul>
        </div>
    );
};

export default Iteration;