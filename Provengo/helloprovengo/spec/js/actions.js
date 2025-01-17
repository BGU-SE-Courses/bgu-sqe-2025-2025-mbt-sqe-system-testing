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

function loginAsAdmin(session) {
  session.writeText(xpaths.loginPageAdmin.usernameInput, adminDetails.username);
  session.writeText(xpaths.loginPageAdmin.passwordInput, adminDetails.password);
  session.click(xpaths.loginPageAdmin.submitButton);

  closeSecurityModal(session);

}

function closeSecurityModal(session) {
  // Wait for the modal dialog to be visible
  waitForElement(session, 'div#modal-security');

  // Click the close button on the modal
  session.click('button.btn-close[data-bs-dismiss="modal"]');

  // Wait for the modal backdrop to disappear
  waitForElement(session, 'div.modal-backdrop.show', 10000);
}
function waitForElement(session, selector, timeout = 10000) {
  const pollInterval = 500; // Check every 500ms
  const startTime = Date.now();

  while (Date.now() - startTime < timeout) {
    const elements = session.findElement(selector);
    if (elements.length > 0) {
      return; // Element found
    }
    session.sleep(pollInterval); // Wait before trying again
  }

  throw new Error(`Timeout: Element "${selector}" not found within ${timeout}ms`);
}
function navigateToCoupons(session) {
  session.click(xpaths.dashboardPageAdmin.marketingClick);
  session.click(xpaths.dashboardPageAdmin.couponsButton);
}

function disableCoupon(session) {
  session.click(xpaths.couponListPage.editClick);
  session.executeScript('window.scrollTo(0, document.body.scrollHeight);');
  session.click(xpaths.couponPage.statusButtonClick);
  session.executeScript('window.scrollTo(0, 0);');
  session.click(xpaths.couponPage.saveButtonClick);
}