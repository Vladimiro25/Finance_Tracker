package com.uzunguc.financetracker.di

import android.content.Context
import androidx.room.Room
import com.uzunguc.financetracker.data.AppDatabase
import com.uzunguc.financetracker.data.dao.CategoryDao
import com.uzunguc.financetracker.data.dao.OperationDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideAppDatabase(): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "db").build()
    }

    @Provides
    fun provideOperationDao(appDatabase: AppDatabase): OperationDao {
        return appDatabase.operationDao()
    }

    @Provides
    fun provideCategoryDao(appDatabase: AppDatabase): CategoryDao {
        return appDatabase.categoryDao()
    }
}