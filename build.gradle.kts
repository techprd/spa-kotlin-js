plugins {
    kotlin("js") version "1.4.31"
}

group = "com.techprd.webapp"
version = "1.4.31"

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
}

dependencies {
    testImplementation(kotlin("test-js"))
    implementation(kotlin("stdlib-js"))
    implementation("org.jetbrains.kotlinx:kotlinx-html:0.7.3")
    implementation("com.techprd.material:kotlin-material-js:1.4.31")
}

kotlin {
    js(LEGACY) {
        useCommonJs()
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
                devtool = "source-map"
            }
        }
        binaries.executable()
    }
}

// Temporary fix for browsers not supporting HTMLDialogElement
tasks.withType<org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile> {
    doLast {
        val content = outputFile.readText()
        outputFile.writer().buffered().use {
            it.write("if (typeof(HTMLDialogElement) == 'undefined') HTMLDialogElement = HTMLElement;\n")
            it.write(content)
        }
    }
}
