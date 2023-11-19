import axios from "axios";


const axiosJsonServer = axios.create({
	baseURL: 'http://localhost:5001',
	withCredentials: true,
	'Access-Control-Allow-Methods': 'GET, POST, OPTIONS, PUT, PATCH, DELETE',
})

const headers = {
	'Content-Type': 'application/json',
  };
export async function GetMenuData() {
	console.log("send http GET request GetMenuData");
	return axiosJsonServer.get('/bestcoffee/menu')
		.then(result => result.data)
		.catch(error => {
			console.log(error.message)
			throw error
		});
}

export async function GetCartOrders() {
	console.log("send http GET request GetCartOrders");
	return await axiosJsonServer.get('/bestcoffee/cart-orders')
		.then(result => result.data)
}

export async function GetMenuProductById(id) {
	console.log("send http GET request GetMenuProductById"+ id);
	return await axiosJsonServer.get(`/bestcoffee/menu/${id}`)
		.then(result => result.data)
}


export async function IncreaseOrderQuantity(id) {
	console.log("send http PUT request IncreaseOrderQuantity"+ id);
	return await axiosJsonServer.put(`/bestcoffee/cart-orders/${id}/increment`)
		.then(result => result)
}


export async function DecreaseOrderQuantity(id) {
	console.log("send http PUT request DecreaseOrderQuantity"+ id);
	
	return await axiosJsonServer.put(`/bestcoffee/cart-orders/${id}/decrement`)
		.then(result => result)
}


export async function RemoveOrderFromCart(id) {
	console.log("send http delete request RemoveOrderFromCart "+ id);
	console.log(headers);
	return await axiosJsonServer.delete(`/bestcoffee/cart-orders/${id}/remove`, {headers})
		.then(result => {
			console.log("delete request header is ", headers);
			return result;
		})
}

export async function AddOrderToCart(id) {
	console.log("send http POST request AddOrderToCart  : " + id);
	return await axiosJsonServer.post(`/bestcoffee/cart-orders/${id}/add`).then(result => result)
}