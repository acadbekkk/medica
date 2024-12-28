package org.acad.presentation.screens.splash

import org.acad.presentation.base.BaseVM
import org.acad.presentation.screens.splash.SplashVM.*

/**
 * Created by Acad Bek on 12/28/2024
 */
class SplashVM : BaseVM<State, Event, Effect>() {

    data class State (
        val loading: Boolean = true
    )

    class Event

    class Effect

    override fun getDefaultState() = State()

    override fun processEvent(event: Event) {}
}