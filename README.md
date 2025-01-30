# Software Quality Engineering - System Testing
This is a repository for the system-testing assignment of the Software Quality Engineering course at the [Ben-Gurion University](https://in.bgu.ac.il/), Israel.

## Assignment Description
In this assignment, we tested an open-source software called moodle(https://moodle.com/).

Moodle is a website for managing online courses.

## Installation
Go to https://download.moodle.org/ and download it from there according to regular instructions

## What we tested
We tested the role changing of participants and adding new content in a moodle course. We chose to test the following user stories: 

*User story:* Teacher downgrades a user permissions from TA to student

*Preconditions:* There is a course with at least two participants, one is Manager and Teacher simulating our lecturer Ahiya, the other one is Teacher simulating our TA Keren

*Expected outcome:* Keren becomes a regular student just like us.

*User story:* The user tries to add new content to the course.

*Preconditions:* There is a course with at least two participants, one is Manager and Teacher simulating our lecturer Ahiya, the other one is doesn't matter simulating our TA Keren, Note that this is in Provengo, in Cucumber we used different xpaths and different usernames and passwords, that means in the database when testing Provengo there has to be a course doesn't matter what it's called with Achiya as Manager and Teacher, and Keren as Teacher, in Cucumber the Manager and Teacher role goes to athelta and the Teacher role goes to eliasbs

*Expected outcome:* if Keren was TA then she can succesfully addd new content else if Keren was changed to Student by Ahiya the test will fail.

## How we tested
We used two different testing methods:
1. [Cucumber](https://cucumber.io/), a behavior-driven testing framework.
2. [Provengo](https://provengo.tech/), a story-based testing framework.

Each of the testing methods is elaborated in its own directory. 

## Results
The system ran as it should without touching the data base but after making a backup of the database using mysqldump and then trying to restore before each run in the two-way criterion (the bthread commented in behavior.js) moodle made very weird interactions, like I can refresh the Participants page of the course that we made and we can see that Keren was restored to Teacher after Ahiya downgraded her to Student, if we go back the homepage of the course we get an error loading the database, which is very inlogical since moodle can read that Keren is no longer Student and is Teacher again!
