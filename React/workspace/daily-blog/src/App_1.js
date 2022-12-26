import './App.css';
import MyComponents from './components/MyComponents';
import Hello from './components/Hello';

function App() {
  const str = "React!";
  const name = "함수형 컴포넌트";
  
  return (
    <div className="App">
    <h1>Hello React</h1>
    박예빈
    <MyComponents name={name} />
    <Hello kbs={name} str={str}/>
    {/* function >> 괄호 안에 props
    class >> 생성자 괄호에 props */}
    </div>
  );
}

export default App;
