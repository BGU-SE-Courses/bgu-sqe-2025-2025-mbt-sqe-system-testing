// @provengo summon selenium
const studentSession = new SeleniumSession("student");
const teacherSession = new SeleniumSession("teacher");

//Pre-Testing instructions:
//Create student user with username "student" and password "studentQ$A1234"
//Create teacher user with username "teacher" and password "teacherQ$A1234"
//Create course and give "teacher" Teacher permissions and "student" Student permissions in the course
//Log in as the teacher and click "got it" on all info boxes



/**
 * This story opens a new browser window, logins as a student, goes to "my courses", and stars Course 1.
 */
bthread('Student Star', function () {
  studentSession.start(URL)
  login(studentSession, {username: 'student', password: 'studentQ$A1234'})
  goToMyCourses(studentSession)
  starCourse(studentSession)
})

/**
 * This story opens a new browser window, logins as a teacher, goes to "my courses", enters Course 1, goes to settings and hides the course from view.
 */
bthread('Teacher Hide', function () {
  teacherSession.start(URL)
  login(teacherSession, {username: 'teacher', password: 'teacherQ$A1234'})
  goToMyCourses(teacherSession)
  goToCourse(teacherSession)
  hideCourse(teacherSession)
})