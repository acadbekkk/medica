package org.acad.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.flow.*

/**
 * Created by Acad Bek on 12/12/2024
 */
abstract class BaseFragment<VB: ViewBinding>(
    private val inflate: (LayoutInflater, ViewGroup?, Boolean) -> VB
) : Fragment() {
    private var _binding: VB? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun <T, R> Flow<T>.observe(observer: (R) -> Unit, mapper: (T) -> R): Flow<R> {
        return this
            .map(mapper)                     // Transform the flow using the mapper
            .distinctUntilChanged()          // Emit only when the value changes
            .onEach { observer(it) }         // Perform the observer action for each emitted value
    }
}