**Using maven to build our bestcoffee project**

The current BestCoffee project can now be built using Maven.

After testing, it can smoothly switch between the Eclipse and IntelliJ IDEA IDEs.

When communicating with the coffee buyer page, it is necessary to listen on port 5001.

In the current version of the BestCoffee server, the main functionalities include operations for adding, deleting, modifying, and querying items in the shopping cart. For example, the doGet() method returns all contents of the shopping cart, doPut() performs an operation to increment or decrement the quantity of an item in the cart, doPost() handles the insertion of a new item into the cart, and doDelete() manages the deletion of an item from the shopping cart.