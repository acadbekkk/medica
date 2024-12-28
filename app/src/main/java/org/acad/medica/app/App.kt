package org.acad.medica.app

import android.app.Application
import org.acad.medica.di.appModule
import org.acad.medica.di.localModule
import org.acad.medica.di.remoteModule
import org.acad.medica.di.repoModule
import org.acad.medica.di.useCaseModule
import org.acad.medica.di.vmModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by Acad Bek on 12/28/2024
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                    appModule,
                    repoModule,
                    useCaseModule,
                    localModule,
                    remoteModule,
                    vmModule
            )
        }
    }
}