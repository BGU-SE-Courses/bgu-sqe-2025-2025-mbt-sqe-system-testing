/*
 *  This is a good place to put common test data, project-wide constants, etc.
 */

const URL = 'http://localhost/stradivarious/en';

const xpaths = {
  login: {
    emailInput: "//*[@id=\"field-email\"]",
    passwordInput: "//*[@id=\"field-password\"]",
    submitLoginButton: "//*[@id=\"submit-login\"]"
  },
  home: {
    goToLoginButton: "/html/body/main/header/nav/div/div/div[1]/div[2]/div[2]/div/a",
    searchField: "/html/body/main/header/div[2]/div/div[1]/div[2]/div[2]/form/input[2]"
  },
  searchResults: {
    firstProduct: "/html/body/main/section/div/div/div/section/section/div[3]/div[1]/div"
  },
  product: {
    addToCartButton: "/html/body/main/section/div/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/button"
  },
  cartPopUp: {
    proceedToCheckoutButton: "//*[@id='blockcart-modal']/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/a[1]"
  },
  cart: {
    proceedToCheckoutButton: "//body/main[1]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/a[1]"
  },
  checkoutAdresses: {
      // gender: "//*[@id='field-id_gender-1']",
      // firstName: "//*[@id='field-firstname']",
      // lastName: "//*[@id='field-lastname']\n",
      // email: "//*[@id='customer-form']/div[1]/div[4]/div[1]/input[1]",
      // password: "//*[@id='customer-form']/div[1]/div[5]/div[1]/div[1]/div[1]/input[1]",
      // birthdate: "//input[@name=\"birthday\"]",
      // confirmTerms: "//input[@name=\"psgdpr\"]",
      // confirmPrivacy: "//input[@name=\"customer_privacy\"]",
      address: "//input[@name=\"address1\"]",
      city: "//input[@name=\"city\"]",
      zipCode: "//input[@name=\"postcode\"]",
      state: "//select[@name='id_state']",
      country: "//select[@name=\"id_country\"]",
      continueButton: "//button[@name=\"confirm-addresses\"]"
  },
  shippingMethod: {
    continueButton: "//button[@name=\"confirmDeliveryOption\"]"
  },
  payment: {
    payByCashButton: "//*[@id=\"payment-option-1\"]",
    confirmTerms: "//*[@id='conditions-to-approve']/ul[1]/li[1]/div[1]/span[1]/input[1]",
    placeOrderButton: "//*[@id='payment-confirmation']/div[1]/button[1]"
  },
  orderConfirmation: {
    successMessage: "//*[@id='content-hook_order_confirmation']/div[1]/div[1]/div[1]/h3"
  }
}

const userDetails = {
  user: {
    firstName: "John",
    lastName: "Levi",
    birthdate: "01/01/1990",
    address: "3171 David Mission",
    city: "West Emilytown",
    state: "Michigan",
    zipCode: "13289",
    country: "United States",
    email: 'john@gmail.com',
    password: 'JohnLevi456'
  },
  admin: {
    email: 'shachco@post.bgu.ac.il',
    password: 'Shachar123?!'
  }  
};