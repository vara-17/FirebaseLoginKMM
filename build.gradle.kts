plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    kotlin("multiplatform").apply(false)
    id("com.android.application").apply(false)
    id("com.android.library").apply(false)
    id("org.jetbrains.compose").apply(false)
    id("com.google.gms.google-services").version("4.3.14").apply(false)
}

buildscript {
    dependencies {
        //classpath("dev.icerock.moko:resources-generator:0.23.0")
    }
}
