import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

android {
    namespace = "com.blitzsplit.login"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
}

dependencies {
    // Compose
    implementation(platform(libs.composeBom))
    implementation(libs.ui)
    implementation(libs.uiGraphics)
    implementation(libs.uiToolingPreview)
    implementation(libs.material3)
    debugImplementation(libs.uiTooling)
    debugImplementation(libs.uiTestManifest)

    // Navigation
    implementation("androidx.navigation:navigation-compose:2.7.6")

    // Hilt
    implementation(libs.daggerHilt)
    implementation(libs.daggerHiltAndCompose)
    kapt(libs.daggerHiltCompiler)

    // Firebase
    implementation(platform(libs.firebaseBom))
    implementation(libs.firebaseAnalytics)
    implementation(libs.firebaseServices)
    implementation(libs.firebaseAuth)
}

// Allow references to generate code
kapt {
    correctErrorTypes = true
}

hilt {
    enableAggregatingTask = true
}

