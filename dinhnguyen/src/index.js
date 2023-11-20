import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
// import App from './App';
import App from './components/App';
import reportWebVitals from './components/reportWebVitals';
import PropTypes from 'prop-types';
import MyAppWithProps from './components/MyAppWithProps';
import RegistationForm from './components/RegisterForm';
import Form from'./components/Form'
import MyCheckbox from './components/Checkbox';
import MyInput from './components/Text field';
import Counter from './components/Counter';
class ComponentExample extends React.Component{
  render(){
    return(
     <div>
      <h1>s
        {this.props.arrayProp}<br/>
        {this.props.stringProp}<br/>
        {this.props.numberProp}<br/>
      </h1>
     </div>
    );
  }
}

ComponentExample.propTypes = {
  arrayProp:PropTypes.array,
  stringProp:PropTypes.string,
  numberProp:PropTypes.number,
}

ComponentExample.defaultProps = {
  arrayProp:['ngoc','bich'],
  stringProp:'fpt-aptech',
  numberProp:20,
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
     <App /> 
    {/* <Login></Login> */}
    {/* <ComponentExample></ComponentExample> */}
    {/* <MyAppWithProps></MyAppWithProps> */}
    {/* <RegistationForm></RegistationForm> */}
    {/* <Form></Form> */}
    {/* <MyCheckbox></MyCheckbox> */}
    {/* <MyInput></MyInput> */}
    {/* <Counter></Counter> */}
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();