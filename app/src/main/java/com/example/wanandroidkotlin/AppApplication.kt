package com.example.wanandroidkotlin

import android.app.Activity
import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject
import javax.inject.Singleton

/**
 *  Created by hannah on 2020-01-21
 */
class AppApplication : Application(), HasActivityInjector {

    companion object{
        lateinit var instance: Application
    }

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>


    override fun activityInjector(): AndroidInjector<Activity> = activityInjector


    override fun onCreate() {
        super.onCreate()

        instance = this

        DaggerMyAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }
}

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class
//        HomeModelBind::class
    ]
)
interface MyAppComponent: AndroidInjector<AppApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): MyAppComponent
    }

    override fun inject(application: AppApplication)
}
