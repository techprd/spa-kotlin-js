plugins {
    id("org.jetbrains.kotlin.js") version "1.3.71"
}

group = "com.techprd.webapp"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-js"))
    implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.6.11")
    implementation("com.techprd.material:kotlin-material:1.3.71")
}

kotlin {
    target {
        browser {}
    }
}
