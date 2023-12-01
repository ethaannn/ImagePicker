plugins {
    id("com.android.library")
    alias(libs.plugins.org.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("maven-publish")
}
android {
    namespace = libs.versions.packageName.get()
    compileSdk = libs.versions.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))
    implementation(libs.androidx.multidex)
    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.material)
}


afterEvaluate {
    publishing{
        publications {
            create<MavenPublication>("release") {
                groupId = "com.github.ethaannn"
                artifactId = "ImagePicker"
                version = "1.0.0"
                from(components["release"])
            }

        }
    }
}