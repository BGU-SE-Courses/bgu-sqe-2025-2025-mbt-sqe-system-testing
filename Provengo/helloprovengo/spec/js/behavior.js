/* @provengo summon selenium */

// /**
//  * This story simulates the admin setting product quantity to 0.
//  */
// bthread('Admin sets product quantity to 0', function () {
//   let s = new SeleniumSession('admin')
//   s.start(adminURL) // Update with your actual admin URL
//   adminLogin(s)
//   setProductQuantity(s, { product: 'Product Name', quantity: '0' })
//   s.close()
// })


/**
 * This story registers a new user, logs in, and adds a product to the wishlist.
 */
bthread('Register, Login, and Add Product to Wishlist', function () {
  let s = new SeleniumSession('user');
  s.start(URL);

  const userData = {
    firstname: 'Test',
    lastname: 'User',
    email: 'testuser@example.com',
    password: 'password123',
  };

  registerUser(s, userData); // Register a new user
  addToWishlist(s); // Replace '{{PRODUCT_NAME}}' with the actual product name

  s.close();
});