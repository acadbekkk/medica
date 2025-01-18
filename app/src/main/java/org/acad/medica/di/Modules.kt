package org.acad.medica.di

import android.content.Context
import android.content.SharedPreferences
import com.github.terrakok.cicerone.Cicerone
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import org.acad.data.local.settings.SettingsRealm
import org.acad.data.local.settings.SettingsStorage
import org.acad.data.local.settings.SettingsStorageImpl
import org.acad.data.local.user.UserStorage
import org.acad.data.local.user.UserStorageImpl
import org.acad.data.remote.auth.AuthFirebase
import org.acad.data.remote.auth.AuthFirebaseImpl
import org.acad.data.repo.AuthRepoImpl
import org.acad.data.repo.SettingsRepoImpl
import org.acad.domain.repo.AuthRepo
import org.acad.domain.repo.SettingsRepo
import org.acad.domain.usecase.auth.SendEmailCodeUseCase
import org.acad.domain.usecase.settings.GetOnboardedUseCase
import org.acad.domain.usecase.settings.OnboardedUseCase
import org.acad.presentation.screens.main.MainVM
import org.acad.presentation.screens.onboarding.OnboardingVM
import org.acad.presentation.screens.sign.sign.SignVM
import org.acad.presentation.screens.sign.signIn.SignInVM
import org.acad.presentation.screens.sign.signUp.SignUpVM
import org.acad.presentation.screens.splash.SplashVM
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Acad Bek on 12/28/2024
 */

private val cicerone = Cicerone.create()

val config = RealmConfiguration.Builder(schema = setOf(SettingsRealm::class)).build()

val appModule = module {
    single { cicerone.router }
    single { cicerone.getNavigatorHolder() }
    single { Realm.open(config) }
    single<SharedPreferences> {
        androidContext().getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    }
}

val repoModule = module {
    single<AuthRepo> { AuthRepoImpl(get()) }
    single<SettingsRepo> { SettingsRepoImpl(get()) }
}

val useCaseModule = module {
    single { SendEmailCodeUseCase(get()) }
    single { GetOnboardedUseCase(get()) }
    single { OnboardedUseCase(get()) }
}

val localModule = module {
    single<UserStorage> { UserStorageImpl() }
    single<SettingsStorage> { SettingsStorageImpl(get()) }
}

val remoteModule = module {
    single<AuthFirebase> { AuthFirebaseImpl() }
}

val vmModule = module {
    viewModel { SplashVM(get(), get()) }
    viewModel { MainVM(get()) }
    viewModel { SignInVM(get()) }
    viewModel { OnboardingVM(get(), get()) }
    viewModel { SignVM(get()) }
    viewModel { SignUpVM(get()) }
}