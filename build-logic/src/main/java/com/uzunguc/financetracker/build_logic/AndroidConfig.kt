import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion

object AndroidConfig {
    const val compileSdk = 36
    const val minSdk = 28
    val javaVersion = JavaVersion.VERSION_11
    const val jvmTarget = "11"
}

fun CommonExtension<*, *, *, *, *, *>.configureDefaultAndroid() {
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = AndroidConfig.javaVersion
        targetCompatibility = AndroidConfig.javaVersion
    }
}