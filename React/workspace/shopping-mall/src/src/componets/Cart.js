import { Table } from "react-bootstrap";
import { useSelector, useDispatch } from "react-redux";
import { 
    changeName, 
    userNameChange, 
    increase1, 
    increase2, 
    increaseCount 
} from "../store";


function Cart() {

    // let value = useSelector((state)=>{ return state})  //useSelector() : Redux store 가져와주는 HOOK
    // let value = useSelector((state)=> state.stock) 
    // let value = useSelector((state)=> state.stock[2]) 
    let state = useSelector((state)=> state)
    console.log(state);
    let dispatch = useDispatch();  // actions에 있는 것들 호출해주는 


    return(
    <div>
        <h2>{state.user} 님의 장바구니 / { state.user.age } </h2>
        <button  onClick={()=>{ 
            //console.log("change");
            //dispatch( changeName())
            dispatch(increase2(25))
            dispatch( userNameChange()) 
         }}>changeName</button>
        <Table>
            <thead>
                <tr>
                    <th>#</th>
                    <th>상품명</th>
                    <th>수량</th>
                    <th>변경하기</th>
                </tr>
            </thead>
            <tbody>
                 {/* ()=>{ return value } vs ()=> value */}
                {state.cart.map((item, i)=>
                    <tr key={i}>
                        <td>{state.cart[i].id}</td>
                        <td>{state.cart[i].name}</td>
                        <td>{state.cart[i].count}</td>
                        <td><button onClick={dispatch(increaseCount())}>+</button></td> 
                        <td><button>-</button></td>  
                        <td><button>수량변경</button></td>  
                    </tr>
                )}             
            </tbody>
        </Table>
    </div>
    )
  }

export default Cart;