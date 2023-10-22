import axios from "axios";


const axiosJsonServer = axios.create({
	baseURL: 'http://localhost:5001'
})

export async function GetMenuData() {
	console.log("send http GET request GetMenuData");
	return axiosJsonServer.get('/menu')
		.then(result => result.data)
		.catch(error => {
			console.log(error.message)
			throw error
		});
}

export async function GetCartOrders() {
	console.log("send http GET request GetCartOrders");
	return await axiosJsonServer.get('/cart-orders')
		.then(result => result.data)
}

export async function GetMenuProductById(id) {
	console.log("send http GET request GetMenuProductById"+ id);
	return await axiosJsonServer.get(`/menu/${id}`)
		.then(result => result.data)
}


export async function IncreaseOrderQuantity(id) {
	console.log("send http PUT request IncreaseOrderQuantity"+ id);
	return await axiosJsonServer.put(`/cart-orders/${id}/increment`)
		.then(result => result)
}


export async function DecreaseOrderQuantity(id) {
	console.log("send http PUT request DecreaseOrderQuantity"+ id);
	return await axiosJsonServer.put(`/cart-orders/${id}/decrement`)
		.then(result => result)
}


export async function RemoveOrderFromCart(id) {
	console.log("send http delete request RemoveOrderFromCart "+ id);
	return await axiosJsonServer.delete(`/cart-orders/${id}/remove`)
		.then(result => result)
}

export async function AddOrderToCart(id) {
	console.log("send http POST request AddOrderToCart  : " + id);
	return await axiosJsonServer.post(`cart-orders/${id}/add`).then(result => result)
}