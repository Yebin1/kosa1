import { useState } from 'react';
import './App.css';

function App() {

  let nickname = 'yb632339';
  let [title, setTitle] = useState(['혜화 갈비 맛집', '홍대 우동', '강남 파스타 맛집']);
  let [like, setLike] = useState([0, 0, 0]);
  let [publish] = useState(['6월 4일 발행', '9월 21일 발행', '1월 10일 발행']);
  let [flag, setFlag] = useState(false);
  let [modal, setModal] = useState([false, false, false]);

  /*
  function change() {
    // setLike(like + 1);
    // console.log(like)
    let copy = [...like]; copy[index]++;
  }
*/

  function onoff(i) {
    if (modal[i] === false) {
      let copy = [...modal];
      copy[i] = true;
      setModal(copy);
    } else if (modal[i] === true) {
      let copy = [...modal];
      copy[i] = false;
      setModal(copy);
    }
  }

  function MyModal(props) {
    return (
      <div id='modal'>
        <b>상세정보</b>
      <p>▶ {props.title} / 
      날짜 : {props.publish} / 
      좋아요 : {props.like}</p>
      </div>
    )
  }


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
              <h4 onClick={() => { onoff(index) }} >{titlename}
                <span onClick={() => {
                  let likeCnt = [...like];
                  likeCnt[index]++;
                  setLike(likeCnt)
                }}>👍</span>{like[index]}</h4>
              <p>{publish[index]}</p>
            </div>
            
            {
              modal[index] === true
                ? <MyModal title={titlename} publish={publish[index]} like={like[index]} />
                : null
            }
          </>
        }
        )} <br />

      {/* {
          <button className='btn btn-primary' 
          onClick={() =>  {
          let titleChange = [...title]; 
          titleChange[0] = '천안 호두과자 맛집';
          setTitle(titleChange);
          }}>title change</button>
          } */}

      <button onClick={() => {
        (title[0] == '혜화 갈비 맛집')
          ? setTitle(['송파 짬뽕 맛집', '명동 만두 맛집', '강북 스테이크 맛집'])
          : setTitle(['혜화 갈비 맛집', '홍대 우동', '강남 파스타 맛집']);
      }} className='btn btn-primary'>title change</button>

      <br /><br />

      <button className='btn btn-success'
        onClick={() => {
          let sortT = [...title];
          sortT.sort();
          setTitle(sortT);
        }}>title sort</button>

      <br /><br />



    </div>


  );

}

export default App;
