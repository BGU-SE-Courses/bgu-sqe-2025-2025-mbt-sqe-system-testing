/* @provengo summon selenium */
// import { bthread } from 'provengo';
/**
 * This story simulates a user writing a comment on a product and then the admin deleting the product.
 */
bthread('User writes comment and Admin deletes product', function () {
  // Start a Selenium session for the user action
  let s = new SeleniumSession('comment');
  s.start(URL); // The URL of your product page
  userLogin(s, {user_name : 'KTNADAV@GMAIL.COM', password: 'Nadavktalav'})
  // User action: Writing a comment to the product
  userWriteComment(s, { title: "good shirt", des : 'This is a great comment about the shirt.' });

});
//
// bthread('admin delete the product', function () {
//   // Start a Selenium session for the user action
//   let s = new SeleniumSession('delete' );
//
//
//   s.start(URL_ADMIN); // The URL of your product page
//   // s.writeText()
//   s.runCode({}, function() {
//     window.resizeTo(1920, 1080);  // Resizing the window to 1920x1080
//   });
//
//   // s.resizeTo(screen.width, screen.height)
//   // s.fullscreen_window()
//   // s.Window()
//   adminLogin(s, {user_name : 'KTNADAV@GMAIL.COM', password: 'Nadavktalav'})
//   //viewStore(s)
//   Ctrl.doSleep(1000)
//   // s.waitForClickability(xpaths.search_for_store.catalog, 10000)
//   searchForProduct(s, {productName: xpaths.search_for_store.product_name})
//   // User action: Writing a comment to the product
//   deleteProduct(s);
//
// });
