package com.uzunguc.financetracker.di

import androidx.lifecycle.ViewModel
import com.uzunguc.financetracker.ui.AddTransactionViewModel
import com.uzunguc.financetracker.ui.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddTransactionViewModel::class)
    abstract fun bindAddTransactionViewModel(addTransactionViewModel: AddTransactionViewModel): ViewModel
}