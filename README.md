# Rest Assured API testing with Java and TestNG runner
[![Build Status](https://travis-ci.com/johncena123456/Rest-Assured-Java-Framework.svg?branch=master)](https://travis-ci.com/johncena123456/Rest-Assured-Java-Framework)

![Java CI with Maven](https://github.com/johncena123456/Rest-Assured-Java-Framework/workflows/Java%20CI%20with%20Maven/badge.svg)

This is a Rest Assured testing framework using Java, testNG, POJO, concepts

## Installation
Just do a maven install (usually IDE take care of dowloading dependancies when you import eg: Eclipse)

```bash
mvn install 
mvn test
```

## Project Structure
```
API_Framework
	src.main.java
		api `To have all End Points `
		pojo `To have easy access to properties or fields, and methods that you can use to access and modify the values `
        utils `T0 have supporting scripts for reports, reading property file`
    src.test.java
        Test cases
```
