// @Provengo summon selenium
// @provengo summon Ctrl


function composeQuery(session, data) {

  session.writeText(xpaths.searchWindow.searchInput, data.text)
}


function userLogin(session, data){

  bp.log.info("start login the user");
  bp.log.info("go to login page");
  sync({request: Event("start user login")})
  //let session = e.data.session
  //
  // let user_name = e.data.user_name;
  // let password = e.data.password
  with(session) {
    session.click(xpaths.login.to_login_page)
    bp.log.info("write user email");
    session.writeText(xpaths.login.email_field, data.user_name)
    bp.log.info("write user password");
    session.writeText(xpaths.login.password_field, data.password)
    bp.log.info("click submit");
    session.click(xpaths.login.submit_login)
    bp.log.info("finish login user");
  }
  sync({ request: Event("end user login")});
}




// bthread('selectTheProduct', function () {

function selectTheProduct(session){
  sync({request: Event("start select the product")})
  with (session) {
    bp.log.info("select a product");
    session.click(xpaths.write_comment.shirt)
    bp.log.info("click on the product");
  }
  //
  sync({ request: Event("end of select the product")});
  // }
}



// bthread('userWriteComment', function () {
function userWriteComment(session, data){
   sync({request: Event("start user write comment")})
  // let session = e.data.session
  // let description = e.data.des;
  // let title = e.data.title;

  with(session) {
    // Wait for product to be visible and click it
    bp.log.info("click on write comment");
    session.click(xpaths.write_comment.add_comment_button)
    bp.log.info("select 5 stars");
    session.click(xpaths.write_comment.stars)
    bp.log.info("enter title");
    session.writeText(xpaths.write_comment.title_field, data.title, clearBeforeWrite = true)
    bp.log.info("enter description");
    session.writeText(xpaths.write_comment.description, data.des, clearBeforeWrite = true)
    bp.log.info("submit the comment");
    session.click(xpaths.write_comment.submit_comment)
    bp.log.info("finish to write comment");
    // sync({ request: Event("comment written")});
  }
  sync({ request: Event("end of user write comment")});

}

function goToComment(session){
  sync({request: Event("start go to comment")})
  with(session) {
    bp.log.info("start go to comment");
    bp.log.info("confirm ");
    session.click(xpaths.goToComment.ok_button);
    bp.log.info("go to the comments ");
    //session.scrollToElement(xpaths.goToComment.comments)
    session.runCode(scrolling.toComments);
    Ctrl.doSleep(2000)
  }

  sync({request: Event("end of go to comment")})
}



// bthread('admin login', function () {
//
// }
function adminLogin(session, data){
  sync({request: Event("start admin login")})
  with (session) {
    bp.log.info("start login admin");
    session.writeText(xpaths.admin_login.email_field, data.user_name)
    bp.log.info("add admin email");
    session.writeText(xpaths.admin_login.password_field, data.password)
    bp.log.info("add admin password");
    session.click(xpaths.admin_login.submit_login)
    bp.log.info("submit admin login details");
    bp.log.info("finish login the admin");
  }

  sync({ request: Event("end of admin login")});

//  }
}

function goToAllProducts(session) {
// bthread('searchForProduct', function () {
  sync({request: Event("start go to all products")})
  // let session = e.data.session
  with (session) {
    //session.click(xpaths.search_for_store.menu)
    //Ctrl.doSleep(2000)
    bp.log.info("got to all products page");
    bp.log.info("click on catalog");
    session.click(xpaths.products.catalog)
    //Ctrl.doSleep(2000)
    bp.log.info("click on products");
    session.click(xpaths.products.products)
    bp.log.info("finish to go to products page");
  }

  sync({request: Event("end of go to all products")});

}

function hideProduct(session) {
// bthread('deleteProduct', function () {
// }
  sync({request: Event("start hide product")})
    // let session = e.data.session
  with (session) {

    bp.log.info("hide a product");
    bp.log.info("click on hide button");
    session.click(xpaths.products.product_hide)
    // bp.log.info("click on delete");
    // session.click(xpaths.products.options)
    // bp.log.info("submit deletion");
    // session.click(xpaths.products.no_one_button)
    // session.click(xpaths.products.confirm_button)

    bp.log.info("finish to hide product");

    // bp.log.info("deleting a product");
    // bp.log.info("click on more options button");
    // session.click(xpaths.products.more_options)
    // bp.log.info("click on delete");
    // session.click(xpaths.products.delete_product)
    // bp.log.info("submit deletion");
    // session.click(xpaths.products.submit_deletion)
    // bp.log.info("finish to delete product");

  }
  sync({request: Event("end of hide product")});
    // }

}

function goToProduct(session){
  sync({request: Event("start go to product")})
  with (session){
    session.runCode(scrolling.down)
  }

  //session.click(xpaths.products.product)
  sync({request: Event("end go to product")})
}






















// bthread('no two delete same high level same time', function (){
//   while (true){
//     sync({waitFor: any({high:true, task:2})})
//     // let taskNum =e.data.task
//     sync({
//       waitFor: any("end of high level action", {task:2}),
//       block : any ({high:true , task:2})
//     })
//   }
// })

// bthread('no two comment same high level same time', function (){
//   while (true){
//     sync({waitFor: any({high:true , task:1})})
//     sync({
//       waitFor: any("end of high level action"),
//       block : any ({high:true , task:1})
//     })
//   }
// })


// bthread("write comment only after login", function (){
//   sync({waitFor: any("userLogin"), block: any("user write comment")})
// });
//
// bthread("write comment only after select product", function (){
//   sync({waitFor: any("select the product"), block: any("user write comment")})
// });
//
// bthread("delete only after write comment", function (){
//   sync({waitFor: any("comment written"), block: any("delete product")})
// });
//
// bthread("search for product only after admin login", function (){
//   sync({waitFor: any("adminLogin"), block: any("search for product")})
// });
//
// bthread("delete product only after search for product ", function (){
//   sync({waitFor: any("search for product"), block: any("delete product")})
// });
