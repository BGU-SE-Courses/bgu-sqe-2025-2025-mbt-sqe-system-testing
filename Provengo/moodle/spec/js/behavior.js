/* @provengo summon selenium */

bthread('student thread', function () {
  var session = new SeleniumSession(studentSessionName);
  session.start(baseURL);

  try {
    student_login(session, studentCredentials);
    search_comment(session, {
      commentText: "hey1",  // We'll change this to cycle through different comments
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
      commentText: "hey1",  // Should match the student's comment
      courseName: testData.courseName
    });
    restore_comment(session, {
      commentText: "hey1",  // Should match the deleted comment
      courseName: testData.courseName
    });
  } finally {
    if (session) {
      session.quit();
    }
  }
})

// Login before actions
bthread('login before search', function () {
  sync({
    waitFor: Event('End(student_login)'),
    block: Event('Start(search_comment)')
  })
})

bthread('teacher login before delete', function () {
  sync({
    waitFor: Event('End(teacher_login)'),
    block: Event('Start(delete_comment)')
  })
})

// Search before navigate
bthread('search before navigate', function () {
  sync({
    waitFor: Event('End(search_comment)'),
    block: Event('Start(navigate_to_comment)')
  })
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

bthread('student quit after navigation', function () {
  sync({
    waitFor: Event('End(navigate_to_comment)'),
    block: Event('QuitSession')
  })
})

// Also add this:
// Ensure teacher session quits after deletion
bthread('teacher quit after delete', function () {
  sync({
    waitFor: Event('End(delete_comment)'),
    block: Event('QuitSession')
  })
})