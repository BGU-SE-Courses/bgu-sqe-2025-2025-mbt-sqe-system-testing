let eventOccurred = false;

bthread('Admin sets product quantity to 0', function () {
    let session;
    try {
        session = new SeleniumSession('adminSession', 'chrome');
        session.start(adminURL);

        adminLogin(session);

        bp.log.info('Setting product quantity to 0...');
        setProductQuantity(session, { product: 'Product Name', quantity: '0' });

        // Emit event to indicate quantity change
        sync({ request: Event("productQuantityZero") });

        eventOccurred = true;  // Manually track event
        bp.log.info('Admin set product quantity to 0. Waiting for user to complete wishlist check...');

        // Wait until the user completes wishlist check
        sync({ waitFor: Event("wishlistCheckCompleted") });

    } catch (error) {
        bp.log.warn(`An error occurred in the admin session: ${error.message}`);
    } finally {
        bp.log.info('Closing admin session...');
        if (session) {
            session.close();
        }
    }
});

bthread('Register, Login, and Add Product to Wishlist', function () {
    let s;
    try {
        s = new SeleniumSession('userSession');
        s.start(URL);

        registerUser(s, {
            firstname: 'Test',
            lastname: 'User',
            email: 'pppppp9@example.com',
            password: 'password123',
        });
        addToWishlist(s);

        bp.log.info("Starting wishlist check...");

        if (eventOccurred) {
            bp.log.info("Admin updated product quantity, checking for empty stock...");
            checkWishlistStockStatus(s, "");
        } else {
            bp.log.info("Product quantity was not updated, checking for 'In Stock'...");
            checkWishlistStockStatus(s, "In Stock");
        }

        // Signal admin that the wishlist check is complete
        sync({ request: Event("wishlistCheckCompleted") });

    } catch (error) {
        bp.log.warn(`An error occurred during the user session: ${error.message}`);
    } finally {
        if (s) {
            bp.log.info("Closing user session...");
            s.close();
        }
    }
});
