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

Run the following commands to set up Moodle and its database:

docker network create moodle-network
docker volume create --name mariadb_data
docker run -d --name mariadb \
--env ALLOW_EMPTY_PASSWORD=yes \
--env MARIADB_USER=bn_moodle \
--env MARIADB_PASSWORD=bitnami \
--env MARIADB_DATABASE=bitnami_moodle \
--network moodle-network \
--volume mariadb_data:/bitnami/mariadb \
bitnami/mariadb:latest
docker run -d --name moodle \
-p 8080:8080 -p 8443:8443 \
--env ALLOW_EMPTY_PASSWORD=yes \
--env MOODLE_DATABASE_USER=bn_moodle \
--env MOODLE_DATABASE_PASSWORD=bitnami \
--env MOODLE_DATABASE_NAME=bitnami_moodle \
--network moodle-network \
--volume moodle_data:/bitnami/moodle \
--volume moodledata_data:/bitnami/moodledata \
bitnami/moodle:latest

Access Moodle at http://localhost:8080.

Set Up Moodle:

Complete the Moodle installation by following the on-screen setup instructions.

Create a course, enroll a student, and set up a forum.

Install Testing Tools:

Install Selenium for browser automation:

Download the Selenium server and ChromeDriver.

Start the Selenium server.

## What we tested
User Story 1: A student searches for a comment in the forum and selects the result.

Preconditions:

The student is logged in and enrolled in the course.

The forum contains at least one comment that matches the search query.

Expected outcome:

The search function returns the matching comment.

The student can click on a result to navigate to the comment in the forum.

User Story 2: A teacher deletes their comment from the forum.

Preconditions:

The teacher has already posted at least one comment in the forum.

Expected outcome:

The comment is successfully deleted.

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
