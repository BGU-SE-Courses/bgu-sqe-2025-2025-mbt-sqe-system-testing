/* @provengo summon selenium */

bthread('notAllowChoiceBeUpdated', function () {
    let session = new SeleniumSession('reply');
    session.start(URL, 'chrome');

    bp.sync({ request: bp.Event("loginAdmin") });
    loginTeacher(session);

    bp.sync({ request: bp.Event("createCourse") });
    createCourse(session);

    bp.sync({ request: bp.Event("navigateToCourse") });
    navigateToCourseFromHomePage(session);

    bp.sync({ request: bp.Event("enrollStudent") });
    enrollStudent(session);

    bp.sync({ request: bp.Event("createActivity") });
    createActivity(session);

    bp.sync({ request: bp.Event("logoutAdmin") });
    logoutAdmin(session);


    bp.sync({ request: bp.Event("loginStudent") });
    loginStudent(session);

    bp.sync({ request: bp.Event("navigateToCourse") });
    navigateToCourseFromHomePage(session);

    bp.sync({ request: bp.Event("enterDisabledActivity") });
    studentEnterDisabledActivity(session);

    bp.sync({ request: bp.Event("choose option 1") });
    chooseOption(session);

    bp.sync({ request: bp.Event("return to course") });
    returnToCourse(session);

    bp.sync({ request: bp.Event("enterDisabledActivity") });
    studentEnterDisabledActivity(session);

    bp.sync({ request: bp.Event("checkCantChangeOption") });
    checkCantChange(session);

    bp.sync({ request: bp.Event("logoutStudent") });

    logoutFromChoice(session);


});

// bthread('ableToChange', function () {
//TODO: hi
// });