/* @provengo summon selenium */

// This behavioral thread (bthread) simulates a user scenario where a logged-in user adds a product to the cart twice.
// After adding the product, the quantity in the cart is verified.
bthread(session.user, function () {
  let s = new SeleniumSession(session.user);

  // Starts a new Selenium session for the user.
  s.start(URL);

  // Logs the user into the application using the provided email and password.
  userLogin(s, { email: 'einavcohen124@gmail.com', password: 'Einav0907' });

  // Simulates adding the same product to the cart twice.
  addProductToCartTwice(s);

  // Verifies that the quantity of the product in the cart is correct (expected to be 2).
  VerifyQuantity(s)

  // Signals that the user scenario is completed, allowing other threads to synchronize based on this event.
  bp.sync({ request: bp.Event("UserScenarioCompleted") });
});

// This behavioral thread (bthread) simulates an admin scenario where the admin changes the product availability.
bthread(session.admin, function () {
  let s = new SeleniumSession(session.admin);

  // Starts a new Selenium session for the admin.
  s.start(AdminURL);

  // The admin updates the product quantity, setting the availability to one.
  adminChangeQuantity(s);

  // A new session to verify that the changes made by the admin are correctly reflected.
  let s_check = new SeleniumSession(session.check);
  s_check.start(AdminURL);

  // Verifies that the product quantity has been updated correctly according to the admin’s changes.
  adminVerifyQuantity(s_check)
});



