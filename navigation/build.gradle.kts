plugins {
    id("movieapp.android.library")
    id("movieapp.android.hilt")
}

android {
    namespace = "com.movieapp.navigation"
}

dependencies {
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.hilt.navigation.compose)
} 