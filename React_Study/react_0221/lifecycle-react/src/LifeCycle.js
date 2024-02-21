import React, { Component } from 'react';

class LifeCycle extends Component {
    state = {
        color: null
    }

    constructor(props){
        super(props);   // 반드시 포함되어야 함
        console.log('constructor() 실행');
    }

    componentDidMount(){
        console.log('componentDidMount() 실행');
    }

    static getDerivedStateFromProps(nextProps, prevState){
        console.log("getDerivedStateFromProps() 실행", nextProps, prevState);

        if(nextProps.color != prevState.color){
            // console.log('값 변경 > ', nextProps.color);
            return {color: nextProps.color};
        }
        return null;
    };

    getSnapshotBeforeUpdate(prevProps, prevState){
        console.log("getSnapshotBeforeUpdate:", prevProps, prevState);

        if(prevProps.color != this.props.color){
            return prevProps.color; // componentDidUpdate의 snapshot 파라미터에 전달된다.
        }
        return null;
    }


    componentDidUpdate(prevProps, prevState, snapshot){
        console.log("componentDidUpdate: ", prevProps, prevState, snapshot, "(업데이트 직전 색상:", snapshot, ")");
    }

    shouldComponentUpdate(nextProps, nextState){
        console.log("shouldComponentUpdate", nextProps, nextState);
        return nextProps.color == 'green' ? false : true;
    }

    render() {
        console.log("render() 실행");

        return (
            <div>
                <h1 style={{color: this.props.color}}>
                    props: {this.props.color} <br/>
                    state: {this.state.color} <br/>
                </h1>
                <button onClick={() => this.setState({color: 'blue'})}>LifeCycle.js - button</button>
            </div>
        );
    }
}

export default LifeCycle;