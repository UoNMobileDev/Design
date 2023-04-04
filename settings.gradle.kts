import java.util.*
pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

//we first create a new Properties object, then we check if the local.properties file exists (assuming that it's located
//in the parent directory of the project directory), and if it does, we load its contents into the Properties object using the
//load() method. Finally, we can access the value of a property called myProperty using the getProperty() method.
val properties = Properties()
val localPropertiesFile = file("local.properties")
if (localPropertiesFile.exists()) {
    localPropertiesFile.inputStream().use { properties.load(it) }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://maven.pkg.github.com/UoNMobileDev/Design")
            credentials {

                username= properties.getProperty("GITHUB_USER")  ?: System.getenv("GITHUB_USER")
                password= properties.getProperty("GITHUB_TOKEN")  ?: System.getenv("GITHUB_TOKEN")

            }
        }
    }
}
rootProject.name = "Design"
include (":app")
include (":design")
