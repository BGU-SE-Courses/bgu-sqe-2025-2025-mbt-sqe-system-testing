/* @provengo summon selenium */

// Ahiya downgrades Keren's permissions from Teacher to Student 
bthread('LoginAndDestroyKerensRights', function () {
  let s = new SeleniumSession('loginAndDestroyKeren');
  s.start(URL);
  loginAndGoToCourse(s,username_1,password_1);
  degradeKerenToStudent(s);
})

// Keren tries to add new content to the course
bthread('LoginAndTryToAddNewContent', function () {
  let s = new SeleniumSession('loginAndTry');
  s.start(URL);
  loginAndGoToCourse(s,username_2,password_2)
  tryToAddNewContent(s);
})


// function syncWait(ms) {
//   const start = Date.now();
//   while (Date.now() - start < ms) {} // Blocking sleep
// }