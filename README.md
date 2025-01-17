# Software Quality Engineering - System Testing
This is a repository for the system-testing assignment of the Software Quality Engineering course at the [Ben-Gurion University](https://in.bgu.ac.il/), Israel.

## Assignment Description
In this assignment, we tested an open-source software called [$$*TODO* software name$$](https://address-of-the-project.com).

$$*TODO* Add some general description about the software$$

## Installation

### Initial setup
1. Download the [moodle packages for windows](https://download.moodle.org/windows/?utm_source=chatgpt.com)
2. Extract the contents of the zip folder and run `Start Moodle.exe`
3. Open your browser and navigate to `localhost`
4. Follow the instructions to setup the project and database. Use the MySQL port configured on your machine (default is 3306).

### Adding student and teacher users
1. Login as **admin** (with the details provided during the setup)
2. Navigate to **Site Administration** from the top toolbar
3. Click **Users**
4. Inside **Accounts**, click **Browse list of users**
5. Click **Add a new user**
6. Create a users for the student and the teacher:

| Username | Password | First Name | Last Name | Email Address    |
| -------- | -------- | ---------- | --------- | -------------    |
| student  | P4$$w0rd | Student    | Sam       | student@test.com |
| teacher  | P4$$w0rd | Teacher    | Tom       | teacher@test.com |

### Adding Course
1. Login as **admin** (with the details provided during the setup)
2. Navigate to **Site Administration** from the top toolbar
3. Click **Courses**
4. Inside **Courses**, click **Manage courses and categories**
5. Inside the right panel, click **Create new course**:

| Course full name | Course short name | Course category |
| ---------------- | ----------------- | --------------- |
| Software Quality Engineering | SQE | Category 1 (create if does not exist) |

6. Make sure you select an appropriate course start and end dates

### Registring teacher and student to the course
1. Login as **admin** (with the details provided during the setup)
2. Navigate to **Site Administration** from the top toolbar
3. Click **Courses**
4. Inside **Courses**, click **Manage courses and categories**
5. Inside the right panel, select **Software Quality Engineering**
6. Scroll down, and then inside the course panel select **Enrolled users**
7. Click the **Enrol users** button
8. Select *Teacher Tom*
9. From the **Assign role** dropdown menu select **Teacher**
10. Click **Enrol users**
7. Click the **Enrol users** button again
8. Select *Student Sam*
9. From the **Assign role** dropdown menu select **Student**
10. Click **Enrol users**


After performing all these steps, you should have 2 users - a student and a teacher, both enrolled to the same course.

## What we tested
$$*TODO* Add a description of the module and the user stories that you chose to test.
For example, in the case of the Moodle example, you can write something like this:

We tested the quiz module that allows for creating and taking quizzes. We chose to test the following user stories: 

*User story:* A teacher adds a new quiz to the course with two yes/no questions

*Preconditions:* There is a course with a teacher

*Expected outcome:* The quiz is added to the course.

*User story:* A students attempts a quiz and answers correctly.

*Preconditions:* There is a course with a quiz with two yes/no questions and the quiz grade is calculated automatically and the grade is visible to the students upon submission.

*Expected outcome:* The student receives 100.
$$

## How we tested
We used two different testing methods:
1. [Cucumber](https://cucumber.io/), a behavior-driven testing framework.
2. [Provengo](https://provengo.tech/), a story-based testing framework.

Each of the testing methods is elaborated in its own directory. 

## Results
Update all README.md files (except for d-e, see Section 1). Specifically, replace all $$*TODO*…$$ according to the instructions inside the $$.

## Detected Bugs
We detected the following bugs:

1. Bug 1: 
   1. General description: ...
   2. Steps to reproduce: ...
   3. Expected result: ...
   4. Actual result: ...
   5. Link to the bug report: (you are encouraged to report the bug to the developers of the software)
2. Bug 2: ...

$$*TODO* if you did not detect the bug, you should delete this section$$  
