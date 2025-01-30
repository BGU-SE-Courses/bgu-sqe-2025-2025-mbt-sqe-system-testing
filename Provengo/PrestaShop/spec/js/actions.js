// @Provengo summon selenium
// @provengo summon Ctrl


// function composeQuery(session, data) {
//
//   session.writeText(xpaths.searchWindow.searchInput, data.text)
// }


function userLogin(session, data){

  bp.log.info("start login the user");

  sync({request: Event("start of user login")})

  with(session) {
    bp.log.info("go to login page");
    session.click(xpaths.login.to_login_page)
    bp.log.info("write user email");
    session.writeText(xpaths.login.email_field, data.user_name)
    bp.log.info("write user password");
    session.writeText(xpaths.login.password_field, data.password)
    bp.log.info("click submit");
    session.click(xpaths.login.submit_login)
    bp.log.info("finish login user");
  }
  sync({ request: Event("end of user login")});
}





function selectTheProduct(session){
  sync({request: Event("start of select the product")})
  with (session) {
    bp.log.info("select a product");
    session.writeText(xpaths.write_comment.search_win, xpaths.products.product_name)
    session.writeText(xpaths.write_comment.search_win, "\n")
    session.click(xpaths.write_comment.press_on_shirt)
    bp.log.info("click on the product");
  }
  sync({ request: Event("end of select the product")});
}




function userWriteComment(session, data){
   sync({request: Event("start of user write comment")})

  with(session) {
    bp.log.info("click on write comment");
    session.click(xpaths.write_comment.add_comment_button)
    bp.log.info("select 5 stars");
    session.click(xpaths.write_comment.stars)
    bp.log.info("enter title");
    session.writeText(xpaths.write_comment.title_field, data.title, clearBeforeWrite = true)
    bp.log.info("enter description");
    session.writeText(xpaths.write_comment.description, data.des, clearBeforeWrite = true)
    bp.log.info("submit the comment");
    sync({request: Event("just before writing")})
    session.click(xpaths.write_comment.submit_comment)
    bp.log.info("finish to write comment");
  }
  sync({ request: Event("end of user write comment")});

}

function goToComment(session){
  sync({request: Event("start of go to comment")})
  with(session) {
    bp.log.info("start go to comment");
    Ctrl.doSleep(500)
    bp.log.info("go to the comments ");
    session.runCode(scrolling.toComments);
    Ctrl.doSleep(2000)
  }

  sync({request: Event( "end of go to comment" )})
}



function adminLogin(session, data){
  sync({request: Event("start of admin login")})
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
  sync({request: Event("start of go to all products")})
  with (session) {
    bp.log.info("click on catalog");
    session.click(xpaths.products.catalog)
    bp.log.info("click on products");
    session.click(xpaths.products.products)
  }

  sync({request: Event("end of go to all products")});

}

function deleteProduct(session) {
  sync({request: Event("start of delete product")})
  with (session) {
    session.click(xpaths.products.submit_search)
    bp.log.info("deleting a product");
    bp.log.info("click on more options button");
    session.click(xpaths.products.more_options)
    bp.log.info("click on delete");
    session.click(xpaths.products.delete_product)
    bp.log.info("submit deletion");
    sync({request: Event("just before deletion")})
    session.click(xpaths.products.submit_deletion)
    bp.log.info("finish to delete product");

  }
  sync({request: Event("end of delete product")});


}

function goToProduct(session) {
  sync({request: Event("start of go to product")})
  with (session) {
    session.click(xpaths.products.submit_search)
  }
  sync({request: Event("end of go to product")})
}








// function adminLogin_before(session, data) {
//   with (session) {
//     bp.log.info("start login admin");
//     session.writeText(xpaths.admin_login.email_field, data.user_name)
//     bp.log.info("add admin email");
//     session.writeText(xpaths.admin_login.password_field, data.password)
//     bp.log.info("add admin password");
//     session.click(xpaths.admin_login.submit_login)
//     bp.log.info("submit admin login details");
//     bp.log.info("finish login the admin");
//   }
// }





// function goToAllProducts_before(session) {
//   with (session) {
//     session.click(xpaths.products.catalog)
//     session.click(xpaths.products.products)
//   }
// }
//
//
//
// function add_product_before(session) {
//   with (session) {
//     session.click(xpaths.before.add_prod)
//     Ctrl.doSleep(20000);
//     session.click(xpaths.before.add_prod_second)
//     Ctrl.doSleep(5000);
//     session.click(xpaths.before.online)
//     Ctrl.doSleep(5000);
//     session.writeText(xpaths.before.prod_name, xpaths.products.product_name)
//     Ctrl.doSleep(5000);
//     session.click(xpaths.before.save_button)
//
//   }
//
// }
//
// function userLogin_before(session, data){
//
//   with(session) {
//     session.click(xpaths.login.to_login_page)
//     session.writeText(xpaths.login.email_field, data.user_name)
//     session.writeText(xpaths.login.password_field, data.password)
//     session.click(xpaths.login.submit_login)
//   }
// }
//
// function selectTheProduct_before(session){
//   with (session) {
//     session.writeText(xpaths.write_comment.search_win, xpaths.products.product_name)
//     session.writeText(xpaths.write_comment.search_win, "\n")
//     session.click(xpaths.write_comment.press_on_shirt)
//   }
// }
//
// function userWriteComment_before(session, data){
//   with(session) {
//
//     session.click(xpaths.write_comment.add_comment_button)
//     session.click(xpaths.write_comment.stars)
//     session.writeText(xpaths.write_comment.title_field, data.title, clearBeforeWrite = true)
//     session.writeText(xpaths.write_comment.description, data.des, clearBeforeWrite = true)
//     session.click(xpaths.write_comment.submit_comment)
//
//   }
//
// }
