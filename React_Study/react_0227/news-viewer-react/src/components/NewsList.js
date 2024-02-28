import React, { useEffect, useState } from 'react';
import NewsItem from './NewsItem';
import axios from 'axios';

const NewsList = ({category}) => {
  const [articles, setArticles] = useState(null);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      const query = (category == 'all') ? '' : '&category=' + category;
      const apiUrl = "https://newsapi.org/v2/top-headlines?country=kr&apiKey=597d42506b0d4839be928b5bd9057d22" + query;
      const response = await axios.get(apiUrl);
      setArticles(response.data.articles);
      setLoading(false);
    };

    fetchData();
  }, [category]);

  if(loading){
    return <>대기 중</>;
  }

  if(!articles){
    return null;
  }

  return (
    <>
      { articles.map(article => (<NewsItem key={article.url} article={article} /> )) }
    </>
  );
};

export default NewsList;