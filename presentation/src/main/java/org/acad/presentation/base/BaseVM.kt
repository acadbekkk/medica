package org.acad.presentation.base

import androidx.lifecycle.ViewModel
import com.google.android.material.search.SearchView.Behavior
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.*

/**
 * Created by Acad Bek on 12/12/2024
 */
abstract class BaseVM<State, Input, Effect> : ViewModel(){

    private val sFlow = MutableStateFlow(this.getDefaultState())
    val state : Flow<State> get() = sFlow

    abstract fun getDefaultState() : State

    fun updateState(update: (current: State) -> State) {
        val state = update(sFlow.value)
        sFlow.value = state
    }

    abstract fun processInput(input: Input)

    private val eFlow = MutableSharedFlow<Effect>()
    val effect : Flow<Effect> get() = eFlow

    fun emitEffect(effect: Effect) {
        eFlow.tryEmit(effect)
    }
}