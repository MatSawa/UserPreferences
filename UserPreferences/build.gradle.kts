plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.library").version("7.4.1").apply(false)
    id("maven-publish")
    kotlin("multiplatform").version("1.8.0").apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}