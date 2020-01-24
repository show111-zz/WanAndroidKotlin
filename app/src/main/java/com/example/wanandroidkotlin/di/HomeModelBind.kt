package com.example.wanandroidkotlin.di

import androidx.lifecycle.ViewModel
import com.example.wanandroidkotlin.homes.viewmodel.HomeVM
import dagger.Binds
import dagger.Module

/**
 *  Created by hannah on 2020-01-21
 */
@Module
abstract class HomeModelBind {
    @Binds
    abstract fun bindViewModel(vm: HomeVM): ViewModel
}
