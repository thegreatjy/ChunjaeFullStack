import logo from './logo.svg';
import './App.css';
import axios from "axios";
import { useState } from 'react';

function App() {
  const [data, setData] = useState(null);

  const onClick = async () => {
    const response = await axios.get(
      'https://newsapi.org/v2/top-headlines?country=kr&apiKey=597d42506b0d4839be928b5bd9057d22')
      .then((response) => { // then: get 요청의 응답이 올 때까지 대기하는 것을 보장한다.
        // console.log(response);
        setData(response);
      });
  };

  return (
    <div className="App">
      <button onClick={onClick}>불러오기</button>
      <div>
        {data && <textarea value={JSON.stringify(data)} />}
      </div>
    </div>
  );
}

export default App;
