window.onload = init;
function init(){
    document.getElementById("btn1").onclick = changeheading1;
}
function changeheading1(){
    const elm = document.getElementById("heading1");
    elm.textContent = "hello"
    // create new element
    // document.write("<p> hello new p tag </p>");
    const newElm = document.createElement('p');
    newElm.textContent = "hello new p"
    elm.after(newElm);
}
function changeheading(){
const elm = document.getElementsByClassName('para');//array of elments
for(const elm of elm){
    elm.textContent = "hello, aganin";
}
}