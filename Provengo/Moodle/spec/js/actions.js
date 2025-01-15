// function navigate_to_login(session) {
//   sync({request: Event("Start(navigate_to_login)")});
//   session.click(xpaths.loginPage.loginLink);
//   sync({request: Event("End(navigate_to_login)")});
// }
//
// function enter_login_info(session) {
//   sync({request: Event("Start(enter_login_info)")});
//   let textFieldUserName = xpaths.loginPage.usernameInput;
//   let textFieldPassword = xpaths.loginPage.passwordInput;
//   session.clear(textFieldUserName);
//   session.writeText(textFieldUserName, student.UserName);
//   session.clear(textFieldPassword);
//   session.writeText(textFieldPassword, student.Password);
//   sync({request: Event("End(enter_login_info)")});
// }
//
// function click_login(session) {
//   sync({request: Event("Start(click_login)")});
//   session.click(xpaths.loginPage.submitButton);
//   sync({request: Event("End(click_login)")});
// }
//
// function navigate_to_coursePage(session) {
//   sync({request: Event("Start(navigate_to_coursePage)")});
//   session.waitForVisibility(xpaths.coursePage.myCoursesLink);
//   session.click(xpaths.coursePage.myCoursesLink.replace('${courseId}', courseId));
//   session.click(xpaths.coursePage.courseLink);
//   sync({request: Event("End(navigate_to_coursePage)")});
// }
//
// function select_choice(session) {
//   sync({request: Event("Start(select_choice)")});
//   let xpathExpression = xpaths.coursePage.choiceLink;
//   session.click(xpathExpression);
//   sync({request: Event("End(select_choice)")});
// }
//
// function select_choice_option(session) {
//   sync({request: Event("Start(select_choice_option)")});
//   let xpathExpression = xpaths.coursePage.choiceOptionLink.replace('${choiceOptionId}', choiceOptionId1);
//   session.click(xpathExpression);
//   sync({request: Event("End(select_choice_option)")});
// }
//
// function change_choice_option(session, data) {
//   sync({request: Event("Start(select_choice_option)"),block:[Event("Start(disable_change_choice_option)"),Event("End(disable_change_choice_option)")]});
//   let xpathExpression = xpaths.coursePage.choiceOptionLink.replace('${choiceOptionId}', choiceOptionId2);
//   session.click(xpathExpression);
//   sync({request: Event("End(select_choice_option)")});
// }
//
// function submit_choice(session) {
//   sync({request: Event("Start(submit_choice)")});
//   session.click(xpaths.coursePage.submitButton);
//   sync({request: Event("End(submit_choice)")});
// }
//
//
function composeQuery(session, data) {
  session.writeText(xpaths.searchWindow.searchInput, data.text)
}

function startSearch(session) {
  with(session) {
    click(xpaths.searchWindow.searchButton)
  }
}

function feelLucky(session) {
  with(session) {
    click(xpaths.searchWindow.feelingLuckyButton)
  }
}