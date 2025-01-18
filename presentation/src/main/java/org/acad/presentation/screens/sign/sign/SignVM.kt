package org.acad.presentation.screens.sign.sign

import com.github.terrakok.cicerone.Router
import org.acad.presentation.base.BaseVM
import org.acad.presentation.navigations.Screens.signIn
import org.acad.presentation.navigations.Screens.signUp
import org.acad.presentation.screens.sign.sign.SignVM.Effect
import org.acad.presentation.screens.sign.sign.SignVM.Event
import org.acad.presentation.screens.sign.sign.SignVM.Event.NavigateToSignIn
import org.acad.presentation.screens.sign.sign.SignVM.Event.NavigateToSignUp
import org.acad.presentation.screens.sign.sign.SignVM.State

/**
 * Created by Acad Bek on 1/13/2025
 */
class SignVM(
    private val router: Router,
) : BaseVM<State, Event, Effect>() {

    class State

    sealed class Event {
        data object NavigateToSignIn : Event()
        data object NavigateToSignUp : Event()
    }

    class Effect

    override fun getDefaultState() = State()

    override fun processEvent(event: Event) {
        when (event) {
            NavigateToSignIn -> router.navigateTo(signIn())
            NavigateToSignUp -> router.navigateTo(signUp())
        }
    }
}