plugins {
    id("java")
    id("org.sonarqube") version "7.0.0.6105"
    checkstyle
    id("com.github.ben-manes.versions") version "0.52.0"
    application
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("hexlet.code.App")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("info.picocli:picocli:4.7.5")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.18.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.0")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}
checkstyle {
    toolVersion = "10.12.1" // например
    configFile = file("config/checkstyle/checkstyle.xml")
}
sonar {
    properties {
        property("sonar.projectKey", "phillharmonia_java-project-71")
        property("sonar.organization", "phillharmonia")
    }
}