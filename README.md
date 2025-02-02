
# Software Quality Engineering - System Testing
This is a repository for the system-testing assignment of the Software Quality Engineering course at the [Ben-Gurion University](https://in.bgu.ac.il/), Israel.

## Assignment Description
In this assignment, we tested an open-source software called prestashop https://prestashop.com/.

PrestaShop is an open-source e-commerce platform that enables businesses to create and manage their online stores. It boasts a range of costummizable themes and modules
Prestashop allows the buisness owners to modify and personolize their website to fit their needs, preferences  and control over producds.
Prestashop has a user-friendly interface, and offers features for product management, orders, shipping, customer management, and analytics, among others. It supports multiple payment gateways, making it easier for businesses to accpet different types of payments worldwild/. PrestaShop is built on the PHP programming language and uses a MySQL database, offering flexibility and scalability for online merchants of all sizes.

## Installation
there are multiple ways to download and install the software, the first and easiest way is using "Docker". and simply installing it with a premade composer code gracefully given by our instructors. the other way:

### Part 1: Installing XAMPP
#### Download XAMPP:

Visit the official XAMPP website at apachefriends.org and download the latest version of XAMPP for your operating system.
#### Install XAMPP:

Run the downloaded installer file as an administrator.
Click "Next" and select the components to install. For PrestaShop, ensure that PHP, MySQL (MariaDB), and phpMyAdmin are selected.
Choose the installation directory (e.g., C:\xampp) and continue with the installation.
Once installed, you may start the control panel from the final screen of the installer.

#### Start Apache and MySQL:

Open the XAMPP Control Panel.
Start the Apache and MySQL modules by clicking the "Start" buttons next to each. You should see their status turn green, indicating they are running.

### Part 2: Creating a Database for PrestaShop
#### Open phpMyAdmin:

In your browser, visit http://localhost/phpmyadmin.
This opens the phpMyAdmin interface, a web-based tool for managing MySQL databases.

#### Create a New Database:

Click on the "Databases" tab.
Enter a name for your PrestaShop database (e.g., prestashop_db) in the "Create database" field.
Click "Create." No need to change the collation.

### Part 3: Installing PrestaShop
#### Download PrestaShop:

Go to the official PrestaShop website at prestashop.com and download the latest version of PrestaShop.
#### Extract PrestaShop:

Extract the downloaded zip file.
Copy the extracted folder to your XAMPP’s htdocs directory (e.g., C:\xampp\htdocs).
#### Rename the PrestaShop Folder (Optional):

For ease of access, you can rename the extracted PrestaShop folder to something simpler, like prestashop.
#### Run the PrestaShop Installation:

In your browser, navigate to http://localhost/prestashop.
The PrestaShop installation wizard should start. Follow the on-screen instructions.
When asked, enter the database details you created earlier. Database server is typically localhost, and the database name is what you created in phpMyAdmin. Use root for the username and leave the password blank (default for XAMPP).
#### Finalize the Installation:

Continue following the instructions to set up your shop, including configuring your shop name, activity, and personal information.
After completing the installation, you'll be prompted to delete the install folder and rename the admin folder for security reasons. You can do this via the file explorer in your XAMPP installation path (e.g., C:\xampp\htdocs\prestashop).
#### Accessing Your PrestaShop Site:

Once installation is complete, access your PrestaShop back office by navigating to the renamed admin directory (e.g., http://localhost/prestashop/admin123).


## What we tested
We tested the user account management module in PrestaShop, which allows for the modification of user details and the activation/deactivation of user accounts by an administrator. We chose to test the following user stories:

**User story:** A user changes their name in PrestaShop.

**Preconditions:** The user has an existing account in the PrestaShop system.

**Expected outcome:** The user's name is updated in their account details.

**User story:** An admin deactivates the user in PrestaShop.

**Preconditions:** There is an existing user account, and an admin has access to the user management area.

**Expected outcome:** The user's account is deactivated, preventing the user from logging in or making purchases.

## How we tested
We used two different testing methods:
1. [Cucumber](https://cucumber.io/), a behavior-driven testing framework.
2. [Provengo](https://provengo.tech/), a story-based testing framework.

Each of the testing methods is elaborated in its own directory.


## Detected Bugs
We detected the following bugs:

1. Bug 1:
   1. General description: press the toggle on the "enabled" button for the user under the admin
   2. Steps to reproduce: enter the admin, enter the customer's section, look for the user and disable him
   3. Expected result: user disabled, test moves forward
   4. Actual result: the user is disabled and the test continues yet we still get an 'error' on disabling the user that the "xpath is not clickable"
   5. Link to the bug report: file:///C:/Users/yuval/IdeaProjects/2025-mbt-j/Provengo/helloprovengo/products/reports/suites/suite-117/runs/run-129/index.html
