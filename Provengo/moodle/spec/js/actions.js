// actions.js

function Login(session, user) {
  session.click(XPaths.LoginButton_In_Main_Page);
  session.writeText(XPaths.Username_Text_Box, user.username);
  session.writeText(XPaths.Password_Text_Box, user.password);
  session.click(XPaths.LoginButton_In_Login_Page);
  //session.sleep(1000);
}

function GoToQACourse(session) {
  session.click(XPaths.Mycourses_Buttom);
  //session.sleep(1000);
  session.click(XPaths.QA_Course_In_My_Courses);
  //session.sleep(1000);
}

function GoToAssignment1(session) {
  session.click(XPaths.Assignment_1_Button);
  //session.sleep(1000);
}

function AddFile(session, fileXPath) {
  session.click(XPaths.Add_Files_Button);
  //session.sleep(1000);
  session.click(XPaths.Go_To_Private_files);
  //session.sleep(1000);
  session.click(fileXPath);
  //session.sleep(1000);
  session.click(XPaths.Select_This_File_Button);
  //session.sleep(1000);
}

function AddFirstFileToAssignment(session) {
  session.click(XPaths.Add_submission_Button);
  //session.sleep(1000);
  
  AddFile(session, XPaths.Upload_File1);
}

function AddSecondFileToAssignment(session) {
  AddFile(session, XPaths.Upload_File2);
}

function SaveStudentSubmission(session) {
  session.click(XPaths.Save_Changes_Button);
  //session.sleep(1000);
}

function ChangeMaxFileSize(session, fileMaxSize) {
  session.click(XPaths.Setting_Button);
  //session.sleep(1000);
  session.moveToElement(XPaths.Find_MaxSize_Button_Location);
  //session.sleep(1000);
  session.click(XPaths.Max_Button);
  //session.sleep(1000);
  session.click(`${XPaths.Max_Button}//option[@value='${fileMaxSize}']`);
  //session.sleep(1000);
  session.moveToElement(XPaths.Save_Updated_Course_Setting);
  //session.sleep(1000);
}

function SaveTeacherUpdates(session) {
  session.click(XPaths.Save_Updated_Course_Setting);
  //session.sleep(1000);
}


function RemoveSubmission(session) {
  session.click(XPaths.Remove_Submission_Button);
  //session.sleep(1000);
  session.click(XPaths.Confirm_Remove_Submission);
}
