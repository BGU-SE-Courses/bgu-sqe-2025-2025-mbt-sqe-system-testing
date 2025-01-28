

// Select Your Criteria Test In data.js, in TEST_TYPE Defenition


  /////////////////////////////// Specific Criteria - Student Upload --> Teacher Reduce /////////////////////////////////
  if (TEST_TYPE === TEST_TYPES.DOMAIN_SPECIFIC) {

      // Student
    bthread('Student Flow - Spesific Criteria', function () {

      let Student_Session = new SeleniumSession('StudentLogin - Specific Criteria');
      Student_Session.start(URL);
      
      Login(Student_Session, USERS.Student);
      // After the function completes, report the event
      bp.sync({ request: Student_EVENTS.STUDENT_LOGGED_IN });
      
      GoToQACourse(Student_Session);
      bp.sync({ request: Student_EVENTS.STUDENT_IN_COURSE });
      
      GoToAssignment1(Student_Session);
      bp.sync({ request: Student_EVENTS.STUDENT_IN_ASSIGNMENT });
      
      AddFirstFileToAssignment(Student_Session);
      AddSecondFileToAssignment(Student_Session);
      bp.sync({ request: Student_EVENTS.STUDENT_FILES_UPLOADED});

      SaveStudentSubmission(Student_Session);
      bp.sync({ request: Student_EVENTS.STUDENT_SUBMISSION_COMPLETED });
    });


    // Teacher
    bthread('Teacher Flow - Spesific Criteria', function () {
      let Teacher_Session = new SeleniumSession('TeacherLogin - Specific Criteria');
      Teacher_Session.start(URL);
      
      Login(Teacher_Session, USERS.Teacher);
      bp.sync({ request: Teacher_EVENTS.TEACHER_LOGGED_IN });
      
      GoToQACourse(Teacher_Session);
      bp.sync({ request: Teacher_EVENTS.TEACHER_IN_COURSE });
      
      GoToAssignment1(Teacher_Session);
      bp.sync({ request: Teacher_EVENTS.TEACHER_IN_ASSIGNMENT });
      
      // MaxFiles_Limited_to_1 defined in data.js
      ChangeMaxFileSize(Teacher_Session, MaxFiles_Limited_to_1);
      bp.sync({ request: Teacher_EVENTS.TEACHER_REDUCE_MAX_FILES });

      bp.sync({ waitFor: Student_EVENTS.STUDENT_SUBMISSION_COMPLETED });
      SaveTeacherUpdates(Teacher_Session);
      bp.sync({ request: Teacher_EVENTS.TEACHER_REDUCTION_COMPLETED });
      bp.sync({ request: Mission_Completed_Events.END_SPECIFIC_CRITERIA });

    });

  }

  ///////////////////// Restart the system //////////////////////////
  // Teacher Reset Flow
  if (TEST_TYPE === TEST_TYPES.RESET) {

    bthread('Teacher Reset Flow', function () {

      let Teacher_Reset_session = new SeleniumSession('TeacherLogin_reset');
      Teacher_Reset_session.start(URL);
    
      Login(Teacher_Reset_session, USERS.Teacher);
      
      // Perform reset actions using the existing session
      GoToQACourse(Teacher_Reset_session);

      GoToAssignment1(Teacher_Reset_session);
      
      // MaxFiles_Limited_to_2 defined in data.js
      ChangeMaxFileSize(Teacher_Reset_session, MaxFiles_Limited_to_2);
      bp.sync({ request: Reset_EVENTS.TEACHER_INCREASE_MAX_FILES });

      SaveTeacherUpdates(Teacher_Reset_session);
      bp.sync({ request: Reset_EVENTS.TEACHER_RESET_COMPLETED});

    });


    // Student Reset Flow
    bthread('Student Reset Flow', function () {
      let Student_Reset_session = new SeleniumSession('StudentLogin_reset');
      Student_Reset_session.start(URL);
      Login(Student_Reset_session, USERS.Student);
      GoToQACourse(Student_Reset_session);
      GoToAssignment1(Student_Reset_session);
      RemoveSubmission(Student_Reset_session);
      bp.sync({ request: Reset_EVENTS.STUDENT_REMOVED_SUBMISSION});
      bp.sync({ request: Reset_EVENTS.STUDENT_RESET_COMPLETED});
      bp.sync({waitFor: Reset_EVENTS.TEACHER_RESET_COMPLETED});
      bp.sync({ request: Reset_EVENTS.RESET_COMPLETED});
    });
  }


  ////////////////////////////////// Two Ways Criteria : TeacherReduce <--> Student Upload //////////////////////////////////////
  if (TEST_TYPE === TEST_TYPES.TWO_WAY) {
    // The teacher - has no limitations, they are the one setting limits
    // Updates flag we created in the data file
    bthread('Teacher Two Way Flow', function () {
        let Teacher_Session = new SeleniumSession('TeacherLogin - Two Way Criteria');
        Teacher_Session.start(URL);
        
        Login(Teacher_Session, USERS.Teacher);
        bp.sync({ request: Teacher_EVENTS.TEACHER_LOGGED_IN });
        
        GoToQACourse(Teacher_Session);
        bp.sync({ request: Teacher_EVENTS.TEACHER_IN_COURSE });
        
        GoToAssignment1(Teacher_Session);
        bp.sync({ request: Teacher_EVENTS.TEACHER_IN_ASSIGNMENT });
        
        ChangeMaxFileSize(Teacher_Session, MaxFiles_Limited_to_1);
        bp.sync({ request: Teacher_EVENTS.TEACHER_REDUCE_MAX_FILES });
        
        SaveTeacherUpdates(Teacher_Session);
        teacherLimitedFiles = true;  // Flag Update
        bp.sync({ request: Teacher_EVENTS.TEACHER_REDUCTION_COMPLETED });
    });

    // The student - limited by the teacher's actions
    // Updates according to flag we created in the data file
    bthread('Student Two Way Flow', function () {
        let Student_Session = new SeleniumSession('StudentLogin - Two Way Criteria');
        Student_Session.start(URL);
        
        Login(Student_Session, USERS.Student);
        bp.sync({ request: Student_EVENTS.STUDENT_LOGGED_IN });
        
        GoToQACourse(Student_Session);
        bp.sync({ request: Student_EVENTS.STUDENT_IN_COURSE });
        
        GoToAssignment1(Student_Session);
        bp.sync({ request: Student_EVENTS.STUDENT_IN_ASSIGNMENT });
        
        AddFirstFileToAssignment(Student_Session);
        bp.sync({ request: Student_EVENTS.STUDENT_FIRST_UPLOAD_COMPLETED});

        // Flag Check
        if (teacherLimitedFiles) {
            bp.sync({ request: Mission_Completed_Events.CANT_UPLOAD_SECOND_FILE });
            bp.sync({ request: Mission_Completed_Events.TWO_WAY_CRITERIA_COMPLETED });
            return;
        }
        
        AddSecondFileToAssignment(Student_Session);
        bp.sync({ request: Student_EVENTS.STUDENT_SECOND_UPLOAD_COMPLETED });

       // Flag Check
        if (teacherLimitedFiles) {
            SaveStudentSubmission(Student_Session);
            bp.sync({ request: Mission_Completed_Events.SUBMISSION_WAS_FAILED });
            bp.sync({ request: Mission_Completed_Events.TWO_WAY_CRITERIA_COMPLETED });

            return;
        }
        
        SaveStudentSubmission(Student_Session);
        bp.sync({ request: Student_EVENTS.STUDENT_SUBMISSION_COMPLETED });
        bp.sync({ request: Mission_Completed_Events.TWO_WAY_CRITERIA_COMPLETED });
    });
}


