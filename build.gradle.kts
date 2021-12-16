plugins {
    kotlin("jvm") version "1.6.10"
}

group = "net.azisaba"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("dev.kord:kord-core:0.8.0-M8")
    implementation("org.slf4j:slf4j-simple:1.8.0-beta4")
}
