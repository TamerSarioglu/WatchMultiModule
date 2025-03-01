plugins {
    id("movieapp.android.library")
    id("movieapp.android.compose")
}

android {
    namespace = "com.movieapp.core.ui"
}

dependencies {
    api(project(":core:common"))
    
    implementation(libs.androidx.core.ktx)
    implementation(libs.coil.compose)
    
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso)
} 