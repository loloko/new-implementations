package com.fernando.myprojects.di

import com.fernando.myprojects.di.main.MainScope
import com.fernando.myprojects.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @MainScope
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity


}