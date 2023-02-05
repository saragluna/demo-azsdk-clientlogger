This project is to demo the native build issue when using Azure Core together with other SLF4J implementation. 

## Reproduce
There are two branches: the `master` and the `non-spring` branch. 

### Reproduce the issue in a Spring Boot application
Because the `spring-boot-starter` has a bundled `logback` implementation, so when used in a Spring Boot application will bring issues. 

Check out the `master` branch, and run:

```shell
./gradlew clean nativeCompile
```

The error will be like:

```console
Error: Classes that should be initialized at run time got initialized during image building:
 ch.qos.logback.classic.Logger was unintentionally initialized at build time. com.azure.core.util.Configuration caused initialization of this class with the following trace: 
        at ch.qos.logback.classic.Logger.<clinit>(Logger.java:47)
        at ch.qos.logback.classic.LoggerContext.<init>(LoggerContext.java:81)
        at ch.qos.logback.classic.spi.LogbackServiceProvider.initialize(LogbackServiceProvider.java:39)
        at org.slf4j.LoggerFactory.bind(LoggerFactory.java:167)
        at org.slf4j.LoggerFactory.performInitialization(LoggerFactory.java:154)
        at org.slf4j.LoggerFactory.getProvider(LoggerFactory.java:437)
        at org.slf4j.LoggerFactory.getILoggerFactory(LoggerFactory.java:423)
        at org.slf4j.LoggerFactory.getLogger(LoggerFactory.java:372)
        at com.azure.core.util.logging.ClientLogger.<init>(ClientLogger.java:101)
        at com.azure.core.util.logging.ClientLogger.<init>(ClientLogger.java:67)
        at com.azure.core.util.logging.ClientLogger.<init>(ClientLogger.java:57)
        at com.azure.core.util.Configuration.<clinit>(Configuration.java:227)
```

### Reproduce in a non-spring application

The Java application needs to import another SLF4J implementation. In the branch, `logback-classic` is added to the dependency. 

Run the following command to build:

```shell
./gradlew clean nativeCompile
```

It will ran into the same error. 

