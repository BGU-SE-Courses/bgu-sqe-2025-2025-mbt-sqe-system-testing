//@provengo summon selenium



// The XPaths That Will Be Used In The Test
const XPaths = {
  // MainPage
  LoginButton_In_Main_Page : '/html[1]/body[1]/div[2]/nav[1]/div[1]/div[2]/div[1]/div[1]/span[1]/a[1]',

  // loginPage 
  Username_Text_Box : '//input[@placeholder="Username"] '   ,
  Password_Text_Box : '//input[@id="password"]',
  LoginButton_In_Login_Page : '//div[3]/button[1]',

  //navigate to course - From StudentUser
  Mycourses_Buttom: '/html[1]/body[1]/div[2]/nav[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/a[1]',
  QA_Course_In_My_Courses: '//div[1]/div[1]/div[1]/div[1]/a[1]/div[1]',

  // navigate to Assignment1 - to Add Submission
  Assignment_1_Button: '//li[2]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[2]/div[2]/div[1]/div[1]/a[1]',
  Add_submission_Button: '//body/div[2]/div[4]/div[1]/div[2]/div[1]/section[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/button[1]',

  // Add Files and Submit. Note that The Files where Uploaded to "Private Files" Before The Task
  Add_Files_Button: '//div[2]/div[1]/div[1]/div[1]/a[1]/i[1]',
  Go_To_Private_files: '//div[2]/div[1]/div[1]/div[1]/div[3]/a[1]',
  Upload_File1: '//a[1]/div[1]/div[3]',
  Upload_File2: '//div[1]/a[2]/div[2]/p[1]',
  Select_This_File_Button: '//form[1]/div[4]/div[1]/button[1]',
  Save_Changes_Button: '//div[1]/span[1]/input[1]',

  // Teacher Reduces The Maximum Size Of The File To Submit To 1
  Setting_Button: '//div[2]/nav[1]/ul[1]/li[2]/a[1]',
  Find_MaxSize_Button_Location: '//fieldset[3]/div[2]/div[5]/div[1]/p[1]',
  Find_Save_Button_Location: '//body/div[3]/div[4]/div[1]/div[3]',
  Max_Button :'//fieldset[3]/div[2]/div[3]/div[2]/select[1]',
  Save_Updated_Course_Setting: '//div[1]/div[1]/div[1]/span[1]/input[1]',


  // Student Remove Subbmission
  Remove_Submission_Button: '//div[2]/div[1]/form[1]/button[1]',
  Confirm_Remove_Submission: '//div[2]/form[1]/button[1]'

}

///////////////////////////////////////////////////// Variables //////////////////////////////////////////////////////

// The URL Of The Moodle Site
const URL = "http://localhost/";

// TEST_TYPES By Criteria 
const TEST_TYPES = {
  DOMAIN_SPECIFIC: "domain-specific",
  TWO_WAY: "two-way",
  RESET: "Reset-The-System"
};


/*  Remove the comment for the case we want to execute
// Note that if we want to run the ensemble.js file, we cannot use TEST_TYPE = TEST_TYPES.RESET
// as it is not defined there */

let TEST_TYPE = TEST_TYPES.DOMAIN_SPECIFIC; 
// or
// let TEST_TYPE = TEST_TYPES.TWO_WAY;
// or
 //let TEST_TYPE = TEST_TYPES.RESET;

// The Users That Will Be Used In The Test
const USERS ={
    Teacher:{
      username: 'admin',
      password: 'Gilandlidor123!'
    },
    Student:{
      username: 'student',
      password: 'Student123!'
    }
}
// The Maximum Files That Can Be Uploaded To The Assignment
const MaxFiles_Limited_to_1 = 1 ;
const MaxFiles_Limited_to_2 = 2 ;


// teacherLimitedFiles = true => The Teacher Limited The Files That Can Be Uploaded
// teacherLimitedFiles = false => The Teacher Did Not Limited The Files That Can Be Uploaded
// Initialized to be false because the teacher did not limited the files that can be uploaded at the beginning
let teacherLimitedFiles = false;


// The Events That Will Be Used In The Tests 


// Student Events
const Student_EVENTS = {
  STUDENT_LOGGED_IN: bp.Event("Student_Logged_In"),
  STUDENT_IN_COURSE: bp.Event("Student_In_Course_QA"),
  STUDENT_IN_ASSIGNMENT: bp.Event("Student_In_Assignment1"),
  STUDENT_FILES_UPLOADED: bp.Event("Student_Files_Uploaded"),
  STUDENT_SUBMISSION_COMPLETED: bp.Event("Student_Submission_Complete"),
  // Specific Student Events For Two Ways Criteria
  STUDENT_FIRST_UPLOAD_COMPLETED: bp.Event("STUDENT_UPLOAD_COMPLETED_1"),
  STUDENT_SECOND_UPLOAD_COMPLETED: bp.Event("STUDENT_UPLOAD_COMPLETED_2"),

};

// Teacher Events
const Teacher_EVENTS = {
  TEACHER_LOGGED_IN: bp.Event("Teacher_Logged_In"),
  TEACHER_IN_COURSE: bp.Event("Teacher_In_Course_QA"),
  TEACHER_IN_ASSIGNMENT: bp.Event("Teacher_In_Assignment1"),
  TEACHER_REDUCE_MAX_FILES: bp.Event("Reduce_Max_Files"),
  TEACHER_REDUCTION_COMPLETED: bp.Event("Teacher_Reduction_Complete"),
  // Specific Teacher Events For Two Ways Criteria
  TEACHER_REDUCTION_COMPLETED_1: bp.Event("Teacher_Reduction_Complete_1"),
  TEACHER_REDUCTION_COMPLETED_2: bp.Event("Teacher_Reduction_Complete_2"),

};


// Reset Events (After Specific Criteria)
const Reset_EVENTS = {
  STUDENT_REMOVED_SUBMISSION: bp.Event("Student_Removed_Submission"),
  TEACHER_RESET_COMPLETED: bp.Event("Teacher_Reset_Completed"),
  STUDENT_RESET_COMPLETED: bp.Event("Student_Reset_Completed"),
  RESET_COMPLETED: bp.Event("Reset_Completed"),
  TEACHER_INCREASE_MAX_FILES: bp.Event("Teahcer_Increased_Max_Files")
};

// Goals Events
const Mission_Completed_Events = {
  END_SPECIFIC_CRITERIA: bp.Event("End_Specific_Criteria"),
  TWO_WAY_CRITERIA_COMPLETED: bp.Event("End_Two_Way_Criteria"),
  CANT_UPLOAD_SECOND_FILE: bp.Event("Cant_Upload_Second_File_Due_To_Max_Files_Was_Reduced"),
  SUBMISSION_WAS_FAILED: bp.Event("Submission_Was_Failed_Due_To_Max_Files_Was_Reduced")

}