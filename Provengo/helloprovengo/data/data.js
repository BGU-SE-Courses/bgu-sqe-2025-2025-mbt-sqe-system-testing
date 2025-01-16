/*
 *  This is a good place to put common test data, project-wide constants, etc.
 */

const URL = 'http://localhost/stradivarious/en';

const xpaths = {
  home: {
    goToLoginButton: "/html/body/main/header/nav/div/div/div[1]/div[2]/div[2]/div/a",
    searchField: "/html/body/main/header/div[2]/div/div[1]/div[2]/div[2]/form/input[2]",
    searchResult: "//*[@id=\"ui-id-4\"]",
    firstProduct: "/html/body/main/section/div/div/div/section/section/div[3]/div[1]/div"
  },
  login: {
    emailInput: "//*[@id=\"field-email\"]",
    passwordInput: "//*[@id=\"field-password\"]",
    submitLoginButton: "//*[@id=\"submit-login\"]"
  }
}

const credentials = {
  user: {
    email: 'john@gmail.com',
    password: 'JohnLevi456'
  },
  admin: {
    email: 'shachco@post.bgu.ac.il',
    password: 'Shachar123?!'
  }  
};

// const products = {
//   tshirt: "T-Shirt" + Keys.RETURN
// }