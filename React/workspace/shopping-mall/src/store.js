import { configureStore, createSlice } from "@reduxjs/toolkit";

// { name : 'state Name',  initialState : 'state Value'}
let user = createSlice({
    name : 'user',
    initialState : 'yuna'     // user='yuna'
})
let peple = createSlice({
    name : 'peple',
    initialState : 200    // peple = 200
})



export default configureStore({   // 상태변수 등록 하는 부분
    reducer: {
        user : user.reducer,
        peple : peple.reducer
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

