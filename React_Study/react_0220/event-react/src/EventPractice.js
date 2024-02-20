import React, { Component } from 'react';

class EventPractice extends Component {
    state = {
        message: '',
        username: ''
    };

    // 메서드 
    handleChange = (e) => {
        this.setState({[e.target.name]: e.target.value});
    };

    handleChange1 = (e) => {
        this.setState({username: e.target.value});
    };

    render() {
        const {message, username} = this.state;

        return (
            <div>
                <h1>이벤트 연습</h1>
                <input type='text' name='message' placeholder='입력해 주세요.' 
                onChange={
                    this.handleChange
                }
                />
                <h3>message: {message}</h3>
                <hr/>
                <input type='text' name='username' placeholder='입력해 주세요.' 
                onChange={
                    this.handleChange
                }
                />
                <h3>username: {username}</h3>
            </div>
            
        );
    }
}

export default EventPractice;