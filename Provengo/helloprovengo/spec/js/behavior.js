/* @provengo summon selenium */

// Scenario: User buys an item from the store
bthread('User buys an item from the store', function () {
  let userSession = new SeleniumSession('user_session');

  // User logs in
  userSession.start(URL)
  goToLogin(userSession)
  login(userSession, userDetails.user.email, userDetails.user.password)
  addItemToCart(userSession)
  proceedToCheckout(userSession)
  // personalInformation(userSession, userDetails.user.firstName, userDetails.user.lastName, userDetails.user.email, userDetails.user.password, userDetails.user.birthdate)
  addresses(userSession, userDetails.user.address, userDetails.user.city, userDetails.user.state, userDetails.user.zipCode, userDetails.user.country)
  shippingMethod(userSession)
  payment(userSession)
  orderConfirmation(userSession)
});
