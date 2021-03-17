rootProject.name = "graal-templating"

include("templating")
include("spring-boot-starter")
include("examples:hello-world-js")
include("examples:hello-world-react")
include("examples:hello-world-ts")
include("examples:spring-boot")

pluginManagement {
    plugins {
        id("pl.allegro.tech.build.axion-release") version "1.12.1"
        id("org.springframework.boot") version "2.4.1"
        id("io.freefair.lombok") version "4.1.6"
        id("com.moowork.node") version "1.3.1"
        id("com.github.hierynomus.license-report") version "0.15.0"
        id("io.github.gradle-nexus.publish-plugin") version "1.0.0"
    }
}

