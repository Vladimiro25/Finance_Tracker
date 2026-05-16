pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Finance Tracker"
include(":app")
include(":core:designsystem")
include(":core:domain")
include(":core:data")
include(":feature:home")
include(":feature:analysis")
include(":feature:transactions")
include(":feature:categories")
include(":feature:profile")
include(":core:common")
