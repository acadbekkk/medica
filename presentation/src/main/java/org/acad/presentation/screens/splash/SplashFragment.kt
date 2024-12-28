package org.acad.presentation.screens.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import org.acad.presentation.base.BaseFragment
import org.acad.presentation.databinding.FragmentSplashBinding
import org.acad.presentation.screens.splash.SplashVM.Effect

/**
 * Created by Acad Bek on 12/28/2024
 */
class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {

    private lateinit var vm: SplashVM

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.state.observe(::render) { it.loading }
        vm.effects.doOnNext(::handleEffect)
    }

    private fun render(loading: Boolean) {}
    private fun handleEffect(effect: Effect) {}

}