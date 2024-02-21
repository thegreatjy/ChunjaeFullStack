import React, { Component } from 'react';
import LifeCycle from './LifeCycle';

class App extends Component {
  state = {
    color: 'red'
  };

  render() {
    return (
      <div>
        <LifeCycle color={this.state.color} />
        <button onClick={() => this.setState({color: 'blue'})}>blue - App.js - button</button>
        <button onClick={() => this.setState({color: 'green'})}>green - App.js - button</button>
      </div>
    );
  }
}

export default App;