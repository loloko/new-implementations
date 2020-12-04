package com.fernando.myprojects.di


import com.fernando.myprojects.di.auth.AuthModule
import com.fernando.myprojects.di.auth.AuthViewModelModule
import com.fernando.myprojects.di.main.MainModule
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
    @ContributesAndroidInjector(modules = [AuthViewModelModule::class, AuthModule::class])
    abstract fun contributeLoginFragment(): LoginFragment

    @ContributesAndroidInjector(modules = [AuthViewModelModule::class, AuthModule::class])
    abstract fun contributeResetPasswordFragment(): ResetPasswordFragment

    @ContributesAndroidInjector(modules = [AuthViewModelModule::class, AuthModule::class])
    abstract fun contributeRegisterFragment(): RegisterFragment


    // MAIN
    @ContributesAndroidInjector(modules = [MainViewModelModule::class, MainModule::class])
    abstract fun contributeMainFragment(): MainFragment
}