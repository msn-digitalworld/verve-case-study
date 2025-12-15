pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        // Note: PubNative repositories removed as they are not accessible
        // HyBid SDK is manually integrated via AAR file in app/libs/
        // Verve JFrog repository kept in case it becomes accessible
        maven {
            url = uri("https://verve.jfrog.io/artifactory/verve-gradle-release")
            // Allow failures for this repository since it may not be accessible
            isAllowInsecureProtocol = false
        }
    }
}

rootProject.name = "CalculatorApp"
include(":app")

