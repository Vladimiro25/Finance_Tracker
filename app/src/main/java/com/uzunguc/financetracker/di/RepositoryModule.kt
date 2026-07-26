package com.uzunguc.financetracker.di

import com.uzunguc.financetracker.data.repository.CategoryRepositoryImpl
import com.uzunguc.financetracker.data.repository.OperationRepositoryImpl
import com.uzunguc.financetracker.domain.repository.CategoryRepository
import com.uzunguc.financetracker.domain.repository.OperationRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindsOperationRepository(impl: OperationRepositoryImpl): OperationRepository

    @Binds
    abstract fun bindsCategoryRepository(impl: CategoryRepositoryImpl): CategoryRepository
}