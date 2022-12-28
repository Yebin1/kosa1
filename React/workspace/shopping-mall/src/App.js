import { Nav, Navbar, Container, NavDropdown } from 'react-bootstrap'
import './App.css';
import data from './data.json';
import { Route, Routes } from 'react-router-dom';
import Detail from './component/Detail'
import Cart from './component/Cart'
import About from './component/About'


function App() {

  return (
    <div className="App">

      <Navbar bg="light" expand="lg">
        <Container>
          <Navbar.Brand onClick={() => window.open('https://www.musinsa.com/brands/5252byoioi', '_blank')}><img src="https://image.msscdn.net/mfile_s01/_brand/free_medium/5252byoioi.png?202212201049" /></Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Nav.Link href="/">Home</Nav.Link>
              <Nav.Link href="/detail">detail</Nav.Link>
              <Nav.Link href="/cart">cart</Nav.Link>
              <Nav.Link href="/about">about</Nav.Link>

            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
      <div className='bg'>
        <img src={"https://image.musinsa.com/images/prd_img/2022110710580500000019790.jpg"} />
      </div>


      <Routes>
        <Route path='/' element={
          <div className='container'>
            <div className='row'>

              {data.map((item, index) => {

                return <>

                  <div className='col-md-4'>
                    <img src={item.img1} className='img-fluid' />
                    <h4>{item.title}</h4>
                    <h5>{item.price}</h5>
                  </div>
                </>

              })
              }
            </div>
          </div>
        }>
        </Route>

        <Route path='/cart' element={<Cart />} />
        <Route path='/detail' element={<Detail />} />
        <Route path='/about' element={<About />} />

        {/* <Outlet></Outlet> */}
        {/* 이 위치에 중첩 라우터 한 거 보여준다 */}

      </Routes>

    </div>
  );
}


export default App;