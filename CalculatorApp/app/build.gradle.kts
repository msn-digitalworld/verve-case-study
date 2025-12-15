plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.verve.calculator"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.verve.calculator"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

configurations {
    // Exclude transitive OMID dependency from HyBid SDK that tries to resolve from inaccessible PubNative repo
    all {
        exclude(group = "com.iab.omid.library", module = "pubnativenet")
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    
    // HyBid SDK - Commented out due to OMID dependency requirement
    // The SDK requires OMID at runtime which causes crashes
    // Using placeholder ads instead to demonstrate integration structure
    // implementation(files("libs/hybid-sdk.aar"))
    
    // Note: Placeholder ads are implemented in AdManager.kt
    // This demonstrates the integration architecture without requiring SDK dependencies
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}