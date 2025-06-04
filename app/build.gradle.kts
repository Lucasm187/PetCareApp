plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("org.jetbrains.kotlin.kapt")
    alias(libs.plugins.google.gms)
}

android {
    namespace = "com.lucas.petcareapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.lucas.petcareapp"
        minSdk = 26
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true // Deixamos habilitado, mas não vamos usar por enquanto
    }
}

dependencies {
    // Firebase BoM
    implementation(platform(libs.firebase.bom))

    // Bibliotecas padrão + Compose
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // Testes
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // ROOM
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    kapt(libs.room.compiler)

    // Firebase Auth + Notificações
    implementation(libs.firebase.auth)
    implementation(libs.firebase.messaging)

    // Google Maps
    implementation(libs.maps)

    // WorkManager
    implementation(libs.work)

    // RecyclerView
    implementation(libs.recyclerview)

    // Coil (para imagens)
    implementation(libs.coil)

    // MPAndroidChart (gráficos – estrutura pronta)
    implementation(libs.mpchart)

    // MVVM (Lifecycle)
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.lifecycle.livedata)
}
