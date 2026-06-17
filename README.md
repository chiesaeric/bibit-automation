# Bibit Automation Framework
![Java](https://img.shields.io/badge/Java-17+-blue)
![Maven](https://img.shields.io/badge/Maven-3.9+-orange)
![Selenium](https://img.shields.io/badge/Selenium-Web-green)
![Appium](https://img.shields.io/badge/Appium-Mobile-purple)
![RestAssured](https://img.shields.io/badge/RestAssured-API-red)
![Allure](https://img.shields.io/badge/Allure-Reporting-yellow)

## Overview

Bibit Automation Framework is a Java-based automation testing framework that supports:

* Web Automation using Selenium
* API Automation using RestAssured
* Mobile Automation using Appium (Android)
* BDD implementation using Cucumber
* Reporting using Allure Report

The framework follows the Page Object Model (POM) design pattern and is designed to support scalable, maintainable, and reusable automation testing.

---

# Framework Capabilities

```text
Automation Framework
│
├── Web Automation
│   ├── Selenium
│   ├── Cucumber
│   ├── Page Object Model (POM)
│   ├── Hooks
│   ├── Screenshot Evidence
│   └── Allure Reporting
│
├── API Automation
│   ├── RestAssured
│   ├── Service Layer
│   ├── Request POJO
│   ├── Response POJO
│   ├── CRUD Operations
│   ├── Assertions
│   └── Allure Request/Response Attachment
│
└── Mobile Automation
    ├── Appium
    ├── UiAutomator2
    ├── Android Emulator
    ├── Appium Inspector
    ├── Page Object Model (POM)
    ├── Dynamic Locator
    ├── Screenshot Evidence
    └── Allure Reporting
```
---

# Technology Stack

| Technology  | Description           |
| ----------- | --------------------- |
| Java        | Programming Language  |
| Maven       | Dependency Management |
| Selenium    | Web Automation        |
| Appium      | Mobile Automation     |
| RestAssured | API Automation        |
| Cucumber    | BDD Framework         |
| JUnit       | Test Runner           |
| Allure      | Test Reporting        |

---

# Prerequisites

Ensure the following tools are installed before running the project.

## Java

```bash
java -version
```

Recommended:

```text
Java 17+
```

## Maven

```bash
mvn -version
```

Recommended:

```text
Maven 3.9+
```

## NodeJS

```bash
node -v
npm -v
```

## Appium (Mobile Testing)

Install Appium globally:

```bash
npm install -g appium
```

Verify installation:

```bash
appium -v
```

## UiAutomator2 Driver

Install Android Driver:

```bash
appium driver install uiautomator2
```

Verify:

```bash
appium driver list --installed
```

## Android SDK

Verify environment variables:

```bash
echo $ANDROID_HOME
echo $ANDROID_SDK_ROOT
```

Example:

```text
/Users/<username>/Library/Android/sdk
```

## Android Emulator

Verify connected device:

```bash
adb devices
```

Expected:

```text
emulator-5554 device
```

## Allure

Install Allure:

### MacOS

```bash
brew install allure
```

Verify installation:

```bash
allure --version
```

---

# Project Setup

Clone repository:

```bash
git clone <repository-url>
```

Navigate to project directory:

```bash
cd bibit-automation
```

Install dependencies:

```bash
mvn clean install
```

---

# Configuration

Configuration file location:

```text
src/test/resources/config/qa.properties
```

Example:

```properties
# API
api.base.url=https://jsonplaceholder.typicode.com

# Web
web.url=https://www.saucedemo.com
browser=chrome

# Mobile
mobile.server.url=http://127.0.0.1:4723
mobile.device.name=emulator-5554
mobile.app.package=com.saucelabs.mydemoapp.android
mobile.app.activity=com.saucelabs.mydemoapp.android.view.activities.SplashActivity
```

---

# Run The Test

## Available Test Suites

| Module            | Description              | Command                         |
| ----------------- | ------------------------ | ------------------------------- |
| All Tests         | Run all automation tests | `mvn clean test`                |
| API Automation    | Run all API scenarios    | `mvn test -Dtest=RunApiTest`    |
| Web Automation    | Run all Web scenarios    | `mvn test -Dtest=RunUiTest`     |
| Mobile Automation | Run all Mobile scenarios | `mvn test -Dtest=RunMobileTest` |

---

## Run Multiple Modules

| Modules      | Command                                    |
| ------------ | ------------------------------------------ |
| API + Web    | `mvn test -Dtest=RunApiTest,RunUiTest`     |
| API + Mobile | `mvn test -Dtest=RunApiTest,RunMobileTest` |
| Web + Mobile | `mvn test -Dtest=RunUiTest,RunMobileTest`  |

---

## Test Runners

| Runner          | Purpose                                 |
| --------------- | --------------------------------------- |
| `RunApiTest`    | Execute all API automation scenarios    |
| `RunUiTest`     | Execute all Web automation scenarios    |
| `RunMobileTest` | Execute all Mobile automation scenarios |

---

## Mobile Prerequisite

Before executing Mobile Automation:

Verify connected device:

```bash
adb devices
```

Start Appium Server:

```bash
appium
```

Run Mobile Test:

```bash
mvn test -Dtest=RunMobileTest
```

---

# Project Structure

```text
bibit-automation
│
├── allure-results/
│
├── src/
│   │
│   ├── main/java/bibit/framework/
│   │   │
│   │   ├── api/                       (API service, request, response, endpoint layer)
│   │   ├── config/                    (configuration reader and utilities)
│   │   ├── driver/                    (WebDriver & MobileDriver initialization)
│   │   │
│   │   ├── objects/
│   │   │   ├── web/                   (web element objects)
│   │   │   └── mobile/                (mobile element objects)
│   │   │
│   │   └── pages/
│   │       ├── web/                   (web page actions/business methods)
│   │       └── mobile/                (mobile page actions/business methods)
│   │
│   └── test/
│       │
│       ├── java/bibit/framework/tests/
│       │   │
│       │   ├── hooks/                 (Cucumber hooks and test lifecycle)
│       │   ├── runners/               (test runners)
│       │   └── steps/                 (BDD step definitions)
│       │       ├── api/
│       │       ├── web/
│       │       └── mobile/
│       │
│       └── resources/
│           │
│           ├── apk/                   (Android application package)
│           ├── config/
│           │   └── qa.properties
│           │
│           └── features/
│               ├── api/
│               ├── web/
│               └── mobile/
│
├── pom.xml
└── README.md
```

---

# Framework Architecture

## Web & Mobile Automation

```text
Feature File
      │
      ▼
Step Definition
      │
      ▼
Page
      │
      ▼
Object
      │
      ▼
Application
```

## API Automation

```text
Feature File
      │
      ▼
Step Definition
      │
      ▼
Service Layer
      │
      ▼
Request / Response POJO
      │
      ▼
API Endpoint
```

## Reporting Flow

```text
Test Execution
      │
      ▼
Allure Results
      │
      ▼
Allure Report
```

---

# Test Execution Strategy

The framework uses dedicated Cucumber runners to execute test suites.

| Runner        | Test Scope        |
| ------------- | ----------------- |
| RunApiTest    | API Automation    |
| RunUiTest     | Web Automation    |
| RunMobileTest | Mobile Automation |

This approach provides clear separation between automation layers and simplifies execution in local environments and CI/CD pipelines.

---

# Generate Allure Report

## Execute Test

```bash
mvn clean test
```

## Generate and Open Report

```bash
allure serve allure-results
```

This command will:

* Generate report
* Start local server
* Open report automatically in browser

## Generate Static Report

```bash
allure generate allure-results --clean -o allure-report
```

Open report manually:

```bash
open allure-report/index.html
```

---

# Screenshot Handling

The framework automatically:
* Captures screenshots on failures
* Attaches screenshots to Allure Report

---

# Supported Automation Scope

## API Automation

* GET
* POST
* PUT
* PATCH
* DELETE

### Features

* Request POJO
* Response POJO
* Service Layer
* CRUD Validation
* Assertions
* Allure Request/Response Attachment

---

## Web Automation

* Selenium WebDriver
* Page Object Model (POM)
* Explicit Wait
* Screenshot Evidence
* Allure Integration

### Features

* Hooks
* Reusable Components
* Screenshot Capture
* Cucumber BDD

---

## Mobile Automation

* Android
* Appium
* UiAutomator2
* Appium Inspector
* Dynamic Locator
* Page Object Model (POM)
* Screenshot Evidence
* Allure Integration

### Features

* Android Emulator Support
* Accessibility ID Strategy
* Dynamic Locator Support
* Screenshot Capture
* Cucumber BDD

---

# Author

**Erik Enrico Chiesa**
QA Automation Engineer
