import logo from "./logo.svg";
import "./App.css";
import "./style.css"
import Product from "./product";
import { useState } from "react";
import Input from "./input";
import Button from "./button";

export default function App(){
  return(
    <div className="App">
      <input
      name="email"
      type="text"
      lang="Email"
      onChange={handleEmailInput}
      isValid={email.isValid}/>
    </div>
  );
}

export default App;