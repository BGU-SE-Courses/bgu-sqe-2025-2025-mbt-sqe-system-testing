const userURL = "http://localhost:8080";
const CHROME_DRIVER_PATH = "C:\\Users\\yuval\\IdeaProjects\\2025-mbt-j\\Selenium\\chromedriver.exe";
const WAIT_TIMEOUT = 15;
const MINI_WAIT_TIMEOUT = 3
const adminURL =
    "http://localhost:8080/admina/index.php?controller=AdminLogin&token=025b338968c09d3426985ad12eb835d1";
const session = {admin: "ADMIN_SESSION", user: "USER_SESSION"};
const credentials = {
  admin: {
    email: "demo@prestashop.com",
    password: "prestashop_demo",
  },
  user: [
    {
      email: "timH@gmail.com ",
      password: "Tt123456!",
      newFirstName: "TimH",
      id: "5",
    },
    {
      email: "timH@gmail.com ",
      password: "Tt123456!",
      newFirstName: "TimH",
      id: "6",
    },
    {
      email: "timH@gmail.com ",
      password: "Tt123456!",
      newFirstName: "TimH",
      id: "7",
    },
  ],
};

const xpaths = {
  admin: {
    emailXpath: '//*[@id=\'email\']',
    passwordXpath: '//*[@id=\'passwd\']',
    submitButtonXpath: "//*[@id='submit_login']",
    customersMenuXpath: "//section[5]/ul[1]/li[1]/span[1]/a[1]",
    searchFieldXpath: '//*[@id=\'customer_email\']',
    searchButtonXpath: '//td[14]/button[1]',
    disableCustomerCheckboxXpath:
        '//*[@id=\'input-false-admin_customers_toggle_status-4\']',
  },
  user: {
    signIn: "//*[@id='_desktop_user_info']/div/a/span[1]",
    email: "//*[@id='login-form']/div/div/div/input[1]",
    password: "//*[@id='login-form']/div[1]/div[2]/div[1]/div[1]/input[1]",
    signInButton: "//*[@id='login-form']/footer[1]/button[1]",
    account: "//*[@id='_desktop_user_info']/div/a/span[1]",
    userAccount: "//div[2]/div[1]/a[2]/span[1]",
    userInfo:"//a[1]/span[1]/i[1]",
    firstNameUserPage: "//*[@id='customer-form']/div[1]/div[2]/div[1]/input[1]",
    passwordUserPage:
        "//*[@id='customer-form']/div[1]/div[5]/div[1]/div[1]/div[1]/input[1]",
    dataPrivacyUserPage:
        "//*[@id='customer-form']/div[1]/div[9]/div[1]/span[1]/label[1]/input[1]",
    termsOfServiceUserPage:
        "//*[@id='customer-form']/div[1]/div[11]/div[1]/span[1]/label[1]/input[1]",
    saveButtonUserPage: "//*[@id='customer-form']/footer/button[1]",
    changeNameMSG: "//*[@id='notifications']/div/article/ul/li[1]",
    HomePage: "//*[@id='_desktop_logo']/a/img[1]",
  },

};
