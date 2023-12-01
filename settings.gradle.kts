@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        maven { url = uri(path = "https://www.jitpack.io") }
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven { url = uri(path = "https://www.jitpack.io") }
        google()
        mavenCentral()
    }
}

rootProject.name = "ImagePicker"
include(":app")
include(":library")
