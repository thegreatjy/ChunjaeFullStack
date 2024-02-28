import './App.css';
import Layout from './components/Layout';
import { Route, Routes } from 'react-router-dom';
import Home from './components/Home';
import News from './components/News';
import NotFound from './components/NotFound';

function App() {
  return (
    <Routes>
      <Route element={<Layout />}>
        <Route path={'/'} element={<Home />} />
        <Route path={'/news'} element={<News />} />
        <Route path={'*'} element={<NotFound />} />
      </Route>
    </Routes>

  );
}

export default App;
