function loadContent(page) {
    var content = document.getElementById("content");
    switch (page) {
      case "overView":
        content.innerHTML = `
                    <h2>Over View</h2></br>
                    <div id="box-overview">
                      <div class="overview-item">
                        <a href="#" onclick="loadContent('orders')"
                            style="color:black">
                        <h3> Total orders</h3>
                        <p>100</p>
                    </a>
                    </div>
                    <div class="overview-item">
                        <h3> Total messages</h3>
                        <p>200</p>
                    </div>
                    <div class="overview-item">
                        <h3> Total feedback</h3>
                        <p>300</p>
                    </div>
                    <div class="overview-item">
                      <a href="#" onclick="loadContent('userAccounts')"
                      style="color:black">
                        <h3> Total existing accounts</h3>
                        <p>400</p>
                      </a>
                    </div>
                    </div>
                `;
        break;
      case "userAccounts":
        content.innerHTML = `
                <table id="table-header">
                  <tr>
                    <th><h2>User Accounts</h2></br></th>
                    <th>
                      <form class="d-flex">
                        <span>From</span>
                        <input type="datetime-local"/>
                        <span>To</span>
                        <input type="datetime-local"/>
                        <span>Status
                          <select name="status" style="padding: 0.5rem 0" required>
                              <option value="">Choose..</option>
                              <option value="active">Active</option>
                              <option value="passive">Passive</option>
                              <option value="ban">Ban</option>
                            </select>  
                        </span>
                        <i class="fa-solid fa-magnifying-glass fa-lg"
                        style="cursor:pointer;"></i>
                      </form>
                    </th>
                  </tr>
                </table>
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Username</th>
                        <th>Password</th>
                        <th>Date of Birth</th>
                        <th>Status</th>
                        <th>Creation Date</th>
                        <th>Actions</th>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>vananguyen1234</td>
                        <td>********</td>
                        <td>1999-03-19</td>
                        <td class="underline">Active</td>
                        <td>2024-02-10</td>
                        <td>
                          <button onclick="openPopup()">Update</button>
                          <button onclick="deleteUser(1)">Delete</button>
                        </td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>nguyenanh206</td>
                        <td>********</td>
                        <td>2005-03-21</td>
                        <td class="underline">Passive</td>
                        <td>2024-02-12</td>
                        <td>
                          <button onclick="openPopup()">Update</button>
                          <button onclick="deleteUser(1)">Delete</button>
                        </td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>vanthu6498</td>
                        <td>********</td>
                        <td>2013-02-19</td>
                        <td class="underline">Ban</td>
                        <td>2024-02-24</td>
                        <td>
                          <button onclick="openPopup()">Update</button>
                          <button onclick="deleteUser(1)">Delete</button>
                        </td>
                    </tr>
                </table>
            `;
        break;
      case "orders":
        content.innerHTML = `
        <table id="table-header-1">
                  <tr>
                    <th><h2>Orders</h2></br></th>
                    <th>
                      <form class="d-flex">
                        <span>From</span>
                        <input type="datetime-local"/>
                        <span>To</span>
                        <input type="datetime-local"/>
                        <span>Status
                          <select name="status" style="padding: 0.5rem 0" required>
                              <option value="">Choose..</option>
                              <option value="shipped">Shipped</option>
                              <option value="delivering">Delivering</option>
                              <option value="pending">Pending</option>
                            </select>  
                        </span>
                        <i class="fa-solid fa-magnifying-glass fa-lg"
                        style="cursor:pointer;"></i>
                      </form>
                    </th>
                  </tr>
                </table>
              <table>
                  <tr>
                      <th>Order ID</th>
                      <th>Customer Name</th>
                      <th>Phone Number</th>
                      <th>Order Status</th>
                      <th>Shipping Address</th>
                      <th>Order Date</th>
                      <th>Actions</th>
                  </tr>
                  <tr>
                      <td>1</td>
                      <td>Nguyen Van Anh</td>
                      <td>0399961835</td>
                      <td class="underline">Shipped</td>
                      <td>8 Ton That Thuyet,</br> Nam Tu Liem, HN</td>
                      <td>2024-02-26</td>
                      <td>
                          <button onclick="deleteOrder(1)">Delete</button>
                      </td>
                  </tr>
                  <tr>
                      <td>2</td>
                      <td>Nguyen Thi Thu</td>
                      <td>0899861835</td>
                      <td class="underline">Delivering</td>
                      <td>8 Ton That Thuyet,</br> Nam Tu Liem, HN</td>
                      <td>2024-02-25</td>
                      <td>
                          <button onclick="openOrderPopup()">Update</button>
                          <button onclick="deleteOrder(1)">Delete</button>
                      </td>
                  </tr>
                  <tr>
                      <td>3</td>
                      <td>Nguyen Hoang Duyen</td>
                      <td>0399961835</td>
                      <td class="underline">Pending</td>
                      <td>8 Ton That Thuyet,</br> Nam Tu Liem, HN</td>
                      <td>2024-02-12</td>
                      <td>
                          <button onclick="openOrderPopup()">Update</button>
                          <button onclick="deleteOrder(1)">Delete</button>
                      </td>
                  </tr>
              </table>
          `;
        break;
      case "productManage":
        break;
      case "addProduct":
        content.innerHTML = `
              <h2>Add Product</h2>
              <form onsubmit="addProduct(event)">
                  <label for="name">Name:</label><br>
                  <input type="text" id="name" name="name"><br>
                  <label for="material">Material:</label><br>
                  <input type="text" id="material" name="material"><br>
                  <label for="capacity">Capacity:</label><br>
                  <input type="text" id="capacity" name="capacity"><br>
                  <label for="image">Image:</label><br>
                  <input type="file" id="image" name="image"><br>
                  <label for="description">Description:</label><br>
                  <textarea id="description" name="description"></textarea><br>
                  <input type="submit" value="Add">
              </form>
          `;
        break;
      case "updateProduct":
        content.innerHTML = `
                <h2>Update Product</h2>
                <form onsubmit="updateProduct(event)">
                    <label for="id">ID:</label><br>
                    <input type="text" id="id" name="id"><br>
                    <label for="name">Name:</label><br>
                    <input type="text" id="name" name="name"><br>
                    <label for="material">Material:</label><br>
                    <input type="text" id="material" name="material"><br>
                    <label for="capacity">Capacity:</label><br>
                    <input type="text" id="capacity" name="capacity"><br>
                    <label for="image">Image:</label><br>
                    <input type="file" id="image" name="image"><br>
                    <label for="description">Description:</label><br>
                    <textarea id="description" name="description"></textarea><br>
                    <input type="submit" value="Update">
                </form>
            `;
        break;
      case "deleteProduct":
        content.innerHTML = `
                <h2>Delete Product</h2>
                <form onsubmit="deleteProduct(event)">
                    <label for="id">Product ID:</label><br>
                    <input type="text" id="id" name="id" oninput="showProduct(this.value)"><br>
                    <div id="productPreview">
                        <h3>Product Preview</h3>
                        <div class="products-container"></div>
                    </div>
                    <input type="submit" value="Delete">
                </form>
            `;
        break;
    }
  }

  loadContent("overView");

  function toggleSubMenu(id) {
    var subMenu = document.getElementById(id);
    if (subMenu.style.display === "none" || subMenu.style.display === "") {
      subMenu.style.display = "block";
    } else {
      subMenu.style.display = "none";
    }
  }
  function showProduct(id) {
    // This is just a mockup, replace with actual product data
    var productPreview = document.getElementById("productPreview");
    productPreview.innerHTML = `
            <h3>Product Preview</h3>
            <div class="products-container"></div>
        `;
  }
  function openPopup() {
    document.getElementById("updateUserPopup").style.display = "block";
  }
  function openOrderPopup() {
    document.getElementById("updateOrderPopup").style.display = "block";
  }
  function closePopup() {
    document.getElementById("updateUserPopup").style.display = "none";
    document.getElementById("updateOrderPopup").style.display = "none";
  }

  function deleteUser(id) {
    // This is just a mockup, replace with actual delete user logic
    var confirmation = confirm(
      "Are you sure you want to delete user with ID: " + id + "?"
    );
    if (confirmation) {
      // Add your delete user logic here
      alert("User with ID: " + id + " has been deleted.");
      // After deleting the user, you might want to update the user list
      loadContent("userAccounts");
    }
  }

  function updateOrder(id) {
    // Add your update order logic here
    alert("Update order with ID: " + id);
  }

  function deleteOrder(id) {
    // Add your delete order logic here
    alert("Delete order with ID: " + id);
  }

  function addProduct(event) {
    event.preventDefault();
    // Add your add product logic here
    alert("Add product with name: " + event.target.name.value);
  }

  function updateOrder(event) {
    event.preventDefault();
  
    // Get the new status from the form
    var newStatus = event.target.elements.status.value;
  
    // Store the new status in localStorage
    localStorage.setItem('orderStatus', newStatus);
  
    // Get all the order status elements in the table
    var statusElements = document.querySelectorAll('.underline');
  
    // Update each status element with the new status
    statusElements.forEach(function(element) {
      element.textContent = newStatus;
    });
  }
  
  
  