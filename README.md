# Test automation framework for Everon 

This test automation framework used to develop automated test scripts for: https://evbox.com/en/ 
## Tech
* **TAF**
    * [Maven](https://maven.apache.org/)
    * [TestNG](https://testng.org/doc/)
    * [Selenium WebDriver](https://selenium.dev/projects/)
* **Reporting**
    * [Log4j2](https://logging.apache.org/log4j/2.x/)
    * [Allure](https://docs.qameta.io/allure/)
* **CI**
    * [Circle CI](https://circleci.com/)
    * [Docker-Selenium](https://github.com/SeleniumHQ/docker-selenium)

  
    
## Usage

* **Local:**
    * Set up configuration in `/src/main/resources/properties/local.yml`.
    * Run the following command from the `project` directory to build the service:
` mvn clean test allure:report -DprofileName=local -DbrowserName={chrome/firefox/ie/safari}`
    * Report generation: navigate to `project/target`, execute command:
`allure serve`.
* **Remote:**
    * After merge into 'master' branch test execution started automatically.
    * Results will be available here: 

`