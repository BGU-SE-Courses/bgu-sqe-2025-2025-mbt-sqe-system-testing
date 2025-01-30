const URL = 'http://localhost/';

const xpaths = {
  // User story 1 start
  homePage: {
    loginPageButton : "//*[@id='usernavigation']/div/div/span/a",
  },
  logInPage:{
    usernameBar: "//*[@id='username']",
    passwordBar: "//*[@id='password']",
    loginButton: "//*[@id='loginbtn']"
  },
  loggedInPage:{
    myCoursesButton: "/html/body/div[2]/nav/div/div[1]/nav/ul/li[3]/a",
    qualityAssuranceButton: "/html/body/div[2]/div[3]/div/div[2]/div/section/div/aside/section/div/div/div[1]/div[2]/div/div/div[1]/div/div/div/div/div[1]/div/div/a/span[3]/span[2]",
  },
  courseHomePage:{
    participantsButton: "/html/body/div[2]/div[4]/div/div[2]/nav/ul/li[3]/a",
    editKerenRoleButton: "/html/body/div[2]/div[4]/div/div[3]/div/section/div/div[3]/form/div/div[1]/div[3]/table/tbody/tr[2]/td[3]/span/a/span/i",
    deleteTeacherRoleOfKeren:"/html/body/div[2]/div[4]/div/div[3]/div/section/div/div[3]/form/div/div[1]/div[3]/table/tbody/tr[2]/td[3]/span/div[1]/span/span",
    addStudentRoleOfKeren:"/html/body/div[2]/div[4]/div/div[3]/div/section/div/div[3]/form/div/div[1]/div[3]/table/tbody/tr[2]/td[3]/span/div[2]/span",
    confirmStudentRoleOfKeren:"/html/body/div[2]/div[4]/div/div[3]/div/section/div/div[3]/form/div/div[1]/div[3]/table/tbody/tr[2]/td[3]/span/ul/li[5]",
    saveKerenRole:"/html/body/div[2]/div[4]/div/div[3]/div/section/div/div[3]/form/div/div[1]/div[3]/table/tbody/tr[2]/td[3]/span/a[1]/i",
    editModeButton: "/html/body/div[2]/nav/div/div[2]/form/div/div/input"
  }
  //User stroy 1 end

  //User story 2 start
  ,editModePage:{
    addContentButton:"/html/body/div[4]/div[5]/div/div[3]/div/section/div/div/div/ul/li[1]/div[1]/div[2]/ul/li/div[2]/div[2]/div[4]/div/div/div/div/div/a/i",
    subsectionButton:"/html/body/div[4]/div[5]/div/div[3]/div/section/div/div/div/ul/li[1]/div[1]/div[2]/ul/li/div[2]/div[2]/div[4]/div/div/div/div/div/div/a[5]/span",
    optionsForSubsectionButton:"/html/body/div[4]/div[5]/div/div[3]/div/section/div/div/div/ul/li[1]/div[1]/div[2]/ul/li[2]/div[2]/div/div/ul/li/div/div[1]/div[3]/div/div/div/div/a/i",
    deleteSubsectionButton:"/html/body/div[4]/div[5]/div/div[3]/div/section/div/div/div/ul/li[1]/div[1]/div[2]/ul/li[2]/div[2]/div/div/ul/li/div/div[1]/div[3]/div/div/div/div/div/a[6]/span",
    confirmDeletionButton:"/html/body/div[8]/div[2]/div/div/div[3]/button[2]"
  }


  //User story 2 end
}

const username_0 = "admin"
const password_0 = "hmodeAdmin!1"
const username_1 = "ahiya"
const password_1 = 'Ahiyaelyassef1!'
const username_2 = 'keren'
const password_2 = 'Kerengorlik1!'