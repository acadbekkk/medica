package org.acad.presentation.screens.sign.signUp

import com.github.terrakok.cicerone.Router
import org.acad.presentation.base.BaseVM
import org.acad.presentation.navigations.Screens.home
import org.acad.presentation.navigations.Screens.signIn
import org.acad.presentation.screens.sign.signUp.SignUpVM.Effect
import org.acad.presentation.screens.sign.signUp.SignUpVM.Event
import org.acad.presentation.screens.sign.signUp.SignUpVM.Event.NavigateToHome
import org.acad.presentation.screens.sign.signUp.SignUpVM.Event.NavigateToSignIn
import org.acad.presentation.screens.sign.signUp.SignUpVM.State

/**
 * Created by Acad Bek on 12/28/2024
 */
class SignUpVM(
    private val router: Router
) : BaseVM<State, Event, Effect>() {

    class State

    sealed class Event {
        data object NavigateToSignIn : Event()
        data object NavigateToHome : Event()
    }

    class Effect

    override fun getDefaultState() = State()

    override fun processEvent(event: Event) {
        when (event) {
            NavigateToSignIn -> router.navigateTo(signIn())
            NavigateToHome -> router.navigateTo(home())
        }
    }
}