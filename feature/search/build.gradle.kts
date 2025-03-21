plugins {
    id("movieapp.android.library")
    id("movieapp.android.feature")
    id("movieapp.android.hilt")
}

android {
    namespace = "com.movieapp.feature.search"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.androidx.lifecycle.compose)
    implementation(project(":core:navigation"))
    
    // Core modules
    implementation(project(":core:repository"))
    implementation(project(":core:network"))
    implementation(project(":core:domain"))
    implementation(project(":core:data"))
    implementation(project(":core:navigation"))
    implementation(project(":core:ui"))
    
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso)
} 