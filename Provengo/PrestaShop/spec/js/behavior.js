// Index Map:
// 0. Prevents the customer from logging in
// 1. Restricts access to the customer's details page
// 2. Disables the ability to change and save the customer's name


let index = 2; // Changing this to 0, 1 or 2 in order to test different scenarios
bthread(session.admin, function () {
  let s = new SeleniumSession(session.admin);
  s.start(adminURL);

  adminLogin(s, credentials.admin);
  adminGoesToCustomersPage(s);
  adminSearchCustomer(s, credentials.user[index]);
  adminDisableCustomer(s, credentials.user[index]);


});


bthread(session.user, function () {
  let s = new SeleniumSession(session.user);
  s.start(userURL);

  userLogin(session.user, s, credentials.user[index]);
  goToInformation(session.user, s);
  changeUserName(session.user, s, credentials.user[index]);

})


bthread("user_can't_login_after_disabled", function () {
  if (index === 0) {
    sync({
      waitFor: Event("End(adminDisablesCustomer)"),
      block: Event("Begin(login)")
    })

  }
})

bthread("user_can't_go_to_information_page_after_disabled", function () {
  if (index === 1) {
    sync({
      waitFor: Event("End(adminDisablesCustomer)"),
      block: Event("Begin(goToInformation)")
    })
  }
})

bthread("user_can't_change_name_after_disabled", function () {
  if (index === 2) {
    sync({
      waitFor: Event("End(adminDisablesCustomer)"),
      block: Event("Begin(changeName)")
    })
  }
})


