fetch(".././JS/products.json")
    .then((response) => response.json())
    .then((data) => {
        products = data;
        showProductsByType("Airless Pump Bottle");
    });

function showProductsByType(type) {
    let listProductHTML = document.querySelector(".products-container");
    let sameTypeProducts = products.filter((product) => product.type == type);

    sameTypeProducts.forEach((product) => {
        let newProduct = document.createElement('div');
        newProduct.dataset.id = product.id;
        newProduct.classList.add('item',product.show);
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
        <button class="addCart">Add To Cart</button>`;
                
        listProductHTML.appendChild(newProduct);
    });
}
