import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt.android)
    id("kotlin-parcelize")
}

android {
    namespace = "com.bonface.consumerapi"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlin {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    //Coroutines
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)
    //Dagger Hilt
    implementation(libs.dagger.hilt)
    ksp(libs.dagger.hilt.ksp)
    //Retrofit
    implementation(libs.retrofit)
    //OKHTTP
    implementation(libs.okhttp)
    //Logging Interceptor
    implementation(libs.logging.interceptor)
    //Moshi
    implementation(libs.moshi)
    ksp(libs.moshi.ksp)
    implementation(libs.moshi.converter)
    //Timber
    implementation(libs.timber)

    testImplementation(libs.junit)
    implementation(libs.junit.ktx)
    testImplementation(libs.mockk)
    testImplementation(libs.mockk.webserver)
    testImplementation(libs.truth)
    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.coroutines.test)
}
