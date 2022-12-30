import { configureStore, createSlice } from "@reduxjs/toolkit";

// { name : 'state Name',  initialState : 'state Value'}
let user = createSlice({    // useState() 역할임
    name : 'user', 
    initialState : 'yuna',     // user='yuna'

    reducers: {  // state(상태변수) 수정하길 원하는 함수 작성한다.
        changeName(state){   //changeName(){  }
            return '김연아 ' + state
        },
    }
})

export let { changeName } = user.actions  // user.actions : state 변경함수



let stock = createSlice({
    name : 'stock',
    initialState : [7,13,20]    // stock = [7,13,20]
})
let cart = createSlice({
    name : 'cart',
    initialState : 
    [      // cart = [{},{}]
        { id : 0, name : "Black and White",  count: 2},
        { id : 2, name : "Red Knit",  count: 1 }
    ],
})

export let { increaseCount } = cart.actions

export default configureStore({   // 상태변수 등록 하는 부분
    reducer: {
        user : user.reducer,
        stock : stock.reducer,
        cart : cart.reducer
    }
})



// import { configureStore} from "@reduxjs/toolkit"

// createSlice( {  
//     name :  변수 이름,
//     initialState : 초기값
//  } )

// export default configureStore({
//     reducer : {
// 	상태변수 등록하는 부분
//     }
// })

