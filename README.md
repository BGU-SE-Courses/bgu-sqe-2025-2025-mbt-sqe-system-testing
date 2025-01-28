# Software Quality Engineering - System Testing

This is a repository for the system-testing assignment of the Software Quality Engineering course at the [Ben-Gurion University](https://in.bgu.ac.il/), Israel.

## Assignment Description

In this assignment, we tested an open-source software called [openCart](https://www.opencart.com).

OpenCart is an open-source e-commerce platform that allows users to create their own online stores. It is written in PHP and uses a MySQL database. OpenCart provides a user-friendly interface for managing products, orders, and customers. It also supports multiple languages and currencies, making it suitable for international businesses. The platform includes a variety of features such as:

- A customizable storefront
- Multiple payment gateways
- Shipping methods
- Extensions and themes to enhance functionality and appearance
- SEO-friendly URLs
- Multi-store management

OpenCart is widely used due to its flexibility, ease of use, and extensive community support.

## Installation

To install OpenCart and prepare the testing environment, follow these steps:

1. **Download and install XAMPP:**

   - Visit the [XAMPP website](https://www.apachefriends.org/download.html) , download and install the latest version of XAMPP.

2. **Start XAMPP Server:**

   - Open the XAMPP server and click the "start buttons of the Apache and the MySQL modules.

3. **Download OpenCart:**

   - Visit the [OpenCart website](https://www.opencart.com/) and download the latest version of OpenCart.

4. **Extract Files:**

   - Extract the downloaded zip file to your web server's root directory (e.g., `C:/xampp/htdocs` for XAMPP).

5. **Set Up Database:**

   - Open your web browser and navigate to `http://localhost/phpmyadmin`.
   - Create a new database (e.g., `opencart_db`).

6. **Install OpenCart:**

   - Open your web browser and navigate to `http://localhost/opencart/upload`.
   - Follow the on-screen instructions to complete the installation. You will need to provide the database details created in the previous step.

7. **Configure OpenCart:**

   - After installation, rename the `config-dist.php` files to `config.php` in both the root directory and the `admin` directory.
   - Update the `config.php` files with your server details.

8. **Prepare Testing Environment:**

   - Ensure you have PHP, MySQL, and a web server (e.g., Apache) installed and running.
   - Install [Cucumber](https://cucumber.io/docs/installation/) and [Provengo](https://provengo.tech/docs/installation/) for testing.

9. **Verify Installation:**
   - Navigate to `http://localhost/opencart` to verify that OpenCart is installed and running correctly.

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
