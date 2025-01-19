/* @provengo summon selenium */
// @provengo summon ctrl

/**
 * This story simulates the admin setting product quantity to 0.
 */
const session = new SeleniumSession('testSession',  'chrome' ); // or 'firefox'

bthread('Admin sets product quantity to 0', function () {
  try {
    bp.log.info('Starting admin session...');
    session.start(adminURL); // Update with your actual admin URL

    bp.log.info('Logging in as admin...');
    adminLogin(session);

    bp.log.info('Setting product quantity to 0...');
    setProductQuantity(session, { product: 'Product Name', quantity: '0' });
  } catch (error) {
    bp.log.warn(`An error occurred: ${error.message}`);
  } finally {
    bp.log.info('Closing admin session...');
    session.close();
  }
});

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