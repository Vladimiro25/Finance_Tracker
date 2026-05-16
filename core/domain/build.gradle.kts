plugins {
    id("finance.android.library")
}

android {
    namespace = "com.uzunguc.financetracker.core.domain"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}