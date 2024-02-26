import React from 'react';
import {useLocation, useSearchParams} from "react-router-dom";

const About = () => {
    const location = useLocation();
    const [searchParams, setSearchParams] = useSearchParams();
    const detail = searchParams.get('detail');
    const mode = searchParams.get('mode');


    return (
        <div>
            <h1>소개</h1>
            <p>리액트 라우터 사용</p>
            <p>쿼리 스트링 : {location.search}</p>
            <p>detail : {detail}</p>
            <p>mode : {mode}</p>
        </div>
    );
};

export default About;