package org.acad.domain.repo

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

/**
 * Created by Acad Bek on 12/30/2024
 */
interface SettingsRepo {
    fun onboarded() : Completable
    fun getBoarded() : Single<Boolean>
}