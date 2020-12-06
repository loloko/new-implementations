package com.fernando.myprojects.di


import com.fernando.myprojects.di.auth.AuthModule
import com.fernando.myprojects.di.auth.AuthScope
import com.fernando.myprojects.di.auth.AuthViewModelModule
import com.fernando.myprojects.di.main.MainModule
import com.fernando.myprojects.di.main.MainScope
import com.fernando.myprojects.di.main.MainViewModelModule
import com.fernando.myprojects.ui.auth.LoginFragment
import com.fernando.myprojects.ui.auth.RegisterFragment
import com.fernando.myprojects.ui.auth.ResetPasswordFragment
import com.fernando.myprojects.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    // AUTH
    @AuthScope
    @ContributesAndroidInjector(modules = [AuthViewModelModule::class, AuthModule::class])
    abstract fun contributeLoginFragment(): LoginFragment

    @AuthScope
    @ContributesAndroidInjector(modules = [AuthViewModelModule::class, AuthModule::class])
    abstract fun contributeResetPasswordFragment(): ResetPasswordFragment

    @AuthScope
    @ContributesAndroidInjector(modules = [AuthViewModelModule::class, AuthModule::class])
    abstract fun contributeRegisterFragment(): RegisterFragment


    // MAIN
    @MainScope
    @ContributesAndroidInjector(modules = [MainViewModelModule::class, MainModule::class])
    abstract fun contributeMainFragment(): MainFragment
}