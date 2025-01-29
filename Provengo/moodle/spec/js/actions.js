/* @provengo summon selenium */

function loginAndGoToCourse(session,username,password){
  session.click(xpaths.homePage.loginPageButton)
  session.writeText(xpaths.logInPage.usernameBar,username)
  session.writeText(xpaths.logInPage.passwordBar,password)
  session.click(xpaths.logInPage.loginButton)
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
}
