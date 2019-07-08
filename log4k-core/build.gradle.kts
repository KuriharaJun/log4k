import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    // Apply the Kotlin JVM plugin to add support for Kotlin on the JVM.
    id("org.jetbrains.kotlin.jvm") version "1.3.41"
    jacoco
    id("org.jetbrains.dokka") version "0.9.18"
    id("org.jlleitschuh.gradle.ktlint") version "8.1.0"
}

buildscript {
    repositories {
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("org.jlleitschuh.gradle:ktlint-gradle:8.1.0")
    }
}

dependencies {
    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.3.41")

    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.3.41")

    // Use the Kotlin JUnit integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

jacoco {
    toolVersion = "0.8.3"
    reportsDir = file("$buildDir/jacocoReport")
}

val jacoco = tasks.jacocoTestReport {
    reports {
        xml.isEnabled = false
        csv.isEnabled = false
        html.isEnabled = true
        html.destination = file("$buildDir/jacocoHtml")
    }
}

val dokka by tasks.getting(DokkaTask::class) {
    moduleName = "log4k-core"
    outputFormat = "html"
    outputDirectory = "$buildDir/dokka"
    jdkVersion = 8
    reportUndocumented = true
    includeNonPublic = false
    skipDeprecated = false
    skipEmptyPackages = true
}