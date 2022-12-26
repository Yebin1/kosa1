import { Component } from "react";

function LogArrayElements(element, index, array) {
    console.log('a[' + index + '] = ' + element);
}
console.log([2, 5, 9].forEach(LogArrayElements));

class MyComponents extends Component {

    /*
     constructor(){
        this.state = {
            // 변수가 여러 개 >> 객체 타입으로
            // key, value 방식으로 값을 넣음
            // 상태가 변하는 것을 처리할 때 state 변수 사용
            // hook을 사용하려면 function 타입으로 만들어야 한다 (useState)

            // 상태 변수 (state variable)
            number: 0,
        }
    }
        */

    // 생성자에 넣고 싶지 않을 때
    // 상태 변수 선언
    state = {
        number: 0,
        message: 'th1-703',
        validate: false,
        messages: ['AngularJS', 'React', 'Vue', 'Ember']
    }

    render() {

        // const {message} = this.state;
        const {message, number, validate, messages} = this.state;
        let name = 'yuna';
        let x,y,z =3;

        return (
            <>
                <h3>Hello {message}</h3>
                <h3>{name}님 반갑습니다</h3>
                <span>{number}님 필요하신 것 있으세요?</span>
                <h2>{validate}</h2>
                <h3>{messages}</h3>
                <h3>{messages[3]}</h3>
                <h3>messages.map</h3>
                <h4>{messages.map((name, index) => (index + " : " + name + ", "))}</h4>
                <h3>{x},{y},{z}</h3>

            </>
        )
    }
}


export default MyComponents;