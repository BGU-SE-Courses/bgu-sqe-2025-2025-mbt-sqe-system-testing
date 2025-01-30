/* @provengo summon selenium */
/* @provengo summon ctrl */


bthread('studentPostsACommentOnForum',function () {
  let s1 = new SeleniumSession('studentMoodleSession', 'chrome');
  sync({ request: Event("Session1 before start : " + s1) });
  s1.start(URL)
  sync({ request: Event("Session1 after start  : " + s1) });
  sync({request:Event('End(findLoginPageAndLogin)')},findLoginPageAndLogin(s1,studentUsername,studentPassword))
  sync({request:Event('End(goToSoftwareQACourse)')},goToCourse(s1))
  sync({request:Event('Start(enterForumAndPostComment)'),waitFor:Event('Start(deleteForum)')},enterForumAndPostComment(s1,commentSubject, commentMessage))
});


//@provengo summon ctrl 
bthread('teacherDeletesForum', function () {
  let s2 = new SeleniumSession('teacherMoodleSession', 'chrome');
  sync({ request: Event("Session2 before start : " + s2) });
  s2.start(URL)
  sync({ request: Event("Session2 after start  : " + s2) });
  sync({request:Event('End(findLoginPageAndLogin)')},findLoginPageAndLogin(s2,teacherUsername,teacherPassword))
  sync({request:Event('End(turnOnEditModeAndGoToCourse)')},turnOnEditModeAndGoToCourse(s2))
  sync({request:Event('End(deleteForum)')},deleteForum(s2))
  Ctrl.sleepEvent(5000)
  Ctrl.doSleep(5000)
  Ctrl.pauseEvent("pausing before deleteOption")
  sync({request:Event('End(deleteForum)')},deleteOption(s2))
  Ctrl.doSleep(5000)
  Ctrl.pauseEvent("pausing before deleteConfirmation")
  sync({request:Event('End(deleteForum)')},deleteConfirmation(s2))
});

