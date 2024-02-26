import React from 'react';
import {useParams} from "react-router-dom";

const Article = () => {
    const {id} = useParams();   // articles/1

    return (
        <div>
            <h2>게시글 Id : {id}</h2>
        </div>
    );
};

export default Article;