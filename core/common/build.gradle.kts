plugins {
    id("movieapp.android.library")
}

android {
    namespace = "com.movieapp.core.common"
}

dependencies {
    implementation(libs.androidx.core.ktx)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso)
}