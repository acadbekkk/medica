package org.acad.data.repo

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.acad.data.local.settings.SettingsStorage
import org.acad.domain.repo.SettingsRepo

/**
 * Created by Acad Bek on 12/30/2024
 */
class SettingsRepoImpl(
    private val storage: SettingsStorage
) : SettingsRepo {
    override fun onboarded() : Completable = storage
        .onboarded()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    override fun getBoarded(): Single<Boolean> = storage
        .getBoarded()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}