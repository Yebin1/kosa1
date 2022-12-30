import { Component } from "react";

class LifeCycleCom extends Component {

    componentDidMount() {
        //컴포넌트가 mount 될 때 코드 실행
    }

    componentDidUpdate() {
       //컴포넌트가 update 될 때 코드 실행
    }

    componentWillUnmount() {
        //컴포넌트가 unmount 될 때 코드 실행
    }

    // useEffect(()=>{ }) // 재렌더링마다 코드 실행
    // useEffect(()=>{ }, []) // mount될때 1회만 실행
    // useEffect(()=>{ }, [상태변수]) // 상태변수가 작동될 때 실행
    // useEffect(()=>{ }, return { 실행코드 }) // 소멸
}