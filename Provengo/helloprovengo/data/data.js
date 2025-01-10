/*
 *  This is a good place to put common test data, project-wide constants, etc.
 */

const URL = "http://localhost/";
const student= {
  UserName: "nir_ahroni",
  Password: "Nir1234"
}
const courseId =1
const choiceOptionId1 =1
const choiceOptionId2 =2
const xpaths = {
  coursePage: {
    myCoursesLink: '//*[@id="myCourses"]',
    courseLink: '//*[contains(@href, "https://sandbox.moodledemo.net/course/view.php?id=${courseId}")]',
    choiceLink: '//li[2]/div[1]/div[2]/div[2]/div[1]/div[1]/a[1]',
    choiceOptionLink: "//*[@id='choice_${choiceOptionId}']",
    submitButton: '//*[@value="Save my choice"]'
  },
}

