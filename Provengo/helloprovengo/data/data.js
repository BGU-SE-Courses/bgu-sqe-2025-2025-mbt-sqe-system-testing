/* @provengo summon selenium */
/*
 *  Common test data, project-wide constants, etc.
 */

const URL = 'http://localhost/opencartsite'; // Replace with your OpenCart URL
const adminURL = 'http://localhost/opencartsite/admin';

const xpaths = {
  wishlist: {
    quantityInput: '//input[@name="quantity"]',
    addToWishlistButton: '//button[@id="add-to-wishlist"]'
  },
  admin: {
    usernameField: '//input[@id="input-username"]',
    passwordField: '//input[@id="input-password"]',
    loginButton: '//button[@type="submit"]',
    productEditLink: '//td[contains(text(), "{product}")]/following-sibling::td//a[contains(@href, "edit")]',
    productQuantityField: '//input[@name="quantity"]',
    saveButton: '//button[@type="submit"]'
  }
}
