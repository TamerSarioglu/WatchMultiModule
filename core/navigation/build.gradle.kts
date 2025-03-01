plugins {
    id("movieapp.android.library")
    id("com.google.devtools.ksp")
    id("movieapp.android.compose")
}

android {
    namespace = "com.movieapp.core.navigation"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.hilt.navigation.compose)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    
    // Compose dependencies
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.compose)  // This includes ui, graphics, tooling-preview, and material3
    debugImplementation(libs.androidx.compose.ui.tooling)
} 