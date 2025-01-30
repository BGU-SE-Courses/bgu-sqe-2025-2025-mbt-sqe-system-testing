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
    search_win: "//*[@id='search_widget']/form/input[2]",
    press_on_shirt: "//*[@id='js-product-list']/div[1]/div/article/div/div[1]/a/picture/img",
    shirt: "//*[@id='content']/section[1]/div/div[1]",
    add_comment_button: "//*[@id='product-comments-list-footer']/button",
    stars : "//*[@id='criterions_list']/li/div/div/div[2]/div[5]",
    title_field: "//*[@id=\'comment_title\']",
    description: "//*[@id='comment_content']",
    submit_comment: "//*[@id=\'post-product-comment-form\']/div[2]/div[2]/button[2]"
  },
  goToComment:{
    // ok_button : "//*[@id=\'product-comment-posted-modal\']/div/div/div[2]/div[2]/button",
    comments: "//*[@id=\'product-comments-list-header\']/div[1]"
  },
  admin_login: {
    email_field: "//*[@id=\'email\']",
    password_field: "//*[@id=\'passwd\']", //
    submit_login: "//*[@id=\'submit_login\']"
  },
  products:{
    options: "//*[@id='product_options-tab-nav']/a",
    no_one_button: "//*[@id=\"product_options_visibility_visibility\"]/div[4]/label/i",
    confirm_button: "//*[@id=\"product_footer_save\"]",
    menu : "//*[@id=\'header_infos\']/i",
    catalog: "//*[@id=\"subtab-AdminCatalog\"]",
    products : "//*[@id=\'subtab-AdminProducts\']/a",
    product_name: "Hummingbird printed t-shirt",
    search_by_name : "//*[@id=\'product_name\']",
    submit_search : "//*[@id=\'product_grid_table\']/thead/tr[2]/td[11]/button",
    more_options: "//*[@id=\"product_grid_table\"]/tbody/tr/td[11]/div/div/a[2]",
    delete_product : "//*[@id=\"product_grid_table\"]/tbody/tr/td[11]/div/div/div/a[3]",
    submit_deletion: "//*[@id=\'product-grid-confirm-modal\']/div/div/div[3]/button[2]",
    product : "//*[@id=\"product_grid_table\"]/tbody/tr[17]/td[4]/a",
    product_hide :"//*[@id=\"product_grid_table\"]/tbody/tr[17]/td[10]/div/div/span"
  },

  before:{
    add_prod :"//*[@id=\"page-header-desc-configuration-add\"]",
    add_prod_second : "//*[@id=\"create_product_create\"]",
    prod_name: "//*[@id=\"product_header_name_2\"]",
    save_button:"//*[@id=\"product_footer_save\"]",
    back_to_catalog:"//*[@id='product_footer_actions_catalog']/span",
    online : "//*[@id=\"product_header_active_0\"]"
  }
}

const scrolling = {
  down: function () {window.scrollTo(0,document.body.scrollHeight); pvg.success("yes");},
  up: function () {window.scrollTo(0,0); pvg.success("yes");},
  toComments: function () {
    xpath = "//*[@id='product-comments-list']"
    var element = document.evaluate(xpath, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
    if (element) {
      element.scrollIntoView({ behavior: "smooth" });
      console.log("Scrolled to element successfully.");
    }
  },
  toProduct: function () {
    xpath = "//*[@id=\"product_grid_table\"]/tbody/tr[17]/td[4]/a"
    var element = document.evaluate(xpath, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
    if (element) {
      element.scrollIntoView({ behavior: "smooth" });
      console.log("Scrolled to element successfully.");
    }
  }
}
