/* @provengo summon selenium */

// Student login action
function student_login(session, credentials) {
  if (!session) {
    throw new Error("Session is undefined in student_login");
  }

  var START = bp.Event("Start(student_login)");
  var END = bp.Event("End(student_login)");

  bp.sync({ request: START });

  try {
    session.click("//a[@href='http://localhost:8080/login/index.php']");
    session.writeText("//input[@name='username']", credentials.username);
    session.writeText("//*[@id='password']", credentials.password);
    session.click("//button[text()='Log in']");

    bp.sync({ request: END });
  } catch (e) {
    throw new Error("Student login failed: " + e.message);
  }
}

function search_comment(session, data) {
  bp.sync({ request: bp.Event("Start(search_comment)") });

  try {
    // Click on "My courses"
    session.click("//a[@href='http://localhost:8080/my/courses.php']");

    // Click on course name - using a more reliable selector
    session.click("//span[3]/span[2]");
    // Or alternatively
    // session.click("//*[@id='yui_3_18_1_1_1736794100431_38']//span[3]/span[2]");

    session.click("//div[1]/div[2]/div[2]/div[1]/div[1]/a[1]");
    session.writeText("//form[1]/div[1]/input[1]", data.commentText, true);
    session.click("//button[@type='submit']");
  } catch (e) {
    throw new Error("Search comment failed: " + e.message);
  }

  bp.sync({ request: bp.Event("End(search_comment)") });
}
// Navigate to comment action
function navigate_to_comment(session) {
  if (!session) {
    throw new Error("Session is undefined in navigate_to_comment");
  }

  var START = bp.Event("Start(navigate_to_comment)");
  var END = bp.Event("End(navigate_to_comment)");

  bp.sync({ request: START });

  try {
    session.click("//h4[1]/a[2]/span[1]"); //*****************

    bp.sync({ request: END });
  } catch (e) {
    throw new Error("Navigate to comment failed: " + e.message);
  }
}

// Teacher login action
function teacher_login(session, credentials) {
  if (!session) {
    throw new Error("Session is undefined in teacher_login");
  }

  var START = bp.Event("Start(teacher_login)");
  var END = bp.Event("End(teacher_login)");

  bp.sync({ request: START });

  try {
    session.click("//a[@href='http://localhost:8080/login/index.php']");
    session.writeText("//input[@name='username']", credentials.username);
    session.writeText("//*[@id='password']", credentials.password);
    session.click("//button[text()='Log in']");

    bp.sync({ request: END });
  } catch (e) {
    throw new Error("Teacher login failed: " + e.message);
  }
}

// Delete comment action
function delete_comment(session, data) {
  bp.sync({ request: bp.Event("Start(delete_comment)") });

  try {
    // These actions can happen in parallel with student
    session.click("//a[@href='http://localhost:8080/my/courses.php']");
    session.click("//span[3]/span[2]");
    session.click("//div[1]/div[2]/div[2]/div[1]/div[1]/a[1]");
    session.writeText("//form[1]/div[1]/input[1]", data.commentText, true);
    session.click("//button[@type='submit']");

    // Signal ready to delete
    bp.sync({ request: bp.Event("ReadyToDelete") });

    // Actual deletion - will wait for student
    session.click("//div[1]/div[2]/div[2]/div[1]/a[3]");
    session.click("//div[2]/form[1]/button[1]");

    bp.sync({ request: bp.Event("End(delete_comment)") });
  } catch (e) {
    throw new Error("Delete comment failed: " + e.message);
  }
}





