package org.acad.data.local.settings

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

/**
 * Created by Acad Bek on 12/30/2024
 */
interface SettingsStorage {
    fun onboarded() : Completable
    fun getBoarded() : Single<Boolean>
}