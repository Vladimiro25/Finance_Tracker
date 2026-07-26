package com.uzunguc.financetracker

import android.app.Application
import com.uzunguc.financetracker.di.AppComponent
import com.uzunguc.financetracker.di.DaggerAppComponent
import com.uzunguc.financetracker.di.DatabaseModule

class FinanceTrackerApp : Application() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().databaseModule(DatabaseModule(this)).build()
    }
}