package org.acad.presentation.screens.sign.signIn

import com.github.terrakok.cicerone.Router
import org.acad.presentation.base.BaseVM
import org.acad.presentation.navigations.Screens.home
import org.acad.presentation.navigations.Screens.signUp
import org.acad.presentation.screens.sign.signIn.SignInVM.*
import org.acad.presentation.screens.sign.signIn.SignInVM.Event.NavigateToHome
import org.acad.presentation.screens.sign.signIn.SignInVM.Event.NavigateToSignUp

/**
 * Created by Acad Bek on 12/28/2024
 */
class SignInVM(
    private val router: Router
) : BaseVM<State, Event, Effect>() {

    class State

    sealed class Event {
        data object NavigateToSignUp : Event()
        data object NavigateToHome : Event()
    }

    class Effect

    override fun getDefaultState() = State()

    override fun processEvent(event: Event) {
        when (event) {
            NavigateToSignUp -> router.navigateTo(signUp())
            NavigateToHome -> router.navigateTo(home())
        }
    }
}