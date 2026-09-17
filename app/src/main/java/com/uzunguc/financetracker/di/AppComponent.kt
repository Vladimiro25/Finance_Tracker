package com.uzunguc.financetracker.di

import com.uzunguc.financetracker.data.dao.CategoryDao
import com.uzunguc.financetracker.data.dao.OperationDao
import com.uzunguc.financetracker.ui.TransactionDetailsViewModel
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [
    DatabaseModule::class,
    RepositoryModule::class,
    ViewModelModule::class
])
interface AppComponent {
    fun getOperationDao(): OperationDao

    fun getCategoryDao(): CategoryDao

    fun daggerViewModelFactory(): DaggerViewModelFactory

    fun transactionDetailsViewModelFactory(): TransactionDetailsViewModel.Factory
}