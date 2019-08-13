# ktor-gradle

A simple Kotlin application on a Ktor server built with Gradle that can
produce a self-contained "Fat" Jar file that includes all dependencies to
run the application. This is an example of how to create this kind of project.

This is set up to easily deploy to [AWS ElasticBeanstalk](https://aws.amazon.com/elasticbeanstalk/)
by setting the port to 5000, which is required by ElasticBeanstalk.

## Configure

To create fat jar, the [Gradle Shadow Plugin](https://imperceptiblethoughts.com/shadow/)
is required. The `buildscript` in `build.gradle` and the optional `shadowJar`
task (to override the default Shadow Plugin settings) are set up to create
a fat jar called `ktor-gradle.jar`.

### Jar file name

The `archiveFileName` property in the shadowJar task (which overrides the
default shadowJar task in the plugin) in `build.gradle` defines the name
of the .jar file that it produces, `ktor-gradle.jar`.

### Class entry point
The `mainClassName` property in `build.gradle` defines the class entry point
for the application, `la.sample.KotrGradleKt`. The Kotlin main entry class
(where `fun main()` is) file name is `KtorGradle.kt`. When it is compiled
to Java the Java class name becomes `KtorGradleKt`.

### Server port

The server port, 5000, is defined in the `embeddedServer(Netty, 8080)`
code in `KtorGradle.kt`.

## Generate Jar file

To build the `ktor-gradle.jar` file (in the `build/libs/` directory):

```
./gradlew assemble

or

./gradlew shadowJar
```

## Run the application

Start the server by running:

```
java -jar build/libs/ktor-gradle.jar
```

### See the running application in a browser

Navigate to localhost:8080 in a browser (port is defined in KtorGradle.kt) and you should see:

```
Greetings, Earthlings! Maven, Kotlin and Gradle salute you.
```

## Resources

For more on using the ShadowJar plugin to build fat jars see:

https://ktor.io/servers/deploy/packing/fatjar.html
https://imperceptiblethoughts.com/shadow/getting-started/#getting-started

For details on deploying a self-contained Jar file to AWS ElasticBeanstalk see:

https://aws.amazon.com/blogs/devops/deploying-a-spring-boot-application-on-aws-using-aws-elastic-beanstalk/
https://docs.aws.amazon.com/elastic-beanstalk/index.html
