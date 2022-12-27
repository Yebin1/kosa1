import './App.css';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import data from './data.json';
import { useEffect, useState } from 'react';


function App() {

  let [modal, setModal] = useState([false, false, false]);

  function onoff(i) {
    if (modal[i] === false) {
      let copy = [...modal];
      copy[i] = true;
      for (let idx = 0; idx < modal.length; idx++) {
        if (idx != i) {
          copy[idx] = false;
        }
      }
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
        <p><img src={props.img2} /></p>

      </div>
    )
  }

  return (
    <div className="App">
      <Navbar bg="light" expand="lg">
        <Container fluid>
          <Navbar.Brand href="#">TTAS</Navbar.Brand>
          <Navbar.Toggle aria-controls="navbarScroll" />
          <Navbar.Collapse id="navbarScroll">
            <Nav
              className="me-auto my-2 my-lg-0"
              style={{ maxHeight: '100px' }}
              navbarScroll
            >
              <Nav.Link href="#action1">아우터</Nav.Link>
              <Nav.Link href="#action2">모자</Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
      <div className="jumbotron">
        {/* <h1 className="display-4">TTAS</h1>
        <p className="lead">Tea Time and Shopping</p> */}

        <div onClick={() => window.open('https://www.musinsa.com/brands/5252byoioi', '_blank')} >
          <img src="https://image.musinsa.com/images/prd_img/2022110710580500000019790.jpg" />
          <br /><br />
        </div>
        {/* <a class="btn btn-dark btn-lg" role="button" href="https://www.musinsa.com/app/goods/2804237" onClick={() => window.open('[url 링크]', '_blank')}>둘러보기</a> */}
      </div>

      <div className='container'>
        <div className='row'>

          {data.map((item, index) => {

            return <>

              <div className='col-md-4'>
                <img src={item.img1} onClick={() => { onoff(index) }} className='img-fluid' />
                <h4>{item.title}</h4>
                <h5>{item.content}</h5>
                <h5>{item.price}</h5>
              </div>


            </>

          })
          }

          {modal.map((m, i) => {
            return <>
              {
                m === true
                  ? <MyModal img2={data[i].img2} />
                  : null
              }
            </>
          })}

        </div>

      </div>

      <br /><br /><br />

    </div>
  );

}

export default App;