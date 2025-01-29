/* @provengo summon selenium */

/**
 * This story opens a new browser window, goes to google.com, and searches for "Pizza".
 */

// function syncWait(ms) {
//   const start = Date.now();
//   while (Date.now() - start < ms) {} // Blocking sleep
// }

// Ahiya downgrades Keren's permissions from Teacher to Student 
// bthread('LoginAndDestroyKerensRights', function () {
//   let s = new SeleniumSession('loginAndDestroyKeren');
//   s.start(URL);
//   goToLoginScreen(s);
//   enterUserNameAndPassword(s,username_1,password_1);
//   goToMyCoursesThenQA_course(s);
//   degradeKerenToStudent(s);



//   // goToLoginScreen(s);
//   // syncWait(1000); // Wait 1 second

//   // enterUserNameAndPassword(s, username_0, password_0);
//   // syncWait(2000); // Wait 2 seconds

//   // goToMyCoursesThenQA_course(s);
//   // syncWait(1500); // Wait 1.5 seconds

//   // clickParticipantsButton(s);
//   // syncWait(1000);

//   // clickEditKerenRoleButton(s);
//   // syncWait(1000);

//   // clickDeleteTeacherRoleOfKeren(s);
//   // syncWait(1500);

//   // clickAddStudentRoleOfKeren(s);
//   // syncWait(1000);

//   // clickConfirmStudentRoleOfKeren(s);
//   // syncWait(1000);

//   // clickSaveKerenRole(s);
//   // syncWait(2000); // Final step, wait a bit longer before ending
// })

// Keren tries to add new content to the course

bthread('LoginAndTryToAddNewContent', function () {
  let s = new SeleniumSession('loginAndTry');
  s.start(URL);
  goToLoginScreen(s);
  enterUserNameAndPassword(s,username_2,password_2);
  goToMyCoursesThenQA_course(s);
  // degradeKerenToStudent(s);
  tryToAddNewContent(s);
  
})

/**
 * This story opens a new browser window, goes to google.com, and searches for "Pasta" using the "I Feel Lucky" feature.
 */
// bthread('Feeling lucky', function () {
//   let s = new SeleniumSession('lucky').start(URL)
//   composeQuery(s, { text: 'Pasta' })
//   feelLucky(s)
// })