package org.acad.presentation.screens.onboarding

import android.content.SharedPreferences
import com.github.terrakok.cicerone.Router
import org.acad.presentation.base.BaseVM
import org.acad.presentation.navigations.Screens.sign
import org.acad.presentation.screens.onboarding.OnboardingVM.Effect
import org.acad.presentation.screens.onboarding.OnboardingVM.Event
import org.acad.presentation.screens.onboarding.OnboardingVM.Event.NavigateToSign
import org.acad.presentation.screens.onboarding.OnboardingVM.State

/**
 * Created by Acad Bek on 12/30/2024
 */
class OnboardingVM(
    private val router: Router,
    private val sharedPref: SharedPreferences
) : BaseVM<State, Event, Effect>() {

    data class State(
        val currentPage: Int = 0,
        val isFirstLaunch: Boolean = true
    )

    sealed class Event {
        data object NavigateToSign : Event()
    }

    class Effect

    override fun getDefaultState() = State()

    override fun processEvent(event: Event) {
        when (event) {
            NavigateToSign -> router.navigateTo(sign())
        }
    }

    fun isFirstLaunch(): Boolean {
        val isFirst = sharedPref.getBoolean("isFirstLaunch", true)
        if (isFirst)
            sharedPref.edit().putBoolean("isFirstLaunch", false).apply()
        return isFirst
    }
}