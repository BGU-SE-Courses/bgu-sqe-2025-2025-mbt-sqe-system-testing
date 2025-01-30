/* @provengo summon selenium */
/* @provengo summon ctrl */
function findLoginPageAndLogin(session, username,password) {
  sync({request: Event('Start(findLoginPageAndLogin)')})
  sync({ request: Event("Session recieved in function: " + session) });
  session.click(xpaths.loginWindowButton)
  session.writeText(xpaths.loginWindow.usernameInput,username)
  session.writeText(xpaths.loginWindow.passwordInput,password)
  session.click(xpaths.loginWindow.loginButton)
  sync({request: Event('End(findLoginPageAndLogin)')})
}

function goToCourse(session) {
  sync({request: Event('Start(goToCourse)')})
  session.click(xpaths.teacherWindow.teacherClickOnCourse)
  sync({request: Event('End(goToCourse)')})
}

function enterForumAndPostComment(session,commentSubject) {
  sync({request: Event('Start(enterForumAndPostComment)')})
  session.click(xpaths.studentWindow.openTopic5)
  session.click(xpaths.studentWindow.studentForumButton)
  session.click(xpaths.studentWindow.addDiscussionButton)
  session.writeText(xpaths.studentWindow.subjectInbox,commentSubject)
  session.click(xpaths.studentWindow.insertButton)
  session.click(xpaths.studentWindow.signsButton)
  session.click(xpaths.studentWindow.dollarButton)
  session.click(xpaths.studentWindow.postToForumButton)
  sync({request: Event('End(enterForumAndPostComment)')})
}

function turnOnEditModeAndGoToCourse(session)
{
  sync({request: Event('Start(turnOnEditModeAndGoToCourses)')})
  session.click(xpaths.teacherWindow.teacherClickOnCourse)
  session.click(xpaths.teacherWindow.editModeButton)
  session.click(xpaths.teacherWindow.teacherOpenTopic2)
  sync({request: Event('End(turnOnEditModeAndGoToCourses)')})
}

//@provengo summon ctrl 
function deleteForum(session)
{
  sync({request: Event('Start(deleteForum)')})
  session.click(xpaths.teacherWindow.teacherCliclOnInfoButton)
  sync({request: Event('End(deleteForum)')})
}


//@provengo summon ctrl 
function deleteOption(session)
{
  session.click(xpaths.teacherWindow.deleteOption)
}
//@provengo summon ctrl 
function deleteConfirmation(session)
{
  session.click(xpaths.teacherWindow.deleteConfirmationPopup)
  sync({request: Event('End(deleteForum)')})
}