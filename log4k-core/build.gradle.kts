/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * MIT License
 *
 * Copyright (c) 2019 Jun Kurihara
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    // Apply the Kotlin JVM plugin to add support for Kotlin on the JVM.
    id(Dependencies.Kotlin.libraryPlugin) version Dependencies.Kotlin.version
    jacoco
    id(Dependencies.Dokka.plugin) version Dependencies.Dokka.version
    id(Dependencies.Kotlin.KtLint.id) version Dependencies.Kotlin.KtLint.version
}

dependencies {
    // Use the Kotlin JDK 8 standard library.
    implementation(Dependencies.Kotlin.stdLib)

    // Use the Kotlin test library.
    testImplementation(Dependencies.Kotlin.kotlinTest)

    // Use the Kotlin JUnit integration.
    testImplementation(Dependencies.Kotlin.kotlinJunit)
}

jacoco {
    toolVersion = "0.8.3"
    reportsDir = file("$buildDir/jacocoReport")
}

val jacoco = tasks.jacocoTestReport {
    reports {
        @Suppress("UnstableApiUsage")
        xml.isEnabled = false
        @Suppress("UnstableApiUsage")
        csv.isEnabled = false
        @Suppress("UnstableApiUsage")
        html.isEnabled = true
        @Suppress("UnstableApiUsage")
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