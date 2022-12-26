import * as React from 'react'
function Hello(props) {
    return (
        // return 안에 들어갈 수 있는 태그는 하나
        // <React.Fragment> 혹은 빈 Frag태그 <></>, <div> 태그 안에는 마음껏 가능
        <React.Fragment>
            <h1>{props.str}</h1>
            <h1>Hello Component</h1>
            <div>{props.kbs}</div>
        </React.Fragment>
    )
}

export default Hello;