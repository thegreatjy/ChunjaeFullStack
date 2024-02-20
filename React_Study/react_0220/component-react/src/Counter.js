import React, { Component } from 'react';

class Counter extends Component {
    state = {
        // state 안에서 멤버변수 선언
        number: 1999,
        fixNumber: -1
    }

    render() {
        const {number, fixNumber} = this.state;

        return (
            <div>
                <h1>{number}</h1>
                <button onClick={()=>{
                    this.setState({number: number+1})
                    }}>+1</button>

                <h1>{fixNumber}</h1>
                <button onClick={()=>{
                    this.setState({number: number+1})
                    }}>+1</button>
            </div>
        );
    }
}

export default Counter;