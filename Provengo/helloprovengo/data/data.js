/* @provengo summon selenium */
/*
 *  Common test data, project-wide constants, etc.
 */
// Export constants and paths for reuse
const URL = 'http://localhost/opencartsite'; // Replace with your OpenCart URL
const adminURL = 'http://localhost/opencartsite/admin-new';

const xpaths = {
  admin: {
    usernameField: '//*[@id="input-username"]',
    passwordField: '//*[@id="input-password"]',
    loginButton: '//*[@id="form-login"]/div[3]/button',
    modalCloseButton: '//*[@id="modal-security"]/div/div/div[1]/button',
    catalogMenu: '//*[@id="menu-catalog"]/a',
    productsSubmenu: '//*[@id="collapse-1"]/li[2]/a',
    firstProductEdit: '//*[@id="form-product"]/div[1]/table/tbody/tr[1]/td[7]/div/a/i',
    dataTab: '//*[@id="form-product"]/ul/li[2]/a',
    productQuantityField: '//*[@id="input-quantity"]',
    saveButton: '//*[@id="content"]/div[1]/div/div/button/i'
  }
};
