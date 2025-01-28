/*
 *  This is a good place to put common test data, project-wide constants, etc.
 */

const URL = 'http://localhost/';

const xpaths = {
  guestWindow :{
    loginWindowButton: '//*[@id="usernavigation"]/div/div/span/a'
  },
  loginWindow: {
    usernameInput: '//*[@id="username"]',
    passwordInput: '//*[@id="password"]',
    loginButton: '//*[@id="loginbtn"]'
  },
  mainWindow: {
    myCourses: '/html/body/div[2]/nav/div/div[1]/nav/ul/li[3]/a'
  },
  myCoursesWindow: {
    course: '/html/body/div[2]/div[3]/div/div[2]/div/section/div/aside/section/div/div/div[1]/div[2]/div/div/div[1]/div/div/div/div/div[1]/div/div/a/span[3]/span[2]',
    threeDots: '/html/body/div[2]/div[3]/div/div[2]/div/section/div/aside/section/div/div/div[1]/div[2]/div/div/div[1]/div/div/div/div/div[2]/div/div/button',
    starButton: '/html/body/div[2]/div[3]/div/div[2]/div/section/div/aside/section/div/div/div[1]/div[2]/div/div/div[1]/div/div/div/div/div[2]/div/div/div/a[1]',
    unstarButton: '/html/body/div[2]/div[3]/div/div[2]/div/section/div/aside/section/div/div/div[1]/div[2]/div/div/div[1]/div/div/div/div/div[2]/div/div/div/a[2]'
  },
  courseWindow: {
    settingsButton: '/html/body/div[2]/div[4]/div/div[2]/nav/ul/li[2]/a',
    visibilitySelect: '/html/body/div[3]/div[4]/div/div[3]/div/section/div/form/fieldset[1]/div[2]/div[4]/div[2]/select',
    hideOption: '/html/body/div[3]/div[4]/div/div[3]/div/section/div/form/fieldset[1]/div[2]/div[4]/div[2]/select/option[1]',
    showOption: '/html/body/div[3]/div[4]/div/div[3]/div/section/div/form/fieldset[1]/div[2]/div[4]/div[2]/select/option[2]',
    submitButton: '/html/body/div[3]/div[4]/div/div[3]/div/section/div/form/div[3]/div[2]/div[1]/div/div[1]/span/input'
  }
}
