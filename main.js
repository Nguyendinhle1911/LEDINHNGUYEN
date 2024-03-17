// Declare Variable 
let listProductHTML = document.querySelector('.products-container');
let listCartHTML = document.querySelector('.listCart');
let iconCart = document.querySelector('.icon-cart');
let iconCartSpan = document.querySelector('.icon-cart span');
let body = document.querySelector('body');
let closeCart = document.querySelector('.close');
let products = [];
let cart = [];


iconCart.addEventListener('click', () => {
    body.classList.toggle('showCart');
})
closeCart.addEventListener('click', () => {
    body.classList.toggle('showCart');
})

listProductHTML.addEventListener('click', (event) => {
    let positionClick = event.target;
    if(positionClick.classList.contains('addCart')){
        let id_product = positionClick.parentElement.dataset.id;
        addToCart(id_product);
    }
})

const addDataToHTML = () => {
    // remove datas default from HTML
        // Add New Data
        if(products.length > 0) // if has data
        {
            products.forEach(product => {
                let newProduct = document.createElement('div');
                newProduct.dataset.id = product.id;
                newProduct.classList.add('item','hide',product.show);
                newProduct.innerHTML = 
                `<div class="image">
                    <a href=".././HTML/productDetail.html?id=${product.id}">
                        <img src="${product.image}" alt="image"/>
                    </a>
                    <div class="product__img-hover">
                        <i class="fa-brands fa-searchengin"
                        title="Quick Review">
                        </i>
                        <i class="fa-solid fa-cart-arrow-down"
                        title="Add to Cart">
                        </i>
                        <i class="fa-regular fa-heart"
                        title="Save to Favourite">
                        </i>
                    </div>
                </div>
                <div class="materialAndCapacity">
                        <div class="material">Material: ${product.material}</div>
                        <div class="capacity">Capacity: ${product.capacity}</div>
                    </div>
                    <div class="price">Price: <b>$${product.price}</b></div>
                    <a href=".././HTML/productDetail.html?id=${product.id}">
                        <h2>${product.name}</h2>
                    </a>
                        <div class="stars">
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star-half-stroke"></i>
                        </div>
                    </div>
                <button class="addCart">Add To Cart</button>`;
                    
                listProductHTML.appendChild(newProduct);
            });
        }
    }

const addToCart = (product_id) => {
    let product = products.find((value) => value.id == product_id);
    let positionThisProductInCart = cart.findIndex((value) => value.product_id == product_id);
    if(cart.length <= 0){
        cart = [{
            product_id: product_id,
            name: product.name,
            price: product.price,
            image: product.image,
            capacity: product.capacity,
            material: product.material,
            type: product.type,
            quantity: 1
        }];
    }else if(positionThisProductInCart < 0){
        cart.push({
            product_id: product_id,
            name: product.name,
            price: product.price,
            image: product.image,
            capacity: product.capacity,
            material: product.material,
            type: product.type,
            quantity: 1
        });
    }else{
        cart[positionThisProductInCart].quantity = cart[positionThisProductInCart].quantity + 1;
    }
    addCartToHTML();
    addCartToMemory();
}

const addCartToMemory = () => {
    localStorage.setItem('cart', JSON.stringify(cart));
}
const addCartToHTML = () => {
    listCartHTML.innerHTML = '';
    let totalQuantity = 0;
    if(cart.length > 0){
        cart.forEach(item => {
            totalQuantity = totalQuantity +  item.quantity;
            let newItem = document.createElement('div');
            newItem.classList.add('item');
            newItem.dataset.id = item.product_id;

            let positionProduct = products.findIndex((value) => value.id == item.product_id);
            let info = products[positionProduct];
            listCartHTML.appendChild(newItem);
            newItem.innerHTML = `
            <div class="image">
                    <img src="${info.image}">
                </div>
                <div class="name">
                    ${info.name} </br>
                    <div class="box-name">
                        Material: ${info.material} </br>
                        Capacity: ${info.capacity}
                    </div>
                </div>
                <div class="totalPrice">$${Number((info.price* item.quantity)).toFixed(2)}</div>
                <div class="quantity">
                    <span class="minus">-</span>
                    <span>${item.quantity}</span>
                    <span class="plus">+</span>
                </div>
            `;
        })
    }
    iconCartSpan.innerText = totalQuantity;
}

listCartHTML.addEventListener('click', (event) => {
    let positionClick = event.target;
    if(positionClick.classList.contains('minus') || positionClick.classList.contains('plus')){
        let product_id = positionClick.parentElement.parentElement.dataset.id;
        let type = 'minus';
        if(positionClick.classList.contains('plus')){
            type = 'plus';
        }
        changeQuantityCart(product_id, type);
    }
})
const changeQuantityCart = (product_id, type) => {
    let positionItemInCart = cart.findIndex((value) => value.product_id == product_id);
    if(positionItemInCart >= 0){
        let info = cart[positionItemInCart];
        switch (type) {
            case 'plus':
                cart[positionItemInCart].quantity = cart[positionItemInCart].quantity + 1;
                break;
        
            default:
                let changeQuantity = cart[positionItemInCart].quantity - 1;
                if (changeQuantity > 0) {
                    cart[positionItemInCart].quantity = changeQuantity;
                }else{
                    cart.splice(positionItemInCart, 1);
                }
                break;
        }
    }
    addCartToHTML();
    addCartToMemory();
}

const initApp = () => {
    // get data product
    fetch('.././JS/products.json')
    .then(response => response.json())
    .then(data => {
        products = data;
        addDataToHTML();
        showItems("all");
        

        // get data cart from memory
        if(localStorage.getItem('cart')){
            cart = JSON.parse(localStorage.getItem('cart'));
            addCartToHTML();
        }
    })
}
initApp();

function openNavBar() {
    document.getElementById("navBar").style.width = "70%";
    document.getElementById("close-btn").style.display = "block";
  }

function closeNavBar() {
    document.getElementById("navBar").style.width = "";
    document.getElementById("close-btn").style.display = "none";
}