//plugins {
//    id("build.android.library")
//    id("build.android.library.compose")
//    id("build.android.library.jacoco")
//    id ("maven-publish")
//}
//
//
//android {
//    publishing {
//        singleVariant("release"){
//            withSourcesJar()
//        }
//    }
//    defaultConfig {
//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//    }
//    lint {
//        checkDependencies = true
//    }
//    namespace = "ac.uk.nottingham.studentapp.design"
//
//}
//dependencies {
//    implementation(libs.androidx.core.ktx)
//    implementation(libs.coil.kt.compose)
//    api(libs.androidx.compose.foundation)
//    api(libs.androidx.compose.foundation.layout)
//    implementation(libs.androidx.compose.material.iconsExtended)
//    api(libs.androidx.compose.material3)
//    debugApi(libs.androidx.compose.ui.tooling)
//    api(libs.androidx.compose.ui.tooling.preview)
//    api(libs.androidx.compose.ui.util)
//    api(libs.androidx.compose.runtime)
////    lintPublish(project(":lint"))
////    androidTestImplementation(project(":core:testing"))
//}
//afterEvaluate {
//    publishing {
//        publications {
//            //creates a meven publication called release
//            create<MavenPublication>("release") {
//                groupId = "ac.uk.nottingham.design"
//                artifactId = "design"
//                version = "1.0"
//
//
//                //applies the component fro the release build variant
//                from(components["release"])
//
//            }
//        }
//        //repositories to which gradle can publish artifacts for azure
////        repositories {
////            maven {
////                name= "Unikit_Android_Library"
////                url= uri("https://pkgs.dev.azure.com/UniversityOfNottingham/1b9c5117-4c85-41e1-bd05-90877ad18f1c/_packaging/Unikit_Android_Library/maven/v1")
////                credentials {
//////                basic(BasicAuthentication)
////                    username="UniversityOfNottingham"
////                    password="b2pjb6jl466mxmq6j653jkelcjwzwok6lao5mcwfrw2ato5pp5rq"
////
////                }
////            }
////        }
//    //for github private
////        repositories {
////            maven {
////                name= "GitHubPackages"
////                url = uri("https://maven.pkg.github.com/123nishan/android_design_lib")
////                credentials {
//////                basic(BasicAuthentication)
////                    username="123nishan"
////                    password="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"
////
////                }
////            }
////        }
//        //for github organisation
//        repositories {
//            maven {
//                name= "GitHubPackages"
//                url = uri("https://maven.pkg.github.com/UoNMobileDev/mobile_libs")
//                credentials {
////                basic(BasicAuthentication)
//                    username="UoNMobileDev"
//                    password="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"
//
//                }
//            }
//        }
//
//    }
//}


plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "ac.uk.nottingham.design.library"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures{
        compose=true
    }

    publishing {
        singleVariant("release"){
            withSourcesJar()
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("io.coil-kt:coil-compose:2.2.2")
    api("androidx.compose.foundation:foundation:1.4.0")
    api("androidx.compose.foundation:foundation-layout:1.4.0")
    implementation("androidx.compose.material3:material3:1.0.1")
    implementation("androidx.compose.material:material-icons-extended:1.4.0")
    debugApi("androidx.compose.ui:ui-tooling:1.4.0")
    api("androidx.compose.ui:ui-tooling-preview:1.4.0")
    api("androidx.compose.ui:ui-util:1.4.0")
    api("androidx.compose.runtime:runtime:1.4.0")











}

afterEvaluate {
    publishing {
        publications {
            //creates a meven publication called release
            create<MavenPublication>("release") {
                groupId = "ac.uk.nottingham.design"
                artifactId = "design"
                version = "1.0"


                //applies the component fro the release build variant
                from(components["release"])

            }
        }
        //repositories to which gradle can publish artifacts for azure
//        repositories {
//            maven {
//                name= "Unikit_Android_Library"
//                url= uri("https://pkgs.dev.azure.com/UniversityOfNottingham/1b9c5117-4c85-41e1-bd05-90877ad18f1c/_packaging/Unikit_Android_Library/maven/v1")
//                credentials {
////                basic(BasicAuthentication)
//                    username="UniversityOfNottingham"
//                    password="b2pjb6jl466mxmq6j653jkelcjwzwok6lao5mcwfrw2ato5pp5rq"
//
//                }
//            }
//        }
        //for github private
//        repositories {
//            maven {
//                name= "GitHubPackages"
//                url = uri("https://maven.pkg.github.com/123nishan/android_design_lib")
//                credentials {
////                basic(BasicAuthentication)
//                    username="123nishan"
//                    password="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"
//
//                }
//            }
//        }
        //for github organisation
        repositories {
            maven {
                name= "GitHubPackages"
                url = uri("https://maven.pkg.github.com/UoNMobileDev/mobile_libs")
                credentials {
//                basic(BasicAuthentication)
                    username="UoNMobileDev"
                    password="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"

                }
            }
        }

    }
}