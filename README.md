# Software Quality Engineering - System Testing
This is a repository for the system-testing assignment of the Software Quality Engineering course at the [Ben-Gurion University](https://in.bgu.ac.il/), Israel.

## Assignment Description
In this assignment, we tested an open-source software called [Moodle](https://address-of-the-project.com).

Moodle is the World's Open Source Learning Platform, widely used around the world by countless universities, schools, companies, and all manner of organisations and individuals.

Moodle is designed to allow educators, administrators and learners to create personalised learning environments with a single robust, secure and integrated system.

## Installation
Preparing the Testing Environment

Install Moodle:

Use Docker for a quick setup:

Run the following commands line by line to set up Moodle and its database:

**Create Docker network**

`docker network create moodle-network`

**Create volume for MariaDB data**

`docker volume create --name mariadb_data`

**Run the MariaDB container in one line**

`docker run -d --name mariadb --env ALLOW_EMPTY_PASSWORD=yes --env MARIADB_USER=bn_moodle --env MARIADB_PASSWORD=bitnami --env MARIADB_DATABASE=bitnami_moodle --network moodle-network --volume mariadb_data:/bitnami/mariadb bitnami/mariadb:latest`

**Create volumes for Moodle**

`docker volume create --name moodle_data`

`docker volume create --name moodledata_data`

**Run the Moodle container in one line**

`docker run -d --name moodle -p 8080:8080 -p 8443:8443 --env ALLOW_EMPTY_PASSWORD=yes --env MOODLE_DATABASE_USER=bn_moodle --env MOODLE_DATABASE_PASSWORD=bitnami --env MOODLE_DATABASE_NAME=bitnami_moodle --network moodle-network --volume moodle_data:/bitnami/moodle --volume moodledata_data:/bitnami/moodledata bitnami/moodle:latest`



**wait 3-4 minutes so the installation is complete**

Access Moodle at http://localhost:8080.

Set Up Moodle:

Complete the Moodle installation by following the on-screen setup instructions.

login as an admin using this:

* username : user
* password: bitnami

create a student with :

* username : s1
* password: 123456Aaa-

create a teacher with :

* username : t1
* password: 123456Aaa-


Create a course with the name "course1", enroll the student and a teacher in the course.

**for the cucumber part add only one comment by the name "hey1"**

**for the provengo part if you want to run one test make sure there is at least one comment of the name "hey1".**

**if you want to test a suit of 5 tests make sure there is at 5 one comment of the name "hey1"**

Install Testing Tools:

Install Selenium for browser automation:

Download the Selenium server and ChromeDriver.

Start the Selenium server.

## What we tested

### User Story 1: Student Comment Search
**A student searches for a comment in the forum and selects the result.**

**Preconditions:**
- The student is logged in and enrolled in the course
- The forum contains at least one comment that matches the search query

**Expected outcome:**
- The search function returns the matching comment
- The student can click on a result to navigate to the comment in the forum

### User Story 2: Teacher Comment Deletion
**A teacher deletes their comment from the forum.**

**Preconditions:**
- The teacher has already posted at least one comment in the forum

**Expected outcome:**
- The comment is successfully deleted

## How we tested
We used two different testing methods:
1. [Cucumber](https://cucumber.io/), a behavior-driven testing framework.
2. [Provengo](https://provengo.tech/), a story-based testing framework.

Each of the testing methods is elaborated in its own directory. 

## Detected Bugs
We detected the following bugs:

1. Bug 1: 
   1. General description: the first time you download moodle and run the test u get many pop up tutorial in the website which can affect the tests badly.
   2. Steps to reproduce: run the first time and skip all the tutorials and after that it should work fine .
   3. Expected result: success
   4. Actual result: fail (only for the first time but once the tutorial is skipped it should get back to normal)