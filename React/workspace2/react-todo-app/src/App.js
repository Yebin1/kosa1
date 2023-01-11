import React, { useState, useEffect } from "react";
import axios from "axios";
import "./App.css";
import List from "./components/List";
import Form from "./components/Form";

export default function App() {

  const SERVER_URL = '/controller/mysql';
  const [list, setList] = useState([]);

  const fetchData = async () => {
    //이런 코드들을 커스텀 훅으로 빼서 어디서든지 간편하게 사용할 수도 있다 
    // => 그것이 react-query라는 라이브러리
    const response = await axios.get(SERVER_URL)
    setList(response.data);
    console(response.data);
  }

  useEffect(() => {
    fetchData();
  }, []);

  const [todoData, setTodoData] = useState([]);
  const [value, setValue] = useState("");

  const handleSubmit = (e) => {
    // form 안에서 input 전송할 때 페이지 리로드 방지
    e.preventDefault();

    // 새로운 할 일 데이터
    let newTodo = {
      id: Date.now(),
      title: value,
      completed: false,
    };

    // 기존 할 일에 새로운 할 일 추가
    // value: "" 입력 후 값이 남아있지 않게 함
    setTodoData(prev => [...prev, newTodo]);
    setValue("");
  }

  return (
    <div>

      <div className="container">
        <div className="todoBlock">
          <div className="title">
            <h1>To Do</h1>
          </div>

          <List todoData={todoData} setTodoData={setTodoData} />
          <Form handleSubmit={handleSubmit} value={value} setValue={setValue} />

        </div> {/* todoBlock */}
      </div> {/* container */}

      <div>
        <table style={
          {
            textAlign: 'left',
          }
        }>
          <thead>
            <th>ID</th>
            <th>NAME</th>
            <th>AGE</th>
          </thead>
          <tbody>
            {list?.map((todo) => (  //  ? 를 쓰면 배열값이 Null일 때 리렌더링 안한다 -> 오류 x
              <tr key={todo.id}>
                <td>{todo.id}</td>
                <td>{todo.name}</td>
                <td>{todo.age}</td>
              </tr>
            ))}
          </tbody>
        </table>

      </div> {/* list table */}

    </div>
  );
}

