import React from 'react';
import {Link, Outlet} from "react-router-dom";

const Articles = () => {
    return (
        <div>
            <Outlet /> { /* Articles의 하위 요소가 출력된다. */ }

            <Link to={'/articles/1'}>게시글 1</Link> |
            <Link to={'/articles/2'}>게시글 2</Link> |
            <Link to={'/articles/3'}>게시글 3</Link>
        </div>
    );
};

export default Articles;