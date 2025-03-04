plugins {
    id("movieapp.android.library")
    id("movieapp.android.feature")
    id("movieapp.android.hilt")
}

android {
    namespace = "com.movieapp.feature.details"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.androidx.lifecycle.compose)
    implementation(project(":core:navigation"))
    implementation(project(":core:network"))
    
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso)
} 