import { useState } from 'react';
import './App.css';

function App() {

  let nickname = 'yb632339';
  let [title, setTitle] = useState(['혜화 갈비 맛집', '홍대 우동', '강남 파스타 맛집']);
  let [like, setLike] = useState([0, 0, 0]);
  let [count, setCount] = useState(0);

  /*
  function change() {
    // setLike(like + 1);
    // console.log(like)
    let copy = [...like]; copy[index]++;
  }
*/

  
    return (

      <div className="App">
        <div>안녕!</div>
        <header>
          <div className="nav">나의 소소한 일상 블로그</div>
          <p>{nickname}님 어서오세요</p>
          <a href="https://cafe.naver.com/kosait" target="_blank">KOSA_IT 카페</a>
        </header>

        {
          title.map((titlename, index) => {
            return <>
              <div className='list'>
                <h4>{titlename}<span onClick={() => { let likeCnt = [...like]; likeCnt[index]++; setLike(likeCnt) }}>👍</span>{like[index]}</h4>
                <p>6월 5일 발행</p>
              </div>
            </>
          }
          )}

        {/* <div className='list'>
        <h4>{title[1]} <span onClick={change}>👍</span>{like[index]}</h4>
        <p>2월 17일 발행</p>
      </div>

      <div className='list'>
        <h4>{title[2]} <span onClick={change}>👍</span>{like[index]}</h4>
        <p>1월 10일 발행</p>
      </div> */}



      </div>


    );
  
}

export default App;
