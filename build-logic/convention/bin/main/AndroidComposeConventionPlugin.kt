import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import utils.libs
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.android.build.api.dsl.BuildFeatures
import com.android.build.api.dsl.BuildType
import com.android.build.api.dsl.DefaultConfig
import com.android.build.api.dsl.ProductFlavor
import com.android.build.api.dsl.AndroidResources
import com.android.build.api.dsl.Installation

class AndroidComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            // Configure compose for either application or library
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
                add("debugImplementation", libs.findLibrary("androidx.compose.ui.test.manifest").get())

                // Add compose bundle
                libs.findBundle("compose").get().get().forEach { dependency ->
                    add("implementation", dependency)
                }
            }
        }
    }

    private fun Project.configureCompose(
        commonExtension: CommonExtension<*, *, *, *, *>
    ) {
        commonExtension.apply {
            buildFeatures {
                compose = true
            }

            composeOptions {
                kotlinCompilerExtensionVersion = libs.findVersion("compose.compiler").get().toString()
            }
        }
    }
} 