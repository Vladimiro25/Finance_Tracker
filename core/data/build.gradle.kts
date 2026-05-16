plugins {
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt.android)
    id("finance.android.library")
}

android {
    namespace = "com.uzunguc.financetracker.core.data"
}

dependencies {
    implementation(libs.androidx.core.ktx)

    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}