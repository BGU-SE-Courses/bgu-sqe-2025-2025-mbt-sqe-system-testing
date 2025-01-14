/* @provengo summon selenium */

// Student actions: login, search, and select a comment
bthread('student thread', function () {
  var session = new SeleniumSession(studentSessionName);
  session.start(baseURL);

  try {
    student_login(session, studentCredentials);
    search_comment(session, {
      commentText: testData.comment,
      courseName: testData.courseName
    });
    navigate_to_comment(session);
  } finally {
    if (session) {
      session.quit();
    }
  }
})

// Teacher actions: login and delete a comment
bthread('teacher thread', function () {
  var session = new SeleniumSession(teacherSessionName);
  session.start(baseURL);

  try {
    teacher_login(session, teacherCredentials);
    delete_comment(session, {
      commentText: testData.comment,
      courseName: testData.courseName
    });
  } finally {
    if (session) {
      session.quit();
    }
  }
})

// Ensure student searches before teacher deletes
bthread('search before delete', function () {
  sync({
    waitFor: Event('End(search_comment)'),
    block: Event('ReadyToDelete')
  })
})

// Ensure navigation happens after search
bthread('navigate after search', function () {
  sync({
    waitFor: Event('End(search_comment)'),
    block: Event('Start(navigate_to_comment)')
  })
})

// Ensure deletion happens after navigation
bthread('delete after navigation', function () {
  sync({
    waitFor: Event('End(navigate_to_comment)'),
    block: Event('ReadyToDelete')
  })
})