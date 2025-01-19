/* @provengo summon selenium */
//@provengo summon textassertion
// @provengo summon ctrl


SeleniumSession.prototype.runScript = function (script) {
  bp.log.info("Driver object: " + this.driver);
  return this.driver.executeScript(script);
};


function adminLogin(session) {
  session.writeText(xpaths.admin.usernameField, 'admin'); // Adjust for your admin credentials
  session.writeText(xpaths.admin.passwordField, '1234'); // Adjust for your admin credentials
  session.click(xpaths.admin.loginButton);
}

// Function to set product quantity
function setProductQuantity(session, data) {
  try {
    bp.log.info("Navigating to Catalog > Products...");

    session.waitForClickability(xpaths.admin.catalogMenu, 5000);
    session.click(xpaths.admin.catalogMenu);
    session.waitForClickability(xpaths.admin.productsSubmenu, 5000);
    session.click(xpaths.admin.productsSubmenu); // Navigate to Products

    bp.log.info("Navigated to Products page.");

    bp.log.info("Opening first product for editing...");
    session.waitForClickability(xpaths.admin.firstProductEdit, 5000);
    session.click(xpaths.admin.firstProductEdit); // Click Edit for the first product

    bp.log.info("Switching to Data tab...");
    session.waitForClickability(xpaths.admin.dataTab, 5000);
    session.click(xpaths.admin.dataTab); // Navigate to Data

    bp.log.info("Setting product quantity to: " + data.quantity);
    session.writeText(xpaths.admin.productQuantityField, data.quantity, true); // Clear before writing
    session.writeText(xpaths.admin.productQuantityField, "\n"); // Press Enter key - save the value
    bp.log.info("Product quantity updated successfully.");
  } catch (error) {
    bp.log.warn("Failed to update product quantity: " + error.message);
    throw error;
  }
}
