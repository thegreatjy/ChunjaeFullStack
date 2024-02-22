import React, { useReducer } from 'react';

// action: Object 타입
function reducer(state, action){
    switch(action.type){
        case 'INC':
            return {count: state.count + 1};
        case 'DEC':
            return {count: ((state.count - 1 < 0) ? 0 : state.count - 1)};
        default:
            return state;
    }
}

const CountReducer = () => {
    // useReducer: 초깃값을 담고 있는 state명, dispatch 반환(값 변화할 때 사용)
    const [state, dispatch] = useReducer(reducer, {count: 0});


    return (
        <div>
            <p>count: {state.count}</p>
            <button onClick={() => dispatch({type: 'INC'})}>+1 버튼</button>
            <button onClick={() => dispatch({type: 'DEC'})}>-1 버튼</button>
        </div>
    );
};

export default CountReducer;
