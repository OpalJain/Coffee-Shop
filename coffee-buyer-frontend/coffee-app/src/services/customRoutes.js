const jsonServer = require('json-server');
const server = jsonServer.create();
const router = jsonServer.router("/Users/sara/Documents/CODE/TeamPro/coffeeshopapp/coffee-buyer-frontend/PWA/coffee-app/src/services/db.json");
const middlewares = jsonServer.defaults();

server.use(middlewares);
server.use(jsonServer.bodyParser);

  server.get('/cart-orders', (req, res) => {
	const data = router.db.get('cart-orders').value();
	console.log(`Received GET request /cart-orders`, data);
	res.status(200).json(rdata.value());
  });

  /*server.get('/menu/undefined', (req, res) => {
	console.log(`----------------Received GET request /menu `);
	res.status(200).json(router.db.get("menu").value());
  });*/
  server.get('/menu', (req, res) => {
	const data = router.db.get('cart-menu').value();
	console.log("----------------Received GET request /menu ",data);
	res.status(200).json(router.db.get("menu").value());
  });

server.put('/cart-orders/:id/increment', (req, res) => {
	const itemId = parseInt(req.params.id, 10);
	console.log(`Received PUT request for item with ID: ${itemId}`);
	const itemToUpdate = router.db.get('cart-orders').find({id: itemId}).value();

	if (itemToUpdate) {
		itemToUpdate.quantity += 1;
		router.db.get('cart-orders').find({id: itemId}).assign(itemToUpdate).write();
		res.json(itemToUpdate);
	} else {
		res.status(404).json({error: 'Item not found'});
	}
});

server.put('/cart-orders/:id/decrement', (req, res) => {
	const itemId = parseInt(req.params.id, 10);
	console.log(`/cart-orders/:id/decrement: ${itemId}`);
	const itemToUpdate = router.db.get('cart-orders').find({id: itemId}).value();

	if (itemToUpdate) {
		itemToUpdate.quantity -= 1;
		router.db.get('cart-orders').find({id: itemId}).assign(itemToUpdate).write();
		res.json(itemToUpdate)
	} else {
		res.status(404).json({error: 'Item not found'});
	}
});

server.delete('/cart-orders/:id/remove', (req, res) => {
	const itemId = parseInt(req.params.id, 10);
	console.log(`/cart-orders/:id/remove: ${itemId}`);
	const orderIndex = router.db.get('cart-orders').findIndex({id: itemId}).value();

	if (orderIndex !== -1) {
		router.db.get('cart-orders').splice(orderIndex, 1).write();
		res.status(200).json({success: true});
	} else {
		res.status(404).json({error: 'Order not found'});
	}
})

server.post('/cart-orders/:id/add', (req, res) => {
	const itemId = parseInt(req.params.id, 10);
	console.log(`/cart-orders/:id/add: ${itemId}`);
	const newOrder = {
		"id": itemId,
		"quantity": 1
	};

	try {
		const orderExists = router.db.get('cart-orders').find({ id: itemId }).value();
		if (orderExists) {
			res.status(200).json({ success: true, message: 'Order already exists' });
		} else {
			router.db.get('cart-orders').push(newOrder).write();
			res.status(200).json({ success: true, message: 'Order added successfully' });
		}
	} catch (error) {
		res.status(500).json({ error: 'Internal server error' });
	}
});

server.use(router);
server.listen(5001, () => {
	console.log('JSON Server is running');
});
