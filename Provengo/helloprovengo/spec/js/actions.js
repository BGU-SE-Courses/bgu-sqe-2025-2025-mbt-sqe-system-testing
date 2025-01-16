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
  session.writeText(xpaths.home.searchField, "T-Shirt");
}