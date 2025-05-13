# **SauceDemo Automation Test Project - Comprehensive Guide**  

This document provides a **step-by-step** guide to understanding, setting up, and running the **SauceDemo Automation Test Project** built with **Selenium WebDriver, TestNG, and Maven**.  

---

## **📌 Table of Contents**  
1. [**Project Overview**](#-project-overview)  
2. [**Prerequisites**](#-prerequisites)  
3. [**Project Structure**](#-project-structure)  
4. [**Key Features**](#-key-features)  
5. [**How to Set Up & Run Tests**](#-how-to-set-up--run-tests)  
6. [**Understanding the Code**](#-understanding-the-code)  
7. [**Test Execution Reports**](#-test-execution-reports)  
8. [**Troubleshooting**](#-troubleshooting)  
9. [**Best Practices**](#-best-practices)  
10. [**Future Improvements**](#-future-improvements)  

---

## **🚀 Project Overview**  
This project automates testing for the **[SauceDemo](https://www.saucedemo.com/)** website, covering:  
✅ **Login Functionality**  
✅ **Product Selection & Cart Management**  
✅ **Checkout Process**  

**Tech Stack:**  
- **Java** (Programming Language)  
- **Selenium WebDriver** (Browser Automation)  
- **TestNG** (Testing Framework)  
- **Maven** (Build & Dependency Management)  
- **Page Object Model (POM)** (Design Pattern)  

---

## **📋 Prerequisites**  
Before running the project, ensure you have:  

| Requirement | Installation Guide |  
|-------------|-------------------|  
| **Java JDK 11+** | [Download & Install](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) |  
| **Maven** | [Installation Guide](https://maven.apache.org/install.html) |  
| **Chrome/Firefox Browser** | Latest version |  
| **Git (Optional)** | [Git Installation](https://git-scm.com/downloads) |  

---

## **📂 Project Structure**  
The project follows a **well-organized** structure:  

```
sauce-demo-tests/
├── src/main/java/  
│   ├── config/            # Configuration files (URLs, credentials)
│   ├── enums/             # Browser types (Chrome, Firefox)
│   ├── factories/         # WebDriver initialization
│   ├── pages/             # Page classes (Login, Products, Cart, Checkout)
│   └── utils/             # Helper classes (Waits, Screenshots)
├── src/test/java/  
│   ├── base/              # BaseTest (Setup & Teardown)
│   └── tests/             # Test classes (Login, Products, Checkout)
├── test-data/             # Test data (JSON/CSV if needed)
├── testng.xml             # TestNG configuration
└── pom.xml                # Maven dependencies
```

---

## **✨ Key Features**  
✔ **Page Object Model (POM)** – Maintainable & reusable page classes  
✔ **WebDriver Factory** – Supports Chrome, Firefox, Edge  
✔ **Explicit Waits** – Avoids flaky tests  
✔ **Screenshot on Failure** – Debugging made easy  
✔ **TestNG Annotations** – Supports parallel execution  
✔ **Maven Build** – Easy dependency management  

---

## **⚙ How to Set Up & Run Tests**  

### **Step 1: Clone the Project**  
```bash
git clone https://github.com/yourusername/sauce-demo-tests.git
cd sauce-demo-tests
```

### **Step 2: Install Dependencies**  
```bash
mvn clean install
```

### **Step 3: Run Tests**  
**Option 1: Run all tests (via TestNG XML)**  
```bash
mvn test
```
**Option 2: Run a specific test class**  
```bash
mvn test -Dtest=LoginTests
```
**Option 3: Run in parallel (configured in `testng.xml`)**  
```xml
<suite name="Parallel Tests" parallel="classes" thread-count="3">
```

---

## **🔍 Understanding the Code**  

### **1. Config.java**  
- Contains **base URL, credentials, timeouts**.  
- Example:  
```java
public static final String BASE_URL = "https://www.saucedemo.com/";
public static final String USERNAME = "standard_user";
```

### **2. DriverFactory.java**  
- **Creates WebDriver instances** for different browsers.  
- Example:  
```java
WebDriver driver = DriverFactory.createDriver(Browser.CHROME);
```

### **3. Page Classes (POM)**  
- Each page (Login, Products, Cart) has its own class.  
- Example (LoginPage.java):  
```java
public class LoginPage {
    @FindBy(id = "user-name") WebElement usernameField;
    public void login(String username, String password) { ... }
}
```

### **4. BaseTest.java**  
- **Setup & Teardown** (Before/After Test)  
```java
@BeforeMethod
public void setup() {
    driver = DriverFactory.createDriver(Browser.CHROME);
    driver.get(Config.BASE_URL);
}
```

### **5. Test Classes**  
- **TestNG** annotations (`@Test`, `@BeforeMethod`).  
- Example (LoginTests.java):  
```java
@Test
public void testValidLogin() {
    new LoginPage(driver).login(Config.USERNAME, Config.PASSWORD);
    Assert.assertTrue(new ProductsPage(driver).isDisplayed());
}
```

---

## **📊 Test Execution Reports**  
After running tests:  
- **Console Logs** – Maven prints test results.  
- **Surefire Reports** – Located in `target/surefire-reports/`.  
- **Screenshots** – Saved in `target/screenshots/` on failure.  

---

## **⚠ Troubleshooting**  
| Issue | Solution |  
|-------|----------|  
| **Browser not launching** | Check WebDriverManager & browser version |  
| **Element not found** | Increase wait time in `WaitHelper.java` |  
| **Dependency errors** | Run `mvn clean install` |  

---

## **🏆 Best Practices**  
✔ **Use POM** for maintainability  
✔ **Avoid Thread.sleep()** – Use explicit waits  
✔ **Separate test data** (JSON/Excel)  
✔ **Run in parallel** for faster execution  

---

## **🔮 Future Improvements**  
- [ ] **Add API Testing** (RestAssured)  
- [ ] **Integrate Allure Reports**  
- [ ] **Dockerize for cross-browser testing**  
- [ ] **Data-Driven Testing (Excel/JSON)**  

---

## **🎯 Conclusion**  
This project demonstrates **Selenium WebDriver automation** with **Java, TestNG, and Maven**. It follows **best practices** and is **easy to extend**.  

🚀 **Happy Testing!** 🚀  

---

### **📌 Quick Commands Cheat Sheet**  
| Command | Description |  
|---------|-------------|  
| `mvn clean install` | Install dependencies |  
| `mvn test` | Run all tests |  
| `mvn test -Dtest=LoginTests` | Run specific test class |  

---

**🔗 Useful Links:**  
- [Selenium Docs](https://www.selenium.dev/documentation/)  
- [TestNG Docs](https://testng.org/doc/)  
- [Maven Guide](https://maven.apache.org/guides/)  

---

This **README.md** ensures **any new developer** can **quickly understand, set up, and run** the project. 🚀 Let me know if you need any modifications! 😊
