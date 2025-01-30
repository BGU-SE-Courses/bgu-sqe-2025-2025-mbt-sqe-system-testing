/*
 *  This is a good place to put common test data, project-wide constants, etc.
 */

const URL = 'http://localhost:8080/login?back=http%3A%2F%2Flocalhost%3A8080%2Fwomen%2F2-9-brown-bear-printed-sweater.html';
const AdminURL = 'http://localhost:9090/index.php?route=/sql&pos=0&db=prestashop&table=ps_cart_product';
const session = {admin: "ADMIN_SESSION", user: "USER_SESSION", check:"CHECK_SESSION"}; // Session names

const xpaths = {
  searchWindow: {

    UserMail: '/html/body/main/section/div/div/div/section/div/section/form/div/div[1]/div[1]/input',
    UserPassword:'/html/body/main/section/div/div/div/section/div/section/form/div/div[2]/div[1]/div/input',
    UserLoginButton: '/html/body/main/section/div/div/div/section/div/section/form/footer/button',
    addToCart: '/html/body/main/section/div/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/button',
    CloseCart: '/html/body/div[1]/div/div/div[2]/div/div[2]/div/div/button',
    ShoppingCart: '/html/body/div/div/div/div[2]/div/div[2]/div/div/a',
    TshirtWindow: '/html/body/main/section',
    Quantity: '/html/body/main/section/div/div/div/section/div/div/div/div[2]/ul/li/div/div[3]/div/div[2]/div/div/div/input',
    UpdateCart: '/html/body/div[7]/div[5]/form[2]/div[1]/div/table/tbody/tr[1]/td[2]/span/a',
    AdminQuantity: '/html/body/div[7]/form/div/table/tbody/tr[7]/td[5]/input[2]',
    done: '/html/body/div[7]/form/div/table/tfoot/tr/th/input',
    VerifyQuantity: '/html/body/div[7]/div[5]/form[2]/div/div/table/tbody/tr/td[11]/span',
  }
}

const credentials = {
  user: {
    email: 'einavcohen124@gmail.com',
    password: 'Einav0907'
    }}

const searchTerm = 'pizza'
const ml = '//*[@id=\'_desktop_user_info\']/div/a/span[1]'
const mp = '//*[@id=\'login-form\']/div/div/div/input[1]'
