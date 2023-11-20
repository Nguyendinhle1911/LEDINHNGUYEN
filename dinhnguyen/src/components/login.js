import React, {Component} from "react";
import './style.css';  
//extand: Kế thừa
// vd: A extand B; thì B là lớp(class) cha của A;
class Login extends Component
{
    render () {
        return (
            <div>
                <h2>Login Form</h2>
                Username: <input type="text"/>
                <br />
                Password: <input type="password"/>
                <br/>
                <input type="button"/>
            </div>
        );
    }
}

export default Login;