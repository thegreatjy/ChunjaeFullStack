import React from 'react';
import PropTypes from 'prop-types';

const MyComponent = ({name, children}) => {
    // const {name, children} = props;

    return (
        <div>
            {
            // MyComponent.props.name : {props.name} <br/>
            // MyComponent.props.children: {props.children} <br/>
            }

            비구조화 name : {name} <br/>
            비구조화 children : {children}

        </div>
    );
};

// default props
MyComponent.defaultProps = {
    name: '기본 이름'
};

// 기본 자료형 제한
MyComponent.propTypes = {
    name: PropTypes.string.isRequired
};

export default MyComponent;