 listCart = [];
function checkCart(){
    var listCartValue = localStorage.getItem('cart');
    if(listCartValue){
        listCart = JSON.parse(listCartValue);
    }
}
checkCart();
showItemCheckOut();
function showItemCheckOut(){
    // clear data default
    let listCartHTML = document.querySelector('.returnCart .list');
    listCartHTML.innerHTML = '';

    let totalQuantityHTML = document.querySelector('.totalQuantity');
    let totalPriceHTML = document.querySelector('.totalPrice');
    let totalQuantity = 0;
    let totalPrice = 0;
    // if has product in Cart
    if(listCart){
        listCart.forEach(product => {
            if(product){
                let newCart = document.createElement('div');
                newCart.classList.add('item');
                newCart.innerHTML = 
                    `<img src="${product.image}">
                    <div class="info">
                        <div class="name">${product.name}</div>
                        <div class="price">$${product.price} / Product</div>
                        <div>Material: ${product.material}</div>
                        <div>Capacity: ${product.capacity}</div>
                    </div>
                    <div class="quantity">${product.quantity}</div>
                    <div class="returnPrice">$${Number((product.price * product.quantity).toFixed(2))}</div>`;
                listCartHTML.appendChild(newCart);
                totalQuantity = totalQuantity + product.quantity;
                totalPrice = totalPrice + Number((product.price * product.quantity).toFixed(2));
            }
        })
    }
    totalQuantityHTML.innerText = totalQuantity;
    totalPrice = Number(totalPrice.toFixed(2));
    totalPriceHTML.innerText = '$' + totalPrice.toFixed(2);
}
console.log(listCart);

document.getElementById("btnCheckout").addEventListener("click", function(event) {
    // Prevent the form from submitting
    event.preventDefault();

    var name = document.getElementById("name");
    var phone = document.getElementById("phone");
    var address = document.getElementById("address");
    var country = document.getElementById("country");
    var city = document.getElementById("city");

    // Reset custom validity
    name.setCustomValidity("");
    phone.setCustomValidity("");
    address.setCustomValidity("");
    country.setCustomValidity("");
    city.setCustomValidity("");

    if (!name.value) {
        name.setCustomValidity("Please enter your name.");
    } else if (!phone.value) {
        phone.setCustomValidity("Please enter your phone number.");
    } else if (!address.value) {
        address.setCustomValidity("Please enter your address.");
    } else if (!country.value) {
        country.setCustomValidity("Please select your country.");
    } else if (!city.value) {
        city.setCustomValidity("Please select your city.");
    } else {
        // All fields are filled, show the popup
        document.getElementById("btnCheckout").style.display = "none";
        document.getElementsByClassName("popup")[0].classList.add("active");
    }

    // Trigger form validation
    event.target.form.reportValidity();
});

   
document.getElementById("dismiss-popup-btn").addEventListener("click", function(event){
    // Prevent the default action
    event.preventDefault();

    document.getElementById("btnCheckout").style.display = "block";
    document.getElementsByClassName("popup")[0].classList.remove("active");

    // Clear cart
    cart = []; // or listCart = []; if you're using listCart for your cart
    localStorage.removeItem('cart');

    // Update cart HTML
    showItemCheckOut();

    // Redirect
    window.location.href = ".././HTML/orderBill.html";
});

