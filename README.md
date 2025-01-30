# Software Quality Engineering - System Testing
This is a repository for the system-testing assignment of the Software Quality Engineering course at the [Ben-Gurion University](https://in.bgu.ac.il/), Israel.

## Assignment Description
In this assignment, we tested an open-source software called PrestaShop (https://localhost:8080).

PrestaShop is an open-source e-commerce platform written in PHP that allows users to create and manage online stores.
It provides a flexible and customizable solution with a wide range of themes, modules, and integrations.
PrestaShop supports multiple payment gateways, languages, and currencies, making it ideal for international businesses.
It has a user-friendly admin panel for managing products, orders, customers, and marketing tools.

## Installation
Download PrestaShop from PrestaShop.com, extract the files, and upload them to your server or set up a Docker container using the official PrestaShop image.
Ensure support for Apache/Nginx, PHP 7.1+, and MySQL 5.6+.
Create a database via phpMyAdmin or a Docker MySQL container, then run the installer at http://localhost/prestashop.
Enable Debug Mode in config/defines.inc.php, install Selenium (npm install -g selenium-webdriver), and download ChromeDriver.
Create test data and run tests using Selenium, PHPUnit, or Behat.

## What we tested
We tested the shopping cart and inventory management functionalities of our e-commerce system.
The following user stories were chosen for testing:

User Story 1: A user adds a product to the cart twice.

Preconditions:
The user is logged in.
The product is available in stock with at least two units.

Expected Outcome:
The cart displays the product with a quantity of two.

User Story 2: The admin updates product availability to one.

Preconditions:
There is a cart with the same product twice.
The admin has access to the product inventory settings.

Expected Outcome:
The cart updates to reflect the new product availability,
reducing the quantity to one if necessary.

To implement these tests, we used Selenium-based behavioral threads (bthreads).
The user scenario simulates adding a product to the cart and verifying the quantity,
while the admin scenario updates the inventory and verifies the changes.

## How we tested
We used two different testing methods:
1. [Cucumber](https://cucumber.io/), a behavior-driven testing framework.
2. [Provengo](https://provengo.tech/), a story-based testing framework.

Each of the testing methods is elaborated in its own directory. 

## Results
Update all README.md files (except for d-e, see Section 1). Specifically, replace all $$*TODO*…$$ according to the instructions inside the $$.
