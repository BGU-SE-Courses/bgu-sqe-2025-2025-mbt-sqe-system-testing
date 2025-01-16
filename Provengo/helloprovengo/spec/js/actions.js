/* @provengo summon selenium */

function composeQuery(session, data) {
  session.writeText(xpaths.searchWindow.searchInput, data.text)
}

function goToLogin(session) {
  session.click(xpaths.home.goToLoginButton)
}

function login(session, email, password) {
  session.writeText(xpaths.login.emailInput, email)
  session.writeText(xpaths.login.passwordInput, password)
  session.click(xpaths.login.submitLoginButton)
}

function addItemToCart(session) {
  session.writeText(xpaths.home.searchField, "T-Shirt"+"\uE006")
  session.click(xpaths.searchResults.firstProduct)
  session.click(xpaths.product.addToCartButton)
}

function proceedToCheckout(session) {
  session.click(xpaths.cartPopUp.proceedToCheckoutButton)
  session.click(xpaths.cart.proceedToCheckoutButton)
}

// function personalInformation(session, firstName, lastName, email, password, birthdate) {
//   session.click(xpaths.checkout.personalInformation.gender)
//   session.writeText(xpaths.checkout.personalInformation.firstName, firstName)
//   session.writeText(xpaths.checkout.personalInformation.lastName, lastName)
//   session.writeText(xpaths.checkout.personalInformation.email, email)
//   session.writeText(xpaths.checkout.personalInformation.password, password)
//   session.writeText(xpaths.checkout.personalInformation.birthdate, birthdate)
//   session.click(xpaths.checkout.personalInformation.confirmTerms)
//   session.click(xpaths.checkout.personalInformation.confirmPrivacy)
// }

function addresses(session, address, city, state, zipCode, country) {
  session.writeText(xpaths.checkoutAdresses.address, address)
  session.writeText(xpaths.checkoutAdresses.city, city)
  session.selectByVisibleText(xpaths.checkoutAdresses.state, state)
  session.writeText(xpaths.checkoutAdresses.zipCode, zipCode)
  session.selectByVisibleText(xpaths.checkoutAdresses.country, country)
  session.click(xpaths.checkoutAdresses.continueButton)
}

function shippingMethod(session) {
  session.click(xpaths.shippingMethod.continueButton)
}

function payment(session) {
  session.click(xpaths.payment.payByCashButton)
  session.click(xpaths.payment.confirmTerms)
  session.click(xpaths.payment.placeOrderButton)
}

function orderConfirmation(session) {
  session.assertText(xpaths.orderConfirmation.successMessage, "YOUR ORDER IS CONFIRMED", [TextAssertions.modifiers.Contains]);
}