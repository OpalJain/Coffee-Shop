/**
 * 
 */
let current_inventory = {

};



// Add double-click event listeners
function addDoubleClickEventListeners() {
	// Get table rows
	const tableRows = document.querySelectorAll('#current_inventory_list tr');
  	tableRows.forEach(row => {
    row.addEventListener('dblclick', () => {
      // Check if any row is already in editing mode
      const editingRow = document.querySelector('.editing');
      if (editingRow && editingRow !== row) {
        cancelEdit(editingRow);
      }

      // Add editing style to the currently double-clicked row
      row.classList.add('editing');

      // Get all cells of the current row
      const cells = row.children;

      // Create input fields and fill them with cell content
      for (let i = 1; i < cells.length; i++) {
        const cellValue = cells[i].textContent;
        cells[i].oldValue = cellValue;
        cells[i].innerHTML = `<input type="text" value="${cellValue}" onblur="updateRow(this)" 
          onkeydown="handleKeyDown(event, this)">`;
      }
    });
  });
}

// Handle keydown events for input fields
function handleKeyDown(event, input) {
  if (event.key === 'Enter') {
    // User pressed Enter, confirm changes
    updateRow(input);
  } else if (event.key === 'Escape') {
    // User pressed Escape, cancel changes
    cancelEdit(input);
  }
}

// Cancel editing mode for a row
function cancelEdit(input) {
  const cell = input.parentElement;
  const row = cell.parentElement;

  const oldValue = cell.oldValue;
    // Exit editing mode
  row.classList.remove('editing');
  cell.textContent = oldValue;
  
}

// Update row data function
function updateRow(input) {
  // Get input value
  const newValue = input.value;

  // Get current cell and row
  const cell = input.parentElement;
  const row = cell.parentElement;

  // Exit editing mode
  row.classList.remove('editing');

  // Update cell content with input value
  cell.textContent = newValue;
}

function getMenuData() {
    console.log("getting in getMenuData()----");
    axios.get('http://localhost:5001/bestcoffee/menu')
    .then(function (response) {
		console.log("sending request to 5001");
        var orderDataContainer = document.querySelector("#current_inventory_list");
        // orderDataContainer.innerHTML = response.data;
        // console.log(response.data);
    })
    .catch(function (error) {
        // handle errors
        console.error('Error fetching orders data:', error);
    });
}

function clearCurrentInventory() {
	console.log("getting in clearCurrentInventory()----");
    console.log(JSON.stringify(current_inventory));
    var tr = ''; 
	    axios.get('http://localhost:5001/bestcoffee/menu')
    .then(function (response) {
		console.log("sending request to 5001");
        var tbody = document.querySelector("#current_inventory_list");
        response.data.forEach(item => {
            console.log(item);
            tr = `<tr>
            <th scope='row'>${item.id}</th>
            <td>${item.name}</td>
            <td>${item.description}</td>
            <td>${item.image}</td>
            <td>$${item.price}</td></tr>`;
            tbody.innerHTML += tr;
            
        });
        //tbody.innerHTML += tr;
        // Rebind double-click event listeners after refreshing data
    	addDoubleClickEventListeners(tbody);
        console.log(JSON.stringify(response.data));
        
    })
    .catch(function (error) {
        // handle errors
        console.error('Error fetching orders data:', error.message);
	    console.error('Response:', error.response);
	    console.error('Request details:', error.request);
	    console.error('Config details:', error.config);
    });
    document.querySelector("#current_inventory_list").innerHTML = "";
}

function clearIncomingOrder() {
    document.querySelector("#incoming_inventory_list").innerHTML = "";
}

function clearOutgoingOrder() {
    document.querySelector("#outgoing_inventory_list").innerHTML = "";
}

function addCurrentInventory() {
    let productName = document.querySelector("#current_order_product_name").value;
    let productBrand = document.querySelector(
        "#current_order_product_brand"
    ).value;
    let productPrice = document.querySelector(
        "#current_order_product_price"
    ).value;
    let productQuantity = document.querySelector(
        "#current_order_product_quantity"
    ).value;

    if (
        is_empty(productName) ||
        is_empty(productBrand) ||
        is_empty(productPrice) ||
        is_empty(productQuantity)
    ) {
        alert("Please fill out all fields");
        return;
    }

    let tbody = document.querySelector("#current_inventory_list");

    let tr = `<tr>
    <th scope='row'>${getIndex(tbody) + 1}</th>
    <td>${productName}</td>
    <td>${productBrand}</td>
    <td>${productQuantity}</td>
    <td>$${productPrice}</td>`;

    tbody.innerHTML += tr;
    let ids = tbody.rows.length + 1;
    console.log("ids = " + ids);
    
        // 准备要发送的数据
	const dataToSend = {
	  "id": ids,
	  "name": productName,
	  "description": productBrand,
	  "image": productQuantity,
	  "price": productPrice
	};

	// 发送 POST 请求
	axios.post('http://localhost:5001/bestcoffee/menu', dataToSend)
	  .then(response => {
	    console.log('Server response:', response.data);
	  })
	  .catch(error => {
	    console.error('Error sending data:', error);
	  });
}

function addIncomingOrder() {
    let productName = document.querySelector(
        "#incoming_order_product_name"
    ).value;
    let productBrand = document.querySelector(
        "#incoming_order_product_brand"
    ).value;
    let productPrice = document.querySelector(
        "#incoming_order_product_price"
    ).value;
    let productQuantity = document.querySelector(
        "#incoming_order_product_quantity"
    ).value;

    if (
        is_empty(productName) ||
        is_empty(productBrand) ||
        is_empty(productPrice) ||
        is_empty(productQuantity)
    ) {
        alert("Please fill out all fields");
        return;
    }

    let tbody = document.querySelector("#incoming_inventory_list");

    let tr = `<tr>
    <th scope='row'>${getIndex(tbody) + 1}</th>
    <td>${productName}</td>
    <td>${productBrand}</td>
    <td>${productQuantity}</td>
    <td>$${productPrice}</td>`;

    tbody.innerHTML += tr;
}

function addOutgoingOrder() {
    let productName = document.querySelector(
        "#outgoing_order_product_name"
    ).value;
    let productBrand = document.querySelector(
        "#outgoing_order_product_brand"
    ).value;
    let productPrice = document.querySelector(
        "#outgoing_order_product_price"
    ).value;
    let productQuantity = document.querySelector(
        "#outgoing_order_product_quantity"
    ).value;

    if (
        is_empty(productName) ||
        is_empty(productBrand) ||
        is_empty(productPrice) ||
        is_empty(productQuantity)
    ) {
        alert("Please fill out all fields");
        return;
    }

    let tbody = document.querySelector("#outgoing_inventory_list");

    let tr = `<tr>
    <th scope='row'>${getIndex(tbody) + 1}</th>
    <td>${productName}</td>
    <td>${productBrand}</td>
    <td>${productQuantity}</td>
    <td>$${productPrice}</td>`;

    tbody.innerHTML += tr;
}