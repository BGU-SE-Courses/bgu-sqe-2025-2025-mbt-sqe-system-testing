/* @provengo summon selenium */

function adminLogin(session) {
  session.writeText('//*[@id="input-username"]', 'admin') // Adjust for your admin credentials
  session.writeText('//*[@id="input-password"]', '1234') // Adjust for your admin credentials
  session.click('//*[@id="form-login"]/div[3]/button')
}

function setProductQuantity(session, data) {
  bp.log.info("Navigating to Catalog > Products...");
  // Check for and handle the modal pop-up
  session.click('//*[@id="modal-security"]/div/div/div[1]/button');
  bp.log.info("Modal closed successfully.");

  session.click('//*[@id="menu-catalog"]/a');
  session.click('//*[@id="collapse-1"]/li[2]/a'); // Navigate to Products
  bp.log.info("Navigated to Products page.");

  bp.log.info("Opening first product for editing...");
  session.click('//*[@id="form-product"]/div[1]/table/tbody/tr[1]/td[7]/div/a/i'); // Click Edit for the first product

  bp.log.info("Switching to Data tab...");
  session.click('//*[@id="form-product"]/ul/li[2]/a'); // Navigate to Data

  bp.log.info("Setting product quantity to: " + data.quantity);
  session.writeText('//*[@id="input-quantity"]', data.quantity);

  bp.log.info("Saving changes...");
  session.click('//*[@id="content"]/div[1]/div/div/button/i'); // Save changes
  bp.log.info("Product quantity updated successfully.");
}