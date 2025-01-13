package org.acad.presentation.screens.signIn

import com.github.terrakok.cicerone.Router
import org.acad.presentation.base.BaseVM
import org.acad.presentation.screens.signIn.SignInVM.*

/**
 * Created by Acad Bek on 12/28/2024
 */
class SignInVM(
    private val router: Router
) : BaseVM<State, Event, Effect>() {

    class State

    class Event

    class Effect

    override fun getDefaultState() = State()

    override fun processEvent(event: Event) {}
}