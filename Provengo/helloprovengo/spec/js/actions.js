/* @provengo summon selenium */

function adminLogin(session) {
  session.writeText(xpaths.admin.usernameField, 'admin'); // Adjust for your admin credentials
  session.writeText(xpaths.admin.passwordField, '1234'); // Adjust for your admin credentials
  session.click(xpaths.admin.loginButton);
}

function setProductQuantity(session, data) {
  bp.log.info("Navigating to Catalog > Products...");

  // Handle the modal pop-up
  try {
    session.click(xpaths.admin.modalCloseButton);
    bp.log.info("Modal closed successfully.");
  } catch (e) {
    bp.log.info("No modal appeared.");
  }

  session.click(xpaths.admin.catalogMenu);
  session.click(xpaths.admin.productsSubmenu); // Navigate to Products
  bp.log.info("Navigated to Products page.");

  bp.log.info("Opening first product for editing...");
  session.click(xpaths.admin.firstProductEdit); // Click Edit for the first product

  bp.log.info("Switching to Data tab...");
  session.click(xpaths.admin.dataTab); // Navigate to Data

  bp.log.info("Setting product quantity to: " + data.quantity);
  session.writeText(xpaths.admin.productQuantityField, data.quantity);

  bp.log.info("Saving changes...");
  session.click(xpaths.admin.saveButton); // Save changes
  bp.log.info("Product quantity updated successfully.");
}
