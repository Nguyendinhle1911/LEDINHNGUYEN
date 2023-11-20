import { useState } from "react";
import React,(useState) from "react";

function App(){
 const [headingText, setHeadingText]= useState("hello");
 function handleClick(){
    headingText("sumitted");
 }

 return(
    <div>
        <h1>{headingText}</h1>
        <button>
            
        </button>
    </div>
 );
}
export default App;