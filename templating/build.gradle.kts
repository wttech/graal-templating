import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    `java-library`
    id("io.freefair.lombok")
    id("maven-publish")
    id("com.github.hierynomus.license-report")
    signing
}

group = rootProject.group
version = rootProject.version

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
}

java {
    withJavadocJar()
    withSourcesJar()
}

tasks.getByName<Javadoc>("javadoc") {
    if (JavaVersion.current().isJava9Compatible) {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }
}

publishing {
    publications {
        create<MavenPublication>("templating") {
            artifactId = "templating"

            from(components["java"])

            versionMapping {
                usage("java-api") {
                    fromResolutionOf("runtimeClasspath")
                }
                usage("java-runtime") {
                    fromResolutionResult()
                }
            }

            repositories {
                maven {
                    name = "mavenCentral"
                    val releasesRepoUrl = "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
                    val snapshotsRepoUrl = "https://s01.oss.sonatype.org/content/repositories/snapshots"
                    url = uri(if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl)
                    credentials(PasswordCredentials::class)
                }
            }

            pom {
                name.set("Graal templating engine")
                description.set("Rendering engine using GraalVM.")
                url.set("https://wttech.github.io/graal-templating")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("tokrug")
                        name.set("Tomasz Krug")
                        email.set("tomasz.krug@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/wttech/graal-templating.git")
                    url.set("https://github.com/wttech/graal-templating")
                }
            }
        }
    }
}

signing {
    val signingKey: String? by project
    val signingPassword: String? by project
    useInMemoryPgpKeys(signingKey, signingPassword)
    sign(publishing.publications["templating"])
}

val graalVersion = "20.3.0"
val reactorVersion = "3.4.2"
val reactorPoolVersion = "0.2.1"
val jacksonVersion = "2.12.0"
val slf4jVersion = "1.7.30"

dependencies {
    // GraalVM JS module
    implementation("org.graalvm.sdk:graal-sdk:${graalVersion}")
    // Reactor
    api("io.projectreactor:reactor-core:${reactorVersion}")
    // Reactor Pool
    implementation("io.projectreactor.addons:reactor-pool:${reactorPoolVersion}")
    // Jackson
    api("com.fasterxml.jackson.core:jackson-databind:${jacksonVersion}")
    // Logging
    implementation("org.slf4j:slf4j-api:${slf4jVersion}")

    // Junit 5
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.6.0")
    testImplementation("org.junit.platform:junit-platform-runner:1.6.0")
    // Reactor
    testImplementation("io.projectreactor:reactor-test:${reactorVersion}")
    // Assertion
    testImplementation("org.assertj:assertj-core:3.11.1")
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        showCauses = true
        showExceptions = true
        showStackTraces = true
        events = setOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.STANDARD_OUT, TestLogEvent.STANDARD_ERROR)
    }

}

tasks {
    downloadLicenses {
        includeProjectDependencies = true
        dependencyConfiguration = "runtimeClasspath"
    }
}
