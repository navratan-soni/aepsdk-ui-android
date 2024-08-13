plugins {
    id("aep-library")
}

val mavenCoreVersion: String by project
val aepComposeUiModuleName: String by project
val aepComposeUiVersion: String by project
val aepComposeUiMavenRepoName: String by project
val aepComposeUiMavenRepoDescription: String by project

aepLibrary {
    namespace = "com.adobe.marketing.mobile.aepcomposeui"

    moduleName = aepComposeUiModuleName
    moduleVersion = aepComposeUiVersion
    enableSpotless = true
    enableCheckStyle = true
    enableDokkaDoc = true

    publishing {
        mavenRepoName = aepComposeUiMavenRepoName
        mavenRepoDescription = aepComposeUiMavenRepoDescription
        gitRepoName = "aepsdk-ui-android"
        addCoreDependency(mavenCoreVersion)
    }
}

dependencies {
    implementation("com.adobe.marketing.mobile:core:$mavenCoreVersion")
    implementation("androidx.compose.ui:ui-tooling:1.4.3")
    implementation ("com.adobe.marketing.mobile:messaging:3.1.0")
}


