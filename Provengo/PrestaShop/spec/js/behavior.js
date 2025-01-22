/* @provengo summon selenium */
// @provengo summon Ctrl

/**
 * This story simulates a user writing a comment on a product and then the admin deleting the product.
 */
bthread('User writes comment', function () {
  // Start a Selenium session for the user action
  let s = new SeleniumSession('comment');

  s.start(URL); // The URL of your product page

  userLogin(s, {user_name : 'NADAV@GMAIL.COM', password: 'Nadavktalav'});

  selectTheProduct(s)

  userWriteComment(s, { title: "good shirt", des : 'This is a great comment about the shirt.' });

  goToComment(s)

  Ctrl.doSleep(2000)

});

//
bthread('admin delete the product', function () {
  // Start a Selenium session for the user action
  let s = new SeleniumSession('delete' );

  s.start(URL_ADMIN); // The URL of your product page

  adminLogin( s, {user_name : 'KTNADAV@GMAIL.COM', password: 'Nadavktalav'});

  goToAllProducts(s, { productName: xpaths.products.product_name});

  hideProduct(s);

  goToProduct(s)

  Ctrl.doSleep(2000)

 }
);


//todo think about if needed the syncronization
// bthread("delete product only after comment writen ", function (){
//   sync({waitFor: any("end of go to comment"), block: any("start delete product")})
// });




