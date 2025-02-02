# Testing PrestaShop using Cucumber
This directory contains the cucumber files for testing the PrestaShop module of the PrestaShop application.

## Running the tests
Run ```mvn test``` to run all the tests.

## Feature files
The behaviors that we tested are in the feature files that inside the [resources/hellocucumber](resources/hellocucumber) directory. See the files for a detailed description of the tests.

This feature file outlines a set of automated test scenarios for the PrestaShop module, focusing on user account management functionalities. There are two main scenarios:
**Admin Deactivates a User:**
This scenario evaluates the administrator's capability to deactivate a user's account.
It starts with the admin logging into PrestaShop using designated credentials, proceeding to the customers page, and disabling a user account based on the provided email address.
The test includes specific examples of admin and user email addresses and passwords to ensure clarity.

**User Changes Their Name:**
This scenario verifies the functionality that enables a user to update their first name in the system.
It describes the steps where a user logs into their account from the homepage, navigates to the section for name updates, and modifies their first name to a new value.
The test includes an example with specific details, such as the user's current name, email, password, and the new first name to be applied.
## Step files
The step files in the [src/test/java/hellocucumber](src/test/java/hellocucumber) directory contain the code that defines how each sentence in the feature files is translated to Selenium actions. See the files for a detailed description of the implementation.
Setup and Initialization:
The class initializes the ChromeDriver and WebDriverWait, pointing to the path of the ChromeDriver and setting the base address for the PrestaShop admin page.
It sets a timeout for waiting for elements to become visible or interactive, ensuring that tests don't fail due to slow loading times.


## Admin Deactivates a User:
***Admin Login Workflow:***

**EnterLoginPage:**
Initializes the driver, opens the PrestaShop admin login page, and maximizes
the browser window. This step acts as the prerequisite for scenarios that require admin access.

**adminLoginWithEmailAndPassword:**
Logs in to the admin account using the provided email and password, verifying successful login by checking the URL.
This step is essential for any test that involves an authenticated admin session.

***Navigating and Interacting with the UI:***

**navigatesToCustomerPage:**
Details the navigation process within the admin dashboard, specifically to the customers page,
using XPath selectors to locate and interact with UI elements.

**deactivatesTheUserWithEmail:**
Covers more advanced interactions, such as searching for a user by email, scrolling to ensure elements are visible,
and toggling the activation status of a user account.
This step includes assertions to verify the toggle's state (active/inactive) and validate the success of the action based on UI feedback.

***DeactivationHappened:***

**adminScenarioPasses:**
Marks the successful completion of an admin-related scenario. It also handles cleanup by quitting the driver,
ensuring the browser is properly closed after the test execution.

## User Changes Their Name:
**navigateToLoginPage**
Initializes the driver, opens the PrestaShop user login page,

**login**
Logs in to the user account using the provided email and password, verifying successful login by checking the URL.
This step is essential for any test that involves an authenticated user session.

**navigateToUserInformation**
click on the user name

**navigateToInformation**
click on the Information

**changeFirstName**
file this details: user's current name, email, password
click termsAndConditionsCheck and dataPrivacyCheck
and then click the save button

***user scenario passes***
Marks the successful completion of a user scenario. It also handles cleanup by quitting the driver,
ensuring the browser is properly closed after the test execution.
