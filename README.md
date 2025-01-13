# Software Quality Engineering - System Testing

This is a repository for the system-testing assignment of the Software Quality Engineering course at the [Ben-Gurion University](https://in.bgu.ac.il/), Israel.

## Assignment Description

In this assignment, we tested an open-source software called Moodel(https://address-of-the-project.com). //TODO change this

$$*TODO* Add some general description about the software$$

Moodle is a software used by universities to manage courses, for both teachers and students.
Some of the features it provides are adding teachers and students to courses, uploading class material, opening quizes and assignments, and more.

## Installation

$$*TODO* Write instructions on how to install the software and prepare the testing environment$$
Installation:

1. We installed Moodle locally according to the instructions in "/SUT/README.md".
   - We defined an admin user with username :"admin" and password: "Sandbox24\*"
2. After installing Moodle, we ran the "start Moodle.exe" file and opened "http://localhost" to open Moodle.
3. We prepared the testing environment by adding to following data to Moodle:
   - Created teacher user with username :"teacher" and password: "Sandbox24\*"
   - Created student user with username :"student" and password: "Sandbox24\*"
   - Created a course called "My First Course"
   - Added the teacher user with the role of "Teacher" and to student with a role of "Student" to "My First Course".
4. To ran the tests, we started the Selenium server according to the instructions in "/Selenium/README.md".
5. We ran the tests in "RunCucumberTest.java".

## What we tested

$$
*TODO* Add a description of the module and the user stories that you chose to test.
For example, in the case of the Moodle example, you can write something like this:

We tested the quiz module that allows for creating and taking quizzes. We chose to test the following user stories:

*User story:* A teacher adds a new quiz to the course with two yes/no questions

*Preconditions:* There is a course with a teacher

*Expected outcome:* The quiz is added to the course.

*User story:* A students attempts a quiz and answers correctly.

*Preconditions:* There is a course with a quiz with two yes/no questions and the quiz grade is calculated automatically and the grade is visible to the students upon submission.

*Expected outcome:* The student receives 100.
$$

We tested the starring a course module that allows students (and teachers) to star a course to mark as their favorite. We chose to test the following user stories:

1.

- User story: A student defined a course called "My First Course" as starred
- Preconditions: The student is logged in to Moodle, The course "My First Course" exists in the system and the student is registered to it.
- Expected outcome: The course is starred (a star is shown next to the course name in "My Courses" page).

1.

- User story: A teacher hides from student a course called "My First Course" as starred
- Preconditions: The teacher is logged in to Moodle, The course "My First Course" exists in the system and the teacher is registered to it.
- Expected outcome: The course is hidden from students (A "hidden from students" label for the teacher in "My Courses" page and the course is not shown to student in "My Courses" page).

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
