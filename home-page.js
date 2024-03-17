// OurProducts

// MenuButtons show Product
function showItems(value) {
    let buttons = document.querySelectorAll(".btn");
    buttons.forEach((btn) => {
        if (value.toUpperCase() == btn.innerText.toUpperCase()) {
            btn.classList.add("active");
        } else {
            btn.classList.remove("active");
        }
    });

    let elements = document.querySelectorAll(".item");
    elements.forEach((element) => {
            if (element.classList.contains(value)) {
                element.classList.remove("hide");
            } else {
                element.classList.add("hide");
            }
        }
    )
}

// Testimonials
let feadbackIndex = 1;
showfeadbacks(feadbackIndex);

function showFeadback(n) {
  showfeadbacks(feadbackIndex += n);
}
function showfeadbacks(n) {
  let i;
  let feadbacks = document.getElementsByClassName("feedback");
  if (n > feadbacks.length) {feadbackIndex = 1}    
  if (n < 1) {feadbackIndex = feadbacks.length}
  for (i = 0; i < feadbacks.length; i++) {
    feadbacks[i].style.display = "none";  
  }
  feadbacks[feadbackIndex-1].style.display = "block";  
}
