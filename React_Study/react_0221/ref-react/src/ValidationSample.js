import React, { Component } from 'react';

class ValidationSample extends Component {
    // 검증하기 버튼을 누르면 input box에 커서 focus 이동
    handleButtonClick = () => {
        this.input.focus(); // focus 이벤트 발생
    };

    render() {
        return (
            <div>
                <input type='text' name='pwd' ref={(ref) => {this.input = ref}} />
                <button onClick={this.handleButtonClick}>검증하기</button>
            </div>
        );
    }
}

export default ValidationSample;