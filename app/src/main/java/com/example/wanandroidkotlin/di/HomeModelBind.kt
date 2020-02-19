package com.example.wanandroidkotlin.di

import androidx.lifecycle.ViewModel
import com.example.wanandroidkotlin.homes.viewmodel.HomeViewModel
import dagger.Binds
import dagger.Module

/**
 *  Created by hannah on 2020-01-21
 */
@Module
abstract class HomeModelBind {
    @Binds
    abstract fun bindViewModel(vm: HomeViewModel): ViewModel
}
