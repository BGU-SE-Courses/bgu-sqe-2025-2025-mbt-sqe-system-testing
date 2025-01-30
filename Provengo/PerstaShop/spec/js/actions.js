/**
 * Logs in the user using the provided credentials.
 * @param {SeleniumSession} session - The user's Selenium session.
 * @param {Object} data - An object containing the user's email and password.
 */
function userLogin(session, data) {
  with (session) {
    // Begin UserLogin
    sync({request: Event("Begin(UserLogin)")});
    // Enters the user's email and password into the respective fields.
    writeText(xpaths.searchWindow.UserMail, data.email);
    writeText(xpaths.searchWindow.UserPassword, data.password);
    // Clicks the login button to submit the credentials.
    click(xpaths.searchWindow.UserLoginButton);
    sync({request: Event("End(UserLogin)")});
    // End UserLogin
  }
}

/**
 * Simulates adding a product to the cart twice and navigating to the shopping cart.
 * @param {SeleniumSession} session - The user's Selenium session.
 */
function addProductToCartTwice(session){
  with (session) {
    sync({request: Event("Begin(addProductToCartTwice)")}); // Begin addProductToCartTwice
    // Clicks the "Add to Cart" button to add the product.
    click(xpaths.searchWindow.addToCart);
    Ctrl.doSleep(2000); // Waits for the UI to update.
    // Clicks the "Close" button to close the cart window.
    click(xpaths.searchWindow.CloseCart);
    Ctrl.doSleep(2000);
    // Clicks the "Add to Cart" button again to add the product a second time.
    click(xpaths.searchWindow.addToCart);
    Ctrl.doSleep(2000);
    // Clicks the shopping cart icon to navigate to the cart page.
    click(xpaths.searchWindow.ShoppingCart);
    Ctrl.doSleep(2500);
    sync({request: Event("End(addProductToCartTwice)")}); // End addProductToCartTwice
  }

}

/**
 * Verifies that the quantity of the added product in the shopping cart is correct (expected to be 2).
 * @param {SeleniumSession} session - The user's Selenium session.
 */
function VerifyQuantity(session) {
  with (session) {
    sync({request: Event("Begin(VerifyQuantity)")}); // Marks the beginning of the quantity verification.
    // Asserts that the quantity of the product in the cart
    assertText(xpaths.searchWindow.Quantity, '2')
    sync({request: Event("End(VerifyQuantity)")}); // End VerifyQuantity

  }
}

/**
 * Simulates the admin modifying the product quantity in the inventory to 1.
 * @param {SeleniumSession} session - The admin's Selenium session.
 */
function adminChangeQuantity(session) {
  with (session) {
    sync({request: Event("Begin(adminChangeQuantity)")}); // Begin adminChangeQuantity
    // Clicks to access the cart update section.
    click(xpaths.searchWindow.UpdateCart);
    Ctrl.doSleep(2000)
    // Updates the quantity of the product to 1.
    writeText(xpaths.searchWindow.AdminQuantity, "1", true)
    Ctrl.doSleep(1000)
    // Clicks the "Done" button to save the changes.
    click(xpaths.searchWindow.done);
    Ctrl.doSleep(1000)
    sync({request: Event("End(adminChangeQuantity)")}); // End adminChangeQuantity

  }
}

/**
 * Verifies that the admin's quantity update was successfully applied.
 * @param {SeleniumSession} session - A separate admin verification session.
 */
function adminVerifyQuantity(session) {
  with (session) {
    sync({request: Event("Begin(adminVerifyQuantity)")}); // Begin adminVerifyQuantity
    // Clicks to access the cart update section.
    click(xpaths.searchWindow.UpdateCart);
    Ctrl.doSleep(2000)
    // Asserts that the quantity of the product in the cart is now 1.
    assertText(xpaths.searchWindow.AdminQuantity, '1')
    Ctrl.doSleep(1000)
    sync({request: Event("End(adminVerifyQuantity)")}); // End adminVerifyQuantity
  }
}





