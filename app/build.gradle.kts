plugins {
    id("movieapp.android.application")
    id("movieapp.android.hilt")
    id("movieapp.android.compose")
}

android {
    namespace = "com.movieapp"

    defaultConfig {
        applicationId = "com.movieapp"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    // Feature modules
    implementation(project(":feature:home"))
    implementation(project(":feature:details"))
    implementation(project(":feature:search"))
    implementation(project(":feature:favorites"))

    // Core modules
    implementation(project(":core:ui"))
    implementation(project(":core:common"))
    implementation(project(":core:data"))
    implementation(project(":core:domain"))
    implementation(project(":core:navigation"))
}