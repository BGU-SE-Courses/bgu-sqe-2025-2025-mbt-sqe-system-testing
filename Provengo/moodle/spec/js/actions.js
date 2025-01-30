//@provengo summon ctrl
// 
// // function composeQuery(session, data) {
//   session.writeText(xpaths.searchWindow.searchInput, data.text)
// }

// function startSearch(session) {
//   with(session) {
//     click(xpaths.searchWindow.searchButton)
//   }
// }

// function feelLucky(session) {
//   with(session) {
//     click(xpaths.searchWindow.feelingLuckyButton)
//   }
// }


function pressLogin(session) {
  sync({request: Event("PressLogin")});

  with(session) {
    Ctrl.doSleep(1000)
    click('//*[@id="usernavigation"]/div/div/span/a')
  }
}

function enterUsername_student(session) {
  with(session) {
    Ctrl.doSleep(1000)
    clear(xpaths.loginPage.usernameInputXpath)
    writeText(xpaths.loginPage.usernameInputXpath, "student")
  }
}

function enterPassword_student(session) {
  with(session) {
    Ctrl.doSleep(1000)
    clear(xpaths.loginPage.passwordInputXpath)
    writeText(xpaths.loginPage.passwordInputXpath, "Sandbox24!")
  }
}

function enterUsername_teacher(session) {
  with(session) {
    Ctrl.doSleep(1000)
    clear(xpaths.loginPage.usernameInputXpath)
    writeText(xpaths.loginPage.usernameInputXpath, "teacher")
  }
}

function enterPassword_teacher(session) {
  with(session) {
    Ctrl.doSleep(1000)
    clear(xpaths.loginPage.passwordInputXpath)
    writeText(xpaths.loginPage.passwordInputXpath, "Sandbox24!")
  }
}

function submitLogin(session) {
  with(session) {
    Ctrl.doSleep(1000)
    click(xpaths.loginPage.submitButtonXpath)
  }
  
  sync({request: Event("SubmitLogin"),
        request: Ctrl.markEvent("SubmitLogin")
  });
}

function goToCourse(session) {
  sync({waitFor: Event("SubmitLogin"),
        request: Event("GoToCourse")
  });

  with(session) {
    Ctrl.doSleep(1000)
    click(xpaths.coursePage.myCoursesLinkXpath)
    click(xpaths.coursePage.courseLinkXpath)
  }
  
  sync({request: Event("InCourse"),
    request: Ctrl.markEvent("InCourse")
});
}

function openQuiz(session) {
  sync({waitFor: Event("InCourse"),
        request: Event("TryOpenQuiz")
});

  with(session) {
    Ctrl.doSleep(1000)
    click(xpaths.coursePage.quizLinkXpath)
  }

  sync({request: Event("OpenedQuiz"),
        request: Ctrl.markEvent("OpenedQuiz")
  });
}

function answerQuiz(session) {
  with(session) {
    Ctrl.doSleep(1000)
    click(xpaths.quizPage.quizPreviewLinkXpath)
    click(xpaths.quizPage.quizAnswerXpath)
  }
}

function submitQuiz(session) {
  with(session) {
    Ctrl.doSleep(1000)
    click(xpaths.quizPage.quizSubmitButtonXpath)
    click(xpaths.quizPage.quizSubmitAllAndFinishButtonXpath)
    click(xpaths.quizPage.quizSubmitAndFinishPopUpXpath)
    click(xpaths.quizPage.FinishReviewXpath)    
  }
}

function editModeQuiz(session) {
  with(session) {
    Ctrl.doSleep(1000)
    click(xpaths.coursePage.editModeXpath)
  }

  sync({waitFor: Event("OpenedQuiz"),
        request: Event("EditModeQuiz")
  });
}

function hideQuiz(session) {
  with(session) {
    Ctrl.doSleep(1000)
    click(xpaths.coursePage.threePointsXpath)
    click(xpaths.coursePage.hideOptionXpath)
  }
  
  sync({request: Event("QuizHidden"),
        request: Ctrl.markEvent("QuizHidden")
  });
}

function showQuiz(session) {
  with(session) {
    Ctrl.doSleep(1000)
    click(xpaths.coursePage.threePointsHideXpath)
    click(xpaths.coursePage.showOptionXpath)
    Ctrl.doSleep(3000)
  }
  
  sync({request: Event("QuizShowen"),
        request: Ctrl.markEvent("QuizShowen")
  });
}