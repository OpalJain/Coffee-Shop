/**
 * 
 */
let current_inventory = {

};

let incoming_purchase = {
    1: {
        name: "Acer Nitro 7",
        brand: "Acer",
        price: 1000,
        quantity: 5,
    },
    2: {
        name: "Asus ROG Strix",
        brand: "Asus",
        price: 1200,
        quantity: 5,
    },
    3: {
        name: "MSI GL65 Leopard",
        brand: "MSI",
        price: 1500,
        quantity: 3,
    },
    4: {
        name: "Lenovo Legion Y540",
        brand: "Lenovo",
        price: 1300,
        quantity: 7,
    },
    5: {
        name: "HP Omen 15",
        brand: "HP",
        price: 1100,
        quantity: 8,
    },
    6: {
        name: "Dell G3",
        brand: "Dell",
        price: 900,
        quantity: 10,
    },
};

let orders = {
    1: {
        name: "Acer Nitro 7",
        brand: "Acer",
        price: 1000,
        quantity: 5,
    },
};

function is_empty(string) {
    if (string.length == 0) {
        return true;
    }
    return false;
}

function getIndex(tbody) {
    let index = tbody.children.length || 0;
    return index;
}

function clearAll() {
    clearCurrentInventory();
    clearIncomingOrder();
    clearOutgoingOrder();
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
	    axios.get('http://localhost:5001/bestcoffee/menu')
    .then(function (response) {
		console.log("sending request to 5001");
        var tbody = document.querySelector("#current_inventory_list");
        response.data.forEach(item => {
            console.log(item);
            let tr = `<tr>
            <th scope='row'>${item.id}</th>
            <td>${item.name}</td>
            <td>${item.description}</td>
            <td>${item.image}</td>
            <td>$${item.price}</td>`;
            tbody.innerHTML += tr;
        });
        console.log(JSON.stringify(response.data));

        

    
        tbody.innerHTML += tr;
    })
    .catch(function (error) {
        // handle errors
        console.error('Error fetching orders data:', error);
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
    
    // 准备要发送的数据
	const dataToSend = {
	  "id": 6,
	  "name": "Coffee Item",
	  "description": "This is a delicious cup of coffee.",
	  "image": "coffee-cup.svg",
	  "price": 60
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