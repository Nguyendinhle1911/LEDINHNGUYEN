window.onload = function(){
    Infinity();

}
// DOM : documet object model
function init(){
    document.getElementById("magic").onmouseover = function(){
        this.classnName = "highlight";
    }
    document.getElementById("magic").onmouseout = function(){
        this.className = "";
    }
}