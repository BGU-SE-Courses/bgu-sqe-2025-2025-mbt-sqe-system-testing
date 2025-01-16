function composeQuery(session, data) {

  session.writeText(xpaths.searchWindow.searchInput, data.text)
}

function userLogin(session, data) {
  with (session){
    session.click(xpaths.login.to_login_page)
    session.writeText(xpaths.login.email_field , data.user_name)
    session.writeText(xpaths.login.password_field , data.password)
    session.click(xpaths.login.submit_login)
  }
}

function adminLogin(session, data) {
  with (session){
    session.writeText(xpaths.admin_login.email_field , data.user_name)
    session.writeText(xpaths.admin_login.password_field , data.password)
    session.click(xpaths.admin_login.submit_login)
    Ctrl.doSleep(5000)

  }
}

function searchForProduct(session, data){
  with (session){
    //session.click(xpaths.search_for_store.menu)
    Ctrl.doSleep(2000)
    session.click(xpaths.search_for_store.catalog)
    Ctrl.doSleep(2000)
    session.click(xpaths.search_for_store.products)

    session.writeText(xpaths.search_for_store.search_by_name, data.productName)
    session.click(xpaths.search_for_store.submit_search)
    // session.click(xpaths.search_for_store.more_options)
    // session.click(xpaths.search_for_store.delete_product)
  }
}
function deleteProduct(session){
  with (session){
    session.click(xpaths.search_for_store.more_options)
    session.click(xpaths.search_for_store.delete_product)
  }
}


function userWriteComment(session, data) {
  with(session) {
    // Wait for product to be visible and click it
    session.click(xpaths.write_comment.shirt)
    session.click(xpaths.write_comment.add_comment_button)
    session.click(xpaths.write_comment.stars)
    session.writeText(xpaths.write_comment.title_field, data.title)
    session.writeText(xpaths.write_comment.description , data.des)
    session.click(xpaths.write_comment.submit_comment)

  }
}

