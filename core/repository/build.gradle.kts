plugins {
    id("movieapp.android.library")
    id("movieapp.android.hilt")
}

android {
    namespace = "com.movieapp.core.repository"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:network"))
    
    // You might need these depending on your implementation
    implementation(libs.androidx.core.ktx)
    
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso)
} 