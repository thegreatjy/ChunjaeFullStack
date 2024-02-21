import React, { Component } from 'react';

class MoveBox extends Component {
    // x, y으로 left, top 이동
    move = (x, y) =>{
        //console.log(this.box.style.left[0, 2]);
        this.box.style.left = x + 'px';
        this.box.style.top = y + 'px';
    };

    render() {
        const style = {
            border: '1px solid black',
            height: '300px',
            width: '300px',
            position: 'relative'    // 하위 요소들은 본인을 기준으로 위치하게 된다.
        };

        const innerStyle = {
            height: '100px',
            width: '100px',
            position: 'absolute',
            backgroundColor: 'red',
            left: '00px',
            top: '00px'
        };

        return (
            <>
            <div style={style}>
                <div style={innerStyle} ref={(ref) => {this.box = ref}}></div>
            </div>
            <button onClick={() => {this.move(0,0)}}>move</button>
            </>
        );
    }
}

export default MoveBox;