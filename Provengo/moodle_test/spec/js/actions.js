function login(session, data){
  with(session){
    click(xpaths.guestWindow.loginWindowButton)
    waitForVisibility(xpaths.loginWindow.usernameInput)
    writeText(xpaths.loginWindow.usernameInput, data.username)
    writeText(xpaths.loginWindow.passwordInput, data.password)
    click(xpaths.loginWindow.loginButton)
  }
}

function goToMyCourses(session){
  with(session){
    click(xpaths.mainWindow.myCourses)
    waitForVisibility(xpaths.myCoursesWindow.course)
  }
}

function starCourse(session){
  with(session){
    click(xpaths.myCoursesWindow.threeDots)
    waitForVisibility(xpaths.myCoursesWindow.starButton)
    click(xpaths.myCoursesWindow.starButton)
  }
}

function goToCourse(session){
  with(session){
    click(xpaths.myCoursesWindow.course)
    waitForVisibility(xpaths.courseWindow.settingsButton)
  }
}

function hideCourse(session){
  with(session){
    click(xpaths.courseWindow.settingsButton)
    waitForVisibility(xpaths.courseWindow.visibilitySelect)
    click(xpaths.courseWindow.visibilitySelect)
    waitForVisibility(xpaths.courseWindow.hideOption)
    click(xpaths.courseWindow.hideOption)
    click(xpaths.courseWindow.submitButton)
  }
}