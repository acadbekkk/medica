package org.acad.presentation.screens.splash

import android.content.SharedPreferences
import com.github.terrakok.cicerone.Router
import org.acad.presentation.base.BaseVM
import org.acad.presentation.navigations.Screens.onboarding
import org.acad.presentation.navigations.Screens.sign
import org.acad.presentation.screens.splash.SplashVM.*

/**
 * Created by Acad Bek on 12/28/2024
 */
class SplashVM(
    private val router: Router,
    private val sharedPref: SharedPreferences,
) : BaseVM<State, Event, Effect>() {

    data class State(
        val isFirstLaunch: Boolean = true,
    )

    class Event

    class Effect

    override fun getDefaultState() = State()

    override fun processEvent(event: Event) {}

    fun isFirstLaunch(): Boolean {
        val isFirst = sharedPref.getBoolean("isFirstLaunch", true)
        if (isFirst)
            sharedPref.edit().putBoolean("isFirstLaunch", false).apply()
        return isFirst
    }

    fun navToOnboarding() {
        router.navigateTo(onboarding())
    }
}