function login(session, username, password) {
    session.click(xpaths.Login.navigateToLogin);
    session.clear(xpaths.Login.enterUsername);
    session.writeText(xpaths.Login.enterUsername, username);
    session.writeText(xpaths.Login.enterPassword, password);
    session.click(xpaths.Login.loginButton);
}

function loginStudent(session) {
    login(session, moodleData.Login.studentUsername, moodleData.Login.password);
}

function loginTeacher(session) {
  login(session, moodleData.Login.teacherUsername, moodleData.Login.password);
}

function loginAdmin(session) {
  login(session, moodleData.Login.adminUsername, moodleData.Login.password);
}
function logoutFromChoice(session) {
    session.click(xpaths.Logout.fromChoiceArrow);
    session.click(xpaths.Logout.logoutFromChoice);
}

function logoutAdmin(session) {
    session.click(xpaths.Logout.userScroll);
    session.click(xpaths.Logout.logout);
}

function logoutTeacher(session) {
  session.click(xpaths.Logout.userScroll);
  session.click(xpaths.Logout.logout);
}

function createCourse(session) {
    session.click(xpaths.Course.myCourses);
    session.click(xpaths.Course.createCourseButton);
    session.writeText(xpaths.Course.enterFullName, moodleData.Course.fullName);
    session.writeText(xpaths.Course.enterShortName, moodleData.Course.shortName);
    session.click(xpaths.Course.saveCourseButton);
}

function navigateToCourseFromHomePage(session) {
    session.click(xpaths.Course.myCourses);
    session.click(xpaths.Course.chooseCourse);
}

function enrollStudentAndTeacher(session) {
    session.click(xpaths.Participants.participantsButton);
    session.click(xpaths.Participants.enrollUsersButton);
    session.click(xpaths.Participants.scrollUsers);
    session.click(xpaths.Participants.chooseFromBox);
    session.click(xpaths.Participants.chooseUser);
    session.click(xpaths.Participants.submitEnroll);

    session.click(xpaths.Participants.participantsButton);
    session.click(xpaths.Participants.enrollUsersButton);
    session.selectByVisibleText(xpaths.Participants.asignedRole, xpaths.Participants.TeacherRoleOption);
    session.click(xpaths.Participants.scrollUsers);
    session.click(xpaths.Participants.chooseTeacher);
    session.click(xpaths.Participants.chooseUser);
    session.click(xpaths.Participants.submitEnroll);



}

function enrollStudent(session) {
  session.click(xpaths.Participants.participantsButton);
  session.click(xpaths.Participants.enrollUsersButton);
  session.click(xpaths.Participants.scrollUsers);
  session.click(xpaths.Participants.chooseFromBox);
  session.click(xpaths.Participants.chooseUser);
  session.click(xpaths.Participants.submitEnroll);
}


function createActivity(session) {
    session.click(xpaths.Activity.editMode);
    session.click(xpaths.Activity.addActivity);
    session.click(xpaths.Activity.choiceActivity);
    session.writeText(xpaths.Activity.writeChoiceName, moodleData.Activity.name);
    session.writeText(xpaths.Activity.writeFirstChoice, moodleData.Activity.firstChoice);
    session.writeText(xpaths.Activity.writeSecondChoice, moodleData.Activity.secondChoice);
    session.click(xpaths.Activity.saveAndDisplayChoice);
}

function createUpdateAbleActivity(session) {
    session.click(xpaths.Activity.editMode);
    session.click(xpaths.Activity.addActivity);
    session.click(xpaths.Activity.choiceActivity);
    session.writeText(xpaths.Activity.writeChoiceName, moodleData.Activity.name);
    session.writeText(xpaths.Activity.writeFirstChoice, moodleData.Activity.firstChoice);
    session.writeText(xpaths.Activity.writeSecondChoice, moodleData.Activity.secondChoice);
    //select yes in changing option button
    session.selectByVisibleText(xpaths.Activity.changeUpdatability, moodleData.Activity.UpdatabilityYes);
    session.click(xpaths.Activity.saveAndDisplayChoice);
}

function ChangeNotUpdateAbleActivity(session) {
    session.click(xpaths.Activity.editMode);
    session.click(xpaths.DisabledActivity.teacherEnterActivity);

    session.click(xpaths.Activity.setting);
    //select yes in changing option button
    session.selectByVisibleText(xpaths.Activity.changeUpdatability, moodleData.Activity.UpdatabilityNo);
    session.click(xpaths.Activity.saveAndDisplayChoice);
}

function enterDisabledActivity(session) {
    session.click(xpaths.DisabledActivity.enterDisabledActivity);
}

function studentEnterActivity(session) {
  session.click(xpaths.DisabledActivity.studentEnterActivity);
}

function chooseOption(session) {
    session.click(xpaths.ChooseOption.chooseOption1);
    session.click(xpaths.ChooseOption.saveChoice);
}

function returnToCourse(session) {
    session.click(xpaths.ReturnToCourse.courseName);
}

function checkCantChange(session) {
    return session.click(xpaths.CheckChange.shouldBeChanged);
}

function chooseOption2(session){
    //choose option 2
    session.click(xpaths.ChooseOption.chooseOption2);
    //save choose
    session.click(xpaths.ChooseOption.saveChoice);
}
