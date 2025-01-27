/*
 *  Common test data and project-wide constants.
 */

const URL = "http://localhost/";

/*
 *  XPath definitions for different functions.
 */

const xpaths = {
    Login: {
        navigateToLogin: "/html/body/div[2]/nav/div/div[2]/div/div/span/a",
        enterUsername: "//*[@id=\"username\"]",
        enterPassword: "//*[@id=\"password\"]",
        loginButton: "//*[@id=\"loginbtn\"]"
    },
    Logout: {
        userScroll: "/html/body/div[4]/nav/div/div[2]/div[3]/div/div/a/span",
        logout: "/html/body/div[4]/nav/div/div[2]/div[3]/div/div/div/div/div/div/a[8]",
        fromChoiceArrow: "/html/body/div[2]/nav/div/div[2]/div[3]/div/div/a/span/span/span/span",
        logoutFromChoice: "/html/body/div[2]/nav/div/div[2]/div[3]/div/div/div/div/div/div/a[7]"
    },
    Course: {
        myCourses: "/html/body/div[2]/nav/div/div[1]/nav/ul/li[3]/a",
        createCourseButton: "/html/body/div[2]/div[3]/div[1]/header[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/form[2]/button[1]",
        enterFullName: "//*[@id=\"id_fullname\"]",
        enterShortName: "//*[@id=\"id_shortname\"]",
        saveCourseButton: "//*[@id=\"id_saveanddisplay\"]",
        chooseCourse: "//div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]/span[3]/span[2]"
    },
    Participants: {
        participantsButton: "/html/body/div[2]/div[4]/div/div[2]/nav/ul/li[3]/a",
        enrollUsersButton: "/html/body/div[2]/div[4]/div/div[3]/div/section/div/div[1]/div/div[2]/div/div/form/div/input[1]",
        scrollUsers: "/html/body/div[5]/div[2]/div/div/div[2]/form/fieldset/div[2]/div[1]/div[2]/div[3]/span",
        chooseFromBox: "/html/body/div[5]/div[2]/div/div/div[2]/form/fieldset/div[2]/div[1]/div[2]/ul/li/span/img",
        chooseUser: "/html/body/div[5]/div[2]/div/div/div[3]/button[2]",
        submitEnroll: "/html/body/div[2]/div[4]/div/div[2]/nav/ul/li[1]/a",
        asignedRole : "//div[2]/div[2]/div[2]/select[1]",
        TeacherRoleOption : "Teacher",
        chooseTeacher : "//div[2]/ul[1]/li[3]"
    },
    Activity: {
        editMode: "/html/body/div[2]/nav/div/div[2]/form/div/div/input",
        addActivity: "/html/body/div[4]/div[5]/div/div[3]/div/section/div/div/div/ul/li[1]/div[1]/div[2]/div[2]/div/button/div/span",
        choiceActivity: "/html/body/div[7]/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div[3]/div/a/div[2]",
        writeChoiceName: "/html/body/div[5]/div[5]/div/div[3]/div/section/div/form/fieldset[1]/div[2]/div[1]/div[2]/input",
        writeFirstChoice: "/html/body/div[5]/div[5]/div/div[3]/div/section/div/form/fieldset[2]/div[2]/div[5]/div[2]/input",
        writeSecondChoice: "/html/body/div[5]/div[5]/div/div[3]/div/section/div/form/fieldset[2]/div[2]/div[7]/div[2]/input",
        saveAndDisplayChoice: "/html/body/div[5]/div[5]/div/div[3]/div/section/div/form/div[4]/div[2]/div[1]/div/div[2]/span/input",
        changeUpdatability: "//fieldset[2]/div[2]/div[1]/div[2]/select[1]",
        setting : "//div[2]/nav[1]/ul[1]/li[2]/a[1]"
    },
    DisabledActivity: {
        enterDisabledActivity: "/html/body/div[2]/div[4]/div/div[3]/div/section/div/div/div/ul/li[1]/div/div[2]/ul/li[2]/div/div[2]/div[2]",
        studentEnterActivity: "/html/body/div[2]/div[4]/div/div[3]/div/section/div/div/div/ul/li[1]/div/div[2]/ul/li[2]/div/div[2]/div[2]/div/div/a",
        teacherEnterActivity: "//li[2]/div[2]/div[2]/div[2]/div[1]/div[1]/span[1]/a[1]"
    },
    ChooseOption: {
        chooseOption1: "/html/body/div[2]/div[4]/div/div[2]/div/section/div[2]/form/ul/li[1]/label",
        saveChoice: "/html/body/div[2]/div[4]/div/div[2]/div/section/div[2]/form/input[4]",
        chooseOption2: "//li[2]/input[1]"
    },
    ReturnToCourse: {
        courseName: "/html/body/div[2]/div[4]/div/header/div/div[1]/div[1]/nav/ol/li[1]/a"
    },
    CheckChange: {
        shouldBeChanged: "/html/body/div[2]/div[4]/div/div[2]/div/section/div[2]/div[3]"
    }
};

const moodleData = {
    Login: {
        adminUsername: "admin",
        studentUsername: "shavit",
        teacherUsername: "teacher",
        password: "Aa!123456"
    },
    Course: {
        fullName: "test_course",
        shortName: "test"
    },
    Activity: {
        name: "good activity",
        firstChoice: "coolOption1",
        secondChoice: "coolerOption2",
        UpdatabilityYes : "Yes",
        UpdatabilityNo : "No"
    }
};
