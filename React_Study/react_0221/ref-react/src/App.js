import './App.css';
import MoveBox from './MoveBox';
import ValidationSample from './ValidationSample';
import React, { Component } from 'react';

class App extends Component {
  render(){
    return (
      <div className="App">
        <ValidationSample/>
        <MoveBox ref={(ref) => {this.moveBox = ref}}/>
        <button onClick={() => this.moveBox.move(100, 100)}>박스 움직이기</button>
      </div>
    );
  }
}

export default App;
