# Selenium Grid ile Paralel Web Testleri ve Jenkins ile Entegrasyon

"Software Testing Bootcamp" is a community of people interested in software testing. We record the weekly webinars that we organize and publish them on Youtube. For more information -> https://testingbootcamp.com/

**Youtube Webinar Video:**

https://youtu.be/uHMUfM2Z1kc

![image](https://user-images.githubusercontent.com/89974862/137537135-9bc84d3a-09bc-4767-bbe1-21bd2f3d9b27.png)

------------

**Getting Started:**

This document will help you to run the following types of parallel tests with Java TestNG.

  - Single Thread TestSuite with Java Classes
  - Parallel Thread TestSuite with Java Classes
  - Parallel Cross Browser Testing

Also will help you to run different type Selenium Grid configurations inside the automation project

  - Selenium Grid Standalone
  - Selenium Grid Hub-node
  - Selenium Grid Docker Standalone
  - Selenium Grid Docker Hub-node
  - Bonigarcia WebDriverManager
  - ChromeDriver
  - GeckoDriver
  - Headless test run option

----------

**Requirements:**

   * Install Java JDK8 https://www.oracle.com/tr/java/technologies/javase/javase8-archive-downloads.html 

   * Install IntelliJ IDEA https://www.jetbrains.com/idea/download/

   * Install Docker for MacOs / Windows https://www.docker.com/products/docker-desktop

   * Download ChromeDriver, GeckoDriver and Selenium Grid JAR file https://www.selenium.dev/downloads/

---------

**Selenium Grid Configuration Types:**

Open a terminal window for standalone mode and keep it open. Hub and Node requires 2 terminal windows. 
Docker commands does not require to keep terminal windows.

* STANDALONE

      cd YOUR-PROJECT-FOLDER/src/test/resources/grid 
      java -jar selenium-server-4.0.0-rc-3.jar standalone



* HUB-NODE

      cd YOUR-PROJECT-FOLDER/src/test/resources/grid 
      java -jar selenium-server-4.0.0-rc-3.jar hub

      cd src/test/resources/grid 
      java -jar selenium-server-4.0.0-rc-3.jar node --detect-drivers true --max-sessions 20 --override-max-sessions true


* STANDALONE (DOCKER)

      docker run -d -p 4444:4444 -p 7900:7900 --shm-size="2g" selenium/standalone-firefox:4.0.0-rc-3-20211010

* HUB-NODE (DOCKER)

Hub (Docker)

      docker run -d -p 4442-4444:4442-4444 --name selenium-hub selenium/hub:4.0.0-rc-3-20211010

Node (Docker)

      docker run -d -p 5555:5555 \
              --shm-size="2g" \
              -e SE_EVENT_BUS_HOST=YOUR_IP_ADDRESS \
              -e SE_EVENT_BUS_PUBLISH_PORT=4442 \
              -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 \
              -e SE_NODE_HOST=YOUR_IP_ADDRESS \
              selenium/node-firefox:4.0.0-rc-3-20211010

Node (Standalone Mac - Optional)

      cd YOUR-PROJECT-FOLDER/src/test/resources/grid 
      java -jar selenium-server-4.0.0-rc-3.jar node --detect-drivers true --max-sessions 20 --override-max-sessions true --port 5554


----------

**How to set Driver files globally?**

For MacOS, copy the ChromeDriver or GeckoDriver to the "/usr/bin/local" folder and right click to them and choose open to skip access permission only once.

For Windows OS, Create a folder on your system as "C:\SeleniumDrivers". Copy the ChromeDriver or GeckoDriver to this new folder and add this folder to your PATH environment variable.

"--detect-drivers true" parameter will detect the all drivers automatically on your computer. It's not a requirement for docker.

----------

**How to run TestNG XML test suite from terminal and Jenkins CI ?**

Run the following command on your terminal. If mvn is not recognised on your OS, you have to install it from here https://maven.apache.org/download.cgi

    mvn clean test -Dsurefire.suiteXmlFiles=src/test/java/suites/ParallelTestWithBrowsers.xml


**Helpful Docs:**

https://mvnrepository.com/

https://www.selenium.dev/downloads/

https://www.selenium.dev/documentation/grid/

https://bonigarcia.dev/webdrivermanager/

https://testng.org/doc/

https://github.com/SeleniumHQ/docker-selenium

https://www.jenkins.io/

