/* @provengo summon selenium */
/*
 *  This is a good place to put common test data, project-wide constants, etc.
 */
const assignment4 = 'Assignment 4';
const studentUsername = 'student';
const studentPassword = 'sandbox24';
const teacherUsername = 'teacher';
const teacherPassword = 'sandbox24';
const commentSubject ='Did you learn provengo?';
const commentMessage ='Keren is the best';
const URL = 'https://sandbox.moodledemo.net/';
const xpaths = {
    loginWindowButton: "//*[@id=\"usernavigation\"]/div[5]/div/span/a",
    loginWindow:
        {
            usernameInput: '//*[@id=\"username\"]',
            passwordInput: '//*[@id=\"password\"]',
            loginButton: '//*[@id=\"loginbtn\"]',
        },
    teacherWindow:
        {
            teacherClickOnCourse:'/html/body/div[2]/div[3]/div/div[2]/div/section/div/div[2]/div/div[6]/div[1]/h3/a',
            editModeButton:'/html/body/div[2]/nav/div/div[2]/form/div/div/input',
            teacherOpenTopic2: '/html/body/div[4]/div[5]/div/div[3]/div/section/div/div/div/ul/li[2]/div/div[1]/div[2]/a/span[2]',
            teacherCliclOnInfoButton: '/html/body/div[4]/div[5]/div/div[3]/div/section/div/div/div/ul/li[2]/div/div[2]/ul/li/div[2]/div[2]/div[4]/div/div/div/div/a/i',
            deleteOption: '/html/body/div[4]/div[5]/div/div[3]/div/section/div/div/div/ul/li[2]/div/div[2]/ul/li/div[2]/div[2]/div[4]/div/div/div/div/div/a[8]',
            deleteConfirmationPopup: '//*[@id="page-course-view-weeks"]/div[8]/div[2]/div/div/div[3]/button[2]'
        },
    studentWindow:
        {
            studentCoursesButton: '/html/body/div[2]/nav/div/div[1]/nav/ul/li[3]/a',
            studentSoftwareQACourseButton: '/html/body/div[2]/div[3]/div/div[2]/div/section/div/aside/section/div/div/div[1]/div[2]/div/div/div[1]/div/div/div/div/div[1]/div/div/a/span[3]/span[2]',
            openTopic5: '/html/body/div[2]/div[5]/div/div[3]/div/section/div/div/div/ul/li[6]/div/div[1]/div[2]/a',
            studentForumButton: '/html/body/div[2]/div[5]/div/div[3]/div/section/div/div/div/ul/li[6]/div/div[2]/ul/li/div/div[2]/div[2]/div/div/a',
            addDiscussionButton: '//*[@id="region-main"]/div[2]/div[1]/div/div[2]/a',
            subjectInbox : '//*[@id=\"id_subject\"]',
            insertButton :'//*[@id="fitem_id_message"]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[3]',
            signsButton: '/html/body/div[2]/div[4]/div/div[2]/div/section/div[2]/div[2]/div[2]/form/div[3]/div[2]/div[1]/div[1]/div[2]/div/div/div/div[2]/div[1]',
            dollarButton: '/html/body/div[5]/div[1]/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div[1]',
            postToForumButton: '//*[@id="id_submitbutton"]'
        }
}


