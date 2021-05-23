plugins {
    kotlin("js") version "1.5.0"
}

group = "com.techprd.webapp"
version = "1.5.0"

repositories {
    mavenCentral()
    mavenLocal()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven") }
}

dependencies {
    testImplementation(kotlin("test-js"))
    implementation(kotlin("stdlib-js"))
    implementation("org.jetbrains.kotlinx:kotlinx-html:0.7.3")
    implementation("com.techprd.material:kotlin-material-js:1.5.0")
}

kotlin {
    js(LEGACY) {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
                devtool = "source-map"
            }
        }
    }
}

// fix for Safari browser
tasks.withType<org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile> {
    doLast {
        val content = outputFile.readText()
        outputFile.writer().buffered().use {
            it.write("if (typeof(HTMLDialogElement) == 'undefined') HTMLDialogElement = {};\n")
            it.write(content)
        }
    }
}
