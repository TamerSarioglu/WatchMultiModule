plugins {
    id("movieapp.android.library")
    id("movieapp.android.hilt")
}

android {
    namespace = "com.movieapp.core.domain"
}

dependencies {
    implementation(project(":core:repository"))
    implementation(project(":core:network"))
    
    implementation(libs.androidx.core.ktx)
    implementation(project(":core:data"))

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso)
} 