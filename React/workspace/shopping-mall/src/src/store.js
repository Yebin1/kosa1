import { configureStore, createSlice } from "@reduxjs/toolkit";

// { name : 'state Name',  initialState : 'state Value'}
let user = createSlice({    // useState() 역할임
    name : 'user', 
   // initialState : 'yuna',     // user='yuna'
    initialState : {name: 'park', age : 20},   // 'Lee', [1, 2]

    reducers: {  // state(상태변수) 수정하길 원하는 함수 작성한다.
        changeName(state){   //changeName(){  }
            return '김연아 ' + state
        },
        userNameChange(state) {
            state.name = 'Kang'
        },
        increase1(state) {
            state.age += 1
        },
        increase2(state, action) {
            state.age += action.payload  // 넘어온 인수 처리
        }
    }
})

export let { changeName, increase1,increase2, userNameChange } = user.actions  // user.actions : state 변경함수


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
    reducers: {
        increaseCount(state) {
            state.count = state.count + 1
        }
    }    
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
//     initialState : 초기값 - 일반 숫자/문자/배열/객체
//  } )

// export default configureStore({
//     reducer : {
// 	상태변수 등록하는 부분
//     }
// })

