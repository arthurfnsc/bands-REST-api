[![Build Status](https://travis-ci.org/arthurfnsc/bands-REST-api.svg?branch=master)](https://travis-ci.org/arthurfnsc/bands-REST-api)
[![CodeCov](https://codecov.io/gh/arthurfnsc/bands-REST-api/branch/master/graph/badge.svg)](https://codecov.io/gh/arthurfnsc/bands-REST-api)
[![CII Best Practices](https://bestpractices.coreinfrastructure.org/projects/2795/badge)](https://bestpractices.coreinfrastructure.org/projects/2795)
[![Gradle Status](https://gradleupdate.appspot.com/arthurfnsc/bands-REST-api/status.svg)](https://gradleupdate.appspot.com/arthurfnsc/bands-REST-api/status)

# Bands-REST-API

OpenAPI 3.0 API First, Spring Boot, Kotlin and Gradle project

## Project execution

### Clone
```sh
$ git clone https://<username>@bitbucket.org/arthurfnsc/bands-REST-api.git
$ cd bands-REST-api
```

### Linux | Windows execution
```sh
$ [./gradlew | gradlew.bat] clean bootRun
```

## Code Quality
### Code Quality Check
```sh
$ [./gradlew | gradlew.bat] clean check
```

## Reports
### Dependency Updates
```sh
$ [./gradlew | gradlew.bat] dependencyUpdates
```

### Dokka
```sh
$ [./gradlew | gradlew.bat] dokka
```

### Project Report
```sh
$ [./gradlew | gradlew.bat] projectReport
```

## Security
### OWASP
```sh
$ [./gradlew | gradlew.bat] dependencyCheckAnalyze
```

##Reports struct
```
bands-REST-api
+-- build
|   +-- project
|   +-- reports
|   |   +-- detekt
|   |   +-- docs
|   |   |   +-- dependencyUpdates
|   |   |   +-- dokka
|   |   +-- jacoco
|   |   +-- ktlint
|   |   +-- tests
```
## Architecture
* [Gradle](https://gradle.org/)
* [Kotlin](https://kotlinlang.org/)
* [Mapstruct](http://mapstruct.org/)
* [Spring Boot 2.1](https://projects.spring.io/spring-boot/)
* [Spring Boot AOP]()
* [Spring Boot Cache]()
* [Spring Boot Devtools](https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-devtools.html)
* [Spring Boot Web]()
* [Swagger Code Generator](https://github.com/int128/gradle-swagger-generator-plugin)

## Documentation
* [Dokka](https://github.com/Kotlin/dokka)
* [OpenAPI 3.0](https://github.com/OAI/OpenAPI-Specification)
* [Project Report](https://docs.gradle.org/current/userguide/project_report_plugin.html)
* [Swagger](https://swagger.io/)
* [Versions](https://github.com/ben-manes/gradle-versions-plugin)

## Code Quality
* [Detekt](https://github.com/arturbosch/detekt)
* [JaCoCo](https://www.eclemma.org/jacoco/)
* [KtLint](https://github.com/JLLeitschuh/ktlint-gradle)
* [Kotlinter](https://github.com/jeremymailen/kotlinter-gradle)
* [SonarQube](https://www.sonarqube.org/)

## Monitoring
* [Spring Boot Actuator](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-project/spring-boot-actuator)
* [Spring Boot Admin](https://github.com/codecentric/spring-boot-admin)
* [Spring Boot Annotation Processor]()

## Security
* [OSS Index](https://github.com/OSSIndex/ossindex-gradle-plugin/)
* [OWASP](https://jeremylong.github.io/DependencyCheck/dependency-check-gradle/index.html)

## Tests Architecture
* [Hamcrest](http://hamcrest.org/)
* [JUnit](https://junit.org)
* [Mockito](http://site.mockito.org/)
* [Rest Assured](http://rest-assured.io/)
* [Spring Test]()

## Integration Tests

* [Postman](https://www.getpostman.com/)
