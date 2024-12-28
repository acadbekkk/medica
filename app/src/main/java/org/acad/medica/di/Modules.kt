package org.acad.medica.di

import com.github.terrakok.cicerone.Cicerone
import org.acad.data.local.user.*
import org.acad.data.remote.auth.AuthFirebase
import org.acad.data.remote.auth.AuthFirebaseImpl
import org.acad.data.repo.*
import org.acad.domain.repo.AuthRepo
import org.acad.domain.usecase.auth.SendEmailCodeUseCase
import org.acad.presentation.screens.main.MainVM
import org.acad.presentation.screens.splash.SplashVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Acad Bek on 12/28/2024
 */

private val cicerone = Cicerone.create()

val appModule = module {
    single { cicerone.router }
    single { cicerone.getNavigatorHolder() }
}

val repoModule = module {
    single<AuthRepo> { AuthRepoImpl(get()) }
}

val useCaseModule = module {
    single { SendEmailCodeUseCase(get()) }
}

val localModule = module {
    single<UserStorage> { UserStorageImpl() }
}

val remoteModule = module {
    single<AuthFirebase> { AuthFirebaseImpl() }
}

val vmModule = module {
    viewModel { SplashVM() }
    viewModel { MainVM(get()) }
}