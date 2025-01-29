/* @provengo summon selenium */

function goToLoginScreen(session) {
  session.click(xpaths.homePage.loginPageButton)
}

function enterUserNameAndPassword(session,username,password){
  session.writeText(xpaths.logInPage.usernameBar,username)
  session.writeText(xpaths.logInPage.passwordBar,password)
  session.click(xpaths.logInPage.loginButton)
}

function goToMyCoursesThenQA_course(session){
  session.click(xpaths.loggedInPage.myCoursesButton)
  session.click(xpaths.loggedInPage.qualityAssuranceButton)
}

function degradeKerenToStudent(session){
  session.click(xpaths.courseHomePage.participantsButton)
  session.click(xpaths.courseHomePage.editKerenRoleButton)
  session.click(xpaths.courseHomePage.deleteTeacherRoleOfKeren)
  session.click(xpaths.courseHomePage.addStudentRoleOfKeren)
  session.click(xpaths.courseHomePage.confirmStudentRoleOfKeren)
  session.click(xpaths.courseHomePage.saveKerenRole)
}

function tryToAddNewContent(session){
  session.click(xpaths.courseHomePage.editModeButton)
  session.click(xpaths.editModePage.addContentButton)
  session.click(xpaths.editModePage.subsectionButton)
  //session.click(xpaths.editModePage.optionsForSubsectionButton)
  //session.click(xpaths.editModePage.deleteSubsectionButton)
  //session.waitFor(xpaths.editModePage.deleteSubsectionButton, 5000);
  //session.click(xpaths.editModePage.confirmDeletionButton)
  // addContentButton:"/html/body/div[4]/div[5]/div/div[3]/div/section/div/div/div/ul/li[1]/div[1]/div[2]/div[2]/div/div/button/i",
  //   subsectionButton:"/html/body/div[4]/div[5]/div/div[3]/div/section/div/div/div/ul/li[1]/div[1]/div[2]/div[2]/div/div/div/a",
  //   optionsForSubsectionButton:"/html/body/div[4]/div[5]/div/div[3]/div/section/div/div/div/ul/li[1]/div[1]/div[2]/ul/li[2]/div[2]/div/div/ul/li/div/div[1]/div[3]/div/div/div/div/a/i",
  //   deleteSubsectionButton:"/html/body/div[4]/div[5]/div/div[3]/div/section/div/div/div/ul/li[1]/div[1]/div[2]/ul/li[2]/div[2]/div/div/ul/li/div/div[1]/div[3]/div/div/div/div/div/a[6]/span",
  //   confirmDeletionButton:

}
// function clickParticipantsButton(session) {
//   session.click(xpaths.courseHomePage.participantsButton);
// }

// function clickEditKerenRoleButton(session) {
//   session.click(xpaths.courseHomePage.editKerenRoleButton);
// }

// function clickDeleteTeacherRoleOfKeren(session) {
//   session.click(xpaths.courseHomePage.deleteTeacherRoleOfKeren);
// }

// function clickAddStudentRoleOfKeren(session) {
//   session.click(xpaths.courseHomePage.addStudentRoleOfKeren);
// }

// function clickConfirmStudentRoleOfKeren(session) {
//   session.click(xpaths.courseHomePage.confirmStudentRoleOfKeren);
// }

// function clickSaveKerenRole(session) {
//   session.click(xpaths.courseHomePage.saveKerenRole);
// }


//   editKerenRoleButton: "",
//   deleteTeacherRoleOfKeren:"",
//   addStudentRoleOfKeren:"",
//   saveKerenRole:""
