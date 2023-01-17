plugins {
    val kotlinVersion = "1.7.0"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    kotlin("plugin.allopen") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion

    id("org.springframework.boot") version "3.0.1"
    id("io.spring.dependency-management") version "1.1.0"
}


repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.7.0")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // postgresql
    implementation("org.postgresql:postgresql:42.5.1")
    implementation("org.hibernate.orm:hibernate-core:6.1.6.Final")
    implementation("org.hibernate.orm:hibernate-spatial:6.1.6.Final")

    runtimeOnly("org.jetbrains.kotlin:kotlin-reflect:1.3.71")
    testCompileOnly("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.assertj:assertj-core:3.12.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.3.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.3.2")
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
    annotation("javax.persistence.MappedSuperclass")
}

tasks.withType<Test> {
    useJUnitPlatform()
}