package com.fernando.myprojects.di.main


import com.fernando.myprojects.adapter.MainAdapter
import dagger.Module
import dagger.Provides


@Module
class MainModule {

    @MainScope
    @Provides
    fun provideMainAdapter(): MainAdapter = MainAdapter()


}