/* @provengo summon selenium */

const AnyStartInSession = function (s) {
  return bp.EventSet("AnyStartInSession-" + s, function (e) {
      return e.data !== null && e.data.hasOwnProperty('startEvent') && e.data.startEvent && String(s).equals(e.data.session.name)
  })
}

defineAction = function (name, func) {
  // Add the new action to the SeleniumSession prototype
  SeleniumSession.prototype[name] = function (data) {
      let session = this;

      // Request a start event
      sync({ request: bp.Event(`Start(${name})`, { session: session, startEvent: true, parameters: data }) })

      // Block any other start events in the session while the function is executing
      block(AnyStartInSession(this.name), function () {
          // Execute the function
          func(session, data)

          // Request an end event
          sync({ request: bp.Event(`End(${name})`, { session: session, endEvent: true, parameters: data }) })
      })
  }
}
defineAction('loginAndGoToCourseA',function(session,user){
    session.click(xpaths.homePage.loginPageButton)
    session.writeText(xpaths.logInPage.usernameBar,username_1)
    session.writeText(xpaths.logInPage.passwordBar,password_1)
    session.click(xpaths.logInPage.loginButton)
    session.click(xpaths.loggedInPage.myCoursesButton)
    session.click(xpaths.loggedInPage.qualityAssuranceButton)
})
defineAction('loginAndGoToCourseK',function(session,user){
  session.click(xpaths.homePage.loginPageButton)
    session.writeText(xpaths.logInPage.usernameBar,username_2)
    session.writeText(xpaths.logInPage.passwordBar,password_2)
    session.click(xpaths.logInPage.loginButton)
    session.click(xpaths.loggedInPage.myCoursesButton)
    session.click(xpaths.loggedInPage.qualityAssuranceButton)
})
defineAction('degradeKerenToStudent',function(session,user){
  session.click(xpaths.courseHomePage.participantsButton)
  session.click(xpaths.courseHomePage.editKerenRoleButton)
  session.click(xpaths.courseHomePage.deleteTeacherRoleOfKeren)
  session.click(xpaths.courseHomePage.addStudentRoleOfKeren)
  session.click(xpaths.courseHomePage.confirmStudentRoleOfKeren)
})
defineAction('confirmDestruction',function(session,user){
  session.click(xpaths.courseHomePage.saveKerenRole)
})
defineAction('tryToAddNewContent',function(session,user){
  session.click(xpaths.courseHomePage.editModeButton)
  session.click(xpaths.editModePage.addContentButton)
  session.click(xpaths.editModePage.subsectionButton)
})


