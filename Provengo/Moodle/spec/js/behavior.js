/* @provengo summon selenium */

// bthread('notAllowChoiceBeUpdated', function () {
//     let session = new SeleniumSession('reply');
//     session.start(URL, 'chrome');

//     bp.sync({ request: bp.Event("loginAdmin") });
//     loginTeacher(session);

//     bp.sync({ request: bp.Event("createCourse") });
//     createCourse(session);

//     bp.sync({ request: bp.Event("navigateToCourse") });
//     navigateToCourseFromHomePage(session);

//     bp.sync({ request: bp.Event("enrollStudent") });
//     enrollStudent(session);

//     bp.sync({ request: bp.Event("createActivity") });
//     createActivity(session);

//     bp.sync({ request: bp.Event("logoutAdmin") });
//     logoutAdmin(session);


//     bp.sync({ request: bp.Event("loginStudent") });
//     loginStudent(session);

//     bp.sync({ request: bp.Event("navigateToCourse") });
//     navigateToCourseFromHomePage(session);

//     bp.sync({ request: bp.Event("enterDisabledActivity") });
//     studentEnterDisabledActivity(session);

//     bp.sync({ request: bp.Event("choose option 1") });
//     chooseOption(session);

//     bp.sync({ request: bp.Event("return to course") });
//     returnToCourse(session);

//     bp.sync({ request: bp.Event("enterDisabledActivity") });
//     studentEnterDisabledActivity(session);

//     bp.sync({ request: bp.Event("checkCantChangeOption") });
//     checkCantChange(session);

//     bp.sync({ request: bp.Event("logoutStudent") });
//     logoutFromChoice(session);


// });

bthread("setUp", function () {
    let session = new SeleniumSession("reply");
    session.start(URL, "chrome");

    bp.sync({ request: bp.Event("loginAdmin") });
    loginAdmin(session);

    bp.sync({ request: bp.Event("createCourse") });
    createCourse(session);

    bp.sync({ request: bp.Event("navigateToCourse") });
    navigateToCourseFromHomePage(session);

    bp.sync({ request: bp.Event("enrollStudentAndTeacher") });
    enrollStudentAndTeacher(session);

    bp.sync({ request: bp.Event("createUpdateAbleActivity") });
    createUpdateAbleActivity(session);

    bp.sync({ request: bp.Event("logoutAdmin") });
    logoutAdmin(session);

    bp.sync({ request: bp.Event("loginStudent") });
    loginStudent(session);

    bp.sync({ request: bp.Event("navigateToCourse") });
    navigateToCourseFromHomePage(session);

    bp.sync({ request: bp.Event("studentEnterActivity") });
    studentEnterActivity(session);

    bp.sync({ request: bp.Event("choose option 1") });
    chooseOption(session);

    bp.sync({ request: bp.Event("logoutStudent") });
    logoutFromChoice(session);

    bp.sync({ request: bp.Event("endSetUp") });
});


bthread("updateChoice", function () {
  let session1 = new SeleniumSession("student");
  session1.start(URL, "chrome");
  
  bp.sync({ waitFor: bp.Event("endSetUp")});


  bp.sync({ request: bp.Event("loginStudent") });
  loginStudent(session1);

  bp.sync({ request: bp.Event("navigateToCourse") });
  navigateToCourseFromHomePage(session1);

  bp.sync({ request: bp.Event("enterActivity") });
  studentEnterActivity(session1);

  bp.sync({ request: bp.Event("chooseOption2") });
  chooseOption2(session1);

  bp.sync({ request: bp.Event("logoutStudent") });
  logoutFromChoice(session1);

});

bthread("cancelUpdating", function () {
  let session2 = new SeleniumSession("teacher");
  session2.start(URL, "chrome");

  bp.sync({ waitFor: bp.Event("endSetUp") });

  bp.sync({ request: bp.Event("loginTeacher") });
  loginTeacher(session2);

  bp.sync({ request: bp.Event("teacherNavigateToCourse") });
  navigateToCourseFromHomePage(session2);

  bp.sync({ request: bp.Event("ChangeNotUpdateAbleActivity") });
  ChangeNotUpdateAbleActivity(session2);

  bp.sync({ request: bp.Event("logoutTeacher") });
  logoutTeacher(session2);
});