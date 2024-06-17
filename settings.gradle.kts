pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()

        maven {url = uri("https://maven.testfairy.com")}
        maven {url = uri("https://example.com/maven")}
    }
}

rootProject.name = "Captone_Coffee_Talk"
include(":app")
 