# SauceDemo Selenium TestNG POM Framework

This repository contains a minimal, extensible Selenium automation framework using Java, TestNG, and Page Object Model.

Run tests:

```bash
mvn test
```

To run in headless mode (CI):

```bash
mvn test -Dheadless=true
```

Configuration is loaded from `src/test/resources/config.properties` and can be overridden via system properties.

Files of interest:
- `src/main/java/com/example/pages` - Page Objects using `@FindBy` and `PageFactory`
- `src/test/java/com/example/base/BaseTest.java` - WebDriver setup/teardown
- `src/main/java/com/example/base/WebDriverFactory.java` - Chrome driver creation (headless support)
- `src/test/java/com/example/listeners/TestListener.java` - Captures screenshots on failure
- `src/test/resources/config.properties` - Base URL, browser, headless flag, implicit wait
