/*
 *  This is a good place to put common test data, project-wide constants, etc.
 */

const URL = 'http://localhost/nadav/';
const URL_ADMIN = "http://localhost/nadav/admin123"

const xpaths = {
  login: {
    to_login_page: "//*[@id='_desktop_user_info']/div/a",
    email_field: "//*[@id='field-email']",
    password_field: "//*[@id=\'field-password\']", //
    submit_login: "//*[@id=\'submit-login\']"
  },
  write_comment: {
    shirt: "//*[@id='content']/section[1]/div/div[1]",
    add_comment_button: "//*[@id=\'add-to-cart-or-refresh\']/div[3]/div[2]/button",
    stars : "//*[@id='criterions_list']/li/div/div/div[2]/div[5]",
    title_field: "//*[@id=\'comment_title\']",
    description: "//*[@id='comment_content']",
    submit_comment: "//*[@id=\'post-product-comment-form\']/div[2]/div[2]/button[2]"
  },
  admin_login: {
    email_field: "//*[@id=\'email\']",
    password_field: "//*[@id=\'passwd\']", //

    submit_login: "//*[@id=\'submit_login\']"
  },
  search_for_store:{
    menu : "//*[@id=\'header_infos\']/i",
    catalog: "//*[@id=\"subtab-AdminCatalog\"]",
    products : "//*[@id=\'subtab-AdminProducts\']/a",
    product_name: "Hummingbird printed t-shirt",
    search_by_name : "//*[@id=\'product_name\']",
    submit_search : "//*[@id=\'product_grid_table\']/thead/tr[2]/td[11]/button",
    more_options: "//*[@id=\"product_grid_table\"]/tbody/tr/td[11]/div/div/a[2]",
    delete_product : "//*[@id=\"product_grid_table\"]/tbody/tr/td[11]/div/div/div/a[3]"


  }

}

