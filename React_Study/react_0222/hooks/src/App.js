import logo from './logo.svg';
import './App.css';
import Counter from './Counter';
import Info from './Info';
import CountReducer from './CountReducer';
import Average from './Average';

function App() {
  return (
    <div className="App">
      <Average />
      <CountReducer />
      <Info />
      <Counter />
    </div>
  );
}

export default App;
