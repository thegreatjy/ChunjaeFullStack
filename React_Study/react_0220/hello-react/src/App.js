import React from 'react';

const App = () => {
  const name = 'React!!!!!';
  const nameBlank = undefined;

  return (
    <>
      {/* { <h1>{name + ' Hello'}</h1> } */}
      <h1>{name === 'React' ? 'React 입니다.' : null}</h1><br/>
      <h1>{name === 'React!!!!!' && 'React!!!!! 입니다.'}</h1><br/>
      <h1>{nameBlank || 'default value'}</h1>

      <h1 style={{backgroundColor: 'black', color: 'aqua', fontSize: '48px'}}>{name}</h1>
      <h2 className='react'>{name}</h2>

      <h1>React</h1>
      <h2>Hello React</h2>
    </>
  );
};

export default App;