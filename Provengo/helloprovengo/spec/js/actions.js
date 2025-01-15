// function composeQuery(session, data) {
//   session.writeText(xpaths.searchWindow.searchInput, data.text)
// }
//
// function startSearch(session) {
//   with(session) {
//     click(xpaths.searchWindow.searchButton)
//   }
// }
//
// function feelLucky(session) {
//   with(session) {
//     click(xpaths.searchWindow.feelingLuckyButton)
//   }
// }

function loginAsAdmin(session, username, password) {
  session.writeText(xpaths.loginPageAdmin.usernameInput, username);
  session.writeText(xpaths.loginPageAdmin.passwordInput, password);
  session.click(xpaths.loginPageAdmin.submitButton);
}

function navigateToCoupons(session) {
  session.click(xpaths.dashboardPageAdmin.marketingClick);
  session.click(xpaths.dashboardPageAdmin.couponsButton);
}

function disableCoupon(session) {
  session.click(xpaths.couponListPage.editClick);
  window.scrollTo(0, document.body.scrollHeight);
  session.click(xpaths.couponPage.statusButtonClick);
  window.scrollTo(0, 0);
  session.click(xpaths.couponPage.saveButtonClick);
}