pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "WatchMultiModule"

// App module
include(":app")

// Core modules
include(":core:common")
include(":core:ui")
include(":core:network")
include(":core:data")
include(":core:domain")
include(":core:testing")

// Feature modules
include(":feature:home")
include(":feature:details")
include(":feature:search")
include(":feature:favorites")
