plugins {
    kotlin("jvm") version "2.1.21"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.14.4"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    jvmToolchain(21)
}

sourceSets {
    main {
        kotlin.setSrcDirs(listOf("Kotlin"))
    }
    test {
        kotlin.setSrcDirs(listOf("kotlin-test"))
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    compilerOptions {
        freeCompilerArgs.add("-Xjsr305=strict")
    }
}

tasks.test {
    useJUnitPlatform()
    maxHeapSize = "2g"
    testLogging {
        events("failed", "skipped")
        showStackTraces = true
    }
    addTestListener(object : TestListener {
        override fun beforeSuite(descriptor: TestDescriptor) {}
        override fun afterSuite(descriptor: TestDescriptor, result: TestResult) {
            if (descriptor.parent == null) {
                println(
                    "${result.resultType} (${result.testCount} tests, " +
                        "${result.successfulTestCount} successes, " +
                        "${result.failedTestCount} failures, " +
                        "${result.skippedTestCount} skipped)"
                )
            }
        }
        override fun beforeTest(descriptor: TestDescriptor) {}
        override fun afterTest(descriptor: TestDescriptor, result: TestResult) {}
    })
}