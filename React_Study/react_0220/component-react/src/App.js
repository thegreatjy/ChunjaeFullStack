// import React from 'react';

// const App = () => {
//   const name = 'React';

//   return (
//     <div>
//       {name}
//     </div>
//   );
// };

// export default App;

import React, { Component } from 'react';
import MyComponent from './MyComponent';
import MyComponentClass from './MyComponentClass';
import Counter from './Counter';
import Say from './Say';

class App extends Component {
  render() {
    const name = 'React11';

    return (
      <div>
        {name}
        <MyComponent name='GNB'><s>React</s>입니다.</MyComponent><hr/>
        <MyComponent name='sideBar'/><hr/>
        <MyComponent /><hr/> {/* 기본값 사용 */}
        <MyComponent name={3}/><hr/> {/* 에러 발생 */}

        <MyComponentClass name='MyComponentClass'></MyComponentClass><hr/>
        <Counter/><hr/>
        <Say/><hr/>
      </div>
    );
  }
}

export default App;