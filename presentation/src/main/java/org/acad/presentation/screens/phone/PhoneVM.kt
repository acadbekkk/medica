package org.acad.presentation.screens.phone

import org.acad.domain.model.User
import org.acad.domain.usecase.auth.SECUseCase
import org.acad.presentation.base.BaseVM
import org.acad.presentation.screens.phone.PhoneVM.*

/**
 * Created by Acad Bek on 12/12/2024
 */
class PhoneVM constructor(
    private val secUseCase: SECUseCase
) : BaseVM<State, Input, Effect>() {

    data class State(
            val user: User? = null
        )

    class Input

    class Effect

    override fun getDefaultState() = State()

    override fun processInput(input: Input) { TODO("Not yet implemented") }
}