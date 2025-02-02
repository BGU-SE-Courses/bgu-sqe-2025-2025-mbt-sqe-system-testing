function adminLogin(session, data) {
  with (session) {
    sync({request: Event("Begin(adminLogin)")});
    writeText(xpaths.admin.emailXpath, data.email);
    writeText(xpaths.admin.passwordXpath, data.password);
    click(xpaths.admin.submitButtonXpath);
    sync({request: Event("End(adminLogin)")});
  }
}

function adminGoesToCustomersPage(session) {
  with (session) {
    sync({request: Event("Begin(adminGoesToCustomersPage)")});
    waitForVisibility(xpaths.admin.customersMenuXpath, WAIT_TIMEOUT * 1000); u
    click(xpaths.admin.customersMenuXpath);
    sync({request: Event("End(adminGoesToCustomersPage)")});
  }

}

function adminSearchCustomer(session, customer) {
  with (session) {
    sync({request: Event("Begin(adminSearchCustomer)")});
    waitForVisibility(xpaths.admin.searchFieldXpath, WAIT_TIMEOUT * 1000);
    //scrollToBottom();
    clear(xpaths.admin.searchFieldXpath);
    writeText(xpaths.admin.searchFieldXpath, customer.email);
    waitForVisibility(xpaths.admin.searchButtonXpath, WAIT_TIMEOUT * 1000);
    click(xpaths.admin.searchButtonXpath,WAIT_TIMEOUT * 1000);
    sync({request: Event("End(adminSearchCustomer)")});

  }
}

function adminDisableCustomer(session, customer) {
  with (session) {

    sync({request: Event("Begin(adminDisablesCustomer)")});
    waitForVisibility(xpaths.admin.disableCustomerCheckboxXpath, WAIT_TIMEOUT * 1000);
    click(xpaths.admin.disableCustomerCheckboxXpath)
    sync({request: Event("End(adminDisablesCustomer)")});

  }
}


function userLogin(session, s, user) {
  with (s) {
    sync({request: Event("Begin(login)")})
    click(xpaths.user.signIn,WAIT_TIMEOUT * 1000);
    writeText(xpaths.user.email, user.email);
    writeText(xpaths.user.password, user.password);
    click(xpaths.user.signInButton);
    sync({request: Event("End(login)")})


  }
}

function goToInformation(session, s) {
  with (s) {
    sync({request: Event("Begin(goToInformation)")})

    click(xpaths.user.userAccount, WAIT_TIMEOUT * 1000);
    click(xpaths.user.userInfo, WAIT_TIMEOUT * 1000)
    sync({request: Event("End(goToInformation)")})


  }
}

function changeUserName(session, s, user) {
  with (s) {
    sync({request: Event("Begin(changeName)")});
    //sleep(3000);
    clear(xpaths.user.firstNameUserPage)
    writeText(xpaths.user.firstNameUserPage, user.newFirstName);
    writeText(xpaths.user.passwordUserPage, user.password);
    scrollToElement(xpaths.user.dataPrivacyUserPage)
    click(xpaths.user.dataPrivacyUserPage);
    scrollToElement(xpaths.user.termsOfServiceUserPage)
    click(xpaths.user.termsOfServiceUserPage);
    scrollToElement(xpaths.user.saveButtonUserPage)
    click(xpaths.user.saveButtonUserPage);
    waitForVisibility(xpaths.user.changeNameMSG, WAIT_TIMEOUT * 1000);
    sync({request: Event("End(changeName)")});

  }
}

