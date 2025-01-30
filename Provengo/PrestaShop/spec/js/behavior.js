/* @provengo summon selenium */
// @provengo summon Ctrl
/* @provengo summon constraints */

/**
 * This story simulates a user writing a comment on a product and then the admin deleting the product.
 */

bthread('User writes comment', function () {
  // Start a Selenium session for the user action
  //
  //   sync({waitFor: any("end of before")})
    let s = new SeleniumSession('comment');
    s.start(URL); // The URL of your product page
    userLogin(s, {user_name: 'NADAV@GMAIL.COM', password: 'Nadavktalav'});
    interrupt(any("just before deletion"), function() {
        selectTheProduct(s)
        userWriteComment(s, {title: "good shirt", des: 'This is a great comment about the shirt.'});
        s.refresh();
        goToComment(s);

    }

  )


});


bthread('admin delete the product', function () {
  // Start a Selenium session for the user action
  //   sync({waitFor: any("end of before")})
    let s = new SeleniumSession('delete');
    s.start(URL_ADMIN); // The URL of your product page
    // Ctrl.doSleep(10000);

    adminLogin( s, {user_name : 'KTNADAV@GMAIL.COM', password: 'Nadavktalav'});

    goToAllProducts(s, { productName: xpaths.products.product_name});
    deleteProduct(s);
    goToProduct(s)

    Ctrl.doSleep(5000)

 }
);

// if the teacher thread finish before the user thread interrupt function
bthread("if delete product stop write comment", function (){
    Constraints.after(any("just before deletion")).block(any("start of select the product")).forever();
});



//
// bthread("before" , function () {
//     let s = new SeleniumSession('before admin');
//     s.start(URL_ADMIN); // The URL of your product page
//     // Ctrl.doSleep(10000);
//     adminLogin_before( s, {user_name : 'KTNADAV@GMAIL.COM', password: 'Nadavktalav'});
//     goToAllProducts_before(s);
//     add_product_before(s)
//
//     let s2 = new SeleniumSession('before user');
//     s2.start(URL)
//     userLogin_before(s2, {user_name: 'NADAV@GMAIL.COM', password: 'Nadavktalav'});
//     selectTheProduct_before(s2)
//     userWriteComment_before(s2, {title: "good shirt", des: 'This is a great comment about the shirt.'});
//     s2.refresh();
//     sync({request: Event("end of before")});
//
//
//
// })






