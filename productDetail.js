fetch(".././JS/products.json")
    .then((response) => response.json())
    .then((data) => {
        products = data;
        showSimilarProducts();
        showDetailProduct();
    });

        function showDetailProduct() {
            let detailHTML = document.querySelector(".detail");
            let productId = new URLSearchParams(window.location.search).get("id");
            let thisProduct = products.filter((value) => value.id == productId)[0];

            // Show details of the clicked product
            detailHTML.querySelector(".image img").src = thisProduct.image;
            detailHTML.querySelector(".name").innerText = thisProduct.name;
            detailHTML.querySelector(".price").innerText = "Price: $" + thisProduct.price;
            detailHTML.querySelector(".material").innerHTML = "<strong>Material:</strong> " + thisProduct.material;
            detailHTML.querySelector(".capacity").innerHTML = "<strong>capacity:</strong> " + thisProduct.capacity;
            detailHTML.querySelector(".description").innerHTML = "<strong>Product Description:</strong><br>" + thisProduct.description;
        }

        function showSimilarProducts() {
            // remove datas default from HTML
            let listProductHTML = document.querySelector(".products-container");
            let productId = new URLSearchParams(window.location.search).get("id");
            let thisProduct = products.filter((value) => value.id == productId)[0];
            //if there is no product with id = productId => return to home page
            if (!thisProduct) {
                window.location.href = "/";
            }
        
            products
                .filter((value) => value.id != productId && value.material == thisProduct.material)
                .forEach((product) => {
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
        
    
    