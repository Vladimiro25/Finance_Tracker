plugins {
    `kotlin-dsl`
}

group = "com.uzunguc.financetracker.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    compileOnly("com.android.tools.build:gradle:8.13.2")
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.21")
}

gradlePlugin {
    plugins {
        register("financeAndroidLibrary") {
            id = "finance.android.library"
            implementationClass = "FinanceAndroidLibraryConventionPlugin"
        }
        register("financeAndroidApplication") {
            id = "finance.android.application"
            implementationClass = "FinanceAndroidApplicationConventionPlugin"
        }
        register("financeAndroidCompose") {
            id = "finance.android.compose"
            implementationClass = "FinanceAndroidComposeConventionPlugin"
        }
    }
}