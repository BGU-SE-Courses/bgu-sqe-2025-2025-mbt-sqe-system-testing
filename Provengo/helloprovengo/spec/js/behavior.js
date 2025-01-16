/* @provengo summon selenium */

// Scenario: User buys an item from the store
bthread('User buys an item from the store', function () {
  let userSession = new SeleniumSession('user_session');

  // User logs in
  userSession.start(URL)
  goToLogin(userSession)
  login(userSession, credentials.user.email, credentials.user.password)
  addItemToCart(userSession)
});
