import com.android.build.api.dsl.CommonExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import utils.libs

class AndroidComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("org.jetbrains.kotlin.plugin.compose")
            pluginManager.withPlugin("com.android.application") {
                extensions.configure<BaseAppModuleExtension> {
                    configureCompose(this)
                }
            }

            pluginManager.withPlugin("com.android.library") {
                extensions.configure<LibraryExtension> {
                    configureCompose(this)
                }
            }

            dependencies {
                val bom = libs.findLibrary("androidx-compose-bom").get()
                add("implementation", platform(bom))
                add("androidTestImplementation", platform(bom))

                // Add compose dependencies
                add("implementation", libs.findLibrary("androidx.activity.compose").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.runtime").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.viewmodel").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.compose").get())

                add("debugImplementation", libs.findLibrary("androidx.compose.ui.tooling").get())
                add("androidTestImplementation", libs.findLibrary("androidx.compose.ui.test").get())
                add(
                    "debugImplementation",
                    libs.findLibrary("androidx.compose.ui.test.manifest").get()
                )

                // Add compose bundle
                libs.findBundle("compose").get().get().forEach { dependency ->
                    add("implementation", dependency)
                }
            }
        }
    }

    private fun Project.configureCompose(
        commonExtension: CommonExtension<*, *, *, *, *, *>
    ) {
        commonExtension.apply {
            buildFeatures {
                compose = true
            }
            // With Kotlin 2.0+, composeOptions are no longer needed
            // The Kotlin Compose Compiler plugin handles the compiler settings
        }
    }
}