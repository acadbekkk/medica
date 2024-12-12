package org.acad.presentation.screens.phone

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import org.acad.domain.model.User
import org.acad.presentation.base.BaseFragment
import org.acad.presentation.databinding.FragmetPhoneBinding
import org.acad.presentation.screens.phone.PhoneVM.Effect

/**
 * Created by Acad Bek on 12/12/2024
 */
class PhoneFragment : BaseFragment<FragmetPhoneBinding>(FragmetPhoneBinding::inflate) {

    private lateinit var vm: PhoneVM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenStarted {
            vm.state.observe(this@PhoneFragment::renderUser) { it.user }
            vm.effect.collect(this@PhoneFragment::handleEffects)
        }
    }

    private fun renderUser(user: User?) {}
    private fun handleEffects(effect: Effect) {}
}