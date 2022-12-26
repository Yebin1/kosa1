import * as React from 'react'
function Hello() {
    return (
        // return 안에 들어갈 수 있는 태그는 하나
        // <React.Fragment> 혹은 빈 Frag태그 <></>, <div> 태그 안에는 마음껏 가능
        <React.Fragment>
            <h1>Hello Component</h1>
        </React.Fragment>
    )
}

export default Hello;