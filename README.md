[![Maintenance](https://img.shields.io/badge/Maintained%3F-yes-green.svg)](https://GitHub.com/arthurfnsc/bands-REST-api.js/graphs/commit-activity)

## Activity
![GitHub commit activity](https://img.shields.io/github/commit-activity/m/arthurfnsc/bands-REST-api.svg?style=popout)
[![HitCount](http://hits.dwyl.io/arthurfnsc/bands-REST-api.svg)](http://hits.dwyl.io/arthurfnsc/bands-REST-api)
![GitHub last commit](https://img.shields.io/github/last-commit/arthurfnsc/bands-REST-api.svg?style=popout)

### Activity Master
![GitHub last commit (branch)](https://img.shields.io/github/last-commit/arthurfnsc/bands-REST-api/master.svg)

### Activity Develop
![GitHub last commit (branch)](https://img.shields.io/github/last-commit/arthurfnsc/bands-REST-api/develop.svg)

## Quality
[![Build Status](https://travis-ci.org/arthurfnsc/bands-REST-api.svg?branch=master)](https://travis-ci.org/arthurfnsc/bands-REST-api)
[![Build Status](https://scrutinizer-ci.com/g/arthurfnsc/bands-REST-api/badges/build.png?b=master)](https://scrutinizer-ci.com/g/arthurfnsc/bands-REST-api/build-status/master)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/cdd4a6584d664e5bb7f08ce7cb53acc9)](https://app.codacy.com/app/arthurfnsc/bands-REST-api?utm_source=github.com&utm_medium=referral&utm_content=arthurfnsc/bands-REST-api&utm_campaign=Badge_Grade_Dashboard)
[![codebeat badge](https://codebeat.co/badges/04c42974-9328-493e-8726-dc62cd3e97d4)](https://codebeat.co/projects/github-com-arthurfnsc-bands-rest-api-develop)
[![CodeCov](https://codecov.io/gh/arthurfnsc/bands-REST-api/branch/master/graph/badge.svg)](https://codecov.io/gh/arthurfnsc/bands-REST-api)
[![Coverage Status](https://coveralls.io/repos/github/arthurfnsc/bands-REST-api/badge.svg?branch=master)](https://coveralls.io/github/arthurfnsc/bands-REST-api?branch=master)
![Coverity Scan](https://img.shields.io/coverity/scan/18345.svg)
[![CII Best Practices](https://bestpractices.coreinfrastructure.org/projects/2795/badge)](https://bestpractices.coreinfrastructure.org/projects/2795)
[![Maintainability](https://api.codeclimate.com/v1/badges/9da475d2a2181f956573/maintainability)](https://codeclimate.com/github/arthurfnsc/bands-REST-api/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/9da475d2a2181f956573/test_coverage)](https://codeclimate.com/github/arthurfnsc/bands-REST-api/test_coverage)
[![Scrutinizer Code Quality](https://scrutinizer-ci.com/g/arthurfnsc/bands-REST-api/badges/quality-score.png?b=master)](https://scrutinizer-ci.com/g/arthurfnsc/bands-REST-api/?branch=master)

### Issues
![GitHub issues](https://img.shields.io/github/issues/arthurfnsc/bands-REST-api.svg)
![GitHub closed issues](https://img.shields.io/github/issues-closed/arthurfnsc/bands-REST-api.svg)
[![Average time to resolve an issue](http://isitmaintained.com/badge/resolution/arthurfnsc/bands-REST-api.svg)](http://isitmaintained.com/project/arthurfnsc/bands-REST-api "Average time to resolve an issue")
[![Percentage of issues still open](http://isitmaintained.com/badge/open/arthurfnsc/bands-REST-api.svg)](http://isitmaintained.com/project/arthurfnsc/bands-REST-api "Percentage of issues still open")
![GitHub pull requests](https://img.shields.io/github/issues-pr/arthurfnsc/bands-REST-api.svg)
![GitHub closed pull requests](https://img.shields.io/github/issues-pr-closed/arthurfnsc/bands-REST-api.svg)

## Security
[![Known Vulnerabilities](https://snyk.io/test/github/arthurfnsc/bands-REST-api/badge.svg?targetFile=build.gradle)](https://snyk.io/test/github/arthurfnsc/bands-REST-api?targetFile=build.gradle)

# Bands-REST-API

[OpenAPI 3.0](https://github.com/OAI/OpenAPI-Specification) API First, Spring Boot, Kotlin and [![Gradle Status](https://gradleupdate.appspot.com/arthurfnsc/bands-REST-api/status.svg)](https://gradleupdate.appspot.com/arthurfnsc/bands-REST-api/status) project

## Project execution

### Clone
```console
foo@bar:~$ https://github.com/arthurfnsc/bands-REST-api.git
foo@bar:~$ cd bands-REST-api
```

### Linux | Windows execution
```console
foo@bar:~$ [./gradlew | gradlew.bat] clean bootRun
```

## Code Quality 
### [Detekt](https://github.com/arturbosch/detekt)
### [JaCoCo](https://www.eclemma.org/jacoco/)
### [KtLint](https://github.com/JLLeitschuh/ktlint-gradle)
### [Kotlinter](https://github.com/jeremymailen/kotlinter-gradle)
### [SonarQube](https://www.sonarqube.org/)
```console
foo@bar:~$ [./gradlew | gradlew.bat] clean check
```

## Reports
### [Versions](https://github.com/ben-manes/gradle-versions-plugin)
```console
foo@bar:~$ [./gradlew | gradlew.bat] dependencyUpdates
```

### [Dokka](https://github.com/Kotlin/dokka)
```console
foo@bar:~$ [./gradlew | gradlew.bat] dokka
```

### [Project Report](https://docs.gradle.org/current/userguide/project_report_plugin.html)
```console
foo@bar:~$ [./gradlew | gradlew.bat] projectReport
```

## Security
### [OSS Index](https://github.com/OSSIndex/ossindex-gradle-plugin/)
```console
foo@bar:~$ [./gradlew | gradlew.bat] audit
```

### [OWASP](https://jeremylong.github.io/DependencyCheck/dependency-check-gradle/index.html)
```console
foo@bar:~$ [./gradlew | gradlew.bat] dependencyCheckAnalyze
```

##Reports struct
```bash
bands-REST-api
└── build
    ├── project
    └── reports
        ├── detekt
        └── docs
            ├── dependencyUpdates
            └── dokka
        ├── jacoco
        ├── ktlint
        └── tests
```

## Architecture
*   [Gradle](https://gradle.org/)
*   [Kotlin](https://kotlinlang.org/)
*   [Mapstruct](http://mapstruct.org/)
*   [Spring Boot 2.1](https://projects.spring.io/spring-boot/)
*   [Spring Boot AOP]()
*   [Spring Boot Cache]()
*   [Spring Boot Devtools](https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-devtools.html)
*   [Spring Boot Web]()
*   [Swagger Code Generator](https://github.com/int128/gradle-swagger-generator-plugin)

## Monitoring
*   [Spring Boot Actuator](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-project/spring-boot-actuator)
*   [Spring Boot Admin](https://github.com/codecentric/spring-boot-admin)
*   [Spring Boot Annotation Processor]()

## Tests Architecture
*   [Hamcrest](http://hamcrest.org/)
*   [JUnit](https://junit.org)
*   [Mockito](http://site.mockito.org/)
*   [Rest Assured](http://rest-assured.io/)
*   [Spring Test]()

## Integration Tests
*   [Postman](https://www.getpostman.com/)
