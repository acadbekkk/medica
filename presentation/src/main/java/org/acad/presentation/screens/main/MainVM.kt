package org.acad.presentation.screens.main

import com.github.terrakok.cicerone.Router
import org.acad.presentation.base.BaseVM
import org.acad.presentation.navigations.Screens.splash
import org.acad.presentation.screens.main.MainVM.Effect
import org.acad.presentation.screens.main.MainVM.Event
import org.acad.presentation.screens.main.MainVM.State

/**
 * Created by Acad Bek on 12/28/2024
 */
class MainVM(
    private val router: Router,
) : BaseVM<State, Event, Effect>() {

    class State

    class Event

    class Effect

    init {
        router.newRootScreen(splash())
    }

    override fun getDefaultState() = State()

    override fun processEvent(event: Event) {}
}